package com.vhry.timeTable.domain.lesson.reposirory;

import com.vhry.timeTable.domain.lesson.domain.LessonJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonJpaRepository extends JpaRepository<LessonJpa, Long> {
}
