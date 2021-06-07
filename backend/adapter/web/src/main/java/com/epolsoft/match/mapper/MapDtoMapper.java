package com.epolsoft.match.mapper;


import com.epolsoft.mapper.SingleMapper;
import com.epolsoft.match.domain.Map;
import org.mapstruct.Mapper;


@Mapper
public interface MapDtoMapper extends SingleMapper<Map, Long> {

    @Override
    default Long inToOut(Map map) {
        return Map.getIdByMap(map);
    }


    @Override
    default Map outToIn(Long id) {
        return Map.getMapById(id);
    }

}
