package com.vhry.timeTable.common.port.in;

import com.vhry.timeTable.common.domain.TimeTableRow;
import com.vhry.timeTable.faculty.domain.Faculty;
import com.vhry.timeTable.group.domain.Group;
import com.vhry.user.person.domain.Person;

import java.time.LocalDate;
import java.util.List;

public interface TimeTableRowSpecUseCase {

    List<TimeTableRow> findByDate(LocalDate date);

    List<TimeTableRow> findByDateBetween(LocalDate from, LocalDate to);

    List<TimeTableRow> findByFaculty(Long facultyId);

    List<TimeTableRow> findByDateAndFaculty(LocalDate date, Long facultyId);

    List<TimeTableRow> findByBetweenDateAndFaculty(LocalDate from, LocalDate to, Long facultyId);

    List<TimeTableRow> findByGroup(Long groupId);

    List<TimeTableRow> findByGroupAndDate(Long groupId, LocalDate date);

    List<TimeTableRow> findByBetweenDateAndGroup(LocalDate from, LocalDate to, Long groupId);

    List<TimeTableRow> findByStudent(Long personId);

    List<TimeTableRow> findByStudentAndDate(Long personId, LocalDate date);

    List<TimeTableRow> findByBetweenDateAndStudent(LocalDate from, LocalDate to, Long personId);

}
