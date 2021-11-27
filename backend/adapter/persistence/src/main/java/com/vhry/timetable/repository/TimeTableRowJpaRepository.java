package com.vhry.timetable.repository;

import com.vhry.timetable.domain.TimeTableRowJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TimeTableRowJpaRepository extends JpaRepository<TimeTableRowJpa, Long>, JpaSpecificationExecutor<TimeTableRowJpa> {

}
