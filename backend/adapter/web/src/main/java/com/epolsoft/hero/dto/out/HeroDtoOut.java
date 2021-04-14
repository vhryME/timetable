package com.epolsoft.hero.dto.out;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class HeroDtoOut {

    @NonNull
    private Integer id;

    @NonNull
    private String name;

    @NonNull
    private String icon;

    @NonNull
    private String role;

    @NonNull
    private Boolean isMelee;

    @NonNull
    private String dateOfCreation;

}
