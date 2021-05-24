package com.epolsoft.hero.service;


import com.epolsoft.hero.domain.Spell;
import com.epolsoft.hero.port.in.SpellUseCase;
import com.epolsoft.hero.port.out.SpellPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class SpellService implements SpellUseCase {

    private final SpellPort port;


    @Override
    public void deleteSpell(Long id) {
        port.deleteSpell(id);
    }


    @Override
    public Spell updateSpell(Long id, Spell spell) {
        return port.updateSpell(id, spell);
    }


    @Override
    public List<Spell> findAllSpells() {
        return port.getAllSpells();
    }

}