package com.vhry.timeTable.common.port.in;

import com.vhry.timeTable.common.domain.TimeTableRow;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface TimeTableRowSpecUseCase {

    List<TimeTableRow> findByDate(LocalDate date);

    List<TimeTableRow> findByDateBetween(LocalDate from, LocalDate to);

    List<TimeTableRow> findByGroup(Long groupId);

    List<TimeTableRow> findByStudent(Long studentId);

}
