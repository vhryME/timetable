package com.epolsoft.hero.controller;


import com.epolsoft.hero.dto.out.SpellAuditDtoOut;
import com.epolsoft.hero.mapper.SpellDtoMapper;
import com.epolsoft.hero.port.in.SpellAuditUseCase;
import com.epolsoft.mapper.DateMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/spell")
@RequiredArgsConstructor
public class SpellController {

    private final SpellAuditUseCase auditUseCase;

    private final SpellDtoMapper mapper;

    private final DateMapper dateMapper;


    @GetMapping("history/{id}")
    public Page<SpellAuditDtoOut> getSpellHistory(Pageable pageable, @PathVariable Long id) {
        return mapper.spellAuditPageToSpellAuditDtoOutPage(auditUseCase.getSpellHistory(id, pageable));
    }


    @GetMapping("history")
    public List<SpellAuditDtoOut> getAllSpellsHistory() {
        return mapper.spellsAuditToSpellsAuditDtpOut(auditUseCase.getAllSpellsAudit());
    }


    @GetMapping("history/date/{date}")
    public List<SpellAuditDtoOut> getSpellsHistoryByDate(@PathVariable String date) {
        return mapper.spellsAuditToSpellsAuditDtpOut(auditUseCase.getSpellsAuditByDate(dateMapper.map(date)));
    }


    @GetMapping("history/name/{name}")
    public List<SpellAuditDtoOut> getSpellsHistoryByName(@PathVariable String name) {
        return mapper.spellsAuditToSpellsAuditDtpOut(auditUseCase.getSpellsAuditByName(name));
    }

}