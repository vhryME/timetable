package com.epolsoft.mapper.match;


import com.epolsoft.domain.match.Region;
import com.epolsoft.dto.match.RegionJpa;
import org.mapstruct.EnumMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface RegionMapper {

    RegionMapper INSTANCE = Mappers.getMapper(RegionMapper.class);

    @EnumMapping
    Region regionJpaToRegion(RegionJpa regionJpa);

    @EnumMapping
    RegionJpa regionToRegionJpa(Region region);

}
