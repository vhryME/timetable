package com.epolsoft.domain.hero;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActiveTalent extends Talent{

    private Double cost;

    private Double timeOfRecovery;

}
