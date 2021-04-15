package com.epolsoft.match.adapter;


import com.epolsoft.match.domain.*;
import com.epolsoft.match.domain.Map;
import com.epolsoft.match.jpa.*;
import com.epolsoft.match.mapper.MatchMapper;
import com.epolsoft.match.port.out.MatchPort;
import com.epolsoft.match.repo.MatchRepo;
import com.epolsoft.match.specification.MatchSpecification;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


@Component
@RequiredArgsConstructor
public class MatchAdapter implements MatchPort {

    private final MatchMapper mapper;
    private final MatchRepo repo;

    private List<Match> matches;


    @PostConstruct
    public void init() {
        matches = new ArrayList<>();

        Match match1 = new Match(1, TypeOfMatch.QuickMatch, LocalDate.now(), 600.0,
                new HashSet<>(Collections.singleton(Map.AlteracPass)), Region.EU, new HashSet<>(Collections.singleton(null)));
        Match match2 = new Match(2, TypeOfMatch.HeroLeague, LocalDate.now(), 15.364,
                new HashSet<>(Collections.singleton(Map.BraxisOutpost)), Region.CN, new HashSet<>(Collections.singleton(null)));
        Match match3 = new Match(3, TypeOfMatch.Brawl, LocalDate.now(), 0.3654,
                new HashSet<>(Collections.singleton(Map.DragonShire)), Region.NA, new HashSet<>(Collections.singleton(null)));
        Match match4 = new Match(4, TypeOfMatch.Unknown, LocalDate.now(), 9856.99,
                new HashSet<>(Collections.singleton(Map.Unknown)), Region.Unknown, new HashSet<>(Collections.singleton(null)));

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
        List<Match> matchesFiltered = matches.stream().
                filter( match -> match.getType().equals(matchFiltered.getType()) ||
                        match.getDate().equals(matchFiltered.getDate()) ||
                        match.getRegion().equals(matchFiltered.getRegion()) ||
                        match.getMaps().equals(matchFiltered.getMaps())).
                collect(Collectors.toList());


        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), matchesFiltered.size());

        return new PageImpl<>(matchesFiltered.subList(start, end), pageable, matchesFiltered.size());
    }

}