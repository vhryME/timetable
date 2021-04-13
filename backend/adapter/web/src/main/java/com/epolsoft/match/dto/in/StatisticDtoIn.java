package com.epolsoft.match.dto.in;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatisticDtoIn {

    @NonNull
    private Integer level;

    @NonNull
    private Integer kills;

    @NonNull
    private Integer assist;

    @NonNull
    private Integer killStreak;

    @NonNull
    private Integer deaths;

    @NonNull
    private Double damageToEnemies;

    @NonNull
    private Double damageToNPC;

    @NonNull
    private Double healToTeammate;

    @NonNull
    private Double heaToYourself;

    @NonNull
    private Double damageToYourself;

    @NonNull
    private Double experience;

    @NonNull
    private Double timeInRevive; //seconds, mill. seconds

    @NonNull
    private Integer takeCamps;

}
