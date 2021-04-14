package com.epolsoft.match.controller;


import com.epolsoft.match.domain.Match;
import com.epolsoft.match.dto.in.MatchDtoIn;
import com.epolsoft.match.dto.in.MatchDtoInFiltered;
import com.epolsoft.match.dto.out.MatchDtoOut;
import com.epolsoft.match.mapper.MatchDtoMapper;
import com.epolsoft.match.port.in.MatchUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


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


    @GetMapping
    public Object getMatchPage(Pageable pageable, @RequestBody(required = false) MatchDtoInFiltered matchFiltered) {
        return useCase.findPageOfMatch(pageable, mapper.matchDtoInFilteredToMatchFiltered(matchFiltered));
    }

}