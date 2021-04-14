package com.epolsoft.hero.dto.out;


import com.epolsoft.hero.dto.in.TalentDtoIn;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
class ActiveTalentDtoIn extends TalentDtoIn {

    @NonNull
    private Double cost;

    @NonNull
    private Double timeOfRecovery;

}
