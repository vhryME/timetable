package com.epolsoft.match.mapper;

import com.epolsoft.hero.mapper.HeroJpaMapper;
import com.epolsoft.hero.mapper.TalentJpaMapper;
import com.epolsoft.mapper.JpaMapper;
import com.epolsoft.match.domain.PlayerInMatch;
import com.epolsoft.match.domain.PlayerInMatchJpa;
import com.epolsoft.match.domain.StatisticJpa;
import org.mapstruct.Mapper;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(uses = {PlayerJpaMapper.class, HeroJpaMapper.class, TalentJpaMapper.class, StatisticJpaMapper.class})
public interface PlayerInMatchJpaMapper extends JpaMapper<PlayerInMatchJpa, PlayerInMatch> {

    default Set<PlayerInMatch> setJpaToSetEntity(Set<PlayerInMatchJpa> set){
        return set.stream().map(this::jpaEntityToEntity).collect(Collectors.toSet());
    }

    default Set<PlayerInMatchJpa> setEntityToSetJpa(Set<PlayerInMatch> set){
        return set.stream().map(this::entityToJpaEntity).collect(Collectors.toSet());
    }

}
