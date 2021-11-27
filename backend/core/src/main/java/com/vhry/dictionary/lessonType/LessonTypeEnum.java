package com.vhry.dictionary.lessonType;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum LessonTypeEnum {

    LECTURE(1L, "Лекция"),
    LAB_WORK(2L, "Лабораторная работа"),
    PRACTICE(3L, "Практическое занятие"),
    SEMINAR(4L, "Семинар"),
    EXAM(5L, "Экзамен");

    Long id;
    String value;

}
