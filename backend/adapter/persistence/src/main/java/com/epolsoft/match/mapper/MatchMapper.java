package com.epolsoft.match.mapper;


import com.epolsoft.match.domain.Match;
import com.epolsoft.match.jpa.MatchJpa;
import com.epolsoft.match.port.out.MatchPort;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper(uses = {TypeOfMatchMapper.class, MapMapper.class, RegionMapper.class, TeamMapper.class})
public interface MatchMapper {

    MatchMapper INSTANCE = Mappers.getMapper(MatchMapper.class);


    Match matchJpaToMatch(MatchJpa matchJpa);

    MatchJpa matchToMatchJpa(Match match);

    MatchJpa matchFilteredToMatchJpa(MatchPort.MatchFiltered matchFiltered);

}