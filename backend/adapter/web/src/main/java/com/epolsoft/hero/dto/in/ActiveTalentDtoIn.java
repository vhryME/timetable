package com.epolsoft.hero.dto.in;


import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
class ActiveTalentDtoIn extends TalentDtoIn {

    @NotNull
    @Min(1)
    @Max(300)
    private Double cost;

    @NotNull
    @Min(1)
    @Max(300)
    private Double timeOfRecovery;

}
