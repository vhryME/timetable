package com.epolsoft.hero.repository;


import com.epolsoft.hero.domain.SpellJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Component
@Repository
public interface SpellRepository extends JpaRepository<SpellJpa, Long> {}