package com.epolsoft.mapper.match;


import com.epolsoft.domain.match.Team;
import com.epolsoft.dto.match.TeamJpa;
import com.epolsoft.mapper.match.player.PlayerInMatchMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;


@Mapper(uses = {PlayerInMatchMapper.class})
public interface TeamMapper {

    TeamMapper INSTANCE = Mappers.getMapper(TeamMapper.class);

    @Mappings({
            @Mapping(source = "teamJpa.id", target = "id"),
            @Mapping(source = "teamJpa.players", target = "players"),
            @Mapping(source = "teamJpa.isWinner", target = "isWinner"),
            @Mapping(source = "teamJpa.levelOfTeam", target = "levelOfTeam"),
            @Mapping(source = "teamJpa.experienceOfTeam", target = "experienceOfTeam"),
    })
    Team teamJpaToTeam(TeamJpa teamJpa);

    @Mappings({
            @Mapping(source = "team.id", target = "id"),
            @Mapping(source = "team.players", target = "players"),
            @Mapping(source = "team.isWinner", target = "isWinner"),
            @Mapping(source = "team.levelOfTeam", target = "levelOfTeam"),
            @Mapping(source = "team.experienceOfTeam", target = "experienceOfTeam"),
    })
    TeamJpa teamToTeamJpa(Team team);

}