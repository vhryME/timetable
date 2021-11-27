package com.vhry.mapper;

import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public interface DtoMapper<DtoIn, Entity, DtoOut> {

    Entity fromIn(DtoIn jpaEntity);

    DtoOut toOut(Entity entity);

    default List<Entity> fromIn(List<DtoIn> jpaEntities) {
        return jpaEntities.stream().map(this::fromIn).collect(Collectors.toList());
    }

    default Page<DtoOut> toOut(Page<Entity> jpaEntities) {
        return jpaEntities.map(this::toOut);
    }

    default List<DtoOut> toOut(List<Entity> jpaEntities) {
        return jpaEntities.stream().map(this::toOut).collect(Collectors.toList());
    }

}
