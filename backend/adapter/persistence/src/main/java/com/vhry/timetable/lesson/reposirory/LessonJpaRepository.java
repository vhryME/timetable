package com.vhry.timetable.lesson.reposirory;

import com.vhry.timetable.lesson.domain.LessonJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonJpaRepository extends JpaRepository<LessonJpa, Long> {
}
