package com.vhry.user.person.reposirory;

import com.vhry.user.person.domain.PersonJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PersonJpaRepository extends JpaRepository<PersonJpa, Long>, JpaSpecificationExecutor<PersonJpa> {
}
