package com.epolsoft.hero.port.in;


import com.epolsoft.hero.domain.SpellAudit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;


public interface SpellAuditUseCase {

    List<SpellAudit> getAllSpellsAudit();


    SpellAudit getSpellAuditById(Long id);


    List<SpellAudit> getSpellsAuditByDate(LocalDate date);


    List<SpellAudit> getSpellsAuditByName(String name);


    Page<SpellAudit> getSpellHistory(Long id, Pageable pageable);

}