package com.epolsoft.hero.dto.out;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HeroDtoOut {

    @NonNull
    private String name;

    @NonNull
    private String icon;

    @NonNull
    private RoleDtoOut role;

    @NonNull
    private Boolean isMelee;

    @NonNull
    private LocalDate dateOfCreated;

    @NonNull
    private Set<SpellDtoOut> spells;

    @NonNull
    private Set<TalentDtoOut> talents;

}
