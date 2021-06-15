package com.epolsoft.hero.dto.in;


import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ActiveTalentDtoIn extends TalentDtoIn {

    @NotNull
    @Min(1)
    @Max(300)
    private Double manaCost;

    @NotNull
    @Min(1)
    @Max(300)
    private Double cooldown;



    @Builder
    public ActiveTalentDtoIn(Long id, String name, String description, String icon, String key, Integer levelOfAccess,
                              Double manaCost, Double cooldown) {
        super(id, name, description, icon, key, levelOfAccess);
        this.manaCost = manaCost;
        this.cooldown = cooldown;
    }

}
