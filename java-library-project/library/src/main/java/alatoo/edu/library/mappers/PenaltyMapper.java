package alatoo.edu.library.mappers;

import alatoo.edu.library.models.dto.BookOperationDto;
import alatoo.edu.library.models.dto.PenaltyDto;
import alatoo.edu.library.models.entities.BookOperation;
import alatoo.edu.library.models.entities.Librarian;
import alatoo.edu.library.models.entities.Penalty;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import java.util.List;
import java.util.stream.Collectors;

public class PenaltyMapper implements BaseMapper<PenaltyDto, Penalty>{
    private MapperFacade mapperFacade;

    public PenaltyMapper() {
        MapperFactory mapperFactory = new DefaultMapperFactory
                .Builder().build();

        mapperFactory.classMap(PenaltyDto.class, Penalty.class)
                .byDefault();
        mapperFacade = mapperFactory.getMapperFacade();
    }

    @Override
    public Penalty toEntity(PenaltyDto dto) {
        return mapperFacade.map(dto, Penalty.class);
    }

    @Override
    public PenaltyDto toDto(Penalty entity) {
        return mapperFacade.map(entity, PenaltyDto.class);
    }

    @Override
    public List<Penalty> toEntities(List<PenaltyDto> dtoList) {
        return dtoList.stream().map(x -> mapperFacade.map(x, Penalty.class)).collect(Collectors.toList());
    }

    @Override
    public List<PenaltyDto> toDtoList(List<Penalty> entities) {
        return entities.stream().map(x -> mapperFacade.map(x, PenaltyDto.class)).collect(Collectors.toList());
    }
}
