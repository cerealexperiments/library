package alatoo.edu.library.mappers;

import alatoo.edu.library.models.dto.BookDto;
import alatoo.edu.library.models.dto.BookOperationDto;
import alatoo.edu.library.models.dto.SaveBookDto;
import alatoo.edu.library.models.dto.UserDto;
import alatoo.edu.library.models.entities.Book;
import alatoo.edu.library.models.entities.BookOperation;
import alatoo.edu.library.models.entities.SaveBook;
import alatoo.edu.library.models.entities.User;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import java.util.List;
import java.util.stream.Collectors;

public class BookOperationMapper implements BaseMapper<BookOperationDto, BookOperation>{
    private MapperFacade mapperFacade;

    public BookOperationMapper() {
        MapperFactory mapperFactory = new DefaultMapperFactory
                .Builder().build();

        mapperFactory.classMap(BookOperationDto.class, BookOperation.class)
                .field("userDto", "user")
                .field("bookDto", "book")
                .field("userDto.roleDtos", "user.roles")
                .field("bookDto.authorDto", "book.author")
                .byDefault()
                .register();

        mapperFactory.classMap(UserDto.class, User.class)
                .byDefault();
        mapperFactory.classMap(BookDto.class, Book.class)
                .byDefault();
        mapperFacade = mapperFactory.getMapperFacade();
    }

    @Override
    public BookOperation toEntity(BookOperationDto dto) {
        return mapperFacade.map(dto, BookOperation.class);
    }

    @Override
    public BookOperationDto toDto(BookOperation entity) {
        return mapperFacade.map(entity, BookOperationDto.class);
    }

    @Override
    public List<BookOperation> toEntities(List<BookOperationDto> dtoList) {
        return dtoList.stream().map(x -> mapperFacade.map(x, BookOperation.class)).collect(Collectors.toList());
    }

    @Override
    public List<BookOperationDto> toDtoList(List<BookOperation> entities) {
        return entities.stream().map(x -> mapperFacade.map(x, BookOperationDto.class)).collect(Collectors.toList());
    }
}
