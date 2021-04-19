package com.epolsoft.match.dto.in;


import com.epolsoft.hero.dto.in.HeroDtoIn;
import com.epolsoft.hero.dto.in.TalentDtoIn;
import com.epolsoft.match.validator.TalentDtoInConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@TalentDtoInConstraint
public class PlayerInMatchDtoIn {

    @NonNull
    private PlayerDtoIn player;

    @NonNull
    private HeroDtoIn hero;

    @NonNull
    private Set<TalentDtoIn> talents;

    private StatisticDtoIn statistic;

}
