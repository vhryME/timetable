package com.epolsoft.match.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "team")
public class TeamJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Boolean isWinner;

    private Integer levelOfTeam;

    private Double experienceOfTeam;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "team")
    private Set<PlayerInMatchJpa> player;
}
