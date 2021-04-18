package com.epolsoft.hero.dto.out;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class HeroDtoOut {

    @NonNull
    private Integer id;

    @NonNull
    private String name;

    private String icon;

    @NonNull
    private String role;

    @NonNull
    private Boolean isMelee;

    @NonNull
    private String dateOfCreation;

}
