package com.vhry.timetable.group.reposirory;

import com.vhry.timetable.group.domain.GroupJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupJpaRepository extends JpaRepository<GroupJpa, Long> {
}
