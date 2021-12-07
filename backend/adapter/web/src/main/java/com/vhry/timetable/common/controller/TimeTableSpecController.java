package com.vhry.timetable.common.controller;

import com.vhry.mapper.DateStringMapper;
import com.vhry.timeTable.common.port.in.TimeTableRowSpecUseCase;
import com.vhry.timetable.common.dto.timetable.in.TimeTableRowWithWorkingDaysDtoIn;
import com.vhry.timetable.common.dto.timetable.out.TimeTableRowWithWorkingDaysDtoOut;
import com.vhry.timetable.common.mapper.TimeTableRowDtoMapper;
import com.vhry.timetable.common.mapper.TimeTableRowWithWorkingDaysDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.vhry.common.EndpointConstants.*;
import static com.vhry.constants.DateFormatConstants.DATE_FORMAT;

@RestController
@RequestMapping(TIMETABLE_API)
@RequiredArgsConstructor
public class TimeTableSpecController {

    private final TimeTableRowWithWorkingDaysDtoMapper dtoMapper;

    private final TimeTableRowSpecUseCase specUseCase;


    @GetMapping(TIMETABLE_BY_DATE)
    public List<TimeTableRowWithWorkingDaysDtoOut> findByDate(@RequestParam String date) {
        return dtoMapper.toOut(
                specUseCase.findByDate(
                        DateStringMapper.asLocalDate(date, DATE_FORMAT)));
    }

    @GetMapping(TIMETABLE_BETWEEN_DATE)
    public List<TimeTableRowWithWorkingDaysDtoOut> findByDateBetween(@RequestParam String from, @RequestParam String to) {
        return dtoMapper.toOut(
                specUseCase.findByDateBetween(
                        DateStringMapper.asLocalDate(from, DATE_FORMAT),
                        DateStringMapper.asLocalDate(to, DATE_FORMAT)));
    }

    @GetMapping(TIMETABLE_BY_FACULTY + "/{facultyId}")
    public List<TimeTableRowWithWorkingDaysDtoOut> findByFaculty(@PathVariable Long facultyId) {
        return dtoMapper.toOut(
                specUseCase.findByFaculty(facultyId));
    }

    @GetMapping(TIMETABLE_BY_FACULTY_BY_DATE + "/{facultyId}")
    public List<TimeTableRowWithWorkingDaysDtoOut> findByFacultyAndDate(@RequestParam String date, @PathVariable Long facultyId) {
        return dtoMapper.toOut(
                specUseCase.findByDateAndFaculty(
                        DateStringMapper.asLocalDate(date, DATE_FORMAT), facultyId));
    }

    @GetMapping(TIMETABLE_BY_FACULTY_BETWEEN_DATE + "/{facultyId}")
    public List<TimeTableRowWithWorkingDaysDtoOut> findByFacultyBetweenDate(@RequestParam String from,
                                                             @RequestParam String to,
                                                             @PathVariable Long facultyId) {
        return dtoMapper.toOut(
                specUseCase.findByBetweenDateAndFaculty(
                        DateStringMapper.asLocalDate(from, DATE_FORMAT),
                        DateStringMapper.asLocalDate(to, DATE_FORMAT),
                        facultyId));
    }

    @GetMapping(TIMETABLE_BY_GROUP + "/{groupId}")
    public List<TimeTableRowWithWorkingDaysDtoOut> findByGroup(@PathVariable Long groupId) {
        return dtoMapper.toOut(
                specUseCase.findByGroup(groupId));
    }

    @GetMapping(TIMETABLE_BY_GROUP_BY_DATE + "/{groupId}")
    public List<TimeTableRowWithWorkingDaysDtoOut> findByGroupAndDate(@RequestParam String date, @PathVariable Long groupId) {
        return dtoMapper.toOut(
                specUseCase.findByGroupAndDate(
                        groupId, DateStringMapper.asLocalDate(date, DATE_FORMAT)));
    }

    @GetMapping(TIMETABLE_BY_GROUP_BETWEEN_DATE + "/{groupId}")
    public List<TimeTableRowWithWorkingDaysDtoOut> findByGroupBetweenDate(@RequestParam String from,
                                                             @RequestParam String to,
                                                             @PathVariable Long groupId) {
        return dtoMapper.toOut(
                specUseCase.findByBetweenDateAndGroup(
                        DateStringMapper.asLocalDate(from, DATE_FORMAT),
                        DateStringMapper.asLocalDate(to, DATE_FORMAT),
                        groupId));
    }

    @GetMapping(TIMETABLE_BY_STUDENT + "/{studentId}")
    public List<TimeTableRowWithWorkingDaysDtoOut> findByStudent(@PathVariable Long studentId) {
        return dtoMapper.toOut(
                specUseCase.findByStudent(studentId));
    }

    @GetMapping(TIMETABLE_BY_STUDENT_BY_DATE + "/{studentId}")
    public List<TimeTableRowWithWorkingDaysDtoOut> findByStudentAndDate(@RequestParam String date, @PathVariable Long studentId) {
        return dtoMapper.toOut(
                specUseCase.findByStudentAndDate(
                        studentId, DateStringMapper.asLocalDate(date, DATE_FORMAT)));
    }

    @GetMapping(TIMETABLE_BY_STUDENT_BETWEEN_DATE + "/{studentId}")
    public List<TimeTableRowWithWorkingDaysDtoOut> findByStudentBetweenDate(@RequestParam String from,
                                                             @RequestParam String to,
                                                             @PathVariable Long studentId) {
        return dtoMapper.toOut(
                specUseCase.findByBetweenDateAndStudent(
                        DateStringMapper.asLocalDate(from, DATE_FORMAT),
                        DateStringMapper.asLocalDate(to, DATE_FORMAT),
                        studentId));
    }

}
