package com.vhry.timetable.group.domain;

import com.vhry.common.JpaAccessor;
import com.vhry.timetable.speciality.domain.SpecialityJpa;
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
@Table(name = "groups")
public class GroupJpa extends JpaAccessor {

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
            mappedBy = "group",
            fetch = FetchType.LAZY)
    private Set<PersonJpa> students;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "speciality_id", nullable = false, columnDefinition = "NOT NULL")
    private SpecialityJpa speciality;

}
