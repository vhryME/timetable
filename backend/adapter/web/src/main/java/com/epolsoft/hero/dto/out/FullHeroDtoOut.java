package com.epolsoft.hero.dto.out;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class FullHeroDtoOut {

    @NotNull
    private Long id;

    @NotNull
    private String name;

    private String icon;

    @NotNull
    private String role;

    @NotNull
    private Boolean isMelee;

    @NotNull
    private String dateOfCreation;

    @NotNull
    @Size(min = 5)
    private Set<SpellDtoOut> spells;

    @NotNull
    private Set<TalentDtoOut> talent;

}