package com.epolsoft.match.adapter;


import com.epolsoft.match.domain.Match;
import com.epolsoft.match.dto.*;
import com.epolsoft.match.mapper.MatchMapper;
import com.epolsoft.match.port.out.MatchQueryPort;
import com.epolsoft.match.repo.MatchRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;


@Component
@RequiredArgsConstructor
public class MatchAdapter implements MatchQueryPort {

    private final MatchMapper mapper;
    private final MatchRepo repo;


    @Override
    public void init() {
        MatchJpa matchJpa1 = new MatchJpa(1L, TypeOfMatchJpa.QuickMatch, LocalDate.now(), 600.0,
                new HashSet<MapJpa>(Collections.singleton(MapJpa.AlteracPass)), RegionJpa.EU, new HashSet<TeamJpa>(Collections.singleton(null)));
        MatchJpa matchJpa2 = new MatchJpa(2L, TypeOfMatchJpa.HeroLeague, LocalDate.now(), 15.364,
                new HashSet<MapJpa>(Collections.singleton(MapJpa.BraxisOutpost)), RegionJpa.CN, new HashSet<TeamJpa>(Collections.singleton(null)));
        MatchJpa matchJpa3 = new MatchJpa(3L, TypeOfMatchJpa.Brawl, LocalDate.now(), 0.3654,
                new HashSet<MapJpa>(Collections.singleton(MapJpa.DragonShire)), RegionJpa.NA, new HashSet<TeamJpa>(Collections.singleton(null)));
        MatchJpa matchJpa4 = new MatchJpa(4L, TypeOfMatchJpa.Unknown, LocalDate.now(), 9856.99,
                new HashSet<MapJpa>(Collections.singleton(MapJpa.Unknown)), RegionJpa.Unknown, new HashSet<TeamJpa>(Collections.singleton(null)));

        repo.save(matchJpa1);
        repo.save(matchJpa2);
        repo.save(matchJpa3);
        repo.save(matchJpa4);
    }


    @Override
    public Match findMatchById(Long id) throws Exception {
        Optional<MatchJpa> match = Optional.of(repo.getOne(id));

        return mapper.matchJpaToMatch(
                match.orElseThrow(
                        () -> new Exception(String.format("Match with id = {%s} is not found", id))));
    }


    @Override
    public void deleteMatch(Long id) throws Exception {
        Optional<MatchJpa> match = Optional.of(repo.getOne(id));

        match.orElseThrow(
                () -> new Exception(String.format("Match with id = {%s} is not found", id)));

        repo.deleteById(id);
    }


    @Override
    public Match saveNewMatch(Match match) throws Exception {
        Optional<MatchJpa> matchJpa = Optional.of(repo.save(mapper.matchToMatchJpa(match)));

        matchJpa.orElseThrow(
                () -> new Exception("Saving of new match was rejected"));

        return mapper.matchJpaToMatch(matchJpa.get());
    }


    @Override
    public Match updateMatch(Long id, Match match) throws Exception {
        Optional<MatchJpa> matchToUpdate = Optional.of(repo.getOne(id));

        matchToUpdate.orElseThrow(
                () -> new Exception(String.format("Match with id = {%s} is not found", id)));

        MatchJpa matchFromDB = repo.save(mapper.matchToMatchJpa(match));

        return mapper.matchJpaToMatch(matchFromDB);
    }


    @Override
    public List<Match> findAll() throws Exception {
        Optional<List<MatchJpa>> matchesJpa = Optional.of(repo.findAll());

        matchesJpa.orElseThrow(
                () -> new Exception("List of Matches from DB is null"));

        List<Match> matches = new ArrayList<>();

        for (MatchJpa matchJpa : matchesJpa.get()) {
            matches.add(mapper.matchJpaToMatch(matchJpa));
        }

        return matches;
    }


    @Override
    public Page<Match> findAllPages(Pageable pageable) {
        Page<MatchJpa> matchesJpaPage = repo.findAll(pageable);

        Page<Match> matchesPage = matchesJpaPage.map(new Function<MatchJpa, Match>() {
            @Override
            public Match apply(MatchJpa matchJpa) {
                return mapper.matchJpaToMatch(matchJpa);
            }
        });

        //Page<Match> matchesPage = repo.findAll(pageable).map(MatchMapper.INSTANCE::matchJpaToMatch);

        return matchesPage;
    }

}
