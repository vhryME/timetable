package com.epolsoft.hero.dto.in;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TalentDtoIn {

    @NonNull
    private String name;

    private String description;

    private String icon;

    private String key;

    @NonNull
    private Integer levelOfAccess;

}
