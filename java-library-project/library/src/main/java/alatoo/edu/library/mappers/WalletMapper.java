package alatoo.edu.library.mappers;

import alatoo.edu.library.models.dto.*;
import alatoo.edu.library.models.entities.*;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import java.util.List;
import java.util.stream.Collectors;

public class WalletMapper implements BaseMapper<WalletDto, Wallet>{
    private MapperFacade mapperFacade;

    public WalletMapper() {
        MapperFactory mapperFactory = new DefaultMapperFactory
                .Builder().build();

        mapperFactory.classMap(WalletDto.class, Wallet.class)
                .field("userDto", "user")
                .field("userDto.roleDtos", "user.roles")
                .byDefault()
                .register();

        mapperFactory.classMap(UserDto.class, User.class)
                .byDefault();
        mapperFacade = mapperFactory.getMapperFacade();
    }

    @Override
    public Wallet toEntity(WalletDto dto) {
        return mapperFacade.map(dto, Wallet.class);
    }

    @Override
    public WalletDto toDto(Wallet entity) {
        return mapperFacade.map(entity, WalletDto.class);
    }

    @Override
    public List<Wallet> toEntities(List<WalletDto> dtoList) {
        return dtoList.stream().map(x -> mapperFacade.map(x, Wallet.class)).collect(Collectors.toList());    }

    @Override
    public List<WalletDto> toDtoList(List<Wallet> entities) {
        return entities.stream().map(x -> mapperFacade.map(x, WalletDto.class)).collect(Collectors.toList());    }
}
