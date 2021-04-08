package com.epolsoft.match.service;


import com.epolsoft.match.domain.Match;
import com.epolsoft.match.port.in.MatchUseCase;
import com.epolsoft.match.port.out.MatchQueryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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
    public Page<Match> findPageOfMatch() {
        return null;
    }

}
