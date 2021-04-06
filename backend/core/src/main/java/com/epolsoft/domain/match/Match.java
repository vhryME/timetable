package com.epolsoft.domain.match;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Match {

    private TypeOfMatch type;

    private Date date;

    private Double duration;

    private List<Map> maps;

    private Region region;

    private List<Team> teams;

}
