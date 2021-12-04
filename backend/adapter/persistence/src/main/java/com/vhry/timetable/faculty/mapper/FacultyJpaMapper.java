package com.vhry.timetable.faculty.mapper;

import com.vhry.common.MappingsJpaTemplate;
import com.vhry.timeTable.faculty.domain.Faculty;
import com.vhry.timetable.faculty.domain.FacultyJpa;
import com.vhry.mapper.JpaMapper;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static com.vhry.common.MappingsJpaTemplate.IN;
import static com.vhry.common.MappingsJpaTemplate.SPECIALITY_MAPPING;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, uses = {MappingsJpaTemplate.class})
public interface FacultyJpaMapper extends JpaMapper<Faculty, FacultyJpa> {

    @Override
    @Mapping(target = "specialities", qualifiedByName = SPECIALITY_MAPPING)
    Faculty fromJpaEntity(FacultyJpa universityRoleJpa);

    @Override
    @Mapping(target = "specialities", qualifiedByName = SPECIALITY_MAPPING + IN)
    FacultyJpa toJpaEntity(Faculty universityRole);

}
