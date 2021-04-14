package com.epolsoft.match.dto.out;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatchDtoOut {

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

}