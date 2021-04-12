package com.epolsoft.match.dto.out;


import com.epolsoft.match.domain.Map;
import com.epolsoft.match.domain.Region;
import com.epolsoft.match.domain.Team;
import com.epolsoft.match.domain.TypeOfMatch;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class FullMatchDto {

    @NonNull
    private TypeOfMatch type;

    @NonNull
    private LocalDate date;

    @NonNull
    private Set<Map> maps;

    @NonNull
    private Region region;

    @NonNull
    private Set<Team> teams;

}