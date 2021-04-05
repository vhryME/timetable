package com.epolsoft.domain.hero;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hero {

    private String name;

    private String icon;

    private Role role;

    private Boolean isMelee;

    private Date dateOfCreated;

    private List<Spell> spells;

    private List<Talent> talents;

}
