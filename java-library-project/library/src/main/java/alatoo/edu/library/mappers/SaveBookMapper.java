package alatoo.edu.library.mappers;

import alatoo.edu.library.models.dto.*;
import alatoo.edu.library.models.entities.*;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import java.util.List;
import java.util.stream.Collectors;

public class SaveBookMapper implements BaseMapper<SaveBookDto, SaveBook>{
    private MapperFacade mapperFacade;

    public SaveBookMapper() {
        MapperFactory mapperFactory = new DefaultMapperFactory
                .Builder().build();

        mapperFactory.classMap(SaveBookDto.class, SaveBook.class)
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
//        mapperFactory.classMap(RoleDto.class, Role.class)
//                .byDefault();
//        mapperFactory.classMap(AuthorDto.class, Author.class)
//                .byDefault();
        mapperFacade = mapperFactory.getMapperFacade();
    }

    @Override
    public SaveBook toEntity(SaveBookDto dto) {
        return mapperFacade.map(dto, SaveBook.class);
    }

    @Override
    public SaveBookDto toDto(SaveBook entity) {
        return mapperFacade.map(entity, SaveBookDto.class);
    }

    @Override
    public List<SaveBook> toEntities(List<SaveBookDto> dtoList) {
        return dtoList.stream().map(x -> mapperFacade.map(x, SaveBook.class)).collect(Collectors.toList());    }

    @Override
    public List<SaveBookDto> toDtoList(List<SaveBook> entities) {
        return entities.stream().map(x -> mapperFacade.map(x, SaveBookDto.class)).collect(Collectors.toList());    }
}
