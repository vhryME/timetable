package com.epolsoft.hero.controller;


import com.epolsoft.hero.domain.Hero;
import com.epolsoft.hero.dto.in.HeroDtoIn;
import com.epolsoft.hero.dto.in.HeroDtoInFiltered;
import com.epolsoft.hero.dto.out.HeroDtoOut;
import com.epolsoft.hero.mapper.HeroDtoMapper;
import com.epolsoft.hero.port.in.HeroUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/hero")
@RequiredArgsConstructor
public class HeroController {

    private final HeroUseCase useCase;
    private final HeroDtoMapper mapper;


    @DeleteMapping("{id}")
    public void deleteHero(@PathVariable("id") Integer id) {
        useCase.deleteHero(id);
    }


    @GetMapping("{id}")
    public HeroDtoOut getHero(@PathVariable("id") Integer id) {
        return mapper.heroToHeroDtoOut(useCase.getHero(id));
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public HeroDtoOut saveNewMatch(@RequestBody @Valid HeroDtoIn heroDtoIn) {
        Hero hero = mapper.heroDtoInToHero(heroDtoIn);

        return mapper.heroToHeroDtoOut(useCase.saveNewHero(hero));
    }


    @PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public HeroDtoOut updateMatch(@PathVariable("id") Integer id, @RequestBody @Valid HeroDtoIn heroDtoIn) {
        Hero hero = useCase.updateHero(id, mapper.heroDtoInToHero(heroDtoIn));

        return mapper.heroToHeroDtoOut(hero);
    }


    @GetMapping
    public Object getMatchPage(Pageable pageable, @RequestParam(required = false) HeroDtoInFiltered heroDtoInFiltered) {
        return useCase.findPageOfHero(pageable, mapper.heroDtoInFilteredToHeroFiltered(heroDtoInFiltered));
    }

}