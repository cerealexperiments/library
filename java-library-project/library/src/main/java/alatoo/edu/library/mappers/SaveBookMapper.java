package alatoo.edu.library.mappers;

import alatoo.edu.library.models.dto.BookOperationDto;
import alatoo.edu.library.models.dto.SaveBookDto;
import alatoo.edu.library.models.entities.BookOperation;
import alatoo.edu.library.models.entities.Reader;
import alatoo.edu.library.models.entities.SaveBook;
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

        mapperFactory.classMap(BookOperationDto.class, BookOperation.class)
                .byDefault();
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
