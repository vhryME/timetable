package com.epolsoft.hero.mapper;


import com.epolsoft.hero.domain.Hero;
import com.epolsoft.hero.dto.in.HeroDtoIn;
import com.epolsoft.hero.dto.out.HeroDtoOut;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(uses = {SpellDtoMapper.class, TalentDtoMapper.class})
public interface HeroDtoMapper {

    @Mapping(target = "role", expression = "java(Role.valueOf(hero.getRole()))")
    @Mapping(target = "dateOfCreation", expression = "java(LocalDate.parse(hero.getDateOfCreation()))")
    Hero heroDtoInToHero(HeroDtoIn heroDtoIn);

    @Mapping(target = "role", expression = "java(hero.getRole().name())")
    @Mapping(target = "dateOfCreation", expression = "java(hero.getDateOfCreation().toString())")
    HeroDtoOut heroToHeroDtoOut(Hero hero);

}