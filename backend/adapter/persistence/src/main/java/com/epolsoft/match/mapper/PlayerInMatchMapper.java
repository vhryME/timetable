package com.epolsoft.match.mapper;


import com.epolsoft.hero.mapper.HeroMapper;
import com.epolsoft.hero.mapper.TalentMapper;
import com.epolsoft.match.domain.PlayerInMatch;
import com.epolsoft.match.jpa.PlayerInMatchJpa;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper(uses = {PlayerMapper.class, HeroMapper.class, TalentMapper.class, StatisticMapper.class})
public interface PlayerInMatchMapper {

    PlayerInMatchMapper INSTANCE = Mappers.getMapper(PlayerInMatchMapper.class);


    PlayerInMatch playerInMatchJpaToPlayerInMatch(PlayerInMatchJpa playerInMatchJpa);

    PlayerInMatchJpa playerInMatchToPlayerInMatchJpa(PlayerInMatch playerInMatch);

}