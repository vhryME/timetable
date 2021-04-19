package com.epolsoft.hero.dto.out;


import com.epolsoft.hero.dto.in.TalentDtoIn;
import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
class ActiveTalentDtoOut extends TalentDtoIn {

    @NotNull
    @Min(1)
    @Max(300)
    private Double cost;

    @NotNull
    @Min(1)
    @Max(300)
    private Double timeOfRecovery;

}
