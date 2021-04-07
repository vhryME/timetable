package com.epolsoft.port.in.match;


import com.epolsoft.domain.match.Match;

import java.util.List;


public interface MatchUseCase {

    Match getMatch(Long id);

    void deleteMatch(Long id);

    Match saveNewMatch(Match match);

    Match updateMatch(Long id);

    List<Match> findAll();

    Match findAllPages();

}
