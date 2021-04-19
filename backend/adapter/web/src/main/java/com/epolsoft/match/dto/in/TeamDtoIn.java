package com.epolsoft.match.dto.in;


import com.epolsoft.match.validator.TeamDtoInConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@TeamDtoInConstraint
public class TeamDtoIn {

    @NonNull
    @Size(min = 5, max = 5)
    private Set<PlayerInMatchDtoIn> players;

    @NonNull
    private Boolean isWinner;

    @NonNull
    @Min(1)
    @Max(30)
    private Integer levelOfTeam;

    @NonNull
    @Max(245000)
    private Double experienceOfTeam;

}
