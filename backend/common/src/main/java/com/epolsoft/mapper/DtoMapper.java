package com.epolsoft.mapper;


import java.util.List;
import java.util.stream.Collectors;

public interface DtoMapper<IN, ENTITY, OUT> {

    ENTITY inToEntity(IN in);


    OUT entityToOut (ENTITY entity);


    default List<ENTITY> inListToEntities(List<IN> inList) {
        return inList.stream().map(this::inToEntity).collect(Collectors.toList());
    }


    default List<OUT> entitiesToOutList(List<ENTITY> entities) {
        return entities.stream().map(this::entityToOut).collect(Collectors.toList());
    }

}