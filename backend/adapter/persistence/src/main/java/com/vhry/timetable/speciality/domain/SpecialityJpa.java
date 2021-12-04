package com.vhry.timetable.speciality.domain;

import com.vhry.common.JpaAccessor;
import com.vhry.timetable.faculty.domain.FacultyJpa;
import com.vhry.timetable.group.domain.GroupJpa;
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

    @Size(max = 40, message = "Lesson name limit: 40 chars")
    @Column(name = "name", nullable = false, columnDefinition = "NOT NULL")
    private String name;

    @Size(max = 7, message = "Lesson name limit: 7 chars")
    @Column(name = "short_name", nullable = false, columnDefinition = "NOT NULL")
    private String shortName;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(
            mappedBy = "speciality",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    private Set<GroupJpa> groups;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "faculty_id", nullable = false, columnDefinition = "NOT NULL")
    private FacultyJpa faculty;

}
