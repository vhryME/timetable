package com.epolsoft.match.mapper;


import com.epolsoft.match.domain.Team;
import com.epolsoft.match.dto.in.TeamDtoIn;
import com.epolsoft.match.dto.out.TeamDtoOut;
import org.mapstruct.Mapper;


@Mapper(uses = {PlayerInMatchDtoMapper.class})
public interface TeamDtoMapper {

    Team teamDtoInToTeam(TeamDtoIn teamDtoIn);

    TeamDtoOut teamToTeamDtoOut(Team team);

}