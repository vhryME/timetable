package com.epolsoft.match.service;


import com.epolsoft.match.domain.Match;
import com.epolsoft.match.domain.Region;
import com.epolsoft.match.port.in.MatchUseCase;
import com.epolsoft.match.port.out.MatchPort;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
class MatchService implements MatchUseCase {

    private final MatchPort port;


    @Override
    @SneakyThrows
    public Match getMatch(Integer id) {
        return port.findMatchById(id);
    }


    @Override
    @SneakyThrows
    public void deleteMatch(Integer id) {
        port.deleteMatch(id);
    }


    @Override
    @SneakyThrows
    public Match saveNewMatch(Match match) {
        return port.saveNewMatch(match);
    }


    @Override
    @SneakyThrows
    public Match updateMatch(Integer id, Match match) {
        return port.updateMatch(id, match);
    }


    @Override
    @SneakyThrows
    public List<Match> findAllMatches() {
        return port.findAllMatches();
    }


    @Override
    @SneakyThrows
    public Object findPageOfMatch(Pageable pageable, MatchPort.MatchFiltered matchFiltered) {
        if(!pageable.isPaged()) {
            return port.findAllMatches();
        }

        Page<Match> matchPage;

        if(matchFiltered != null) {
            matchPage = port.findPageOfMatchFiltered(pageable, matchFiltered);
        } else {
            matchPage = port.findPageOfMatch(pageable);
        }

        return matchPage;
    }

}
