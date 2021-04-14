package com.epolsoft.match.dto.in;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatchDtoInFiltered {

    private String type;

    private String date;

    private String region;

    private Double duration;

    private Set<Integer> mapsId;

}