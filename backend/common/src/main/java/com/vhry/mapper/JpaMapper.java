package com.vhry.mapper;

import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public interface JpaMapper<Entity, JpaEntity> {

    Entity fromJpaEntity(JpaEntity jpaEntity);

    JpaEntity toJpaEntity(Entity entity);

    default Page<Entity> fromJpaEntities(Page<JpaEntity> jpaEntities) {
        return jpaEntities.map(this::fromJpaEntity);
    }

    default List<Entity> fromJpaEntities(List<JpaEntity> jpaEntities) {
        return jpaEntities.stream().map(this::fromJpaEntity).collect(Collectors.toList());
    }

    default List<JpaEntity> toJpaEntities(List<Entity> entities) {
        return entities.stream().map(this::toJpaEntity).collect(Collectors.toList());
    }

}
