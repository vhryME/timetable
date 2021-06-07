package com.epolsoft.match.controller;


import com.epolsoft.match.domain.Match;
import com.epolsoft.match.dto.in.MatchDtoIn;
import com.epolsoft.match.dto.in.MatchDtoInFiltered;
import com.epolsoft.match.dto.out.FullMatchDtoOut;
import com.epolsoft.match.dto.out.MatchDtoOut;
import com.epolsoft.match.mapper.MatchDtoMapper;
import com.epolsoft.match.port.in.MatchUseCase;
import com.epolsoft.match.port.out.MatchPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/match")
@RequiredArgsConstructor
class MatchController {

    private final MatchUseCase useCase;
    private final MatchDtoMapper mapper;


    @DeleteMapping("{id}")
    public void deleteMatch(@PathVariable("id") Integer id) {
        useCase.deleteMatch(id);
    }


    @GetMapping("{id}")
    public FullMatchDtoOut getMatch(@PathVariable("id") Integer id) {
        return mapper.matchToFullMatchDtoOut(useCase.getMatch(id));
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public MatchDtoOut saveNewMatch(@RequestBody @Valid MatchDtoIn matchDtoIn) {
        Match match = mapper.matchDtoInToMatch(matchDtoIn);

        return mapper.matchToMatchDtoOut(useCase.saveNewMatch(match));
    }


    @PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public MatchDtoOut updateMatch(@PathVariable("id") Integer id, @RequestBody @Valid MatchDtoIn matchDtoIn) {
        Match match = useCase.updateMatch(id, mapper.matchDtoInToMatch(matchDtoIn));

        return mapper.matchToMatchDtoOut(match);
    }


    @GetMapping
    public List<MatchDtoOut> getAllMatches() {
        return mapper.matchesToMatchesDtoOut(useCase.findAllMatches());
    }


    @PostMapping("/search")
    public Page<MatchDtoOut> getMatchPage(Pageable pageable, @RequestBody(required = false) MatchDtoInFiltered matchFilteredIn) {
        MatchPort.MatchFiltered matchFiltered = mapper.matchDtoInFilteredToMatchFiltered(matchFilteredIn);

        return mapper.pageToPageOut(useCase.findPageOfMatch(pageable, matchFiltered));
    }

}