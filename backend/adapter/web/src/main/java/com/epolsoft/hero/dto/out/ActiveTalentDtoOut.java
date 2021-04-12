package com.epolsoft.hero.dto.out;


import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
class ActiveTalentDtoOut extends TalentDtoOut {

    @NonNull
    private Double cost;

    @NonNull
    private Double timeOfRecovery;

}
