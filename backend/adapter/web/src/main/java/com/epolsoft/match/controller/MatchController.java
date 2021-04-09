package com.epolsoft.match.controller;

import com.epolsoft.match.domain.Match;
import com.epolsoft.match.port.in.MatchUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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


    @PostMapping("/new")
    public Match saveNewMatch() {
        return useCase.saveNewMatch(new Match());
    }


    @GetMapping("/get/{id}")
    public Match getMatch(@PathVariable("id") Long id) {
        return useCase.getMatch(id);
    }


    @GetMapping("/all")
    public List<Match> getAllMatches() {
        return useCase.findAll();
    }


    @GetMapping("/get_all_pages/{size}/{num}")
    public Page<Match> getAllPages(@PathVariable("size") Integer pageSize, @PathVariable("num") Integer pageNumber) {
        return useCase.findAllPages(pageSize, pageNumber);
    }


    @DeleteMapping("/delete/{id}")
    public void deleteMatch(@PathVariable("id") Long id) {
        useCase.deleteMatch(id);
    }

}
