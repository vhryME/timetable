package com.epolsoft.match.dto.in;


import com.epolsoft.match.validator.TeamConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@TeamConstraint
public class TeamDtoIn {

    private Long id;

    @NotNull
    @Valid
    @Size(min = 5, max = 5)
    private Set<PlayerInMatchDtoIn> players;

    @NotNull
    private Boolean isWinner;

    @NotNull
    @Min(1)
    @Max(30)
    private Integer levelOfTeam;

    @NotNull
    @Max(245000)
    private Double experienceOfTeam;

}
