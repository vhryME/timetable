package com.epolsoft.hero.audit.spell;


import com.epolsoft.hero.audit.AuditListener;
import com.epolsoft.hero.domain.SpellJpa;
import com.epolsoft.hero.repo.SpellRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Example;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;


public class SpellAuditJpaListener implements AuditListener {

    private final SpellRepository spellRepository;

    private final SpellAuditJpaRepository spellAuditRepository;

    private final EntityManager entityManager;


    @Override
    @PostPersist
    @Transactional
    public void prePersist(Object spellJpa) {
        entityManager.clear();

        SpellJpa spellJpaFromDB = spellRepository.findOne(Example.of((SpellJpa) spellJpa)).get();

        SpellJpaAudit spellJpaAudit = new SpellJpaAudit(spellJpaFromDB);

        spellJpaAudit.setRevisionAction("INSERT");

        spellAuditRepository.save(spellJpaAudit);
    }


    @Override
    @PostUpdate
    @Transactional
    public void preUpdate(Object spellJpa) {
        entityManager.clear();

        SpellJpaAudit spellJpaAudit = new SpellJpaAudit((SpellJpa) spellJpa);

        spellJpaAudit.setRevisionAction("UPDATE");

        spellAuditRepository.save(spellJpaAudit);
    }


    @Override
    @PostRemove
    @Transactional
    public void preRemove(Object spellJpa) {
        entityManager.clear();

        SpellJpaAudit spellJpaAudit = new SpellJpaAudit((SpellJpa) spellJpa);

        spellJpaAudit.setRevisionAction("DELETE");

        spellAuditRepository.save(spellJpaAudit);
    }


    public SpellAuditJpaListener(@Lazy SpellAuditJpaRepository spellAuditRepository,
                                 @Lazy EntityManager entityManager,
                                 @Lazy SpellRepository spellRepository) {
        this.spellAuditRepository = spellAuditRepository;
        this.entityManager = entityManager;
        this.spellRepository = spellRepository ;
    }

}