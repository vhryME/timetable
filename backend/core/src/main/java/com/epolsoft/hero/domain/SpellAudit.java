package com.epolsoft.hero.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpellAudit {

    private Long id;

    private Long spellId;

    private String name;

    private String key;

    private String description;

    private String uuid;

    private String icon;

    private Double cooldown;

    private Integer manaCost;

    private String revisionBy;

    private LocalDate revisionDate;

    private String revisionAction;

}