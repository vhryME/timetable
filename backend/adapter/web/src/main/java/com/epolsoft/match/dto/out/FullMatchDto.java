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
    private Integer id;

    @NonNull
    private String type;

    @NonNull
    private String date;

    @NonNull
    private Set<Integer> mapsId;

    @NonNull
    private String region;

    @NonNull
    private Set<Integer> teamsId;

}