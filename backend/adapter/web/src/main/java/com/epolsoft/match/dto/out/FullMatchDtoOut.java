package com.epolsoft.match.dto.out;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class FullMatchDtoOut {

    @NotNull
    private Integer id;

    @NotNull
    private String type;

    @NotNull
    private String date;

    @NotNull
    private Set<Integer> mapsId;

    @NotNull
    private String region;

    @NotNull
    private Set<TeamDtoOut> teams;

}