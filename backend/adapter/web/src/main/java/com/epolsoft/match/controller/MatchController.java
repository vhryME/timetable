package com.epolsoft.match.controller;


import com.epolsoft.match.domain.Map;
import com.epolsoft.match.domain.Match;
import com.epolsoft.match.domain.Region;
import com.epolsoft.match.domain.TypeOfMatch;
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

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


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
    public Object getMatchPage(Pageable pageable , @RequestParam(required = false) String typeOfMatch, @RequestParam(required = false) String date,
                                                 @RequestParam(required = false) String region, @RequestParam(required = false) Double duration, @RequestParam(required = false) Set<String> maps) {
        if(pageable.isUnpaged()) {
            Page<Match> matchPage = null;

            if(typeOfMatch != null && date != null && region != null && duration != null && maps != null) {
                Set<Map> mapsToFiltered = new HashSet<>();

                for (String map : maps) {
                    mapsToFiltered.add(Map.valueOf(map));
                }

                MatchPort.MatchFiltered matchFiltered = new MatchPort.MatchFiltered();

                matchFiltered.setType(TypeOfMatch.valueOf(typeOfMatch));
                matchFiltered.setDate(LocalDate.parse(date));
                matchFiltered.setRegion(Region.valueOf(region));
                matchFiltered.setDuration(duration);
                matchFiltered.setMaps(mapsToFiltered);

                matchPage = useCase.findPageOfMatchFiltered(pageable, matchFiltered);
            } else {
                matchPage = useCase.findPageOfMatch(pageable);
            }

            return matchPage.map(mapper::matchToMatchDtoOut);
        }

        List<Match> matches = useCase.findAll();
        List<MatchDtoOut> matchesDtoIn = new ArrayList<>();

        for (Match match : matches) {
            matchesDtoIn.add(mapper.matchToMatchDtoOut(match));
        }

        return matchesDtoIn;
    }

}