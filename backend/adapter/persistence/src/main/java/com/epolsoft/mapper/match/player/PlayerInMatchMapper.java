package com.epolsoft.mapper.match.player;


import com.epolsoft.domain.match.player.PlayerInMatch;
import com.epolsoft.dto.match.player.PlayerInMatchJpa;
import com.epolsoft.mapper.hero.HeroMapper;
import com.epolsoft.mapper.hero.TalentMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;


@Mapper(uses = {PlayerMapper.class, HeroMapper.class, TalentMapper.class, StatisticMapper.class})
public interface PlayerInMatchMapper {

    PlayerInMatchMapper INSTANCE = Mappers.getMapper(PlayerInMatchMapper.class);

    @Mappings({
            @Mapping(source = "playerInMatchJpa.id", target = "id"),
            @Mapping(source = "playerInMatchJpa.player", target = "player"),
            @Mapping(source = "playerInMatchJpa.hero", target = "hero"),
            @Mapping(source = "playerInMatchJpa.talents", target = "talents"),
            @Mapping(source = "playerInMatchJpa.statistic", target = "statistic"),
    })
    PlayerInMatch playerInMatchJpaToPlayerInMatch(PlayerInMatchJpa playerInMatchJpa);

    @Mappings({
            @Mapping(source = "playerInMatch.id", target = "id"),
            @Mapping(source = "playerInMatch.player", target = "player"),
            @Mapping(source = "playerInMatch.hero", target = "hero"),
            @Mapping(source = "playerInMatch.talents", target = "talents"),
            @Mapping(source = "playerInMatch.statistic", target = "statistic"),
    })
    PlayerInMatchJpa playerInMatchToPlayerInMatchJpa(PlayerInMatch playerInMatch);

}