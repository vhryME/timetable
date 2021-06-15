package com.epolsoft.hero.dto.in;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpellDtoIn {

    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String key;

    private String description;

    private String icon;

    @NotNull
    private String uuid;

    @NotNull
    @Min(1) @Max(300)
    private Integer manaCost;

    @Min(1) @Max(300)
    private Double cooldown;

}