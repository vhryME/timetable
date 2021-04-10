package com.epolsoft.match.port.in;


import com.epolsoft.match.domain.Match;
import com.epolsoft.match.port.out.MatchQueryPort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface MatchUseCase {

    void init();

    Match getMatch(Long id);

    void deleteMatch(Long id);

    Match saveNewMatch(Match match);

    Match updateMatch(Long id, Match match);

    List<Match> findAll();

    Page<Match> findPageOfMatch(Pageable pageable);

    Page<Match> findPageOfMatchFiltered(Pageable pageable, MatchQueryPort.MatchFiltered matchFiltered);

}
