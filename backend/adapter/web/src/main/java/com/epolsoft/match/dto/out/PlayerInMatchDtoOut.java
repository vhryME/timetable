package com.epolsoft.match.dto.out;

import com.epolsoft.hero.domain.Hero;
import com.epolsoft.hero.domain.Talent;
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
    private PlayerDtoOut player;

    @NonNull
    private Hero hero;

    @NonNull
    private Set<Talent> talents;

    @NonNull
    private StatisticDtoOut statistic;

}
