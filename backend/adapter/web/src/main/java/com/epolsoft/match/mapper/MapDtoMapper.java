package com.epolsoft.match.mapper;


import com.epolsoft.mapper.SingleMapper;
import com.epolsoft.match.domain.Map;
import org.mapstruct.Mapper;


@Mapper
public interface MapDtoMapper extends SingleMapper<Map, Integer> {

    @Override
    default Integer inToOut(Map map) {
        return Map.getIdByMap(map);
    }


    @Override
    default Map outToIn(Integer id) {
        return Map.getMapById(id);
    }

}
