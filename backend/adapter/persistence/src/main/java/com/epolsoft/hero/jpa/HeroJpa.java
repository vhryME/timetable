package com.epolsoft.hero.jpa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "hero")
public class HeroJpa {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private String icon;

    @Enumerated(EnumType.STRING)
    private RoleJpa role;

    private Boolean isMelee;

    private LocalDate dateOfCreation;

    @OneToMany
    private Set<SpellJpa> spells;

    @OneToMany
    private Set<TalentJpa> talents;

}
