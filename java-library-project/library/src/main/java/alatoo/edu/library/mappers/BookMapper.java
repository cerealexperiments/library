package alatoo.edu.library.mappers;

import alatoo.edu.library.models.dto.AuthorDto;
import alatoo.edu.library.models.dto.BookDto;
import alatoo.edu.library.models.entities.Author;
import alatoo.edu.library.models.entities.Book;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import java.util.List;
import java.util.stream.Collectors;

public class BookMapper implements BaseMapper <BookDto, Book>{
    private MapperFacade mapperFacade;

    public BookMapper() {
        MapperFactory mapperFactory = new DefaultMapperFactory
                .Builder().build();

        mapperFactory.classMap(BookDto.class, Book.class)
                .field("authorDto", "author")
                .byDefault()
                .register();

        mapperFactory.classMap(AuthorDto.class, Author.class)
                .byDefault();
        mapperFacade = mapperFactory.getMapperFacade();
    }

    @Override
    public Book toEntity(BookDto dto) {
        return mapperFacade.map(dto, Book.class);
    }

    @Override
    public BookDto toDto(Book entity) {
        return mapperFacade.map(entity, BookDto.class);
    }

    @Override
    public List<Book> toEntities(List<BookDto> dtoList) {
        return dtoList.stream().map(x -> mapperFacade.map(x, Book.class)).collect(Collectors.toList());
    }

    @Override
    public List<BookDto> toDtoList(List<Book> entities) {
        return entities.stream().map(x-> mapperFacade.map(x, BookDto.class)).collect(Collectors.toList());
    }
}
