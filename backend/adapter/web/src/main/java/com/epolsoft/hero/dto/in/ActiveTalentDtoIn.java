package com.epolsoft.hero.dto.in;


import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
class ActiveTalentDtoIn extends TalentDtoIn {

    @NonNull
    @Min(1)
    @Max(300)
    private Double cost;

    @NonNull
    @Min(1)
    @Max(300)
    private Double timeOfRecovery;

}
