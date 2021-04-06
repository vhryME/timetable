package com.epolsoft.domain.match;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Match {

    private Long id;

    private TypeOfMatch type;

    private LocalDate date;

    private Double duration;

    private Set<Map> maps;

    private Region region;

    private Set<Team> teams;

}
