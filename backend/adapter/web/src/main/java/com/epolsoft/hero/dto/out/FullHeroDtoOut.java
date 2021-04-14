package com.epolsoft.hero.dto.out;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class FullHeroDtoOut {

    @NonNull
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String icon;

    @NonNull
    private String role;

    @NonNull
    private Boolean isMelee;

    @NonNull
    private String dateOfCreation;

    @NonNull
    private Set<Integer> spellsId;

    @NonNull
    private Set<Integer> talentsId;

}