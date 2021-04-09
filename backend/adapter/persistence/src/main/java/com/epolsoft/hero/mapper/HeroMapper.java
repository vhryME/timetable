package com.epolsoft.hero.mapper;


import com.epolsoft.hero.domain.Hero;
import com.epolsoft.hero.dto.HeroJpa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;


@Mapper(uses = {RoleMapper.class, SpellMapper.class, TalentMapper.class})
public interface HeroMapper {

    HeroMapper INSTANCE = Mappers.getMapper(HeroMapper.class);

    Hero heroJpaToHero(HeroJpa heroJpa);

    HeroJpa heroToHeroJpa(Hero hero);

}