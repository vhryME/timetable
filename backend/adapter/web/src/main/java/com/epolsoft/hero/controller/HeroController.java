package com.epolsoft.hero.controller;


import com.epolsoft.hero.domain.Hero;
import com.epolsoft.hero.dto.in.HeroDtoIn;
import com.epolsoft.hero.dto.in.HeroDtoInFiltered;
import com.epolsoft.hero.dto.out.FullHeroDtoOut;
import com.epolsoft.hero.dto.out.HeroDtoOut;
import com.epolsoft.hero.mapper.HeroDtoMapper;
import com.epolsoft.hero.mapper.TalentDtoMapper;
import com.epolsoft.hero.port.in.HeroUseCase;
import com.epolsoft.hero.port.out.HeroPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/hero")
@RequiredArgsConstructor
class HeroController {

    private final HeroUseCase useCase;
    private final HeroDtoMapper mapper;
    private final TalentDtoMapper talentDtoMapper;


    @DeleteMapping("{id}")
    public void deleteHero(@PathVariable("id") Integer id) {
        useCase.deleteHero(id);
    }


    @GetMapping("{id}")
    public FullHeroDtoOut getHero(@PathVariable("id") Integer id) {
        Hero hero = useCase.getHero(id);

        FullHeroDtoOut fullHeroDtoOut = mapper.heroToFullHeroDtoOut(hero);
        fullHeroDtoOut.setTalents(talentDtoMapper.talentToTalentDtoOutWithInheritance(hero.getTalents()));

        return fullHeroDtoOut;
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public HeroDtoOut saveNewHero(@RequestBody @Valid HeroDtoIn heroDtoIn) {
        Hero hero = mapper.inToEntity(heroDtoIn);
        hero.setTalents(talentDtoMapper.talentDtoInToTalentWithInheritance(heroDtoIn.getTalents()));

        return mapper.entityToOut(useCase.saveNewHero(hero));
    }


    @PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public HeroDtoOut updateHero(@PathVariable("id") Integer id, @RequestBody @Valid HeroDtoIn heroDtoIn) {
        Hero heroForUpdate = mapper.inToEntity(heroDtoIn);
        heroForUpdate.setTalents(talentDtoMapper.talentDtoInToTalentWithInheritance(heroDtoIn.getTalents()));

        Hero hero = useCase.updateHero(id, heroForUpdate);

        return mapper.entityToOut(hero);
    }


    @GetMapping
    public List<HeroDtoOut> getAllHeroes() {
        return mapper.entitiesToOutList(useCase.findAllHeroes());
    }


    @PostMapping("search")
    public Page<HeroDtoOut> getHeroPage(Pageable pageable, @RequestBody(required = false) HeroDtoInFiltered heroDtoInFiltered) {
        HeroPort.HeroFiltered heroFiltered = mapper.heroDtoInFilteredToHeroFiltered(heroDtoInFiltered);

        return mapper.pageToPageOut(useCase.findPageOfHero(pageable, heroFiltered));
    }

}
