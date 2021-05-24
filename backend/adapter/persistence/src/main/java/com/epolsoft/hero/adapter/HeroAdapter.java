package com.epolsoft.hero.adapter;


import com.epolsoft.hero.domain.Hero;
import com.epolsoft.hero.domain.Role;
import com.epolsoft.hero.domain.Spell;
import com.epolsoft.hero.domain.Talent;
import com.epolsoft.hero.port.out.HeroPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


@Component
@RequiredArgsConstructor
class HeroAdapter implements HeroPort {

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
        return heroes.stream().filter(hero -> hero.getId().equals(id)).findFirst().orElse(null);
    }


    @Override
    public void deleteHero(Integer id) throws Exception {
        heroes.removeIf(hero -> hero.getId().equals(id));
    }


    @Override
    public Hero saveNewHero(Hero hero) throws Exception {
        int id = heroes.get(heroes.size() - 1).getId() + 1;

        hero.setId(id);
        heroes.add(hero);

        if(heroes.contains(hero)) {
            return heroes.get(heroes.size() - 1);
        }

        return null;
    }


    @Override
    public Hero updateHero(Integer id, Hero hero) throws Exception {

        Hero current = heroes.stream().filter(heroItem -> heroItem.getId().equals(id)).findFirst().orElse(null);

        if(current != null) {
            hero.setId(id);
            heroes.set(heroes.indexOf(current), hero);
        }

        if(heroes.contains(hero)) {
            return heroes.get(heroes.indexOf(hero));
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
        List<Hero> heroesFiltered =  heroes;

        if(heroFiltered.getRole() != null) {
            heroesFiltered = heroesFiltered.stream().filter(hero -> hero.getRole().name().contains(heroFiltered.getRole()))
                    .collect(Collectors.toList());

        }

        if(heroFiltered.getRoleId() != null) {
            heroesFiltered = heroesFiltered.stream().filter(hero -> hero.getRole().id.equals(heroFiltered.getRoleId()))
                    .collect(Collectors.toList());

        }

        if(heroFiltered.getIsMelee() != null) {
            heroesFiltered = heroesFiltered.stream().filter(hero -> hero.getIsMelee().equals(heroFiltered.getIsMelee()))
                    .collect(Collectors.toList());
        }

        if(heroFiltered.getName() != null) {
            heroesFiltered = heroesFiltered.stream().filter(hero -> hero.getName().contains(heroFiltered.getName()))
                    .collect(Collectors.toList());
        }

        if(heroFiltered.getDateOfCreation() != null) {
            heroesFiltered = heroesFiltered.stream().filter(hero ->
                    hero.getDateOfCreation().toString().contains(heroFiltered.getDateOfCreation())).
                    collect(Collectors.toList());
        }

        if(heroFiltered.getSpells() != null) {
            heroesFiltered = getHeroesFilteredBySpells(heroesFiltered, heroFiltered.getSpells());
        }

        if(heroFiltered.getTalents() != null) {
            heroesFiltered = getHeroesFilteredByTalents(heroesFiltered, heroFiltered.getTalents());
        }

        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), heroesFiltered.size());

        return new PageImpl<>(heroesFiltered.subList(start, end), pageable, heroesFiltered.size());
    }


    private List<Hero> getHeroesFilteredBySpells(List<Hero> heroesForFilter, Set<Spell> spells) {
        List<Hero> heroesFilteredWithSpells = new ArrayList<>();

        heroesForFilter.forEach(hero ->
                hero.getSpells().forEach(spell ->
                        spells.forEach(spellPattern -> {
                                    if(spell.equals(spellPattern)) heroesFilteredWithSpells.add(hero);
                                }
                        )));

        return heroesFilteredWithSpells;
    }


    private List<Hero> getHeroesFilteredByTalents(List<Hero> heroesForFilter, Set<Talent> talents) {
        List<Hero> heroesFilteredWithSpells = new ArrayList<>();

        heroesForFilter.forEach(hero ->
                hero.getTalents().forEach(talent ->
                        talents.forEach(talentPattern -> {
                                    if(talent.equals(talentPattern)) heroesFilteredWithSpells.add(hero);
                                }
                        )));

        return heroesFilteredWithSpells;
    }


}
