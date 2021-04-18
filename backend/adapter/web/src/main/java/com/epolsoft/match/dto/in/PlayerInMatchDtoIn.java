package com.epolsoft.match.dto.in;


import com.epolsoft.hero.dto.in.HeroDtoIn;
import com.epolsoft.hero.dto.in.TalentDtoIn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerInMatchDtoIn {

    @NonNull
    private PlayerDtoIn player;

    @NonNull
    private HeroDtoIn hero;

    @NonNull
    private Set<TalentDtoIn> talents;

    private StatisticDtoIn statistic;

}
