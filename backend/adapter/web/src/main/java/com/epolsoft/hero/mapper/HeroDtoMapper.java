package com.epolsoft.hero.mapper;


import com.epolsoft.hero.domain.Hero;
import com.epolsoft.hero.domain.Role;
import com.epolsoft.hero.dto.in.HeroDtoIn;
import com.epolsoft.hero.dto.in.HeroDtoInFiltered;
import com.epolsoft.hero.dto.out.FullHeroDtoOut;
import com.epolsoft.hero.dto.out.HeroDtoOut;
import com.epolsoft.hero.port.out.HeroPort;
import com.epolsoft.mapper.DateMapper;
import com.epolsoft.mapper.DtoMapper;
import com.epolsoft.match.domain.Match;
import com.epolsoft.match.domain.Region;
import com.epolsoft.match.dto.out.MatchDtoOut;
import com.epolsoft.match.mapper.MatchDtoMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

import java.util.function.Function;


@Mapper(uses = {SpellDtoMapper.class, TalentDtoMapper.class, DateMapper.class, HeroDtoMapper.RoleDtoMapper.class})
public interface HeroDtoMapper extends DtoMapper<HeroDtoIn, Hero, HeroDtoOut> {

    @Override
    @Mapping(source = "heroDtoIn.roleId", target = "role")
    Hero inToEntity(HeroDtoIn heroDtoIn);


    @Override
    @Mapping(source = "hero.role", target = "roleId")
    HeroDtoOut entityToOut(Hero hero);


    @Mapping(source = "hero.role", target = "roleId")
    FullHeroDtoOut heroToFullHeroDtoOut(Hero hero);


    HeroPort.HeroFiltered heroDtoInFilteredToHeroFiltered(HeroDtoInFiltered heroDtoInFiltered);


    default Page<HeroDtoOut> pageToPageOut(Page<Hero> page) {
        return page.map(this::entityToOut);
    }


    @Mapper
    interface RoleDtoMapper {

        default Role map(Long id) { return Role.getRoleById(id); }


        default Long map(Role role) {
            return Role.getIdByRole(role.getRole());
        }

    }

}