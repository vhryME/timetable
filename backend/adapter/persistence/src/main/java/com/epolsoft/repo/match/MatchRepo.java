package com.epolsoft.repo.match;

import com.epolsoft.dto.match.MatchJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepo extends JpaRepository<MatchJpa, Long>, JpaSpecificationExecutor<MatchJpa> {
}