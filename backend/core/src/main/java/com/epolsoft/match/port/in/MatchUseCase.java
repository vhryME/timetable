package com.epolsoft.match.port.in;


import com.epolsoft.match.domain.Match;
import com.epolsoft.match.port.out.MatchPort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface MatchUseCase {

    Match getMatch(Integer id);

    void deleteMatch(Integer id);

    Match saveNewMatch(Match match);

    Match updateMatch(Integer id, Match match);

    List<Match> findAll();

    Page<Match> findPageOfMatch(Pageable pageable);

    Page<Match> findPageOfMatchFiltered(Pageable pageable, MatchPort.MatchFiltered matchFiltered);

}
