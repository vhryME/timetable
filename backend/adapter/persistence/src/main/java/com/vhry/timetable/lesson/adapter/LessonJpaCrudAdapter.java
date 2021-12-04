package com.vhry.timetable.lesson.adapter;

import com.vhry.timeTable.lesson.domain.Lesson;
import com.vhry.timetable.lesson.domain.LessonJpa;
import com.vhry.timetable.lesson.mapper.LessonJpaMapper;
import com.vhry.timeTable.lesson.port.out.LessonCrudPort;
import com.vhry.mapper.JpaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LessonJpaCrudAdapter implements LessonCrudPort {

    private final JpaRepository<LessonJpa, Long> jpaRepository;

    private final LessonJpaMapper jpaMapper;


    @Override
    public JpaRepository<LessonJpa, Long> getRepository() {
        return jpaRepository;
    }

    @Override
    public JpaMapper<Lesson, LessonJpa> getJpaMapper() {
        return jpaMapper;
    }

}
