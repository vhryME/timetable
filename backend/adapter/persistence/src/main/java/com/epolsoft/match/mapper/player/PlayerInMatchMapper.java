package com.epolsoft.match.mapper.player;


import com.epolsoft.match.domain.PlayerInMatch;
import com.epolsoft.match.dto.player.PlayerInMatchJpa;
import com.epolsoft.hero.mapper.HeroMapper;
import com.epolsoft.hero.mapper.TalentMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;


@Mapper(uses = {PlayerMapper.class, HeroMapper.class, TalentMapper.class, StatisticMapper.class})
public interface PlayerInMatchMapper {

    PlayerInMatchMapper INSTANCE = Mappers.getMapper(PlayerInMatchMapper.class);


    PlayerInMatch playerInMatchJpaToPlayerInMatch(PlayerInMatchJpa playerInMatchJpa);

    PlayerInMatchJpa playerInMatchToPlayerInMatchJpa(PlayerInMatch playerInMatch);

}