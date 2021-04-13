package com.epolsoft.match.mapper;


import com.epolsoft.match.domain.Region;
import com.epolsoft.match.dto.in.RegionDtoIn;
import com.epolsoft.match.dto.out.RegionDtoOut;
import org.mapstruct.Mapper;
import org.mapstruct.ValueMapping;
import org.mapstruct.ValueMappings;


@Mapper
public interface RegionDtoMapper {

    @ValueMappings({
            @ValueMapping(source = "NA", target = "NA"),
            @ValueMapping(source = "EU", target = "EU"),
            @ValueMapping(source = "KR", target = "KR"),
            @ValueMapping(source = "CN", target = "CN"),
            @ValueMapping(source = "Unknown", target = "Unknown")
    })
    Region regionDtoInToRegion(RegionDtoIn regionDtoIn);


    @ValueMappings({
            @ValueMapping(source = "NA", target = "NA"),
            @ValueMapping(source = "EU", target = "EU"),
            @ValueMapping(source = "KR", target = "KR"),
            @ValueMapping(source = "CN", target = "CN"),
            @ValueMapping(source = "Unknown", target = "Unknown")
    })
    RegionDtoOut regionToRegionDtoOut(Region region);

}
