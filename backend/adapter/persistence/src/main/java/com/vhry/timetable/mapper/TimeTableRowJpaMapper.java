package com.vhry.timetable.mapper;

import com.vhry.common.MappingsJpaTemplate;
import com.vhry.mapper.JpaMapper;
import com.vhry.timeTable.common.domain.TimeTableRow;
import com.vhry.timetable.domain.TimeTableRowJpa;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static com.vhry.common.MappingsJpaTemplate.*;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, uses = {MappingsJpaTemplate.class})
public interface TimeTableRowJpaMapper extends JpaMapper<TimeTableRow, TimeTableRowJpa> {

    @Override
    @Mapping(target = "group", qualifiedByName = GROUP_MAPPING)
    @Mapping(target = "lessons", qualifiedByName = LESSON_MAPPING)
    TimeTableRow fromJpaEntity(TimeTableRowJpa timeTableRowJpa);

    @Override
    @Mapping(target = "group", qualifiedByName = GROUP_MAPPING + IN)
    @Mapping(target = "lessons", qualifiedByName = LESSON_MAPPING + IN)
    TimeTableRowJpa toJpaEntity(TimeTableRow timeTableRow);

}
