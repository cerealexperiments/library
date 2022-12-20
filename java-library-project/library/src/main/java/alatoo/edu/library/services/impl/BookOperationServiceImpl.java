package alatoo.edu.library.services.impl;

import alatoo.edu.library.dao.BookOperationRepo;
import alatoo.edu.library.dao.WalletRepo;
import alatoo.edu.library.exceptions.PaymentException;
import alatoo.edu.library.mappers.BookMapper;
import alatoo.edu.library.mappers.BookOperationMapper;
import alatoo.edu.library.mappers.WalletMapper;
import alatoo.edu.library.models.dto.BookDto;
import alatoo.edu.library.models.dto.BookOperationDto;
import alatoo.edu.library.models.dto.WalletDto;
import alatoo.edu.library.models.entities.BookOperation;
import alatoo.edu.library.models.enums.OperationStatus;
import alatoo.edu.library.services.BookOperationService;
import alatoo.edu.library.services.BookService;
import alatoo.edu.library.services.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookOperationServiceImpl implements BookOperationService {
    @Autowired
    private ReaderService readerService;

    @Autowired
    private BookOperationRepo repo;

    @Autowired
    private WalletRepo walletRepo;

    @Autowired
    private BookService bookService;

    @Override
    public BookOperationDto save(BookOperationDto bookOperationDto) {
        return map().toDto(repo.save(map().toEntity(bookOperationDto)));
    }

    public WalletDto walletAutomaticAdd(Long userId){
        WalletDto walletDto = new WalletDto();
        walletDto.setUserDto(readerService.findById(userId));
        walletDto.setMoney(1000);
        return walletMapper().toDto(walletRepo.save(walletMapper().toEntity(walletDto)));
    }

    @Override
    public BookOperationDto update(BookOperationDto bookOperationDto) {
        return null;
    }

    @Override
    public BookOperationDto findById(Long id) {
        return null;
    }

    @Override
    public List<BookOperationDto> findAll() {
        return null;
    }

    @Override
    public BookOperationDto buy_a_book(Long book_id, Long user_id) {
        BookOperationDto bookOperationDtoBorrowed = map().toDto(repo.findByBookAndOperationStatus(bookService.findEntityById(book_id), OperationStatus.BORROWED));
        BookOperationDto bookOperationDtoReserved = map().toDto(repo.findByBookAndOperationStatus(bookService.findEntityById(book_id), OperationStatus.RESERVED));
        BookOperationDto bookOperationDtoSold = map().toDto(repo.findByBookAndOperationStatus(bookService.findEntityById(book_id), OperationStatus.SOLD));
        if (bookOperationDtoReserved == null && bookOperationDtoBorrowed == null && bookOperationDtoSold == null) {
            WalletDto walletDto = walletMapper().toDto(walletRepo.findByUser(readerService.findEntityById(user_id)));
            if (walletDto != null) {
                BookDto bookDto = bookService.findById(book_id);
                if (walletDto.getMoney() >= bookDto.getPrice()) {
                    walletDto.setMoney(walletDto.getMoney() - bookDto.getPrice());
                    walletRepo.save(walletMapper().toEntity(walletDto));
                    BookOperationDto bookOperationDto = new BookOperationDto();
                    bookOperationDto.setBookDto(bookDto);
                    bookOperationDto.setOperation_price(bookDto.getPrice());
                    bookOperationDto.setOperationStatus(OperationStatus.SOLD);
                    bookOperationDto.setUserDto(readerService.findById(user_id));
                    bookOperationDto.setStart_date(LocalDateTime.now());
                    bookOperationDto.setEnd_date(LocalDateTime.now().plusYears(100));
                    bookOperationDto = map().toDto(repo.save(map().toEntity(bookOperationDto)));
                    return bookOperationDto;
                } else {
                    throw new PaymentException("Not enough money");
                }
            } else {
                throw new PaymentException("You have not set up your wallet!");
            }
        }
        else {
            throw new PaymentException("Book isn't available");
        }
    }

    @Override
    public BookOperationDto borrow_a_book(Long bookId, Long userId, LocalDateTime endDate) {
        BookOperationDto bookOperationDtoBorrowed = map().toDto(repo.findByBookAndOperationStatus(bookService.findEntityById(bookId), OperationStatus.BORROWED));
        BookOperationDto bookOperationDtoReserved = map().toDto(repo.findByBookAndOperationStatus(bookService.findEntityById(bookId), OperationStatus.RESERVED));
        BookOperationDto bookOperationDtoSold = map().toDto(repo.findByBookAndOperationStatus(bookService.findEntityById(bookId), OperationStatus.SOLD));
        if (bookOperationDtoReserved == null && bookOperationDtoBorrowed == null && bookOperationDtoSold == null){
            bookOperationDtoBorrowed = new BookOperationDto();
            bookOperationDtoBorrowed.setBookDto(bookService.findById(bookId));
            bookOperationDtoBorrowed.setUserDto(readerService.findById(userId));
            bookOperationDtoBorrowed.setOperation_price(0);
            bookOperationDtoBorrowed.setOperationStatus(OperationStatus.BORROWED);
            bookOperationDtoBorrowed.setStart_date(LocalDateTime.now());
            bookOperationDtoBorrowed.setEnd_date(endDate);
                return save(bookOperationDtoBorrowed);
            }
        else {
            throw new PaymentException("Book isn't available");
        }
    }

    @Override
    public BookOperationDto returnBook(Long bookId, Long userId) {
        BookOperationDto bookOperationDto = map().toDto(repo.findByBookAndOperationStatus(bookService.findEntityById(bookId), OperationStatus.BORROWED));
        if (bookOperationDto == null){
            throw new PaymentException("You can't return the book that you didn't borrow");
        }
        else if (!bookOperationDto.getUserDto().getId().equals(userId)){
            throw new PaymentException("You can't return the book that you didn't borrow");
        }
        else {
            bookOperationDto.setOperationStatus(OperationStatus.RETURNED);
            bookOperationDto.setEnd_date(LocalDateTime.now());
            return save(bookOperationDto);
        }
    }

    @Override
    public List<BookDto> findBorrowedBooks() {
        return bookMapper().toDtoList(repo.findBookByOperationStatus(OperationStatus.BORROWED));
    }

    @Override
    public BookOperationDto reserveBook(Long bookId, Long userId, LocalDateTime endDate) {
        BookOperationDto bookOperationDtoBorrowed = map().toDto(repo.findByBookAndOperationStatus(bookService.findEntityById(bookId), OperationStatus.BORROWED));
        BookOperationDto bookOperationDtoReserved = map().toDto(repo.findByBookAndOperationStatus(bookService.findEntityById(bookId), OperationStatus.RESERVED));
        BookOperationDto bookOperationDtoSold = map().toDto(repo.findByBookAndOperationStatus(bookService.findEntityById(bookId), OperationStatus.SOLD));
        if (bookOperationDtoReserved == null && bookOperationDtoBorrowed == null && bookOperationDtoSold == null){
            BookOperationDto bookOperationDto = new BookOperationDto();
            bookOperationDto.setBookDto(bookService.findById(bookId));
            bookOperationDto.setUserDto(readerService.findById(userId));
            bookOperationDto.setOperation_price(0);
            bookOperationDto.setOperationStatus(OperationStatus.RESERVED);
            bookOperationDto.setStart_date(LocalDateTime.now());
            bookOperationDto.setEnd_date(endDate);
            return save(bookOperationDto);
        }
        else {
            throw new PaymentException("Book isn't available");
        }
    }

    public WalletMapper walletMapper() {
        return new WalletMapper();
    }

    public BookOperationMapper map() {
        return new BookOperationMapper();
    }

    public BookMapper bookMapper() {
        return new BookMapper();
    }
}
