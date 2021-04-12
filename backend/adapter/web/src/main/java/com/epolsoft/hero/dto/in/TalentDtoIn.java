package com.epolsoft.hero.dto.in;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public
class TalentDtoIn {

    @NonNull
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String description;

    @NonNull
    private String icon;

    @NonNull
    private String key;

    @NonNull
    private Integer levelOfAccess;

}
