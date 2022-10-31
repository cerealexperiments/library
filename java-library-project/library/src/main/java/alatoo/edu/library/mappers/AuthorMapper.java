package alatoo.edu.library.mappers;

import alatoo.edu.library.models.dto.AuthorDto;
import alatoo.edu.library.models.entities.Author;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import java.util.List;
import java.util.stream.Collectors;

public class AuthorMapper implements BaseMapper <AuthorDto, Author>{
    private MapperFacade mapperFacade;

    public AuthorMapper() {
        MapperFactory mapperFactory = new DefaultMapperFactory
                .Builder().build();

        mapperFactory.classMap(AuthorDto.class, Author.class)
                .byDefault();
        mapperFacade = mapperFactory.getMapperFacade();
    }

    @Override
    public Author toEntity(AuthorDto dto) {
        return mapperFacade.map(dto, Author.class);
    }

    @Override
    public AuthorDto toDto(Author entity) {
        return mapperFacade.map(entity, AuthorDto.class);
    }

    @Override
    public List<Author> toEntities(List<AuthorDto> dtoList) {
        return dtoList.stream().map(x -> mapperFacade.map(x, Author.class)).collect(Collectors.toList());
    }

    @Override
    public List<AuthorDto> toDtoList(List<Author> entities) {
        return entities.stream().map(x-> mapperFacade.map(x, AuthorDto.class)).collect(Collectors.toList());
    }
}
