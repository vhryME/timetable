package com.epolsoft.hero.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hero {

    private Integer id;

    private String name;

    private String icon;

    private Role role;

    private Boolean isMelee;

    private LocalDate dateOfCreation;

    private Set<Spell> spells;

    private Set<Talent> talents;

}
