package com.epolsoft.hero.dto.out;


import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ActiveTalentDtoOut extends TalentDtoOut {

    @NotNull
    @Min(1)
    @Max(300)
    private Double manaCost;

    @NotNull
    @Min(1)
    @Max(300)
    private Double cooldown;


    @Builder
    public ActiveTalentDtoOut(Long id, String name, String description, String icon, String key, Integer levelOfAccess,
                              Double manaCost, Double cooldown) {
        super(id, name, description, icon, key, levelOfAccess);
        this.manaCost = manaCost;
        this.cooldown = cooldown;
    }

}
