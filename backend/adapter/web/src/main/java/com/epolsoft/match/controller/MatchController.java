package com.epolsoft.match.controller;


import com.epolsoft.match.domain.Match;
import com.epolsoft.match.dto.in.MatchDtoIn;
import com.epolsoft.match.dto.out.MatchDtoOut;
import com.epolsoft.match.mapper.MatchDtoMapper;
import com.epolsoft.match.port.in.MatchUseCase;
import com.epolsoft.match.port.out.MatchPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/match")
@RequiredArgsConstructor
public class MatchController {

    private final MatchUseCase useCase;
    private final MatchDtoMapper mapper;


    @DeleteMapping("{id}")
    public void deleteMatch(@PathVariable("id") Integer id) {
        useCase.deleteMatch(id);
    }


    @GetMapping("{id}")
    public MatchDtoOut getMatch(@PathVariable("id") Integer id) {
        return mapper.matchToMatchDtoOut(useCase.getMatch(id));
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public MatchDtoOut saveNewMatch(@RequestBody MatchDtoIn matchDtoIn) {
        Match match = mapper.matchDtoInToMatch(matchDtoIn);

        return mapper.matchToMatchDtoOut(useCase.saveNewMatch(match));
    }


    @PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public MatchDtoOut updateMatch(@PathVariable("id") Integer id, @RequestBody MatchDtoIn matchDtoIn) {
        Match match = useCase.updateMatch(id, mapper.matchDtoInToMatch(matchDtoIn));

        return mapper.matchToMatchDtoOut(match);
    }


    @GetMapping("/all")
    public List<MatchDtoOut> getAllMatches() {
        List<Match> matches = useCase.findAll();
        List<MatchDtoOut> matchesDtoIn = new ArrayList<>();

        for (Match match : matches) {
            matchesDtoIn.add(mapper.matchToMatchDtoOut(match));
        }

        return matchesDtoIn;
    }


    @GetMapping("/get_page")
    public Page<MatchDtoOut> getHeroPage(Pageable pageable) {
        Page<Match> matchPage = useCase.findPageOfMatch(pageable);

        return matchPage.map(mapper::matchToMatchDtoOut);
    }


    @GetMapping("/get_filtered_page")
    public Page<MatchDtoOut> getHeroPageFiltered(Pageable pageable , MatchPort.MatchFiltered matchFiltered) {
        Page<Match> matchPage = useCase.findPageOfMatchFiltered(pageable, matchFiltered);

        return matchPage.map(mapper::matchToMatchDtoOut);
    }

}