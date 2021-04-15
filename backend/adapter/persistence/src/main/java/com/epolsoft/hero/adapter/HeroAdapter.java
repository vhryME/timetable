package com.epolsoft.hero.adapter;


import com.epolsoft.hero.domain.Hero;
import com.epolsoft.hero.domain.Role;
import com.epolsoft.hero.port.out.HeroPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;


@Component
@RequiredArgsConstructor
public class HeroAdapter implements HeroPort {

    private List<Hero> heroes;


    @PostConstruct
    public void init() {
        heroes = new ArrayList<>();

        Hero hero1 = new Hero(1, "Valira", "icon_valira", Role.Specialist, false, LocalDate.now(),
                new HashSet<>(), new HashSet<>());
        Hero hero2 = new Hero(2, "Garrosh", "icon_garrosh", Role.Warrior, true, LocalDate.now(),
                new HashSet<>(), new HashSet<>());
        Hero hero3 = new Hero(3, "Alarak", "icon_alarak", Role.Assassin, true, LocalDate.now(),
                new HashSet<>(), new HashSet<>());
        Hero hero4 = new Hero(4, "Auriel", "icon_auriel", Role.Support, false, LocalDate.now(),
                new HashSet<>(), new HashSet<>());

        heroes.add(hero1);
        heroes.add(hero2);
        heroes.add(hero3);
        heroes.add(hero4);
    }


    @Override
    public Hero findHeroById(Integer id) throws Exception {
        return heroes.get(id);
    }


    @Override
    public void deleteHero(Integer id) throws Exception {
        heroes.remove(id);
    }


    @Override
    public Hero saveNewHero(Hero hero) throws Exception {
        heroes.add(hero);

        int index = heroes.indexOf(hero);

        if(index >= 0) {
            return heroes.get(index);
        }

        return null;
    }


    @Override
    public Hero updateHero(Integer id, Hero hero) throws Exception {
        if(heroes.get(id) != null) {
            heroes.set(id, hero);
        }

        int index = heroes.indexOf(hero);

        if(index >= 0) {
            return heroes.get(index);
        }

        return null;
    }


    @Override
    public List<Hero> findAllHeroes() throws Exception {
        return heroes;
    }


    @Override
    public Page<Hero> findPageOfHero(Pageable pageable) throws Exception {
        int start = (int)pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), heroes.size());

        return new PageImpl<>(heroes.subList(start, end), pageable, heroes.size());
    }


    @Override
    public Page<Hero> findPageOfHeroFiltered(Pageable pageable, HeroFiltered heroFiltered) throws Exception {
        List<Hero> heroesFiltered = heroes.stream().
                filter( hero -> hero.getRole().equals(heroFiltered.getRole()) ||
                        hero.getIsMelee().equals(heroFiltered.getIsMelee()) ||
                        hero.getDateOfCreation().equals(heroFiltered.getDateOfCreation()) ||
                        hero.getSpells().equals(heroFiltered.getSpells()) ||
                        hero.getTalents().equals(heroFiltered.getTalents())).
                collect(Collectors.toList());

        int start = (int)pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), heroesFiltered.size());

        return new PageImpl<>(heroesFiltered.subList(start, end), pageable, heroesFiltered.size());
    }

}
