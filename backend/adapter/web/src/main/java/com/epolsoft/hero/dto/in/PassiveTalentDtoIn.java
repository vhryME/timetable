package com.epolsoft.hero.dto.in;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
class PassiveTalentDtoIn extends TalentDtoIn {


    @NonNull
    private Long id;

    @NonNull
    private String skill;

}
