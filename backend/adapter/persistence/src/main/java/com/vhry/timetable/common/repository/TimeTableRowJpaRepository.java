package com.vhry.timetable.common.repository;

import com.vhry.timetable.common.domain.TimeTableRowJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TimeTableRowJpaRepository extends JpaRepository<TimeTableRowJpa, Long>, JpaSpecificationExecutor<TimeTableRowJpa> {

}
