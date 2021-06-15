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
    public Hero find(Long id) {
        return port.find(id);
    }


    @Override
    @SneakyThrows
    public void delete(Long id) {
        port.delete(id);
    }


    @Override
    @SneakyThrows
    public Hero create(Hero hero) {
        return port.create(hero);
    }


    @Override
    @SneakyThrows
    public Hero update(Long id, Hero hero) {
        return port.update(id, hero);
    }


    @Override
    @SneakyThrows
    public List<Hero> findAll() {
        return port.findAll();
    }


    @Override
    @SneakyThrows
    public Page<Hero> findPageOfHero(Pageable pageable, HeroPort.HeroFiltered heroFiltered) {
        Page<Hero> heroPage;

        if(heroFiltered != null) {
            heroPage = port.findPageOfHeroFiltered(pageable, heroFiltered);
        } else {
            heroPage = port.findPageOfHero(pageable);
        }

        return heroPage;
    }

}