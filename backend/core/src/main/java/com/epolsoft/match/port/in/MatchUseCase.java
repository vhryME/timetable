package com.epolsoft.match.port.in;


import com.epolsoft.match.domain.Match;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface MatchUseCase {

    void init();

    Match getMatch(Long id);

    void deleteMatch(Long id);

    Match saveNewMatch(Match match);

    Match updateMatch(Long id);

    List<Match> findAll();

    Page<Match> findPageOfMatch(Pageable pageable);
}
