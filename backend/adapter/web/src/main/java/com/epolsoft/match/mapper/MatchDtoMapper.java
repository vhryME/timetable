package com.epolsoft.match.mapper;


import com.epolsoft.mapper.DateMapper;
import com.epolsoft.match.domain.Match;
import com.epolsoft.match.domain.Region;
import com.epolsoft.match.domain.TypeOfMatch;
import com.epolsoft.match.dto.in.MatchDtoIn;
import com.epolsoft.match.dto.in.MatchDtoInFiltered;
import com.epolsoft.match.dto.out.FullMatchDtoOut;
import com.epolsoft.match.dto.out.MatchDtoOut;
import com.epolsoft.match.port.out.MatchPort;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.function.Function;


@Mapper(uses = {MapDtoMapper.class, TeamDtoMapper.class, DateMapper.class,
        MatchDtoMapper.TypeOfMatchMapper.class, MatchDtoMapper.RegionMapper.class})
public interface MatchDtoMapper {

    @Mapping(source = "matchDtoIn.mapId", target = "map")
    @Mapping(source = "matchDtoIn.regionId", target = "region")
    Match matchDtoInToMatch(MatchDtoIn matchDtoIn);


    @Mapping(source = "match.map", target = "mapId")
    @Mapping(source = "match.region", target = "regionId")
    MatchDtoOut matchToMatchDtoOut(Match match);


    MatchPort.MatchFiltered matchDtoInFilteredToMatchFiltered(MatchDtoInFiltered matchDtoInFiltered);


    @Mapping(source = "match.map", target = "mapId")
    @Mapping(source = "match.region", target = "regionId")
    FullMatchDtoOut matchToFullMatchDtoOut(Match match);


    default Page<MatchDtoOut> pageToPageOut(Page<Match> page) {
        return page.map(this::matchToMatchDtoOut);
    }


    @Mapper
    interface TypeOfMatchMapper {

        default String asString(TypeOfMatch type) {
            return type != null ? type.name() : null;
        }

        default TypeOfMatch asType(String type) {
            return type != null ? TypeOfMatch.valueOf(type) : null;
        }

    }


    @Mapper
    interface RegionMapper {

        default Region map(int id) {
            return Region.getRegionById(id);
        }

        default Integer map(Region region) {
            return Region.getIdByRegion(region);
        }

    }

}