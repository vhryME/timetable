package com.vhry.timeTable.common.port.out;

import com.vhry.port.out.SpecPort;
import com.vhry.timeTable.common.domain.TimeTableRow;
import com.vhry.timeTable.faculty.domain.Faculty;
import com.vhry.timeTable.group.domain.Group;
import com.vhry.user.person.domain.Person;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface TimeTableRowSpecPort extends SpecPort {

    List<TimeTableRow> findByDate(LocalDate date);

    List<TimeTableRow> findByDateBetween(LocalDate from, LocalDate to);

    List<TimeTableRow> findByFaculty(Faculty faculty);

    List<TimeTableRow> findByDateAndFaculty(LocalDate date, Faculty faculty);

    List<TimeTableRow> findByBetweenDateAndFaculty(LocalDate from, LocalDate to, Faculty faculty);

    List<TimeTableRow> findByGroup(Group group);

    List<TimeTableRow> findByGroupAndDate(Group group, LocalDate date);

    List<TimeTableRow> findByBetweenDateAndGroup(LocalDate from, LocalDate to, Group group);

    List<TimeTableRow> findByStudent(Person person);

    List<TimeTableRow> findByStudentAndDate(Person person, LocalDate date);

    List<TimeTableRow> findByBetweenDateAndStudent(LocalDate from, LocalDate to, Person person);
}
