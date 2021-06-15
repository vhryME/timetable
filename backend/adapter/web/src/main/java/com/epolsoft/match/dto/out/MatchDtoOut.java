package com.epolsoft.match.dto.out;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.NotNull;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatchDtoOut {

    @NotNull
    private Long id;

    @NotNull
    private String type;

    @NotNull
    private String date;

    @NotNull
    private Integer mapId;

    @NotNull
    private Integer regionId;

}