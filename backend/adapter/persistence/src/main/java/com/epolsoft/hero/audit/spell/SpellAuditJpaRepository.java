package com.epolsoft.hero.audit.spell;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SpellAuditJpaRepository extends JpaRepository<SpellJpaAudit, Long>, JpaSpecificationExecutor<SpellJpaAudit> {}