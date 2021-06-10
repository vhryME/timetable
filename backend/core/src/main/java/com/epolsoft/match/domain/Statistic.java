package com.epolsoft.match.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Statistic {

    private Long id;

    private Integer level;

    private Integer kills;

    private Integer assist;

    private Integer killStreak;

    private Integer deaths;

    private Double damageToEnemies;

    private Double damageToNPC;

    private Double healToTeammate;

    private Double healToYourself;

    private Double damageToYourself;

    private Double experience;

    private Double timeInRevive;

    private Integer takeCamps;

}
