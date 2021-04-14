package com.epolsoft.hero.dto.in;


import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
class PassiveTalentDtoIn extends TalentDtoIn {

    @NonNull
    private String skill;

}
