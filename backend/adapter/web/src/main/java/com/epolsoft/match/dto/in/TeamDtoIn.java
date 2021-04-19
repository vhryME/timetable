package com.epolsoft.match.dto.in;


import com.epolsoft.match.validator.TeamDtoInConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@TeamDtoInConstraint
public class TeamDtoIn {

    @NotNull
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
