package com.epolsoft.match.domain;

import com.epolsoft.hero.domain.HeroJpa;
import com.epolsoft.hero.domain.TalentJpa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "player_in_match")
public class PlayerInMatchJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "player", referencedColumnName = "id")
    private PlayerJpa player;

    @OneToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "hero", referencedColumnName = "id")
    private HeroJpa hero;

    @ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(
            name = "player_in_match_talent",
            joinColumns = @JoinColumn(name = "player_in_match_id"),
            inverseJoinColumns = @JoinColumn(name = "talent_id")
    )
    private Set<TalentJpa> talents;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
    @JoinColumn(name = "statistic", referencedColumnName = "id")
    private StatisticJpa statistic;
}
