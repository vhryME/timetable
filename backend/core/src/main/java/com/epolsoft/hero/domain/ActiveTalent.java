package com.epolsoft.hero.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public
class ActiveTalent extends Talent {

    private Double cost;

    private Double timeOfRecovery;

}