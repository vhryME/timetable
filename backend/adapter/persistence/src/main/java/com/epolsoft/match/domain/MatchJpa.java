package com.epolsoft.match.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "match")
public class MatchJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "type", referencedColumnName = "id")
    private TypeOfMatchJpa type;

    private LocalDate date;

    private Double duration;

    @OneToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "map", referencedColumnName = "id")
    private MapJpa map;

    @OneToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "region", referencedColumnName = "id")
    private RegionJpa region;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "team1", referencedColumnName = "id")
    private TeamJpa team1;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "team2", referencedColumnName = "id")
    private TeamJpa team2;
}
