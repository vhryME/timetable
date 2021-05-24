package com.epolsoft.hero.audit.spell;


import com.epolsoft.hero.audit.EntityAudit;
import com.epolsoft.hero.domain.SpellJpa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "spell_audit")
public class SpellJpaAudit extends EntityAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long spellId;

    private String uuid;

    private String name;

    private String description;

    private String icon;

    private String key;

    private Double cooldown;

    private Integer manaCost;


    public SpellJpaAudit(SpellJpa spellJpa) {
        this.uuid = spellJpa.getUuid();
        this.name = spellJpa.getName();
        this.description = spellJpa.getDescription();
        this.icon = spellJpa.getIcon();
        this.key = spellJpa.getKey();
        this.spellId = spellJpa.getId();
        this.manaCost = spellJpa.getManaCost();
        this.cooldown = spellJpa.getCooldown();
    }

}