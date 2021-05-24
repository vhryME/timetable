package com.epolsoft.hero.repo;


import com.epolsoft.hero.domain.SpellJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SpellRepository extends JpaRepository<SpellJpa, Long> {

    SpellJpa findByName(String name);

}