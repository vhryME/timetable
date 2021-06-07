package com.epolsoft.match.adapter;


import com.epolsoft.match.domain.*;
import com.epolsoft.match.domain.Map;
import com.epolsoft.match.port.out.MatchPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


@Component
@RequiredArgsConstructor
class MatchAdapter implements MatchPort {

    private List<Match> matches;


    @PostConstruct
    public void init() {
        matches = new ArrayList<>();

        Match match1 = new Match(1, TypeOfMatch.getTypeOfMatchById(1L), LocalDate.now(), 600.0,
                Map.getMapById(1L), Region.getRegionById(1L), new Team(), new Team());
        Match match2 = new Match(2, TypeOfMatch.getTypeOfMatchById(3L), LocalDate.now(), 15.364,
                Map.getMapById(4L), Region.getRegionById(3L), new Team(), new Team());
        Match match3 = new Match(3, TypeOfMatch.getTypeOfMatchById(5L), LocalDate.now(), 0.3654,
                Map.getMapById(6L), Region.getRegionById(4L), new Team(), new Team());
        Match match4 = new Match(4, TypeOfMatch.getTypeOfMatchById(0L), LocalDate.now(), 9856.99,
                Map.getMapById(0L), Region.getRegionById(0L), new Team(), new Team());

        matches.add(match1);
        matches.add(match2);
        matches.add(match3);
        matches.add(match4);
    }


    @Override
    public Match findMatchById(Integer id) throws Exception {
        return matches.get(id);
    }


    @Override
    public void deleteMatch(Integer id) throws Exception {
        matches.remove(id);
    }


    @Override
    public Match saveNewMatch(Match match) {
        matches.add(match);

        int index = matches.indexOf(match);

        if(index >= 0) {
            match.setId(index);
            return matches.get(index);
        }

        return null;
    }


    @Override
    public Match updateMatch(Integer id, Match match) throws Exception {
        if(matches.get(id) != null) {
            match.setId(id);
            matches.set(id, match);
        }

        int index = matches.indexOf(match);

        if(index >= 0) {
            return matches.get(index);
        }

        return null;
    }


    @Override
    public List<Match> findAllMatches() throws Exception {
        return matches;
    }


    @Override
    public Page<Match> findPageOfMatch(Pageable pageable) throws Exception {
        int start = (int)pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), matches.size());

        return new PageImpl<>(matches.subList(start, end), pageable, matches.size());
    }


    @Override
    public Page<Match> findPageOfMatchFiltered(Pageable pageable, MatchFiltered matchFiltered) throws Exception {
        List<Match> matchesFiltered = matches;

        if(matchFiltered.getType() != null && !matchFiltered.getType().equals("")) {
            matchesFiltered = matchesFiltered.stream().filter(match -> match.getType().getTypeOfMatch().contains(matchFiltered.getType())).
                    collect(Collectors.toList());
        }

        if(matchFiltered.getDate() != null) {
            matchesFiltered = matchesFiltered.stream().filter(match -> match.getDate().equals(matchFiltered.getDate())).
                    collect(Collectors.toList());
        }

        if(matchFiltered.getDuration() != null) {
            matchesFiltered = matchesFiltered.stream().filter(match -> match.getDuration().equals(matchFiltered.getDuration())).
                    collect(Collectors.toList());
        }

        if(matchFiltered.getMap() != null) {
            matchesFiltered = matchesFiltered.stream().filter(match -> match.getMap().getMap().contains(matchFiltered.getMap().getMap()))
                    .collect(Collectors.toList());
        }

        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), matchesFiltered.size());

        return new PageImpl<>(matchesFiltered.subList(start, end), pageable, matchesFiltered.size());
    }

}