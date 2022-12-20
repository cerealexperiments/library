package alatoo.edu.library.mappers;

import alatoo.edu.library.models.dto.BookDto;
import alatoo.edu.library.models.dto.ImageDto;
import alatoo.edu.library.models.dto.RoleDto;
import alatoo.edu.library.models.dto.UserDto;
import alatoo.edu.library.models.entities.Book;
import alatoo.edu.library.models.entities.Image;
import alatoo.edu.library.models.entities.Role;
import alatoo.edu.library.models.entities.User;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper implements BaseMapper<UserDto, User> {
    private MapperFacade mapperFacade;

    public UserMapper() {
        MapperFactory mapperFactory = new DefaultMapperFactory
                .Builder().build();

        mapperFactory.classMap(UserDto.class, User.class)
                .field("roleDtos", "roles")
                .byDefault()
                .register();

        mapperFactory.classMap(RoleDto.class, Role.class)
                .byDefault();
        mapperFacade = mapperFactory.getMapperFacade();
    }

    @Override
    public User toEntity(UserDto dto) {
        return mapperFacade.map(dto, User.class);
    }

    @Override
    public UserDto toDto(User entity) {
        return mapperFacade.map(entity, UserDto.class);
    }

    @Override
    public List<User> toEntities(List<UserDto> dtoList) {
        return dtoList.stream().map(x -> mapperFacade.map(x, User.class)).collect(Collectors.toList());
    }

    @Override
    public List<UserDto> toDtoList(List<User> entities) {
        return entities.stream().map(x -> mapperFacade.map(x, UserDto.class)).collect(Collectors.toList());
    }
}
