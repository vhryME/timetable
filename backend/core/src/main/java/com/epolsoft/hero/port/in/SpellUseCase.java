package com.epolsoft.hero.port.in;


import com.epolsoft.hero.domain.Spell;

import java.util.List;


public interface SpellUseCase {

    void deleteSpell(Long id);


    Spell updateSpell(Long id, Spell spell);


    List<Spell> findAllSpells();

}