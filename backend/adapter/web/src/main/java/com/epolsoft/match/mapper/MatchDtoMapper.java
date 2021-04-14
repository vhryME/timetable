package com.epolsoft.match.mapper;


import com.epolsoft.match.domain.Match;
import com.epolsoft.match.dto.in.MatchDtoIn;
import com.epolsoft.match.dto.in.MatchDtoInFiltered;
import com.epolsoft.match.dto.out.MatchDtoOut;
import com.epolsoft.match.dto.out.TeamDtoOut;
import com.epolsoft.match.port.out.MatchPort;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDate;


@Mapper(uses = {MapDtoMapper.class, TeamDtoMapper.class})
public interface MatchDtoMapper {


    @Mapping(target = "type", expression = "java(TypeOfMatch.valueOf(matchDtoIn.getType()))")
    @Mapping(target = "date", expression = "java(LocalDate.parse(matchDtoIn.getDate()))")
    @Mapping(source = "matchDtoIn.mapsId", target = "maps")
    @Mapping(target = "region", expression = "java(Region.valueOf(matchDtoIn.getRegion()))")
    Match matchDtoInToMatch(MatchDtoIn matchDtoIn);


    @Mapping(target = "type", expression = "java(match.getType().name())")
    @Mapping(target = "date", expression = "java(match.getDate().toString())")
    @Mapping(source = "match.maps", target = "mapsId")
    @Mapping(target = "region", expression = "java(match.getRegion().name())")
    MatchDtoOut matchToMatchDtoOut(Match match);


    MatchPort.MatchFiltered matchDtoInFilteredToMatchFiltered(MatchDtoInFiltered matchDtoInFiltered);

}