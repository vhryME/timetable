package com.epolsoft.match.dto.out;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.NotEmpty;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class FullMatchDtoOut {

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
    private Set<TeamDtoOut> teams;

}