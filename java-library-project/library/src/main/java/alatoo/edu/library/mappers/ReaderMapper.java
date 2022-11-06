package alatoo.edu.library.mappers;

import alatoo.edu.library.models.dto.BookOperationDto;
import alatoo.edu.library.models.dto.ReaderDto;
import alatoo.edu.library.models.entities.BookOperation;
import alatoo.edu.library.models.entities.Penalty;
import alatoo.edu.library.models.entities.Reader;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import java.util.List;
import java.util.stream.Collectors;

public class ReaderMapper implements BaseMapper<ReaderDto, Reader>{
    private MapperFacade mapperFacade;

    public ReaderMapper() {
        MapperFactory mapperFactory = new DefaultMapperFactory
                .Builder().build();

        mapperFactory.classMap(BookOperationDto.class, BookOperation.class)
                .byDefault();
        mapperFacade = mapperFactory.getMapperFacade();
    }

    @Override
    public Reader toEntity(ReaderDto dto) {
        return mapperFacade.map(dto, Reader.class);
    }

    @Override
    public ReaderDto toDto(Reader entity) {
        return mapperFacade.map(entity, ReaderDto.class);
    }

    @Override
    public List<Reader> toEntities(List<ReaderDto> dtoList) {
        return dtoList.stream().map(x -> mapperFacade.map(x, Reader.class)).collect(Collectors.toList());
    }

    @Override
    public List<ReaderDto> toDtoList(List<Reader> entities) {
        return entities.stream().map(x -> mapperFacade.map(x, ReaderDto.class)).collect(Collectors.toList());
    }
}
