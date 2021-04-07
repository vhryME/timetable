package com.epolsoft.dto.hero;

import com.epolsoft.domain.hero.Role;
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
    private Long id;

    private String name;

    private String icon;

    @Enumerated(EnumType.STRING)
    private RoleJpa role;

    private Boolean isMelee;

    private LocalDate dateOfCreated;

    @OneToMany
    private Set<SpellJpa> spells;

    @OneToMany
    private Set<TalentJpa> talents;

}
