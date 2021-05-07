package com.epolsoft.hero.port.in;


import com.epolsoft.hero.domain.Hero;
import com.epolsoft.hero.port.out.HeroPort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface HeroUseCase {

    Hero getHero(Integer id);

    void deleteHero(Integer id);

    Hero saveNewHero(Hero hero);

    Hero updateHero(Integer id, Hero hero);

    List<Hero> findAllHeroes();

    Page<Hero> findPageOfHero(Pageable pageable,  HeroPort.HeroFiltered heroFiltered);

}