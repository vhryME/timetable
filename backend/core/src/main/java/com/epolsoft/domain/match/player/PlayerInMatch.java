package com.epolsoft.domain.match.player;

import com.epolsoft.domain.hero.Hero;
import com.epolsoft.domain.hero.Talent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerInMatch {

    private Player player;

    private Hero hero;

    private List<Talent> talents;

    private Statistic statistic;

}
