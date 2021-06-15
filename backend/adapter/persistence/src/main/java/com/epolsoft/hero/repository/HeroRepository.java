package com.epolsoft.hero.repository;


import com.epolsoft.hero.domain.HeroJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroRepository extends JpaRepository<HeroJpa, Long>, JpaSpecificationExecutor<HeroJpa> {
    HeroJpa findByName(String name);
}
