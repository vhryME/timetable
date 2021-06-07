package com.epolsoft.hero.adapter;


import com.epolsoft.hero.domain.Spell;
import com.epolsoft.hero.domain.SpellJpa;
import com.epolsoft.hero.mapper.SpellJpaMapper;
import com.epolsoft.hero.port.out.SpellPort;
import com.epolsoft.hero.repository.SpellRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
@RequiredArgsConstructor
public class SpellAdapter implements SpellPort {

    private final SpellRepository repository;

    private final SpellJpaMapper mapper;


    @Override
    public void deleteSpell(Long id) {
        repository.deleteById(id);
    }


    @Override
    public Spell updateSpell(Long id, Spell spell) {
        SpellJpa spellJpa = mapper.entityToJpaEntity(spell);

        if(repository.existsById(id)) {
            return mapper.jpaEntityToEntity(repository.save(spellJpa));
        }

        return null;
    }


    @Override
    public List<Spell> getAllSpells() {
        return repository.findAll().stream().map(mapper::jpaEntityToEntity).collect(Collectors.toList());
    }

}
