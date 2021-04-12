package com.epolsoft.match.dto.out;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamDtoOut {

    @NonNull
    private Set<PlayerInMatchDtoOut> players;

    @NonNull
    private Boolean isWinner;

    @NonNull
    private Integer levelOfTeam;

    @NonNull
    private Double experienceOfTeam;

}
