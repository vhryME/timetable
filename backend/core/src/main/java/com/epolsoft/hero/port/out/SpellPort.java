package com.epolsoft.hero.port.out;


import com.epolsoft.hero.domain.Spell;

import java.util.List;


public interface SpellPort {

    void deleteSpell(Long id);

    Spell updateSpell(Long id, Spell spell);

    List<Spell> getAllSpells();

}
