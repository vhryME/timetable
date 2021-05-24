package com.epolsoft.hero.domain;


import com.epolsoft.hero.audit.spell.SpellAuditJpaListener;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(SpellAuditJpaListener.class)
@Table(name = "spell")
public class SpellJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String uuid;

    private String name;

    private String description;

    private String icon;

    private String key;

    private Integer manaCost;

    private Double cooldown;

}