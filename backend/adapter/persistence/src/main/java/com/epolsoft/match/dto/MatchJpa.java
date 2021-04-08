package com.epolsoft.match.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class MatchJpa {
    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private TypeOfMatchJpa type;

    private LocalDate date;

    private Double duration;

    @ElementCollection(targetClass = MapJpa.class)
    @Enumerated(value = EnumType.STRING)
    private Set<MapJpa> maps;

    @Enumerated(value = EnumType.STRING)
    private RegionJpa region;

    @OneToMany
    private Set<TeamJpa> teams;
}
