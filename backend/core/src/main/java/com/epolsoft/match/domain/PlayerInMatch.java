package com.epolsoft.match.domain;

import com.epolsoft.hero.domain.Hero;
import com.epolsoft.hero.domain.Talent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public
class PlayerInMatch {

    private Long id;

    private Player player;

    private Hero hero;

    private Set<Talent> talents;

    private Statistic statistic;

}
