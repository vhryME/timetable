package com.vhry.timeTable.common.service;

import com.vhry.exception.AppException;
import com.vhry.exception.ErrorCodeEnum;
import com.vhry.timeTable.common.domain.TimeTableRow;
import com.vhry.timeTable.common.port.in.TimeTableRowSpecUseCase;
import com.vhry.timeTable.common.port.out.TimeTableRowSpecPort;
import com.vhry.timeTable.faculty.domain.Faculty;
import com.vhry.timeTable.faculty.port.in.FacultyCrudUseCase;
import com.vhry.timeTable.group.domain.Group;
import com.vhry.timeTable.group.port.in.GroupCrudUseCase;
import com.vhry.user.person.domain.Person;
import com.vhry.user.person.port.in.PersonCrudUseCase;
import com.vhry.util.Maps;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TimeTableRowSpecService implements TimeTableRowSpecUseCase {

    private final TimeTableRowSpecPort specPort;

    private final GroupCrudUseCase groupCrudUseCase;

    private final PersonCrudUseCase personCrudUseCase;

    private final FacultyCrudUseCase facultyCrudUseCase;


    private Faculty findFacultyForSpec(Long facultyId) {
        return Optional.ofNullable(
                facultyCrudUseCase.findById(facultyId)).orElseThrow(
                () -> new AppException(ErrorCodeEnum.E3001, Maps.<String, Object>builder()
                        .put("facultyId", facultyId)
                        .build()));
    }

    private Group findGroupForSpec(Long groupId) {
        return Optional.ofNullable(
                groupCrudUseCase.findById(groupId)).orElseThrow(
                () -> new AppException(ErrorCodeEnum.E3002, Maps.<String, Object>builder()
                        .put("groupId", groupId)
                        .build()));
    }

    private Person findStudentForSpec(Long personId) {
        return Optional.ofNullable(personCrudUseCase.findById(personId))
                .orElseThrow(
                        () -> new AppException(ErrorCodeEnum.E3003, Maps.<String, Object>builder()
                                .put("personId", personId)
                                .build()));
    }

    private LocalDate checkDateForSpec(LocalDate date) {
        return Optional.of(date)
                .orElseThrow(
                        () -> new AppException(ErrorCodeEnum.E3004));
    }

    @Override
    public List<TimeTableRow> findByDate(LocalDate date) {
        return specPort.findByDate(
                checkDateForSpec(date));
    }

    @Override
    public List<TimeTableRow> findByDateBetween(LocalDate from, LocalDate to) {
        return specPort.findByDateBetween(
                checkDateForSpec(from), checkDateForSpec(to));
    }

    @Override
    public List<TimeTableRow> findByFaculty(Long facultyId) {
        return specPort.findByFaculty(
                findFacultyForSpec(facultyId));
    }

    @Override
    public List<TimeTableRow> findByDateAndFaculty(LocalDate date, Long facultyId) {
        return specPort.findByDateAndFaculty(
                checkDateForSpec(date), findFacultyForSpec(facultyId));
    }

    @Override
    public List<TimeTableRow> findByBetweenDateAndFaculty(LocalDate from, LocalDate to, Long facultyId) {
        return specPort.findByBetweenDateAndFaculty(
                checkDateForSpec(from), checkDateForSpec(to), findFacultyForSpec(facultyId));
    }

    @Override
    public List<TimeTableRow> findByGroup(Long groupId) {
        return specPort.findByGroup(
                findGroupForSpec(groupId));
    }

    @Override
    public List<TimeTableRow> findByGroupAndDate(Long groupId, LocalDate date) {
        return specPort.findByGroupAndDate(
                findGroupForSpec(groupId), checkDateForSpec(date));
    }

    @Override
    public List<TimeTableRow> findByBetweenDateAndGroup(LocalDate from, LocalDate to, Long groupId) {
        return specPort.findByBetweenDateAndGroup(
                checkDateForSpec(from), checkDateForSpec(to), findGroupForSpec(groupId));
    }

    @Override
    public List<TimeTableRow> findByStudent(Long personId) {
        return specPort.findByStudent(
                findStudentForSpec(personId));
    }

    @Override
    public List<TimeTableRow> findByStudentAndDate(Long personId, LocalDate date) {
        return specPort.findByStudentAndDate(
                findStudentForSpec(personId), checkDateForSpec(date));
    }

    @Override
    public List<TimeTableRow> findByBetweenDateAndStudent(LocalDate from, LocalDate to, Long personId) {
        return specPort.findByBetweenDateAndStudent(
                checkDateForSpec(from), checkDateForSpec(to), findStudentForSpec(personId));
    }

}
