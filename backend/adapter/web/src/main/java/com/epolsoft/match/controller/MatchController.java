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


    @DeleteMapping("/delete/{id}")
    public void deleteMatch(@PathVariable("id") Integer id) {
        useCase.deleteMatch(id);
    }


    @GetMapping("/get/{id}")
    public MatchDtoIn getMatch(@PathVariable("id") Integer id) {
        return mapper.matchToMatchDtoIn(useCase.getMatch(id));
    }


    @PostMapping(value = "/new", consumes = MediaType.APPLICATION_JSON_VALUE)
    public MatchDtoIn saveNewMatch(@RequestBody MatchDtoOut matchDtoOut) {
        Match match = mapper.matchDtoOutToMatch(matchDtoOut);

        return mapper.matchToMatchDtoIn(useCase.saveNewMatch(match));
    }


    @PutMapping(value = "/edit/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public MatchDtoIn updateMatch(@PathVariable("id") Integer id, @RequestBody MatchDtoOut matchDtoOut) {
        Match match = useCase.updateMatch(id, mapper.matchDtoOutToMatch(matchDtoOut));

        return mapper.matchToMatchDtoIn(match);
    }


    @GetMapping("/all")
    public List<MatchDtoIn> getAllMatches() {
        List<Match> matches = useCase.findAll();
        List<MatchDtoIn> matchesDtoIn = new ArrayList<>();

        for (Match match : matches) {
            matchesDtoIn.add(mapper.matchToMatchDtoIn(match));
        }

        return matchesDtoIn;
    }


    @GetMapping("/get_page")
    public Page<MatchDtoIn> getHeroPage(Pageable pageable) {
        Page<Match> matchPage = useCase.findPageOfMatch(pageable);

        return matchPage.map(mapper::matchToMatchDtoIn);
    }


    @GetMapping("/get_filtered_page")
    public Page<MatchDtoIn> getHeroPageFiltered(Pageable pageable , MatchPort.MatchFiltered matchFiltered) {
        Page<Match> matchPage = useCase.findPageOfMatchFiltered(pageable, matchFiltered);

        return matchPage.map(mapper::matchToMatchDtoIn);
    }

}