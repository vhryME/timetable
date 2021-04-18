package com.epolsoft.match.mapper;


import com.epolsoft.match.domain.Map;
import org.mapstruct.Mapper;


@Mapper
public interface MapDtoMapper {

    default Map map(int id) {
        return Map.getMapById(id);
    }

    default Integer map(Map map) {
        return Map.getIdByMap(map);
    }

}
