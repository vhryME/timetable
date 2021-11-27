package com.vhry.timeTable.domain.faculty.domain;

import com.vhry.common.JpaAccessor;
import com.vhry.timetable.domain.speciality.domain.SpecialityJpa;
import lombok.Data;
import lombok.EqualsAndHashCode;

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

    @Size(max = 40, message = "Faculty name limit: 40 chars")
    @Column(name = "name", nullable = false, columnDefinition = "NOT NULL")
    private String name;

    @OneToMany(
            mappedBy = "faculty",
            fetch = FetchType.LAZY)
    private Set<SpecialityJpa> specialities;

}
