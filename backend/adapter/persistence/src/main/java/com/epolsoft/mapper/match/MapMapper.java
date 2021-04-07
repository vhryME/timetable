package com.epolsoft.mapper.match;


import com.epolsoft.domain.match.Map;
import com.epolsoft.dto.match.MapJpa;
import org.mapstruct.EnumMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface MapMapper {

    MapMapper INSTANCE = Mappers.getMapper(MapMapper.class);

    @EnumMapping
    Map mapJpaToMap(MapJpa mapJpa);

    @EnumMapping
    MapJpa mapToMapJpa(Map map);

}
