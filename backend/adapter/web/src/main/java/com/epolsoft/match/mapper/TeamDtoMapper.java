package com.epolsoft.match.mapper;


import com.epolsoft.match.domain.Team;
import com.epolsoft.match.dto.in.TeamDtoIn;
import com.epolsoft.match.dto.out.TeamDtoOut;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper(uses = {PlayerInMatchDtoMapper.class})
public interface TeamDtoMapper {

    TeamDtoMapper INSTANCE = Mappers.getMapper(TeamDtoMapper.class);


    Team teamJpaToTeam(TeamDtoOut teamDtoOut);

    TeamDtoIn teamToTeamDtoIn(Team team);

}