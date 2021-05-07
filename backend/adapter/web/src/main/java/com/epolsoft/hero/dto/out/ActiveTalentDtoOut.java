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
    private Double cost;

    @NotNull
    @Min(1)
    @Max(300)
    private Double timeOfRecovery;


    @Builder
    public ActiveTalentDtoOut(String type, Long id, String name, String description, String icon, String key, Integer levelOfAccess,
                              Double cost, Double timeOfRecovery) {
        super(type, id, name, description, icon, key, levelOfAccess);
        this.cost = cost;
        this.timeOfRecovery = timeOfRecovery;
    }

}
