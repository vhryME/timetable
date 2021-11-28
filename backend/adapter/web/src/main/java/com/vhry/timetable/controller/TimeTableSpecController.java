package com.vhry.timetable.controller;

import com.vhry.constants.DateFormatConstants;
import com.vhry.mapper.DateStringMapper;
import com.vhry.timeTable.common.port.in.TimeTableRowSpecUseCase;
import com.vhry.timetable.dto.timetable.out.TimeTableRowDtoOut;
import com.vhry.timetable.mapper.TimeTableRowDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.vhry.common.EndpointConstants.*;
import static com.vhry.constants.DateFormatConstants.DATE_FORMAT;

@RestController
@RequestMapping(TIMETABLE_API)
@RequiredArgsConstructor
public class TimeTableSpecController {

    private final TimeTableRowDtoMapper dtoMapper;

    private final TimeTableRowSpecUseCase specUseCase;


    @GetMapping(TIMETABLE_BY_DATE)
    public List<TimeTableRowDtoOut> findByDate(@RequestParam String date) {
        return dtoMapper.toOut(
                specUseCase.findByDate(
                        DateStringMapper.asLocalDate(date, DATE_FORMAT)));
    }

    @GetMapping(TIMETABLE_BETWEEN_DATE)
    public List<TimeTableRowDtoOut> findByDateBetween(@RequestParam String from, @RequestParam String to) {
        return dtoMapper.toOut(
                specUseCase.findByDateBetween(
                        DateStringMapper.asLocalDate(from, DATE_FORMAT),
                        DateStringMapper.asLocalDate(to, DATE_FORMAT)));
    }

    @GetMapping(TIMETABLE_BY_DATE_AND_GROUP + "/{facultyId}")
    public List<TimeTableRowDtoOut> findByDateAndFaculty(@RequestParam String date, @PathVariable Long facultyId) {
        return dtoMapper.toOut(
                specUseCase.findByDateAndFaculty(
                        DateStringMapper.asLocalDate(date, DATE_FORMAT), facultyId));
    }

    @GetMapping(TIMETABLE_BY_GROUP)
    public List<TimeTableRowDtoOut> findByGroup(@RequestParam Long groupId) {
        return dtoMapper.toOut(
                specUseCase.findByGroup(groupId));
    }

    @GetMapping(TIMETABLE_BY_STUDENT)
    public List<TimeTableRowDtoOut> findByStudent(@RequestParam Long studentId) {
        return dtoMapper.toOut(
                specUseCase.findByStudent(studentId));
    }

}
