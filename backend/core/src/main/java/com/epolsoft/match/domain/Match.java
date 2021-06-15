package com.epolsoft.match.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Match {

    private Long id;

    private TypeOfMatch type;

    private LocalDate date;

    private Double duration;

    private Map map;

    private Region region;

    private Team team1;

    private Team team2;

}
