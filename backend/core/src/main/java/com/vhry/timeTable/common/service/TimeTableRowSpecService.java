package com.vhry.timeTable.common.service;

import com.vhry.exception.AppException;
import com.vhry.exception.ErrorCodeEnum;
import com.vhry.timeTable.common.domain.TimeTableRow;
import com.vhry.timeTable.common.port.in.TimeTableRowSpecUseCase;
import com.vhry.timeTable.common.port.out.TimeTableRowSpecPort;
import com.vhry.timeTable.faculty.port.in.FacultyCrudUseCase;
import com.vhry.timeTable.group.port.in.GroupCrudUseCase;
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


    @Override
    public List<TimeTableRow> findByDate(LocalDate date) {
        return specPort.findByDate(date);
    }

    @Override
    public List<TimeTableRow> findByDateBetween(LocalDate from, LocalDate to) {
        return specPort.findByDateBetween(from, to);
    }

    @Override
    public List<TimeTableRow> findByDateAndFaculty(LocalDate date, Long facultyId) {
        return specPort.findByDateAndFaculty(date,
                Optional.ofNullable(
                        facultyCrudUseCase.findById(facultyId)).orElseThrow(
                        () -> new AppException(ErrorCodeEnum.E3001, Maps.<String, Object>builder()
                                .put("facultyId", facultyId)
                                .build())));
    }

    @Override
    public List<TimeTableRow> findByGroup(Long groupId) {
        return specPort.findByGroup(
                Optional.ofNullable(
                        groupCrudUseCase.findById(groupId)).orElseThrow(
                        () -> new AppException(ErrorCodeEnum.E3001, Maps.<String, Object>builder()
                                .put("groupId", groupId)
                                .build())));
    }

    @Override
    public List<TimeTableRow> findByStudent(Long studentId) {
        return specPort.findByStudent(
                Optional.ofNullable(
                        personCrudUseCase.findById(studentId)).orElseThrow(
                        () -> new AppException(ErrorCodeEnum.E3001, Maps.<String, Object>builder()
                                .put("studentId", studentId)
                                .build())));
    }

}
