package alatoo.edu.library.mappers;

import java.util.List;

public interface BaseMapper <S,T>{
    T toEntity(S dto);
    S toDto(T entity);

    List<T> toEntities(List<S> dtoList);
    List<S> toDtoList(List<T> entities);
}
