package com.epolsoft.dto.match;

import com.epolsoft.dto.match.player.PlayerInMatchJpa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "team")
public class TeamJpa {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany
    private Set<PlayerInMatchJpa> players;

    private Boolean isWinner;

    private Integer levelOfTeam;

    private Double experienceOfTeam;

}
