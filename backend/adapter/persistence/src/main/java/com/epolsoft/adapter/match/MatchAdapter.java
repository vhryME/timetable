package com.epolsoft.adapter.match;


import com.epolsoft.domain.match.Match;
import com.epolsoft.dto.match.MatchJpa;
import com.epolsoft.mapper.match.MatchMapper;
import com.epolsoft.port.out.match.MatchQueryPort;
import com.epolsoft.repo.match.MatchRepo;
import lombok.RequiredArgsConstructor;
import org.hibernate.criterion.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
@RequiredArgsConstructor
public class MatchAdapter implements MatchQueryPort {

    private final MatchMapper mapper;
    private final MatchRepo repo;


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
        MatchJpa matchJpa = repo.save(mapper.matchToMatchJpa(match));

        return mapper.matchJpaToMatch(matchJpa);
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
    public org.springframework.data.domain.Page<Match> findPageOfMatch(MatchFiltered matchFiltered, org.springframework.data.domain.Pageable pageable) throws Exception {
        return null;
    }

}
