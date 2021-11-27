package com.vhry.timeTable.domain.lesson.mapper;


import com.vhry.common.MappingsJpaTemplate;
import com.vhry.timeTable.lesson.domain.Lesson;
import com.vhry.timeTable.domain.lesson.domain.LessonJpa;
import com.vhry.mapper.JpaMapper;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static com.vhry.common.MappingsJpaTemplate.IN;
import static com.vhry.common.MappingsJpaTemplate.LESSON_TYPE_MAPPING;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, uses = {MappingsJpaTemplate.class})
public interface LessonJpaMapper extends JpaMapper<Lesson, LessonJpa> {

    @Override
    @Mapping(target = "type", qualifiedByName = LESSON_TYPE_MAPPING)
    Lesson fromJpaEntity(LessonJpa lessonJpa);

    @Override
    @Mapping(target = "type", qualifiedByName = LESSON_TYPE_MAPPING + IN)
    LessonJpa toJpaEntity(Lesson lesson);
}
