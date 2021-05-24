package com.epolsoft.hero.mapper;


import com.epolsoft.hero.domain.Spell;
import com.epolsoft.hero.domain.SpellAudit;
import com.epolsoft.hero.dto.in.SpellDtoIn;
import com.epolsoft.hero.dto.out.SpellAuditDtoOut;
import com.epolsoft.hero.dto.out.SpellDtoOut;
import com.epolsoft.mapper.DtoMapper;
import com.epolsoft.mapper.SingleMapper;
import org.mapstruct.Mapper;


@Mapper
public interface SpellDtoMapper extends DtoMapper<SpellDtoIn, Spell, SpellDtoOut> {
//
//    Spell spellDtoInToSpell(SpellDtoIn spellDtoIn);
//
//
//    SpellDtoOut spellToSpellDtoOut(Spell spell);
//
//
    SpellAuditDtoOut spellAuditToSpellAuditDtoOut(SpellAudit spellAudit);

}