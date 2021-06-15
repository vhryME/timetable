package com.epolsoft.hero.dto.out;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class HeroDtoOut {

    @NotNull
    private Long id;

    @NotNull
    private String name;

    private String icon;

    @NotNull
    private Integer roleId;

    @NotNull
    private Boolean isMelee;

    @NotNull
    private String dateOfCreation;

}
