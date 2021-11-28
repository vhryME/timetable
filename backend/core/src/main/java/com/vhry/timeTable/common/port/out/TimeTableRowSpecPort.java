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

    List<TimeTableRow> findByDateAndFaculty(LocalDate date, Faculty faculty);

    List<TimeTableRow> findByGroup(Group group);

    List<TimeTableRow> findByStudent(Person person);

}
