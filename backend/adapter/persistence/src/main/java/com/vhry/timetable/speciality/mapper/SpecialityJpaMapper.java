package com.vhry.timetable.speciality.mapper;

import com.vhry.common.MappingsJpaTemplate;
import com.vhry.timeTable.faculty.domain.Speciality;
import com.vhry.mapper.JpaMapper;
import com.vhry.timetable.speciality.domain.SpecialityJpa;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static com.vhry.common.MappingsJpaTemplate.GROUP_MAPPING;
import static com.vhry.common.MappingsJpaTemplate.IN;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, uses = {MappingsJpaTemplate.class})
public interface SpecialityJpaMapper extends JpaMapper<Speciality, SpecialityJpa> {

    @Override
    @Mapping(target = "groups", qualifiedByName = GROUP_MAPPING)
    Speciality fromJpaEntity(SpecialityJpa specialityJpa);

    @Override
    @Mapping(target = "groups", qualifiedByName = GROUP_MAPPING + IN)
    SpecialityJpa toJpaEntity(Speciality speciality);
}
