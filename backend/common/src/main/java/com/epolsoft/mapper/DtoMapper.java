package com.epolsoft.mapper;


public interface DtoMapper<IN, ENTITY, OUT> {

    ENTITY inToEntity(IN in);


    OUT entityToOut (ENTITY entity);

}