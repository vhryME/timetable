package com.vhry.timetable.specification;

import com.vhry.timetable.domain.TimeTableRowJpa;
import org.springframework.data.jpa.domain.Specification;

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

}
