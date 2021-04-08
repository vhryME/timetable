package com.epolsoft.hero.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
class PassiveTalent extends Talent {

    private Long id;

    private String skill;

}
