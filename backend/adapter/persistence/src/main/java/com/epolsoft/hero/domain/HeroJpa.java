package com.epolsoft.hero.domain;

import com.epolsoft.hero.converter.SQLEnumType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hero")
@TypeDef(
        name = "sql_enum",
        typeClass = SQLEnumType.class
)
public class HeroJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String icon;

    @OneToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "role", referencedColumnName = "id")
    private RoleJpa role;

    private Boolean isMelee;

    private LocalDate dateOfCreation;

    @Enumerated(EnumType.STRING)
    @Type(type = "sql_enum")
    private StatusJpa status;

    @OneToMany(cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "hero_id")
    private Set<SpellJpa> spells;

    @ManyToMany(cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinTable(
            name = "hero_talent",
            joinColumns = @JoinColumn(name = "hero_id"),
            inverseJoinColumns = @JoinColumn(name = "talent_id")
    )
    private Set<TalentJpa> talents;
}
