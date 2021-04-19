package com.epolsoft.hero.dto.out;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpellDtoOut {

    @NotNull
    private String name;

    @NotNull
    private String key;

    private String description;

    private String icon;

    @Min(1)
    @Max(300)
    private Double cooldown;

    @Min(1)
    @Max(300)
    private Double manaCost;

}