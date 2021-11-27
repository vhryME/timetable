package com.vhry.dictionary.universityRole;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "university_roles_dict")
public class UniversityRoleJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Access(AccessType.PROPERTY)
    private Long id;

    @Column(name = "value")
    private String value;

}
