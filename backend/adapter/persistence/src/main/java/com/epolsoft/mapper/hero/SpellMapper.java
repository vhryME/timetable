package com.epolsoft.mapper.hero;


import com.epolsoft.domain.hero.Spell;
import com.epolsoft.dto.hero.SpellJpa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;


@Mapper
public interface SpellMapper {

    SpellMapper INSTANCE = Mappers.getMapper(SpellMapper.class);

    @Mappings({
            @Mapping(source = "spellJpa.id", target = "id"),
            @Mapping(source = "spellJpa.name", target = "name"),
            @Mapping(source = "spellJpa.key", target = "key"),
            @Mapping(source = "spellJpa.description", target = "description"),
            @Mapping(source = "spellJpa.icon", target = "icon"),
            @Mapping(source = "spellJpa.cooldown", target = "cooldown"),
            @Mapping(source = "spellJpa.manaCost", target = "manaCost"),
    })
    Spell spellJpaToSpell(SpellJpa spellJpa);

    @Mappings({
            @Mapping(source = "spell.id", target = "id"),
            @Mapping(source = "spell.name", target = "name"),
            @Mapping(source = "spell.key", target = "key"),
            @Mapping(source = "spell.description", target = "description"),
            @Mapping(source = "spell.icon", target = "icon"),
            @Mapping(source = "spell.cooldown", target = "cooldown"),
            @Mapping(source = "spell.manaCost", target = "manaCost"),
    })
    SpellJpa spellToSpellJpa(Spell spell);

}