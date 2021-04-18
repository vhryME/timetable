package com.epolsoft.hero.dto.out;


import com.epolsoft.hero.dto.in.TalentDtoIn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
class PassiveTalentDtoOut extends TalentDtoIn {

    private SpellDtoOut spell;

}
