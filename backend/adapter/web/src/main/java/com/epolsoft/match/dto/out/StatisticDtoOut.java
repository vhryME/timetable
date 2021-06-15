package com.epolsoft.match.dto.out;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatisticDtoOut {

    @NotNull
    private Integer level;

    @NotNull
    private Integer kills;

    @NotNull
    private Integer assist;

    @NotNull
    private Integer killStreak;

    @NotNull
    private Integer deaths;

    @NotNull
    private Double damageToEnemies;

    @NotNull
    private Double damageToNpc;

    @NotNull
    private Double healToTeammate;

    @NotNull
    private Double healToYourself;

    @NotNull
    private Double damageToYourself;

    @NotNull
    private Double experience;

    @NotNull
    private Double timeInRevive; //seconds, mill. seconds

    @NotNull
    private Integer takeCamps;
}
