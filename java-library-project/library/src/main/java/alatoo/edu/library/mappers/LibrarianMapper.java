package alatoo.edu.library.mappers;

import alatoo.edu.library.models.dto.BookOperationDto;
import alatoo.edu.library.models.dto.ImageDto;
import alatoo.edu.library.models.dto.LibrarianDto;
import alatoo.edu.library.models.entities.BookOperation;
import alatoo.edu.library.models.entities.Image;
import alatoo.edu.library.models.entities.Librarian;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import java.util.List;
import java.util.stream.Collectors;

public class LibrarianMapper implements BaseMapper<LibrarianDto, Librarian>{
    private MapperFacade mapperFacade;

    public LibrarianMapper() {
        MapperFactory mapperFactory = new DefaultMapperFactory
                .Builder().build();

        mapperFactory.classMap(BookOperationDto.class, BookOperation.class)
                .byDefault();
        mapperFacade = mapperFactory.getMapperFacade();
    }

    @Override
    public Librarian toEntity(LibrarianDto dto) {
        return mapperFacade.map(dto, Librarian.class);
    }

    @Override
    public LibrarianDto toDto(Librarian entity) {
        return mapperFacade.map(entity, LibrarianDto.class);
    }

    @Override
    public List<Librarian> toEntities(List<LibrarianDto> dtoList) {
        return dtoList.stream().map(x -> mapperFacade.map(x, Librarian.class)).collect(Collectors.toList());
    }

    @Override
    public List<LibrarianDto> toDtoList(List<Librarian> entities) {
        return entities.stream().map(x -> mapperFacade.map(x, LibrarianDto.class)).collect(Collectors.toList());
    }
}
