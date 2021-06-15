package com.epolsoft.match.repository;

import com.epolsoft.match.domain.MatchJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends JpaRepository<MatchJpa, Long>, JpaSpecificationExecutor<MatchJpa> {
}
