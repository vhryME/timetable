package com.epolsoft.hero.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
class ActiveTalent extends Talent {

    private Long id;

    private Double cost;

    private Double timeOfRecovery;

}
