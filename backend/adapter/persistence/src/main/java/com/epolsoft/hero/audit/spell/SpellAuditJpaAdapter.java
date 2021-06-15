package com.epolsoft.hero.audit.spell;


import com.epolsoft.hero.domain.SpellAudit;
import com.epolsoft.hero.port.out.SpellAuditPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


@Component
@RequiredArgsConstructor
public class SpellAuditJpaAdapter implements SpellAuditPort {

    private final SpellAuditJpaRepository repository;

    private final SpellAuditJpaMapper mapper;


    @Override
    public List<SpellAudit> findAllSpellsAudit() {
        return repository.findAll().stream().map(mapper::jpaEntityToEntity).collect(Collectors.toList());
    }


    @Override
    public SpellAudit findSpellAuditById(Long id) {
        return mapper.jpaEntityToEntity(repository.getOne(id));
    }


    @Override
    public List<SpellAudit> findSpellsAuditByDate(LocalDate date) {
        return repository.findAll(SpellAuditJpaSpecification.findByRevisionDate(date)).stream().map(mapper::jpaEntityToEntity).
                collect(Collectors.toList());
    }


    public List<SpellAudit> findSpellsAuditByName(String name) {
        return repository.findAll(SpellAuditJpaSpecification.findByName(name)).stream().map(mapper::jpaEntityToEntity).
                collect(Collectors.toList());
    }


    @Override
    public Page<SpellAudit> findSpellHistory(Long id, Pageable pageable) {
        return repository.findAll(SpellAuditJpaSpecification.findBySpellId(id), pageable).map(mapper::jpaEntityToEntity);
    }

}