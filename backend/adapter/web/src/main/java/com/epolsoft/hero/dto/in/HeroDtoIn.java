package com.epolsoft.hero.dto.in;


import com.epolsoft.match.validator.TalentDtoInConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@TalentDtoInConstraint
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
    @Size(min = 5)
    private Set<SpellDtoIn> spells;

    @NotNull
    private Set<TalentDtoIn> talents;

}
