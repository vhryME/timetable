package com.epolsoft.hero.port.in;


import com.epolsoft.hero.domain.Hero;
import com.epolsoft.hero.port.out.HeroPort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface HeroUseCase {

    Hero find(Long id);


    void delete(Long id);


    Hero create(Hero hero);


    Hero update(Long id, Hero hero);


    List<Hero> findAll();


    Page<Hero> findPageOfHero(Pageable pageable,  HeroPort.HeroFiltered heroFiltered);

}