package com.epolsoft.match.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "match")
public class MatchJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToOne
    @JoinColumn(name = "type", referencedColumnName = "id")
    private TypeJpa type;

    private LocalDate date;

    private Double duration;

    @OneToOne
    @JoinColumn(name = "map", referencedColumnName = "id")
    private MapJpa map;

    @OneToOne
    @JoinColumn(name = "region", referencedColumnName = "id")
    private RegionJpa region;

    @OneToOne
    @JoinColumn(name = "team1", referencedColumnName = "id")
    private TeamJpa team1;

    @OneToOne
    @JoinColumn(name = "team2", referencedColumnName = "id")
    private TeamJpa team2;
}
