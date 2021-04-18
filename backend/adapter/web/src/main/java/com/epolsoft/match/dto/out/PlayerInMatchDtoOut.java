package com.epolsoft.match.dto.out;

import com.epolsoft.hero.domain.Hero;
import com.epolsoft.hero.dto.out.TalentDtoOut;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerInMatchDtoOut {

    @NonNull
    private Long id;

    @NonNull
    private PlayerDtoOut player;

    @NonNull
    private Hero hero;

    @NonNull
    private Set<TalentDtoOut> talents;

    private StatisticDtoOut statistic;

}
