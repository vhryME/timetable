package com.epolsoft.dto.match.player;

import com.epolsoft.domain.hero.Hero;
import com.epolsoft.domain.hero.Talent;
import com.epolsoft.dto.hero.HeroJpa;
import com.epolsoft.dto.hero.TalentJpa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "playerInMatch")
public class PlayerInMatchJpa {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private PlayerJpa player;

    @OneToOne
    private HeroJpa hero;

    @OneToMany
    private Set<TalentJpa> talents;

    @OneToOne
    private StatisticJpa statistic;

}
