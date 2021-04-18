package com.epolsoft.match.dto.out;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.Size;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamDtoOut {

    @NonNull
    private Long id;

    @NonNull
    @Size(min = 5, max = 5)
    private Set<PlayerInMatchDtoOut> players;

    @NonNull
    private Boolean isWinner;

    @NonNull
    @Size(min = 0, max = 30)
    private Integer levelOfTeam;

    @NonNull
    @Size(min = 0, max = 245000)
    private Double experienceOfTeam;

}
