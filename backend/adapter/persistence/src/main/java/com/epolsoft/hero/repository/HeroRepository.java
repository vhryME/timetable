package com.epolsoft.hero.repository;


import com.epolsoft.hero.domain.HeroJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface HeroRepository extends JpaRepository<HeroJpa, Long>, JpaSpecificationExecutor<HeroJpa> {}
