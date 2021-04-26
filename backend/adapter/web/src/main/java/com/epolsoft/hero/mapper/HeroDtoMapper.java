package com.epolsoft.hero.mapper;


import com.epolsoft.hero.domain.Hero;
import com.epolsoft.hero.domain.Role;
import com.epolsoft.hero.dto.in.HeroDtoIn;
import com.epolsoft.hero.dto.in.HeroDtoInFiltered;
import com.epolsoft.hero.dto.out.HeroDtoOut;
import com.epolsoft.hero.port.out.HeroPort;
import com.epolsoft.match.mapper.MatchDtoMapper;
import org.mapstruct.Mapper;


@Mapper(uses = {SpellDtoMapper.class, TalentDtoMapper.class, MatchDtoMapper.DateMapper.class, HeroDtoMapper.RoleDtoMapper.class})
public interface HeroDtoMapper {

    Hero heroDtoInToHero(HeroDtoIn heroDtoIn);


    HeroDtoOut heroToHeroDtoOut(Hero hero);


    HeroPort.HeroFiltered heroDtoInFilteredToHeroFiltered(HeroDtoInFiltered heroDtoInFiltered);


    @Mapper
    interface RoleDtoMapper {

        default String asString(Role role) {
            return role != null ? role.name() : null;
        }

        default Role asRole(String role) {
            return role != null ? Role.valueOf(role) : null;
        }

    }

}