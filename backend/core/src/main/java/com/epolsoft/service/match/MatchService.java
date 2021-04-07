package com.epolsoft.service.match;


import com.epolsoft.domain.match.Match;
import com.epolsoft.port.in.match.MatchUseCase;
import com.epolsoft.port.out.match.MatchQueryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class MatchService implements MatchUseCase {

    private final MatchQueryPort port;

    @Override
    public Match getMatch(Long id) {
        Match match = new Match();

        try {
            match = port.findMatchById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return match;
    }

    @Override
    public void deleteMatch(Long id) {

    }

    @Override
    public Match saveNewMatch(Match match) {
        Match matchFromDB = new Match();

        try {
            matchFromDB = port.saveNewMatch(match);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return matchFromDB;
    }

    @Override
    public Match updateMatch(Long id) {
        return null;
    }

    @Override
    public List<Match> findAll() {
        List<Match> matches = new ArrayList<>();

        try {
            matches = port.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return matches;
    }

    @Override
    public Match findAllPages() {
        return null;
    }

}
