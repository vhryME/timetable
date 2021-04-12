package com.epolsoft.match.mapper;


import com.epolsoft.match.domain.Region;
import com.epolsoft.match.dto.in.RegionDtoIn;
import com.epolsoft.match.dto.out.RegionDtoOut;
import org.mapstruct.Mapper;
import org.mapstruct.ValueMapping;
import org.mapstruct.ValueMappings;
import org.mapstruct.factory.Mappers;


@Mapper
public interface RegionDtoMapper {

    RegionDtoMapper INSTANCE = Mappers.getMapper(RegionDtoMapper.class);


    @ValueMappings({
            @ValueMapping(source = "NA", target = "NA"),
            @ValueMapping(source = "EU", target = "EU"),
            @ValueMapping(source = "KR", target = "KR"),
            @ValueMapping(source = "CN", target = "CN"),
            @ValueMapping(source = "Unknown", target = "Unknown")
    })
    Region regionJpaToRegion(RegionDtoOut regionDtoOut);


    @ValueMappings({
            @ValueMapping(source = "NA", target = "NA"),
            @ValueMapping(source = "EU", target = "EU"),
            @ValueMapping(source = "KR", target = "KR"),
            @ValueMapping(source = "CN", target = "CN"),
            @ValueMapping(source = "Unknown", target = "Unknown")
    })
    RegionDtoIn regionToRegionDtoIn(Region region);

}
