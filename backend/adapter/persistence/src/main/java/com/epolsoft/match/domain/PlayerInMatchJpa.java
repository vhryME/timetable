package com.epolsoft.match.domain;

import com.epolsoft.hero.domain.HeroJpa;
import com.epolsoft.hero.domain.TalentJpa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "player_in_match")
public class PlayerInMatchJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToOne
    @JoinColumn(name = "player", referencedColumnName = "id")
    private PlayerJpa player;

    @OneToOne
    @JoinColumn(name = "hero", referencedColumnName = "id")
    private HeroJpa heroJpa;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "player_in_match_talent",
            joinColumns = @JoinColumn(name = "player_in_match_id"),
            inverseJoinColumns = @JoinColumn(name = "talent_id")
    )
    private Set<TalentJpa> talents;

    @OneToOne
    @JoinColumn(name = "statistic", referencedColumnName = "id")
    private StatisticJpa statistic;
}
