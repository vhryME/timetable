package com.epolsoft.hero.dto.out;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpellAuditDtoOut {

    private Long id;

    private Long spellId;

    private String name;

    private String key;

    private String description;

    private String uuid;

    private String icon;

    private Integer manaCost;

    private Double cooldown;

    private String revisionBy;

    private String revisionDate;

    private String revisionAction;

}