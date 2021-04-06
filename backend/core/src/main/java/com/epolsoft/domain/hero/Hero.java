package com.epolsoft.domain.hero;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hero {

    private Long id;

    private String name;

    private String icon;

    private Role role;

    private Boolean isMelee;

    private Date dateOfCreated;

    private Set<Spell> spells;

    private Set<Talent> talents;

}
