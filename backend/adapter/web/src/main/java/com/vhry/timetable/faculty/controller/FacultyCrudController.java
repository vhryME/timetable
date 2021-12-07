package com.vhry.timetable.faculty.controller;

import com.vhry.common.CrudController;
import com.vhry.mapper.DtoMapper;
import com.vhry.port.in.CrudUseCase;
import com.vhry.timeTable.faculty.domain.Faculty;
import com.vhry.timeTable.faculty.port.in.FacultyCrudUseCase;
import com.vhry.timetable.faculty.dto.in.FacultyDtoIn;
import com.vhry.timetable.faculty.dto.out.FacultyDtoOut;
import com.vhry.timetable.faculty.mapper.FacultyDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.vhry.common.EndpointConstants.FACULTY_API;

@RestController
@RequestMapping(FACULTY_API)
@RequiredArgsConstructor
public class FacultyCrudController implements CrudController<FacultyDtoIn, Faculty, FacultyDtoOut> {

    private final FacultyDtoMapper dtoMapper;

    private final FacultyCrudUseCase crudUseCase;


    @Override
    public DtoMapper<FacultyDtoIn, Faculty, FacultyDtoOut> getDtoMapper() {
        return dtoMapper;
    }

    @Override
    public CrudUseCase<Faculty> getCrudUseCase() {
        return crudUseCase;
    }

}
