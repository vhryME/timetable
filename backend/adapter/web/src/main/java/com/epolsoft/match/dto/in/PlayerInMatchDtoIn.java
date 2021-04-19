package com.epolsoft.match.dto.in;


import com.epolsoft.hero.dto.in.HeroDtoIn;
import com.epolsoft.hero.dto.in.TalentDtoIn;
import com.epolsoft.match.validator.TalentDtoInConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.NotNull;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@TalentDtoInConstraint
public class PlayerInMatchDtoIn {

    @NotNull
    private PlayerDtoIn player;

    @NotNull
    private HeroDtoIn hero;

    @NotNull
    private Set<TalentDtoIn> talents;

    private StatisticDtoIn statistic;

}
