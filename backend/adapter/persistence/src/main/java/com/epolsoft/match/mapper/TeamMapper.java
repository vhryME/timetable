package com.epolsoft.match.mapper;


import com.epolsoft.match.domain.Team;
import com.epolsoft.match.dto.TeamJpa;
import com.epolsoft.match.mapper.player.PlayerInMatchMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;


@Mapper(uses = {PlayerInMatchMapper.class})
public interface TeamMapper {

    TeamMapper INSTANCE = Mappers.getMapper(TeamMapper.class);


    Team teamJpaToTeam(TeamJpa teamJpa);

    TeamJpa teamToTeamJpa(Team team);

}