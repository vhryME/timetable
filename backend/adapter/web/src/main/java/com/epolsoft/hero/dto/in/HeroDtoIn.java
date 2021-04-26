package com.epolsoft.hero.dto.in;


import com.epolsoft.match.validator.TalentConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@TalentConstraint
public class HeroDtoIn {

    @NotNull
    private String name;

    private String icon;

    private String role = "Unknown";

    @NotNull
    private Boolean isMelee;

    @NotNull
    private String dateOfCreation;

    @NotNull
    @Valid
    @Size(min = 5)
    private Set<SpellDtoIn> spells;

    @NotNull
    @Valid
    private Set<TalentDtoIn> talents;

}
