package com.vhry.timetable.domain;

import com.vhry.common.JpaAccessor;
import com.vhry.timeTable.domain.group.domain.GroupJpa;
import com.vhry.timeTable.domain.lesson.domain.LessonJpa;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "time_table_rows")
public class TimeTableRowJpa extends JpaAccessor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Access(AccessType.PROPERTY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private GroupJpa group;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "time_table_rows_lessons_relation",
            joinColumns = @JoinColumn(name = "time_table_row_id"),
            inverseJoinColumns = @JoinColumn(name = "lesson_id"))
    private Set<LessonJpa> lessons;

}
