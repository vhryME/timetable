package com.epolsoft.hero.dto.in;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpellDtoIn {

    @NonNull
    private String name;

    @NonNull
    private String key;

    @NonNull
    private String description;

    @NonNull
    private String icon;

    @NonNull
    private Double cooldown;

    @NonNull
    private Double manaCost;

}