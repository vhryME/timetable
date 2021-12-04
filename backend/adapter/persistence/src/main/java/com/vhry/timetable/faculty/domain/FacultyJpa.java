package com.vhry.timetable.faculty.domain;

import com.vhry.common.JpaAccessor;
import com.vhry.timetable.speciality.domain.SpecialityJpa;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "groups")
public class FacultyJpa extends JpaAccessor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Access(AccessType.PROPERTY)
    private Long id;

    @Size(max = 50, message = "Faculty name limit: 50 chars")
    @Column(name = "name", nullable = false, columnDefinition = "NOT NULL")
    private String name;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(
            mappedBy = "faculty",
            fetch = FetchType.LAZY)
    private Set<SpecialityJpa> specialities;

}
