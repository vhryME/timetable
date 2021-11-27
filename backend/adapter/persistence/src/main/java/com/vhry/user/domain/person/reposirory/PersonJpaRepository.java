package com.vhry.user.domain.person.reposirory;

import com.vhry.user.domain.person.domain.PersonJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonJpaRepository extends JpaRepository<PersonJpa, Long> {
}
