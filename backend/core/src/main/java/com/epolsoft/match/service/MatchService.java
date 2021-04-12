package com.epolsoft.match.service;


import com.epolsoft.match.domain.Match;
import com.epolsoft.match.port.in.MatchUseCase;
import com.epolsoft.match.port.out.MatchPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class MatchService implements MatchUseCase {

    private final MatchPort port;


    @Override
    public Match getMatch(Integer id) {
        Match match = new Match();

        try {
            match = port.findMatchById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return match;
    }


    @Override
    public void deleteMatch(Integer id) {
        try {
            port.deleteMatch(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
    public Match updateMatch(Integer id, Match match) {
        Match matchUpdated = null;

        try {
            matchUpdated = port.updateMatch(id, match);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return matchUpdated;
    }


    @Override
    public List<Match> findAll() {
        List<Match> matches = new ArrayList<>();

        try {
            matches = port.findAllMatches();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return matches;
    }


    @Override
    public Page<Match> findPageOfMatch(Pageable pageable) {
        Page<Match> matchPage = null;

        try {
            matchPage = port.findPageOfMatch(pageable);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return matchPage;
    }


    @Override
    public Page<Match> findPageOfMatchFiltered(Pageable pageable, MatchPort.MatchFiltered matchFiltered) {
        Page<Match> matchPage = null;

        try {
            matchPage = port.findPageOfMatchFiltered(pageable, matchFiltered);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return matchPage;
    }

}
