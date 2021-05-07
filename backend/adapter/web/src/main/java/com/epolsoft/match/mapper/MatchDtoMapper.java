package com.epolsoft.match.mapper;


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


@Mapper(uses = {MapDtoMapper.class, TeamDtoMapper.class, MatchDtoMapper.DateMapper.class,
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
        return page.map(new Function<Match, MatchDtoOut>() {
            @Override
            public MatchDtoOut apply(Match match) {
                return matchToMatchDtoOut(match);
            }
        });
    }


    @Mapper
    interface DateMapper {

        default String asString(LocalDate date) {
            return date != null ? date.toString() : null;
        }

        default LocalDate asLocalDate(String date) {
            return date != null ? LocalDate.parse(date) : null;
        }

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

//        default String asString(Region region) { return region != null ? region.name() : null; }

//        default Region asType(String region) { return region != null ? Region.valueOf(region) : null; }

        default Region map(int id) {
            return Region.getRegionById(id);
        }

        default Integer map(Region region) {
            return Region.getIdByRegion(region);
        }

    }

}