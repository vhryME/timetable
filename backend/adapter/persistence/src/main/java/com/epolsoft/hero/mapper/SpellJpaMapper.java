package com.epolsoft.hero.mapper;


import com.epolsoft.hero.domain.Spell;
import com.epolsoft.hero.domain.SpellJpa;
import com.epolsoft.mapper.JpaMapper;
import org.mapstruct.Mapper;

import java.util.Set;
import java.util.stream.Collectors;


@Mapper
public interface SpellJpaMapper extends JpaMapper<SpellJpa, Spell> {

    default Set<SpellJpa> setEntityToSetJpaEntity(Set<Spell> set){
        return set.stream().map(this::entityToJpaEntity).collect(Collectors.toSet());
    }


    default Set<Spell> setJpaEntityToSetEntity(Set<SpellJpa> set){
        return set.stream().map(this::jpaEntityToEntity).collect(Collectors.toSet());
    }
}