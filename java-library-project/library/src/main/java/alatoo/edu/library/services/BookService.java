package alatoo.edu.library.services;

import alatoo.edu.library.models.dto.BookDto;
import alatoo.edu.library.models.entities.Book;
import alatoo.edu.library.models.entities.Reader;
import alatoo.edu.library.models.input_dtos.InputBookDto;

import java.util.List;

public interface BookService extends BaseCrudService<BookDto, Long>{
    public InputBookDto saveInputBookDto(InputBookDto inputBookDto);
    List<BookDto> findByName(String name);
    List<BookDto> findByAuthor(String authorName);
    List<BookDto> findByPublishingDate(int publishingDate);
    List<BookDto> alreadyReadBooks(Long readerId);
    Book findEntityById(Long id);
    List<BookDto> findFavouriteBooks(Long readerId);
}
