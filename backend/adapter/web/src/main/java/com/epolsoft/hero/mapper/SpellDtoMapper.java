package com.epolsoft.hero.mapper;


import com.epolsoft.hero.domain.Spell;
import com.epolsoft.hero.domain.SpellAudit;
import com.epolsoft.hero.dto.in.SpellDtoIn;
import com.epolsoft.hero.dto.out.SpellAuditDtoOut;
import com.epolsoft.hero.dto.out.SpellDtoOut;
import com.epolsoft.mapper.DtoMapper;
import com.epolsoft.mapper.SingleMapper;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;


@Mapper
public interface SpellDtoMapper extends DtoMapper<SpellDtoIn, Spell, SpellDtoOut> {

    SpellAuditDtoOut spellAuditToSpellAuditDtoOut(SpellAudit spellAudit);


    default List<SpellAuditDtoOut> spellsAuditToSpellsAuditDtpOut(List<SpellAudit> spellsAudit) {
        return spellsAudit.stream().map(this::spellAuditToSpellAuditDtoOut).collect(Collectors.toList());
    }


    default Page<SpellAuditDtoOut> spellAuditPageToSpellAuditDtoOutPage(Page<SpellAudit> spellAuditPage) {
        return spellAuditPage.map(this::spellAuditToSpellAuditDtoOut);
    }

}