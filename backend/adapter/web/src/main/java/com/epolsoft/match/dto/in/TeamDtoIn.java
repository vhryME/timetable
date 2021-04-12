package com.epolsoft.match.dto.in;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamDtoIn {

    @NonNull
    private Long id;

    @NonNull
    private Set<PlayerInMatchDtoIn> players;

    @NonNull
    private Boolean isWinner;

    @NonNull
    private Integer levelOfTeam;

    @NonNull
    private Double experienceOfTeam;

}
