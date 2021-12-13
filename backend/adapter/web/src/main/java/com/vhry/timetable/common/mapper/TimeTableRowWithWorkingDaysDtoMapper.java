package com.vhry.timetable.common.mapper;

import com.vhry.common.MappingsDtoTemplate;
import com.vhry.mapper.DtoMapper;
import com.vhry.timeTable.common.domain.TimeTableRowWithWorkingDays;
import com.vhry.timetable.common.dto.timetable.in.TimeTableRowWithWorkingDaysDtoIn;
import com.vhry.timetable.common.dto.timetable.out.TimeTableRowWithWorkingDaysDtoOut;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static com.vhry.common.MappingsDtoTemplate.IN;
import static com.vhry.common.MappingsDtoTemplate.OUT;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, uses = {MappingsDtoTemplate.class})
public interface TimeTableRowWithWorkingDaysDtoMapper extends
        DtoMapper<TimeTableRowWithWorkingDaysDtoIn, TimeTableRowWithWorkingDays, TimeTableRowWithWorkingDaysDtoOut> {

    @Override
    @Mapping(target = "group", qualifiedByName = MappingsDtoTemplate.GROUP_DTO_MAPPING + IN)
    @Mapping(target = "monday", qualifiedByName = MappingsDtoTemplate.LESSON_DTO_MAPPING + IN)
    @Mapping(target = "tuesday", qualifiedByName = MappingsDtoTemplate.LESSON_DTO_MAPPING + IN)
    @Mapping(target = "wednesday", qualifiedByName = MappingsDtoTemplate.LESSON_DTO_MAPPING + IN)
    @Mapping(target = "thursday", qualifiedByName = MappingsDtoTemplate.LESSON_DTO_MAPPING + IN)
    @Mapping(target = "friday", qualifiedByName = MappingsDtoTemplate.LESSON_DTO_MAPPING + IN)
    TimeTableRowWithWorkingDays fromIn(TimeTableRowWithWorkingDaysDtoIn jpaEntity);

    @Override
    @Mapping(target = "group", qualifiedByName = MappingsDtoTemplate.GROUP_DTO_MAPPING + OUT)
    @Mapping(target = "monday", qualifiedByName = MappingsDtoTemplate.LESSON_DTO_MAPPING + OUT)
    @Mapping(target = "tuesday", qualifiedByName = MappingsDtoTemplate.LESSON_DTO_MAPPING + OUT)
    @Mapping(target = "wednesday", qualifiedByName = MappingsDtoTemplate.LESSON_DTO_MAPPING + OUT)
    @Mapping(target = "thursday", qualifiedByName = MappingsDtoTemplate.LESSON_DTO_MAPPING + OUT)
    @Mapping(target = "friday", qualifiedByName = MappingsDtoTemplate.LESSON_DTO_MAPPING + OUT)
    TimeTableRowWithWorkingDaysDtoOut toOut(TimeTableRowWithWorkingDays timeTableRowWithWorkingDays);

}
