package com.epolsoft.match.mapper;


import com.epolsoft.match.domain.Match;
import com.epolsoft.match.dto.in.MatchDtoIn;
import com.epolsoft.match.dto.in.MatchDtoInFiltered;
import com.epolsoft.match.dto.out.MatchDtoOut;
import com.epolsoft.match.port.out.MatchPort;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(uses = {MapDtoMapper.class, TeamDtoMapper.class})
public interface MatchDtoMapper {


    @Mapping(target = "type", expression = "java(com.epolsoft.match.domain.TypeOfMatch.valueOf(matchDtoIn.getType()))")
    @Mapping(target = "date", expression = "java(java.time.LocalDate.parse(matchDtoIn.getDate()))")
    @Mapping(source = "matchDtoIn.mapsId", target = "maps")
    @Mapping(target = "region", expression = "java(com.epolsoft.match.domain.Region.valueOf(matchDtoIn.getRegion()))")
    Match matchDtoInToMatch(MatchDtoIn matchDtoIn);


    @Mapping(target = "type", expression = "java(match.getType().name())")
    @Mapping(target = "date", expression = "java(match.getDate().toString())")
    @Mapping(source = "match.maps", target = "mapsId")
    @Mapping(target = "region", expression = "java(match.getRegion().name())")
    MatchDtoOut matchToMatchDtoOut(Match match);


    @Mapping(target = "type", expression = "java(com.epolsoft.match.domain.TypeOfMatch.valueOf(matchDtoInFiltered.getType()))")
    @Mapping(target = "date", expression = "java(java.time.LocalDate.parse(matchDtoInFiltered.getDate()))")
    @Mapping(source = "matchDtoInFiltered.mapsId", target = "maps")
    @Mapping(target = "region", expression = "java(com.epolsoft.match.domain.Region.valueOf(matchDtoInFiltered.getRegion()))")
    MatchPort.MatchFiltered matchDtoInFilteredToMatchFiltered(MatchDtoInFiltered matchDtoInFiltered);

}