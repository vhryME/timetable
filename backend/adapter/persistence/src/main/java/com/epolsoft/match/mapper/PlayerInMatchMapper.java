package com.epolsoft.match.mapper;


import com.epolsoft.hero.mapper.HeroMapper;
import com.epolsoft.hero.mapper.TalentMapper;
import com.epolsoft.match.domain.PlayerInMatch;
import com.epolsoft.match.jpa.PlayerInMatchJpa;
import org.mapstruct.Mapper;


@Mapper(uses = {PlayerMapper.class, HeroMapper.class, TalentMapper.class, StatisticMapper.class})
public interface PlayerInMatchMapper {

    PlayerInMatch playerInMatchJpaToPlayerInMatch(PlayerInMatchJpa playerInMatchJpa);

    PlayerInMatchJpa playerInMatchToPlayerInMatchJpa(PlayerInMatch playerInMatch);

}