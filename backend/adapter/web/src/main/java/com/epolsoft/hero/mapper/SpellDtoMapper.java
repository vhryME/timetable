package com.epolsoft.hero.mapper;


import com.epolsoft.hero.domain.Spell;
import com.epolsoft.hero.dto.in.SpellDtoIn;
import com.epolsoft.hero.dto.out.SpellDtoOut;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface SpellDtoMapper {

    SpellDtoMapper INSTANCE = Mappers.getMapper(SpellDtoMapper.class);


    Spell spellDtoOutToSpell(SpellDtoOut spellDtoOut);

    SpellDtoIn spellToSpellDtoIn(Spell spell);

}