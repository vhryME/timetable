package com.vhry.timeTable.domain.faculty.reposirory;

import com.vhry.timeTable.domain.faculty.domain.FacultyJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyJpaRepository extends JpaRepository<FacultyJpa, Long> {
}
