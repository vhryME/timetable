package com.epolsoft.hero.repository;

import com.epolsoft.hero.domain.TalentJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TalentRepository extends JpaRepository<TalentJpa, Long> {
}
