package com.epolsoft.hero.controller;


import com.epolsoft.hero.domain.ActiveTalent;
import com.epolsoft.hero.domain.Hero;
import com.epolsoft.hero.domain.PassiveTalent;
import com.epolsoft.hero.domain.Talent;
import com.epolsoft.hero.dto.in.*;
import com.epolsoft.hero.dto.out.FullHeroDtoOut;
import com.epolsoft.hero.dto.out.HeroDtoOut;
import com.epolsoft.hero.dto.out.PassiveTalentDtoOut;
import com.epolsoft.hero.dto.out.TalentDtoOut;
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
import java.util.HashSet;
import java.util.List;
import java.util.Set;


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
        Set<TalentDtoOut> talentsWithInheritance = new HashSet<>();

        Hero hero = useCase.getHero(id);

        hero.getTalents().forEach(talent -> {
            if(talent instanceof ActiveTalent){
                talentsWithInheritance.add(talentDtoMapper.activeTalentToActiveTalentDtoOut((ActiveTalent) talent));
            } else if (talent instanceof PassiveTalent) {
                talentsWithInheritance.add(talentDtoMapper.passiveTalentToPassiveTalentDtoOut((PassiveTalent) talent));
            }
        });

        FullHeroDtoOut fullHeroDtoOut = mapper.heroToFullHeroDtoOut(hero);
        fullHeroDtoOut.setTalents(talentsWithInheritance);

        return fullHeroDtoOut;
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public HeroDtoOut saveNewHero(@RequestBody @Valid HeroDtoIn heroDtoIn) {
        Set<Talent> talentsWithInheritance = new HashSet<>();

        heroDtoIn.getTalents().forEach(talentDtoIn ->{
            if(talentDtoIn instanceof ActiveTalentDtoIn){
                talentsWithInheritance.add(talentDtoMapper.activeTalentDtoInToActiveTalent((ActiveTalentDtoIn) talentDtoIn));
            } else if (talentDtoIn instanceof PassiveTalentDtoIn) {
                talentsWithInheritance.add(talentDtoMapper.passiveTalentDtoInToPassiveTalent((PassiveTalentDtoIn) talentDtoIn));
            }
        });

        Hero hero = mapper.heroDtoInToHero(heroDtoIn);
        hero.setTalents(talentsWithInheritance);

        return mapper.heroToHeroDtoOut(useCase.saveNewHero(hero));
    }


    @PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public HeroDtoOut updateHero(@PathVariable("id") Integer id, @RequestBody @Valid HeroDtoIn heroDtoIn) {
        Set<Talent> talentsWithInheritance = new HashSet<>();

        heroDtoIn.getTalents().forEach(talentDtoIn ->{
            if(talentDtoIn instanceof ActiveTalentDtoIn){
                talentsWithInheritance.add(talentDtoMapper.activeTalentDtoInToActiveTalent((ActiveTalentDtoIn) talentDtoIn));
            } else if (talentDtoIn instanceof PassiveTalentDtoIn) {
                talentsWithInheritance.add(talentDtoMapper.passiveTalentDtoInToPassiveTalent((PassiveTalentDtoIn) talentDtoIn));
            }
        });

        Hero heroForUpdate = mapper.heroDtoInToHero(heroDtoIn);
        heroForUpdate.setTalents(talentsWithInheritance);

        Hero hero = useCase.updateHero(id, heroForUpdate);

        return mapper.heroToHeroDtoOut(hero);
    }


    @GetMapping
    public List<HeroDtoOut> getAllHeroes() {
        List<HeroDtoOut> heroes = new ArrayList<>();

        useCase.findAllHeroes().forEach(match -> heroes.add(mapper.heroToHeroDtoOut(match)));

        return heroes;
    }


    @PostMapping("search")
    public Page<HeroDtoOut> getHeroPage(Pageable pageable, @RequestBody(required = false) HeroDtoInFiltered heroDtoInFiltered) {
        HeroPort.HeroFiltered heroFiltered = mapper.heroDtoInFilteredToHeroFiltered(heroDtoInFiltered);

        return mapper.pageToPageOut(useCase.findPageOfHero(pageable, heroFiltered));
    }

}