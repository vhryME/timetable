package com.vhry.timetable.controller;

import com.vhry.common.CrudController;
import com.vhry.mapper.DtoMapper;
import com.vhry.port.in.CrudUseCase;
import com.vhry.timeTable.common.domain.TimeTableRow;
import com.vhry.timeTable.common.port.in.TimeTableRowCrudUseCase;
import com.vhry.timetable.dto.timetable.in.TimeTableRowDtoIn;
import com.vhry.timetable.dto.timetable.out.TimeTableRowDtoOut;
import com.vhry.timetable.mapper.TimeTableRowDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.vhry.common.EndpointConstants.TIMETABLE_API;

@RestController
@RequestMapping(TIMETABLE_API)
@RequiredArgsConstructor
public class TimeTableCrudController implements CrudController<TimeTableRowDtoIn, TimeTableRow, TimeTableRowDtoOut> {

    private final TimeTableRowDtoMapper dtoMapper;

    private final TimeTableRowCrudUseCase useCase;


    @Override
    public DtoMapper<TimeTableRowDtoIn, TimeTableRow, TimeTableRowDtoOut> getDtoMapper() {
        return dtoMapper;
    }

    @Override
    public CrudUseCase<TimeTableRow> getCrudUseCase() {
        return useCase;
    }

}
