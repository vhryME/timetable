package com.epolsoft.match.dto.in;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.Valid;
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

    private Integer mapId = 0;

    private Integer regionId = 0;

    @NotNull
    @Valid
    private TeamDtoIn teamDtoIn1;

    @NotNull
    @Valid
    private TeamDtoIn teamDtoIn2;

}
