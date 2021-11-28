package com.vhry.timetable.domain.speciality.domain;

import com.vhry.common.JpaAccessor;
import com.vhry.timeTable.domain.faculty.domain.FacultyJpa;
import com.vhry.timeTable.domain.group.domain.GroupJpa;
import com.vhry.user.person.domain.PersonJpa;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "specialities")
public class SpecialityJpa extends JpaAccessor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Access(AccessType.PROPERTY)
    private Long id;

    @Size(max = 7, message = "Lesson name limit: 7 chars")
    @Column(name = "name", nullable = false, columnDefinition = "NOT NULL")
    private String name;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(
            mappedBy = "speciality",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    private Set<GroupJpa> groups;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "groups_persons_relation",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id"))
    private Set<PersonJpa> students;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "faculty_id", nullable = false, columnDefinition = "NOT NULL")
    private FacultyJpa faculty;

}
