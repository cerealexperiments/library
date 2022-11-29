package alatoo.edu.library.mappers;

import alatoo.edu.library.models.dto.AuthorDto;
import alatoo.edu.library.models.dto.RoleDto;
import alatoo.edu.library.models.entities.Author;
import alatoo.edu.library.models.entities.Role;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import java.util.List;
import java.util.stream.Collectors;

public class RoleMapper implements BaseMapper <RoleDto, Role>{
    private MapperFacade mapperFacade;

    public RoleMapper() {
        MapperFactory mapperFactory = new DefaultMapperFactory
                .Builder().build();

        mapperFactory.classMap(RoleDto.class, Role.class)
                .byDefault();
        mapperFacade = mapperFactory.getMapperFacade();
    }

    @Override
    public Role toEntity(RoleDto dto) {
        return mapperFacade.map(dto, Role.class);
    }

    @Override
    public RoleDto toDto(Role entity) {
        return mapperFacade.map(entity, RoleDto.class);
    }

    @Override
    public List<Role> toEntities(List<RoleDto> dtoList) {
        return dtoList.stream().map(x -> mapperFacade.map(x, Role.class)).collect(Collectors.toList());
    }

    @Override
    public List<RoleDto> toDtoList(List<Role> entities) {
        return entities.stream().map(x-> mapperFacade.map(x, RoleDto.class)).collect(Collectors.toList());
    }
}
