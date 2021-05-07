package com.epolsoft.hero.mapper;


import com.epolsoft.hero.domain.Hero;
import com.epolsoft.hero.domain.Role;
import com.epolsoft.hero.dto.in.HeroDtoIn;
import com.epolsoft.hero.dto.in.HeroDtoInFiltered;
import com.epolsoft.hero.dto.out.FullHeroDtoOut;
import com.epolsoft.hero.dto.out.HeroDtoOut;
import com.epolsoft.hero.port.out.HeroPort;
import com.epolsoft.match.domain.Match;
import com.epolsoft.match.domain.Region;
import com.epolsoft.match.dto.out.MatchDtoOut;
import com.epolsoft.match.mapper.MatchDtoMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

import java.util.function.Function;


@Mapper(uses = {SpellDtoMapper.class, TalentDtoMapper.class, MatchDtoMapper.DateMapper.class, HeroDtoMapper.RoleDtoMapper.class})
public interface HeroDtoMapper {

    @Mapping(source = "heroDtoIn.roleId", target = "role")
    Hero heroDtoInToHero(HeroDtoIn heroDtoIn);


    @Mapping(source = "hero.role", target = "roleId")
    HeroDtoOut heroToHeroDtoOut(Hero hero);


//    @Mapping(source = "heroDtoInFiltered.roleId", target = "role")
    HeroPort.HeroFiltered heroDtoInFilteredToHeroFiltered(HeroDtoInFiltered heroDtoInFiltered);


    @Mapping(source = "hero.role", target = "roleId")
    FullHeroDtoOut heroToFullHeroDtoOut(Hero hero);


    default Page<HeroDtoOut> pageToPageOut(Page<Hero> page) {
        return page.map(new Function<Hero, HeroDtoOut>() {
            @Override
            public HeroDtoOut apply(Hero hero) {
                return heroToHeroDtoOut(hero);
            }
        });
    }


    @Mapper
    interface RoleDtoMapper {

//        default String asString(Role role) {
//            return role != null ? role.name() : null;
//        }
//
//        default Role asRole(String role) {
//            return role != null ? Role.valueOf(role) : null;
//        }

        default Role map(int id) {
            return Role.getRoleById(id);
        }

        default Integer map(Role role) {
            return Role.getIdByRole(role);
        }

    }

}