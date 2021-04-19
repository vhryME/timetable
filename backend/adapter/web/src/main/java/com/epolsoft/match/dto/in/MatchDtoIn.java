package com.epolsoft.match.dto.in;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatchDtoIn {

    private String type = "Unknown";

    @NotNull
    private String date;

    private Set<Integer> mapsId = new HashSet<>(Collections.singleton(0));

    private String region = "Unknown";

    @NotNull
    private Set<TeamDtoIn> teams;

}
