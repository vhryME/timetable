package com.epolsoft.hero.dto.out;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class HeroDtoOut {

    @NotNull
    private Integer id;

    @NotNull
    private String name;

    private String icon;

    @NotNull
    private String role;

    @NotNull
    private Boolean isMelee;

    @NotNull
    private String dateOfCreation;

}
