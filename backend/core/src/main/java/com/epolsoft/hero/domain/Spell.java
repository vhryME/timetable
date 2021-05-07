package com.epolsoft.hero.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public
class Spell {

    private Long id;

    private String name;

    private String key;

    private String description;

    private String uuid;

    private String icon;

    private Double cooldown;

    private Double manaCost;

}
