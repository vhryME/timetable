package com.epolsoft.match.mapper;


import com.epolsoft.match.domain.Region;
import com.epolsoft.match.dto.RegionJpa;
import org.mapstruct.Mapper;
import org.mapstruct.ValueMapping;
import org.mapstruct.ValueMappings;
import org.mapstruct.factory.Mappers;


@Mapper
public interface RegionMapper {

    RegionMapper INSTANCE = Mappers.getMapper(RegionMapper.class);


    @ValueMappings({
            @ValueMapping(source = "NA", target = "NA"),
            @ValueMapping(source = "EU", target = "EU"),
            @ValueMapping(source = "KR", target = "KR"),
            @ValueMapping(source = "CN", target = "CN"),
            @ValueMapping(source = "Unknown", target = "Unknown")
    })
    Region regionJpaToRegion(RegionJpa regionJpa);


    @ValueMappings({
            @ValueMapping(source = "NA", target = "NA"),
            @ValueMapping(source = "EU", target = "EU"),
            @ValueMapping(source = "KR", target = "KR"),
            @ValueMapping(source = "CN", target = "CN"),
            @ValueMapping(source = "Unknown", target = "Unknown")
    })
    RegionJpa regionToRegionJpa(Region region);

}
