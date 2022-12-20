package alatoo.edu.library.services.impl;

import alatoo.edu.library.dao.BookRepo;
import alatoo.edu.library.dao.ReaderRepo;
import alatoo.edu.library.dao.SaveBookRepo;
import alatoo.edu.library.exceptions.NotFoundByIdException;
import alatoo.edu.library.exceptions.PaymentException;
import alatoo.edu.library.mappers.BookMapper;
import alatoo.edu.library.mappers.SaveBookMapper;
import alatoo.edu.library.models.dto.BookDto;
import alatoo.edu.library.models.dto.SaveBookDto;
import alatoo.edu.library.models.entities.Reader;
import alatoo.edu.library.services.AuthorService;
import alatoo.edu.library.services.BookService;
import alatoo.edu.library.services.ReaderService;
import alatoo.edu.library.services.SaveBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SaveBookServiceImpl implements SaveBookService {
    @Autowired
    private SaveBookRepo repo;

    @Autowired
    private BookService bookService;

    @Autowired
    private ReaderService readerService;

    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private ReaderRepo readerRepo;

    @Override
    public SaveBookDto save(SaveBookDto saveBookDto) {
        return map().toDto(repo.save(map().toEntity(saveBookDto)));
    }

    @Override
    public SaveBookDto update(SaveBookDto saveBookDto) {
        return null;
    }

    @Override
    public SaveBookDto findById(Long id) {
        return null;
    }

    @Override
    public List<SaveBookDto> findAll() {
        return null;
    }



    public SaveBookMapper map() {
        return new SaveBookMapper();
    }

    @Override
    public SaveBookDto addBookToFavourites(Long readerId, Long bookId) {
        SaveBookDto saveBookDto = findByBookAndReader(readerId, bookId);
        if (saveBookDto != null){
            if (!saveBookDto.isFavourite()){
                saveBookDto.setFavourite(true);
            }
            else {
                throw new PaymentException("Book is already added to favourites by you!");
            }
        }
        else {
            saveBookDto = new SaveBookDto();
            saveBookDto.setBookDto(bookService.findById(bookId));
            saveBookDto.setUserDto(readerService.findById(readerId));
            saveBookDto.setFavourite(true);
        }
        return save(saveBookDto);
    }

    @Override
    public SaveBookDto addBookToAlreadyRead(Long readerId, Long bookId) {
        SaveBookDto saveBookDto = findByBookAndReader(readerId, bookId);
        System.out.println(saveBookDto);
        if (saveBookDto != null){
            if (!saveBookDto.isRead()){
                saveBookDto.setRead(true);
            }
            else {
                throw new PaymentException("Book is already read by you!");
            }
        }
        else {
            saveBookDto = new SaveBookDto();
            saveBookDto.setBookDto(bookService.findById(bookId));
            saveBookDto.setUserDto(readerService.findById(readerId));
            saveBookDto.setRead(true);
        }
        return save(saveBookDto);
    }

    @Override
    public SaveBookDto findByBookAndReader(Long readerId, Long bookId) {
        return map().toDto(repo.findDistinctByBookAndUser(bookService.findEntityById(bookId),readerService.findEntityById(readerId)));
    }
}
