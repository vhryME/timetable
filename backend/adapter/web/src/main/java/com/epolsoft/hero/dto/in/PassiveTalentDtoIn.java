package com.epolsoft.hero.dto.in;


import lombok.*;

import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PassiveTalentDtoIn extends TalentDtoIn {

    @NotNull
    private String spell;


    @Builder
    public PassiveTalentDtoIn(String type, String name, String description, String icon, String key, Integer levelOfAccess, String spell) {
        super(type, name, description, icon, key, levelOfAccess);
        this.spell = spell;
    }

}
