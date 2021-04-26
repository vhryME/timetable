package com.epolsoft.hero.service;


import com.epolsoft.hero.domain.Hero;
import com.epolsoft.hero.port.in.HeroUseCase;
import com.epolsoft.hero.port.out.HeroPort;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
class HeroService implements HeroUseCase {

    private final HeroPort port;


    @Override
    @SneakyThrows
    public Hero getHero(Integer id) {
        return port.findHeroById(id);
    }

    @Override
    @SneakyThrows
    public void deleteHero(Integer id) {
        port.deleteHero(id);
    }

    @Override
    @SneakyThrows
    public Hero saveNewHero(Hero hero) {
        return port.saveNewHero(hero);
    }

    @Override
    @SneakyThrows
    public Hero updateHero(Integer id, Hero hero) {
        return port.updateHero(id, hero);
    }

    @Override
    @SneakyThrows
    public List<Hero> findAllHeroes() {
        return port.findAllHeroes();
    }

    @Override
    @SneakyThrows
    public Object findPageOfHero(Pageable pageable, HeroPort.HeroFiltered heroFiltered) {
        if(!pageable.isPaged()) {
            return port.findAllHeroes();
        }
        Page<Hero> heroPage;

        if(heroFiltered != null) {
            heroPage = port.findPageOfHeroFiltered(pageable, heroFiltered);
        } else {
            heroPage = port.findPageOfHero(pageable);
        }

        return heroPage;
    }

}