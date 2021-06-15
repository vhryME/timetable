package com.epolsoft.hero.audit.spell;


import com.epolsoft.hero.domain.SpellAudit;
import com.epolsoft.mapper.JpaMapper;
import org.mapstruct.Mapper;


@Mapper
public interface SpellAuditJpaMapper extends JpaMapper<SpellJpaAudit, SpellAudit> {}