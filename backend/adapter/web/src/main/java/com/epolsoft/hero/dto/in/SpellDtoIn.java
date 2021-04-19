package com.epolsoft.hero.dto.in;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpellDtoIn {

    @NonNull
    private String name;

    @NonNull
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