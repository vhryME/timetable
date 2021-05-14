package com.epolsoft.match.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "statistic")
public class StatisticJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Integer level;

    private Integer kills;

    private Integer assist;

    private Integer killStreak;

    private Integer death;

    private Double damageToEnemy;

    private Double damageToNpc;

    private Double healToTeamMate;

    private Double healToYourself;

    private Double damageToYourself;

    private Double experience;

    private Double timeInRevive;

    private Integer takeCamps;
}
