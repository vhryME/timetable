package com.epolsoft.mapper.match;


import com.epolsoft.domain.match.Match;
import com.epolsoft.dto.match.MatchJpa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;


@Mapper(uses = {TypeOfMatchMapper.class, MapMapper.class, RegionMapper.class, TeamMapper.class})
public interface MatchMapper {

    MatchMapper INSTANCE = Mappers.getMapper(MatchMapper.class);

    @Mappings({
            @Mapping(source = "matchJpa.id", target = "id"),
            @Mapping(source = "matchJpa.type", target = "type"),
            @Mapping(source = "matchJpa.date", target = "date"),
            @Mapping(source = "matchJpa.duration", target = "duration"),
            @Mapping(source = "matchJpa.maps", target = "maps"),
            @Mapping(source = "matchJpa.regions", target = "regions"),
            @Mapping(source = "matchJpa.teams", target = "teams")
    })
    Match matchJpaToMatch(MatchJpa matchJpa);

    @Mappings({
            @Mapping(source = "match.id", target = "id"),
            @Mapping(source = "match.type", target = "type"),
            @Mapping(source = "match.date", target = "date"),
            @Mapping(source = "match.duration", target = "duration"),
            @Mapping(source = "match.maps", target = "maps"),
            @Mapping(source = "match.regions", target = "regions"),
            @Mapping(source = "match.teams", target = "teams")
    })
    MatchJpa matchToMatchJpa(Match match);

}