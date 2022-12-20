package alatoo.edu.library.services;

import alatoo.edu.library.models.dto.BookDto;
import alatoo.edu.library.models.dto.BookOperationDto;
import alatoo.edu.library.models.dto.WalletDto;

import java.time.LocalDateTime;
import java.util.List;

public interface BookOperationService extends BaseCrudService<BookOperationDto, Long>{
    BookOperationDto buy_a_book(Long book_id, Long user_id);
    BookOperationDto borrow_a_book(Long bookId, Long userId, LocalDateTime endDate);
    BookOperationDto returnBook(Long bookId, Long userId);
    List<BookDto> findBorrowedBooks();
    WalletDto walletAutomaticAdd(Long userId);
    BookOperationDto reserveBook(Long bookId, Long userId, LocalDateTime endDate);
}
