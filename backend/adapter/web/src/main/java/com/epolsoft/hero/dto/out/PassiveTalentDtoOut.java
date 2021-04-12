package com.epolsoft.hero.dto.out;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
class PassiveTalentDtoOut extends TalentDtoOut {

    @NonNull
    private String skill;

}
