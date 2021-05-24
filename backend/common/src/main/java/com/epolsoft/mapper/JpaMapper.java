package com.epolsoft.mapper;


import java.util.List;
import java.util.stream.Collectors;

public interface JpaMapper<JpaENTITY, ENTITY> {

    JpaENTITY entityToJpaEntity(ENTITY entity);


    ENTITY jpaEntityToEntity (JpaENTITY jpaEntity);


    default List<JpaENTITY> listJpaEntityToListEntity(List<ENTITY> list) {
        return list.stream().map(this::entityToJpaEntity).collect(Collectors.toList());
    }


    default List<ENTITY> listEntityToListJpaEntity(List<JpaENTITY> list) {
        return list.stream().map(this::jpaEntityToEntity).collect(Collectors.toList());
    }

}