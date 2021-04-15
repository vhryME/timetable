package com.epolsoft.hero.port.out;


import com.epolsoft.hero.domain.Hero;
import com.epolsoft.hero.domain.Role;
import com.epolsoft.hero.domain.Spell;
import com.epolsoft.hero.domain.Talent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface HeroPort {

    Hero findHeroById(Integer id) throws Exception;

    void deleteHero(Integer id) throws Exception;

    Hero saveNewHero(Hero hero) throws Exception;

    Hero updateHero(Integer id, Hero hero) throws Exception;

    List<Hero> findAllHeroes() throws Exception;

    Page<Hero> findPageOfHero(Pageable pageable) throws Exception;

    Page<Hero> findPageOfHeroFiltered(Pageable pageable, HeroFiltered heroFiltered) throws Exception;


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    class HeroFiltered {

        private Role role;

        private Boolean isMelee;

        private LocalDate dateOfCreation;

        private Set<Spell> spells;

        private Set<Talent> talents;

    }

}