package com.vhry.timetable.faculty.mapper;

import com.vhry.common.MappingsDtoTemplate;
import com.vhry.mapper.DtoMapper;
import com.vhry.timeTable.faculty.domain.Faculty;
import com.vhry.timetable.faculty.dto.in.FacultyDtoIn;
import com.vhry.timetable.faculty.dto.out.FacultyDtoOut;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static com.vhry.common.MappingsDtoTemplate.*;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, uses = {MappingsDtoTemplate.class})
public interface FacultyDtoMapper extends DtoMapper<FacultyDtoIn, Faculty, FacultyDtoOut> {

    @Override
    @Mapping(target = "specialities", qualifiedByName = SPECIALITY_DTO_MAPPING + IN)
    Faculty fromIn(FacultyDtoIn dtoIn);

    @Override
    @Mapping(target = "specialities", qualifiedByName = SPECIALITY_DTO_MAPPING + OUT)
    FacultyDtoOut toOut(Faculty entity);

}
