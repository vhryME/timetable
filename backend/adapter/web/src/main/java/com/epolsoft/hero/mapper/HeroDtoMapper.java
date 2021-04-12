package com.epolsoft.hero.mapper;


import com.epolsoft.hero.domain.Hero;
import com.epolsoft.hero.dto.in.HeroDtoIn;
import com.epolsoft.hero.dto.out.HeroDtoOut;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper(uses = {RoleDtoMapper.class, SpellDtoMapper.class, TalentDtoMapper.class})
public interface HeroDtoMapper {

    HeroDtoMapper INSTANCE = Mappers.getMapper(HeroDtoMapper.class);

    Hero heroDtoOutToHero(HeroDtoOut heroDtoOut);

    HeroDtoIn heroToHeroDtoIn(Hero hero);

}