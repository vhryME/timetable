package com.epolsoft.hero.dto.out;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.Min;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class FullHeroDtoOut {

    @NonNull
    private Long id;

    @NonNull
    private String name;

    private String icon;

    @NonNull
    private String role;

    @NonNull
    private Boolean isMelee;

    @NonNull
    private String dateOfCreation;

    @NonNull
    @Min(5)
    private Set<SpellDtoOut> spells;

    @NonNull
    private Set<TalentDtoOut> talent;

}