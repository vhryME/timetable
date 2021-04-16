package com.epolsoft.hero.mapper;


import com.epolsoft.hero.domain.Spell;
import com.epolsoft.hero.dto.in.SpellDtoIn;
import org.mapstruct.Mapper;


@Mapper
public interface SpellDtoMapper {
    Spell SpellDtoInToSpell(SpellDtoIn spellDtoIn);
}