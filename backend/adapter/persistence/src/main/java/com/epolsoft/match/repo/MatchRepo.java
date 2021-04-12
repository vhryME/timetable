package com.epolsoft.match.repo;

import com.epolsoft.match.jpa.MatchJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepo extends JpaRepository<MatchJpa, Long>, JpaSpecificationExecutor<MatchJpa> {
}