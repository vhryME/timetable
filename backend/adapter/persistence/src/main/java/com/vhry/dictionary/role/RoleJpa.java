package com.vhry.dictionary.role;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "roles_dict")
public class RoleJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Access(AccessType.PROPERTY)
    private Long id;

    @Column(name = "value")
    private String value;

}
