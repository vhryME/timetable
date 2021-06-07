package com.epolsoft.match.dto.out;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;


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
    private Integer mapId;

    @NotNull
    private Integer regionId;

    @NotNull
    @Valid
    private TeamDtoOut teamDtoOut1;

    @NotNull
    @Valid
    private TeamDtoOut teamDtoOut2;

}