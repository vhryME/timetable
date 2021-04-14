package com.epolsoft.hero.dto.out;


import com.epolsoft.hero.domain.Spell;
import com.epolsoft.hero.dto.in.TalentDtoIn;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
class PassiveTalentDtoOut extends TalentDtoIn {

    @NonNull
    private Spell spell;

}
