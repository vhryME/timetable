package com.epolsoft.match.mapper;


import com.epolsoft.match.domain.Match;
import com.epolsoft.match.domain.Region;
import com.epolsoft.match.domain.TypeOfMatch;
import com.epolsoft.match.dto.in.MatchDtoIn;
import com.epolsoft.match.dto.in.MatchDtoInFiltered;
import com.epolsoft.match.dto.out.MatchDtoOut;
import com.epolsoft.match.port.out.MatchPort;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDate;


@Mapper(uses = {MapDtoMapper.class, TeamDtoMapper.class, MatchDtoMapper.DateMapper.class,
        MatchDtoMapper.TypeOfMatchMapper.class, MatchDtoMapper.RegionMapper.class})
public interface MatchDtoMapper {

    @Mapping(source = "matchDtoIn.mapsId", target = "maps")
    Match matchDtoInToMatch(MatchDtoIn matchDtoIn);


    @Mapping(source = "match.maps", target = "mapsId")
    MatchDtoOut matchToMatchDtoOut(Match match);


    @Mapping(source = "matchDtoInFiltered.mapsId", target = "maps")
    MatchPort.MatchFiltered matchDtoInFilteredToMatchFiltered(MatchDtoInFiltered matchDtoInFiltered);


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

        default String asString(Region region) {
            return region != null ? region.name() : null;
        }

        default Region asType(String region) {
            return region != null ? Region.valueOf(region) : null;
        }

    }

}