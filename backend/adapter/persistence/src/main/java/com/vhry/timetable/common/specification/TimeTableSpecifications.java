package com.vhry.timetable.common.specification;

import com.vhry.timetable.common.domain.TimeTableRowJpa;
import com.vhry.timetable.group.domain.GroupJpa;
import com.vhry.user.person.domain.PersonJpa;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import java.time.LocalDate;

public class TimeTableSpecifications {

    public static Specification<TimeTableRowJpa> findByDate(LocalDate date) {
        return (root, query, cb) -> cb.equal(root
                .joinSet("lessons", JoinType.LEFT)
                .get("date"), date);
    }

    public static Specification<TimeTableRowJpa> findByDateBetween(LocalDate from, LocalDate to) {
        return (root, query, cb) -> cb.between(root
                .joinSet("lessons", JoinType.LEFT)
                .get("date"), from, to);
    }

    public static Specification<TimeTableRowJpa> findByGroup(Long groupId) {
        return (root, query, cb) -> cb.equal(root
                .get("group")
                .get("id"), groupId);
    }

    public static Specification<TimeTableRowJpa> findByStudent(Long studentId) {
        return (root, query, cb) -> cb.equal(root
                .join("group")
                .joinSet("students", JoinType.LEFT)
                .get("id"), studentId);
    }

    public static Specification<TimeTableRowJpa> findByFaculty(Long facultyId) {
        return (root, query, cb) -> cb.equal(root
                .join("group", JoinType.LEFT)
                .join("speciality", JoinType.LEFT)
                .join("faculty", JoinType.LEFT)
                .get("id"), facultyId);
    }

}
