package com.vhry.dictionary.universityRole;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum UniversityRoleEnum {

    STUDENT(1L, "Студент"),
    HEADMAN(2L, "Староста"),
    TRADE_UNION_COMMITTEE_MEMBER(3L, "Член профкома"),
    TEACHER(4L, "Преподаватель"),
    CURATOR(5L, "Куратор");

    Long id;
    String value;

}
