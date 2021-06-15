package com.epolsoft.match.port.in;


import com.epolsoft.match.domain.Match;
import com.epolsoft.match.port.out.MatchPort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface MatchUseCase {

    Match find(Long id);

    void delete(Long id);

    Match create(Match match);

    Match update(Long id, Match match);

    List<Match> findAll();

    Page<Match> findPageOfMatch(Pageable pageable, MatchPort.MatchFiltered matchFiltered);

//    Page<Match> findPageOfMatchFiltered(Pageable pageable, MatchPort.MatchFiltered matchFiltered);

}
