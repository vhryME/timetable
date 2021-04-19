package com.epolsoft.match.dto.out;

import com.epolsoft.hero.domain.Hero;
import com.epolsoft.hero.dto.out.TalentDtoOut;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerInMatchDtoOut {

    @NotNull
    private Long id;

    @NotNull
    @Valid
    private PlayerDtoOut player;

    @NotNull
    @Valid
    private Hero hero;

    @NotNull
    @Valid
    private Set<TalentDtoOut> talents;

    @Valid
    private StatisticDtoOut statistic;

}
