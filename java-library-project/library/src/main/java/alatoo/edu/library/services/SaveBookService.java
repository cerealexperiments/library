package alatoo.edu.library.services;

import alatoo.edu.library.models.dto.BookDto;
import alatoo.edu.library.models.dto.SaveBookDto;
import alatoo.edu.library.models.entities.Book;
import alatoo.edu.library.models.entities.Reader;
import alatoo.edu.library.models.entities.SaveBook;

import java.util.List;

public interface SaveBookService extends BaseCrudService<SaveBookDto, Long>{
    SaveBookDto addBookToFavourites(Long readerId,Long bookId);
    SaveBookDto addBookToAlreadyRead(Long readerId,Long bookId);
    SaveBookDto findByBookAndReader(Long readerId,Long bookId);
}
