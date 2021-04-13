package com.epolsoft.hero.mapper;


import com.epolsoft.hero.domain.Hero;
import com.epolsoft.hero.jpa.HeroJpa;
import org.mapstruct.Mapper;


@Mapper(uses = {RoleMapper.class, SpellMapper.class, TalentMapper.class})
public interface HeroMapper {

    Hero heroJpaToHero(HeroJpa heroJpa);

    HeroJpa heroToHeroJpa(Hero hero);

}