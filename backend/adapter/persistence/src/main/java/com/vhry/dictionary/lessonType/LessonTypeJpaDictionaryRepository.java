package com.vhry.dictionary.lessonType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonTypeJpaDictionaryRepository extends JpaRepository<LessonTypeJpa, Long> {

}
