package com.vhry.timeTable.lesson.domain;

import com.vhry.dictionary.lessonType.LessonType;
import com.vhry.domain.IdAccessorUpdated;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
public class Lesson extends IdAccessorUpdated {

    private String name;

    private String shortName;

    private LessonType type;

    private LocalDate date;

    private LocalDateTime startDateTime;

    private LocalDateTime endDateTime;

}
