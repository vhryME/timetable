package com.epolsoft.hero.mapper;


import com.epolsoft.hero.domain.Spell;
import com.epolsoft.hero.dto.in.SpellDtoIn;
import com.epolsoft.hero.dto.out.SpellDtoOut;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface SpellDtoMapper {

    Spell spellDtoInToSpell(SpellDtoIn spellDtoIn);

    SpellDtoIn spellToSpellDtoOut(Spell spell);

}