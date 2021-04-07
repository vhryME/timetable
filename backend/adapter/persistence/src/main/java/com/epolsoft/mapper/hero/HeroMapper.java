package com.epolsoft.mapper.hero;


import com.epolsoft.domain.hero.Hero;
import com.epolsoft.dto.hero.HeroJpa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;


@Mapper(uses = {RoleMapper.class, SpellMapper.class, TalentMapper.class})
public interface HeroMapper {

    HeroMapper INSTANCE = Mappers.getMapper(HeroMapper.class);

    @Mappings({
            @Mapping(source = "heroJpa.id", target = "id"),
            @Mapping(source = "heroJpa.name", target = "name"),
            @Mapping(source = "heroJpa.icon", target = "icon"),
            @Mapping(source = "heroJpa.role", target = "role"),
            @Mapping(source = "heroJpa.isMelee", target = "isMelee"),
            @Mapping(source = "heroJpa.dateOfCreated", target = "dateOfCreated"),
            @Mapping(source = "heroJpa.spells", target = "spells"),
            @Mapping(source = "heroJpa.talents", target = "talents")
    })
    Hero heroJpaToHero(HeroJpa heroJpa);


    @Mappings({
            @Mapping(source = "hero.id", target = "id"),
            @Mapping(source = "hero.name", target = "name"),
            @Mapping(source = "hero.icon", target = "icon"),
            @Mapping(source = "hero.role", target = "role"),
            @Mapping(source = "hero.isMelee", target = "isMelee"),
            @Mapping(source = "hero.dateOfCreated", target = "dateOfCreated"),
            @Mapping(source = "hero.spells", target = "spells"),
            @Mapping(source = "hero.talents", target = "talents")
    })
    HeroJpa heroToHeroJpa(Hero hero);

}