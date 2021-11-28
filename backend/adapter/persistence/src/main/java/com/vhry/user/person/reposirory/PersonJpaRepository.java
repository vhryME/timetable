package com.vhry.user.person.reposirory;

import com.vhry.user.person.domain.PersonJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonJpaRepository extends JpaRepository<PersonJpa, Long> {
}
