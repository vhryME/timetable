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

    @NotNull
    private Long id;

    @NotNull
    private Long spellId;

    @NotNull
    private String name;

    @NotNull
    private String key;

    @NotNull
    private String description;

    @NotNull
    private String uuid;

    @NotNull
    private String icon;

    @NotNull
    private Integer manaCost;

    @NotNull
    private Double cooldown;

    @NotNull
    private String revisionBy;

    @NotNull
    private String revisionDate;

    @NotNull
    private String revisionAction;

}