package com.epolsoft.hero.adapter;


import com.epolsoft.hero.domain.Hero;
import com.epolsoft.hero.domain.HeroJpa;
import com.epolsoft.hero.domain.Role;
import com.epolsoft.hero.domain.Spell;
import com.epolsoft.hero.mapper.HeroJpaMapper;
import com.epolsoft.hero.mapper.TalentJpaMapper;
import com.epolsoft.hero.port.out.HeroPort;
import com.epolsoft.hero.repository.HeroRepository;
import com.epolsoft.hero.specification.HeroSpecification;
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
import java.util.Set;


@Component
@RequiredArgsConstructor
class HeroAdapter implements HeroPort {

    private List<Hero> heroes;

    private final HeroJpaMapper heroJpaMapper;

    private final HeroRepository heroRepository;

    private final TalentJpaMapper talentJpaMapper;


    @PostConstruct
    public void init() {
        heroes = new ArrayList<>();
        Set<Spell> spells = new HashSet<>();

        Spell spell1 = new Spell(1L, "uuid1", "name1", "description1", "icon1", "key1", 1, 1.1);
        Spell spell2 = new Spell(2L, "uuid2", "name2", "description2", "icon2", "key2", 2, 1.1);
        Spell spell3 = new Spell(3L, "uuid3", "name3", "description3", "icon3", "key3", 3, 1.1);
        Spell spell4 = new Spell(4L, "uuid4", "name4", "description4", "icon4", "key4", 4, 1.1);
        Spell spell5 = new Spell(5L, "uuid5", "name5", "description5", "icon5", "key5", 5, 1.1);

        spells.add(spell1);
        spells.add(spell2);
        spells.add(spell3);
        spells.add(spell4);
        spells.add(spell5);

        Hero hero1 = new Hero(1, "Valira", "icon_valira", Role.getRoleById(1L), false, LocalDate.now(),
                spells, new HashSet<>());
        Hero hero2 = new Hero(2, "Garrosh", "icon_garrosh", Role.getRoleById(2L), true, LocalDate.now(),
                spells, new HashSet<>());
        Hero hero3 = new Hero(3, "Alarak", "icon_alarak", Role.getRoleById(3L), true, LocalDate.now(),
                spells, new HashSet<>());
        Hero hero4 = new Hero(4, "Auriel", "icon_auriel", Role.getRoleById(4L), false, LocalDate.now(),
                spells, new HashSet<>());

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
    public Hero saveNewHero(Hero hero) {
        HeroJpa heroJpa = heroJpaMapper.entityToJpaEntity(hero);
        heroJpa.setTalents(talentJpaMapper.talentToTalentJpaWithInheritance(hero.getTalents()));

        return heroJpaMapper.jpaEntityToEntity(heroRepository.save(heroJpa));
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
        if(heroFiltered != null) {
            return heroRepository.findAll(HeroSpecification.filter(heroFiltered), pageable).
                    map(heroJpaMapper::jpaEntityToEntity);
        }

        return null;
    }

}
