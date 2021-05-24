package com.epolsoft.hero.audit.spell;


import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;


public final class SpellAuditJpaSpecification {

    public static Specification<SpellJpaAudit> findBySpellId(Long spellId) {
        return (Specification<SpellJpaAudit>) (root, criteriaQuery, criteriaBuilder) -> {
            if(spellId != null) {
                return criteriaBuilder.equal(root.get("spellId"), spellId);
            }

            return null;
        };
    }


    public static Specification<SpellJpaAudit> findByRevisionDate(LocalDate date) {
        return (Specification<SpellJpaAudit>) (root, criteriaQuery, criteriaBuilder) -> {
            if(date != null) {
                return criteriaBuilder.equal(root.get("revisionDate"), date);
            }

            return null;
        };
    }


    public static Specification<SpellJpaAudit> findByName(String name) {
        return (Specification<SpellJpaAudit>) (root, criteriaQuery, criteriaBuilder) -> {
            if(name != null) {
                return criteriaBuilder.equal(root.get("name"), name);
            }

            return null;
        };
    }

}