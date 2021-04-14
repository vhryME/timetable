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

    private Integer id;

    private TypeOfMatch type;

    private LocalDate date;

    private Double duration;

    private Set<Map> maps;

    private Region region;

    private Set<Team> teams;

}
