package com.epolsoft.mapper;


import java.util.List;
import java.util.stream.Collectors;

public interface JpaMapper<JPA, Entity> {

    JPA entityToJpaEntity(Entity entity);


    Entity jpaEntityToEntity (JPA JPA);


    default List<JPA> listJpaEntityToListEntity(List<Entity> list) {
        return list.stream().map(this::entityToJpaEntity).collect(Collectors.toList());
    }


    default List<Entity> listEntityToListJpaEntity(List<JPA> list) {
        return list.stream().map(this::jpaEntityToEntity).collect(Collectors.toList());
    }

}