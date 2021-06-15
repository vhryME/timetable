package com.epolsoft.match.service;


import com.epolsoft.match.domain.Match;
import com.epolsoft.match.port.in.MatchUseCase;
import com.epolsoft.match.port.out.MatchPort;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
class MatchService implements MatchUseCase {

    private final MatchPort port;


    @Override
    @SneakyThrows
    public Match find(Long id) {
        return port.find(id);
    }


    @Override
    @SneakyThrows
    public void delete(Long id) {
        port.delete(id);
    }


    @Override
    @SneakyThrows
    public Match create(Match match) {
        return port.create(match);
    }


    @Override
    @SneakyThrows
    public Match update(Long id, Match match) {
        return port.update(id, match);
    }


    @Override
    @SneakyThrows
    public List<Match> findAll() {
        return port.findAll();
    }


    @Override
    @SneakyThrows
    public Page<Match> findPageOfMatch(Pageable pageable, MatchPort.MatchFiltered matchFiltered) {
        Page<Match> matchPage;

        if(matchFiltered != null) {
            matchPage = port.findPageOfMatchFiltered(pageable, matchFiltered);
        } else {
            matchPage = port.findPageOfMatch(pageable);
        }

        return matchPage;
    }

}
