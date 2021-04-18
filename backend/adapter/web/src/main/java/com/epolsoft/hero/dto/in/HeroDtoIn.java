package com.epolsoft.hero.dto.in;


import com.epolsoft.hero.dto.out.SpellDtoOut;
import com.epolsoft.hero.dto.out.TalentDtoOut;
import com.epolsoft.match.validator.TalentDtoInConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.Min;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@TalentDtoInConstraint
public class HeroDtoIn {

    @NonNull
    private String name;

    private String icon;

    private String role = "Unknown";

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
