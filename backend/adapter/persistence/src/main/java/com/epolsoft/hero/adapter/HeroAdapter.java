package com.epolsoft.hero.adapter;


import com.epolsoft.hero.domain.Hero;
import com.epolsoft.hero.domain.HeroJpa;
import com.epolsoft.hero.domain.StatusJpa;
import com.epolsoft.hero.mapper.HeroJpaMapper;
import com.epolsoft.hero.port.out.HeroPort;
import com.epolsoft.hero.repository.HeroRepository;
import com.epolsoft.hero.specification.HeroSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Component
@RequiredArgsConstructor
class HeroAdapter implements HeroPort {

    private final HeroRepository heroRepository;

    private final HeroJpaMapper heroJpaMapper;

    @Override
    @Transactional
    public Hero find(Long id) throws Exception {
        HeroJpa heroJpa = heroRepository.findById(id).get();

        return heroJpaMapper.jpaEntityToEntity(heroJpa);
    }


    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        HeroJpa hero = heroRepository.findById(id).get();

        hero.setStatus(StatusJpa.Delete);

        heroRepository.save(hero);
    }


    @Override
    @Transactional
    public Hero create(Hero hero) throws Exception {
        HeroJpa heroJpa = heroJpaMapper.entityToJpaEntity(hero);

        heroJpa.setStatus(StatusJpa.Draft);

        heroRepository.save(heroJpa);

        return heroJpaMapper.jpaEntityToEntity(heroJpa);
    }


    @Override
    @Transactional
    public Hero update(Long id, Hero hero) throws Exception {
        HeroJpa current = heroRepository.findById(id).get();

        if (current != null) {
            current = heroJpaMapper.entityToJpaEntity(hero);
        }
        heroRepository.save(current);

        return heroJpaMapper.jpaEntityToEntity(current);
    }


    @Override
    public List<Hero> findAll() throws Exception {
        List<HeroJpa> heroes = heroRepository.findAll();

        return heroJpaMapper.listJpaEntityToListEntity(heroes);
    }


    @Override
    public Page<Hero> findPageOfHero(Pageable pageable) throws Exception {
        Page<HeroJpa> heroesFromJpa = heroRepository.findAll(pageable);

        return heroJpaMapper.jpaHeroPageToHeroPage(heroesFromJpa);
    }

    @Override
    public Page<Hero> findPageOfHeroFiltered(Pageable pageable, HeroFiltered heroFiltered) throws Exception {
        if (heroFiltered != null) {
            return heroRepository.findAll(HeroSpecification.filter(heroFiltered), pageable).
                    map(heroJpaMapper::jpaEntityToEntity);
        }

        return null;
    }
}
