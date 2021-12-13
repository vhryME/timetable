package com.vhry.timetable.common.mapper;

import com.vhry.common.MappingsDtoTemplate;
import com.vhry.mapper.DtoMapper;
import com.vhry.timeTable.common.domain.TimeTableRow;
import com.vhry.timetable.common.dto.timetable.in.TimeTableRowDtoIn;
import com.vhry.timetable.common.dto.timetable.out.TimeTableRowDtoOut;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static com.vhry.common.MappingsDtoTemplate.IN;
import static com.vhry.common.MappingsDtoTemplate.OUT;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, uses = {MappingsDtoTemplate.class})
public interface TimeTableRowDtoMapper extends DtoMapper<TimeTableRowDtoIn, TimeTableRow, TimeTableRowDtoOut> {

    @Override
    @Mapping(target = "group", qualifiedByName = MappingsDtoTemplate.GROUP_DTO_MAPPING + IN)
    @Mapping(target = "lessons", qualifiedByName = MappingsDtoTemplate.LESSON_DTO_MAPPING + IN)
    TimeTableRow fromIn(TimeTableRowDtoIn dtoIn);

    @Override
    @Mapping(target = "group", qualifiedByName = MappingsDtoTemplate.GROUP_DTO_MAPPING + OUT)
    @Mapping(target = "lessons", qualifiedByName = MappingsDtoTemplate.LESSON_DTO_MAPPING + OUT)
    TimeTableRowDtoOut toOut(TimeTableRow entity);

}
