package com.epolsoft.hero.dto.in;


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
