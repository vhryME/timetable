package com.vhry.timeTable.common.port.in;

import com.vhry.timeTable.common.domain.TimeTableRow;
import com.vhry.timeTable.common.domain.TimeTableRowWithWorkingDays;
import com.vhry.timeTable.faculty.domain.Faculty;
import com.vhry.timeTable.group.domain.Group;
import com.vhry.user.person.domain.Person;

import java.time.LocalDate;
import java.util.List;

public interface TimeTableRowSpecUseCase {

    List<TimeTableRowWithWorkingDays> findByDate(LocalDate date);

    List<TimeTableRowWithWorkingDays> findByDateBetween(LocalDate from, LocalDate to);

    List<TimeTableRowWithWorkingDays> findByFaculty(Long facultyId);

    List<TimeTableRowWithWorkingDays> findByDateAndFaculty(LocalDate date, Long facultyId);

    List<TimeTableRowWithWorkingDays> findByBetweenDateAndFaculty(LocalDate from, LocalDate to, Long facultyId);

    List<TimeTableRowWithWorkingDays> findByGroup(Long groupId);

    List<TimeTableRowWithWorkingDays> findByGroupAndDate(Long groupId, LocalDate date);

    List<TimeTableRowWithWorkingDays> findByBetweenDateAndGroup(LocalDate from, LocalDate to, Long groupId);

    List<TimeTableRowWithWorkingDays> findByStudent(Long personId);

    List<TimeTableRowWithWorkingDays> findByStudentAndDate(Long personId, LocalDate date);

    List<TimeTableRowWithWorkingDays> findByBetweenDateAndStudent(LocalDate from, LocalDate to, Long personId);

}
