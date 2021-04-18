package com.epolsoft.hero.dto.out;


import com.epolsoft.hero.dto.in.TalentDtoIn;
import lombok.*;

import javax.validation.constraints.Size;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
class ActiveTalentDtoOut extends TalentDtoIn {

    @NonNull
    @Size(min = 1, max = 300)
    private Double cost;

    @NonNull
    @Size(min = 1, max = 300)
    private Double timeOfRecovery;

}
