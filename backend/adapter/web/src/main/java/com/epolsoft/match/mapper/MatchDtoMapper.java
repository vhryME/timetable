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

import java.util.List;
import java.util.stream.Collectors;


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


    default List<MatchDtoOut> matchesToMatchesDtoOut(List<Match> matches) {
        return matches.stream().map(this::matchToMatchDtoOut).collect(Collectors.toList());
    }


    default Page<MatchDtoOut> pageToPageOut(Page<Match> page) {
        return page.map(this::matchToMatchDtoOut);
    }


    @Mapper
    interface TypeOfMatchMapper {

        default TypeOfMatch map(Long id) { return TypeOfMatch.getTypeOfMatchById(id); }


        default Long map(TypeOfMatch type) {
            return TypeOfMatch.getIdByTypeOfMatch(type);
        }

    }


    @Mapper
    interface RegionMapper {

        default Region map(Long id) {
            return Region.getRegionById(id);
        }

        default Long map(Region region) {
            return Region.getIdByRegion(region);
        }

    }

}
