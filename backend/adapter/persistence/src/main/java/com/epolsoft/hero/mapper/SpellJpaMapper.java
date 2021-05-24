package com.epolsoft.hero.mapper;


import com.epolsoft.hero.domain.Spell;
import com.epolsoft.hero.domain.SpellJpa;
import com.epolsoft.mapper.JpaMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;


@Mapper
public interface SpellJpaMapper extends JpaMapper<SpellJpa, Spell> {}