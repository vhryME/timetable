package com.epolsoft.match.dto.in;


import com.epolsoft.match.validator.TeamConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@TeamConstraint
public class MatchDtoIn {

    private Long id;

    private String type = "Unknown";

    @NotNull
    private String date;

    private Integer mapId = 0;

    private Integer regionId = 0;

    private Double duration;

    @NotNull
    @Valid
    private TeamDtoIn team1;

    @NotNull
    @Valid
    private TeamDtoIn team2;

}
