package com.epolsoft.hero.dto.out;


import lombok.*;

import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PassiveTalentDtoOut extends TalentDtoOut {

    @NotNull
    private String spell;


    @Builder
    public PassiveTalentDtoOut(Long id, String name, String description, String icon, String key, Integer levelOfAccess, String spell) {
        super(id, name, description, icon, key, levelOfAccess);
        this.spell = spell;
    }

}
