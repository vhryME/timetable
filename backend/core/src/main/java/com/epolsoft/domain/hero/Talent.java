package com.epolsoft.domain.hero;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Talent {

    private String name;

    private String description;

    private String icon;

    private String key;

    private Integer levelOfAccess;

}
