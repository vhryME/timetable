package com.vhry.user.person.domain;

import com.vhry.common.JpaAccessor;
import com.vhry.dictionary.universityRole.UniversityRoleJpa;
import com.vhry.user.common.domain.UserJpa;
import com.vhry.timeTable.domain.group.domain.GroupJpa;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "persons")
public class PersonJpa extends JpaAccessor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Access(AccessType.PROPERTY)
    private Long id;

    @Size(max = 50, message = "Person name limit: 50 chars")
    @Column(name = "name", nullable = false, columnDefinition = "NOT NULL")
    private String name;

    @Size(max = 50, message = "Person surname limit: 50 chars")
    @Column(name = "surname", nullable = false, columnDefinition = "NOT NULL")
    private String surname;

    @Size(max = 50, message = "Person lastname limit: 50 chars")
    @Column(name = "lastname", nullable = false, columnDefinition = "NOT NULL")
    private String lastname;

    @Size(max = 152, message = "Person full name limit: 152 chars")
    @Column(name = "fullname")
    private String fullName;

    @Column(name = "admission_date", nullable = false, columnDefinition = "NOT NULL")
    private LocalDate admissionDate;

    @OneToOne(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.REMOVE, CascadeType.MERGE, CascadeType.PERSIST},
            orphanRemoval = true)
    @JoinColumn(name = "user_id", nullable = false, columnDefinition = "NOT NULL")
    private UserJpa user;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "persons_university_roles_relation",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "university_role_id"))
    private Set<UniversityRoleJpa> universityRoles;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id", nullable = false, columnDefinition = "NOT NULL")
    private GroupJpa group;

}
