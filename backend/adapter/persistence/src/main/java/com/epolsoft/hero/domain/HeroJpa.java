package com.epolsoft.hero.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hero")
public class HeroJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String icon;

    @OneToOne
    @JoinColumn(name = "role", referencedColumnName = "id")
    private RoleJpa role;

    private Boolean isMelee;

    private LocalDate dateOfCreation;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "hero_id")
    private Set<SpellJpa> spells;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "hero_talent",
            joinColumns = @JoinColumn(name = "hero_id"),
            inverseJoinColumns = @JoinColumn(name = "talent_id")
    )
    private Set<TalentJpa> talents;


}
