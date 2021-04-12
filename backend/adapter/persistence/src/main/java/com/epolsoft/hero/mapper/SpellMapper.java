package com.epolsoft.hero.mapper;


import com.epolsoft.hero.domain.Spell;
import com.epolsoft.hero.jpa.SpellJpa;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface SpellMapper {

    SpellMapper INSTANCE = Mappers.getMapper(SpellMapper.class);


    Spell spellJpaToSpell(SpellJpa spellJpa);

    SpellJpa spellToSpellJpa(Spell spell);

}