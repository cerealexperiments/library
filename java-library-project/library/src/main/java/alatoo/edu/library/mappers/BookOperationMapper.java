package alatoo.edu.library.mappers;

import alatoo.edu.library.models.dto.BookDto;
import alatoo.edu.library.models.dto.BookOperationDto;
import alatoo.edu.library.models.entities.Book;
import alatoo.edu.library.models.entities.BookOperation;
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
