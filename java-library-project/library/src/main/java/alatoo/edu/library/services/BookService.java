package alatoo.edu.library.services;

import alatoo.edu.library.models.dto.BookDto;
import alatoo.edu.library.models.input_dtos.InputBookDto;

public interface BookService extends BaseCrudService<BookDto, Long>{
    public BookDto saveInputBookDto(InputBookDto inputBookDto);
}
