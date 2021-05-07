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
    private Double cost;

    @NotNull
    @Min(1)
    @Max(300)
    private Double timeOfRecovery;



    @Builder
    public ActiveTalentDtoIn(String type, String name, String description, String icon, String key, Integer levelOfAccess,
                              Double cost, Double timeOfRecovery) {
        super(type, name, description, icon, key, levelOfAccess);
        this.cost = cost;
        this.timeOfRecovery = timeOfRecovery;
    }

}
