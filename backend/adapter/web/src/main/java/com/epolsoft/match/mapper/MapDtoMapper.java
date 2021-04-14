package com.epolsoft.match.mapper;


import com.epolsoft.match.domain.Map;
import org.mapstruct.Mapper;


@Mapper
public interface MapDtoMapper {

    default Map map(int value) {
        return Map.getMapById(value);
    }

    default Integer map(Map map) {
        return Map.getIdByMap(map);
    }

}
