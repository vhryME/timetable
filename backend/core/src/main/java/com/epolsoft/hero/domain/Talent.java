package com.epolsoft.hero.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public
class Talent {

    private Long id;

    private String name;

    private String description;

    private String icon;

    private String key;

    private Integer levelOfAccess;

}
