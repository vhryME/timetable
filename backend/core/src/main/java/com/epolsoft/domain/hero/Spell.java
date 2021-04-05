package com.epolsoft.domain.hero;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Spell {

    private String name;

    private String key;

    private String description;

    private String icon;

    private Double cooldown;

    private Double manaCost;

}
