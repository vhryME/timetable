package com.epolsoft.hero.dto.in;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HeroDtoIn {

    @NonNull
    private String name;

    @NonNull
    private String icon;

    @NonNull
    private RoleDtoIn role;

    @NonNull
    private Boolean isMelee;

    @NonNull
    private LocalDate dateOfCreation;

    @NonNull
    private Set<SpellDtoIn> spells;

    @NonNull
    private Set<TalentDtoIn> talents;

}
