package com.epolsoft.hero.service;


import com.epolsoft.hero.domain.SpellAudit;
import com.epolsoft.hero.port.in.SpellAuditUseCase;
import com.epolsoft.hero.port.out.SpellAuditPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
@RequiredArgsConstructor
public class SpellAuditService implements SpellAuditUseCase {

    private final SpellAuditPort port;


    @Override
    public List<SpellAudit> getAllSpellsAudit() {
        return port.findAllSpellsAudit();
    }


    @Override
    public SpellAudit getSpellAuditById(Long id) {
        return port.findSpellAuditById(id);
    }


    @Override
    public List<SpellAudit> getSpellsAuditByDate(LocalDate date) {
        return port.findSpellsAuditByDate(date);
    }


    @Override
    public List<SpellAudit> getSpellsAuditByName(String name) {
        return port.findSpellsAuditByName(name);
    }


    @Override
    public Page<SpellAudit> getSpellHistory(Long id, Pageable pageable) {
        return port.findSpellHistory(id, pageable);
    }

}