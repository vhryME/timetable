package com.epolsoft.hero.dto.in;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class HeroDtoInFiltered {

    private String role;

    private Boolean isMelee;

    private String dateOfCreation;

    private Set<SpellDtoIn> spells;

    private Set<TalentDtoIn> talents;

}