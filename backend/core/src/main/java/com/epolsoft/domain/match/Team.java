package com.epolsoft.domain.match;

import com.epolsoft.domain.match.player.PlayerInMatch;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Team {

    private Long id;

    private Set<PlayerInMatch> players;

    private Boolean isWinner;

    private Integer levelOfTeam;

    private Double experienceOfTeam;

}
