package com.epolsoft.match.dto.in;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatchDtoIn {

    @NonNull
    private String type;

    @NonNull
    private String date;

    @NonNull
    private Set<Integer> mapsId;

    @NonNull
    private String region;

}
