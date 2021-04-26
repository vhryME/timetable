package com.epolsoft.match.dto.in;


import com.epolsoft.hero.dto.in.HeroDtoIn;
import com.epolsoft.hero.dto.in.TalentDtoIn;
import com.epolsoft.match.validator.TalentConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@TalentConstraint
public class PlayerInMatchDtoIn {

    @NotNull
    @Valid
    private PlayerDtoIn player;

    @NotNull
    @Valid
    private HeroDtoIn hero;

    @NotNull
    @Valid
    private Set<TalentDtoIn> talents;

    @Valid
    private StatisticDtoIn statistic;

}
