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

        Match match1 = new Match(1L, TypeOfMatch.QuickMatch, LocalDate.now(), 600.0,
                new HashSet<Map>(Collections.singleton(Map.AlteracPass)), Region.EU, new HashSet<Team>(Collections.singleton(null)));
        Match match2 = new Match(2L, TypeOfMatch.HeroLeague, LocalDate.now(), 15.364,
                new HashSet<Map>(Collections.singleton(Map.BraxisOutpost)), Region.CN, new HashSet<Team>(Collections.singleton(null)));
        Match match3 = new Match(3L, TypeOfMatch.Brawl, LocalDate.now(), 0.3654,
                new HashSet<Map>(Collections.singleton(Map.DragonShire)), Region.NA, new HashSet<Team>(Collections.singleton(null)));
        Match match4 = new Match(4L, TypeOfMatch.Unknown, LocalDate.now(), 9856.99,
                new HashSet<Map>(Collections.singleton(Map.Unknown)), Region.Unknown, new HashSet<Team>(Collections.singleton(null)));

        matches.add(match1);
        matches.add(match2);
        matches.add(match3);
        matches.add(match4);
    }


    @Override
    public Match findMatchById(Integer id) throws Exception {
        return matches.get(Integer.valueOf(id));
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
            return matches.get(index);
        }

        return null;
    }


    @Override
    public Match updateMatch(Integer id, Match match) throws Exception {
        if(matches.get(id) != null) {
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
                filter(match -> match.getType().equals(matchFiltered.getType())).
                filter(match -> match.getDate().equals(matchFiltered.getDate())).
                filter(match -> match.getRegion().equals(matchFiltered.getRegion())).
                filter(match -> match.getDuration().equals(matchFiltered.getDuration())).
                filter(match -> match.getMaps().equals(matchFiltered.getMaps())).
                collect(Collectors.toList());

        int start = (int)pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), matches.size());

        return new PageImpl<>(matchesFiltered.subList(start, end), pageable, matches.size());
    }

    //    @Override
//    public Match findMatchById(Long id) throws Exception {
//        Optional<MatchJpa> match = Optional.of(repo.getOne(id));
//
//        return mapper.matchJpaToMatch(
//                match.orElseThrow(
//                        () -> new Exception(String.format("Match with id = {%s} is not found", id))));
//    }
//
//
//    @Override
//    public void deleteMatch(Long id) throws Exception {
//        Optional<MatchJpa> match = Optional.of(repo.getOne(id));
//
//        match.orElseThrow(
//                () -> new Exception(String.format("Match with id = {%s} is not found", id)));
//
//        repo.deleteById(id);
//    }
//
//
//    @Override
//    public Match saveNewMatch(Match match) throws Exception {
//        Optional<MatchJpa> matchJpa = Optional.of(repo.save(mapper.matchToMatchJpa(match)));
//
//        matchJpa.orElseThrow(
//                () -> new Exception("Saving of new match was rejected"));
//
//        return mapper.matchJpaToMatch(matchJpa.get());
//    }
//
//
//    @Override
//    public Match updateMatch(Long id, Match match) throws Exception {
//        Optional<MatchJpa> matchToUpdate = Optional.of(repo.getOne(id));
//
//        matchToUpdate.orElseThrow(
//                () -> new Exception(String.format("Match with id = {%s} is not found", id)));
//
//        MatchJpa matchFromDB = repo.save(mapper.matchToMatchJpa(match));
//
//        return mapper.matchJpaToMatch(matchFromDB);
//    }
//
//
//    @Override
//    public List<Match> findAllMatches() throws Exception {
//        Optional<List<MatchJpa>> matchesJpa = Optional.of(repo.findAll());
//
//        matchesJpa.orElseThrow(
//                () -> new Exception("List of Matches from DB is null"));
//
//        List<Match> matches = new ArrayList<>();
//
//        for (MatchJpa matchJpa : matchesJpa.get()) {
//            matches.add(mapper.matchJpaToMatch(matchJpa));
//        }
//
//        return matches;
//    }
//
//
//    @Override
//    public Page<Match> findPageOfMatch(Pageable pageable) throws Exception {
//        Optional<Page<MatchJpa>> optionalMatchesJpa = Optional.of(repo.findAll(pageable));
//
//        Page<MatchJpa> matchesJpaPage = optionalMatchesJpa.orElseThrow(
//                () -> new Exception("List of Matches with pageable from DB is null"));
//
//        Page<Match> matchesPage = matchesJpaPage.map(mapper::matchJpaToMatch);
//
//        return matchesPage;
//    }
//
//
//    @Override
//    public Page<Match> findPageOfMatchFiltered(Pageable pageable, MatchFiltered matchFiltered) throws Exception {
//        MatchJpa matchJpa = mapper.matchFilteredToMatchJpa(matchFiltered);
//
//        Specification<MatchJpa> specification = Specification.
//                where(MatchSpecification.findByRegion(matchJpa.getRegion())).
//                and(MatchSpecification.findByType(matchJpa.getType()));
//
//        Optional<Page<MatchJpa>> optionalMatchesJpa = Optional.of(repo.findAll(specification, pageable));
//
//        Page<MatchJpa> matchesJpaPage = optionalMatchesJpa.orElseThrow(
//                () -> new Exception("List of Matches with pageable by criteria from DB is null"));
//
//        Page<Match> matchesPage = matchesJpaPage.map(mapper::matchJpaToMatch);
//
//        return matchesPage;
//    }

}