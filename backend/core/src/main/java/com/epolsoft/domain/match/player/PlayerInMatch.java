package com.epolsoft.domain.match.player;

import com.epolsoft.domain.hero.Hero;
import com.epolsoft.domain.hero.Talent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerInMatch {

    private Long id;

    private Player player;

    private Hero hero;

    private Set<Talent> talents;

    private Statistic statistic;

}
