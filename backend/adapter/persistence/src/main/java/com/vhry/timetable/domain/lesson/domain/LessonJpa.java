package com.vhry.timeTable.domain.lesson.domain;

import com.vhry.common.JpaAccessor;
import com.vhry.dictionary.lessonType.LessonTypeJpa;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "lessons")
public class LessonJpa extends JpaAccessor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Access(AccessType.PROPERTY)
    private Long id;

    @Size(max = 60, message = "Lesson name limit: 128 chars")
    @Column(name = "name", nullable = false, columnDefinition = "NOT NULL")
    private String name;

    @Size(max = 5, message = "Lesson shortname limit: 128 chars")
    @Column(name = "short_name", nullable = false, columnDefinition = "NOT NULL")
    private String shortName;

    @Column(name = "date", nullable = false, columnDefinition = "NOT NULL")
    private LocalDate date;

    @Column(name = "start_date_time", nullable = false, columnDefinition = "NOT NULL")
    private Date startDateTime;

    @Column(name = "end_date_time", nullable = false, columnDefinition = "NOT NULL")
    private Date endDateTime;

    @OneToOne
    @JoinColumn(name = "lesson_type_id")
    private LessonTypeJpa type;

}
