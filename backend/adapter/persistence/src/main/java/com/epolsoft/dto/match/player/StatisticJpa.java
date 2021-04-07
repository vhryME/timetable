package com.epolsoft.dto.match.player;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "statistic")
public class StatisticJpa {

    @Id
    @GeneratedValue
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

    private Double timeInRevive; //seconds, mill. seconds

    private Integer takeCamps;

}
