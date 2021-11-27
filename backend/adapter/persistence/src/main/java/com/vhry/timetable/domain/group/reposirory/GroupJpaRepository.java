package com.vhry.timeTable.domain.group.reposirory;

import com.vhry.timeTable.domain.group.domain.GroupJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupJpaRepository extends JpaRepository<GroupJpa, Long> {
}
