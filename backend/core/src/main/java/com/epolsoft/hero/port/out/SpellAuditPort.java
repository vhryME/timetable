package com.epolsoft.hero.port.out;


import com.epolsoft.hero.domain.SpellAudit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;


public interface SpellAuditPort {

    List<SpellAudit> findAllSpellsAudit();

    SpellAudit findSpellAuditById(Long id);

    List<SpellAudit> findSpellsAuditByDate(LocalDate date);

    List<SpellAudit> findSpellsAuditByName(String name);

    Page<SpellAudit> findSpellHistory(Long id, Pageable pageable);

}
