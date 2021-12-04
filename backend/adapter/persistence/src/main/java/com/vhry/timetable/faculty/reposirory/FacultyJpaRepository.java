package com.vhry.timetable.faculty.reposirory;

import com.vhry.timetable.faculty.domain.FacultyJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyJpaRepository extends JpaRepository<FacultyJpa, Long> {
}
