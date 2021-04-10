package com.epolsoft.match.controller;

import com.epolsoft.match.domain.Match;
import com.epolsoft.match.port.in.MatchUseCase;
import com.epolsoft.match.port.out.MatchQueryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/match")
@RequiredArgsConstructor
public class MatchController {

    private final MatchUseCase useCase;


    @GetMapping("/init")
    public void init() {
        useCase.init();
    }


    @DeleteMapping("/delete/{id}")
    public void deleteMatch(@PathVariable("id") Long id) {
        useCase.deleteMatch(id);
    }


    @GetMapping("/get/{id}")
    public Match getMatch(@PathVariable("id") Long id) {
        return useCase.getMatch(id);
    }


    @PostMapping(value = "/new", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Match saveNewMatch(@RequestBody Match match) {
        return useCase.saveNewMatch(match);
    }


    @PutMapping(value = "/edit/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Match updateMatch(@PathVariable("id") Long id, @RequestBody Match match) {
        return useCase.updateMatch(id, match);
    }


    @GetMapping("/all")
    public List<Match> getAllMatches() {
        return useCase.findAll();
    }


    @GetMapping("/get_pages")
    public Page<Match> getPages(Pageable page) {
        return useCase.findPageOfMatch(page);
    }


    @GetMapping("/get_filtered_pages")
    public Page<Match> getFilteredPages(Pageable pageable ,MatchQueryPort.MatchFiltered matchFiltered) {
        return useCase.findPageOfMatchFiltered(pageable, matchFiltered);
    }

}
