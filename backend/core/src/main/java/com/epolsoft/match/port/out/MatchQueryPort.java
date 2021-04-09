package com.epolsoft.match.port.out;


import com.epolsoft.match.domain.Match;
import com.epolsoft.match.domain.Region;
import com.epolsoft.match.domain.TypeOfMatch;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface MatchQueryPort {

    void init();

    Match findMatchById(Long id) throws Exception;

    void deleteMatch(Long id) throws Exception;

    Match saveNewMatch(Match match) throws Exception;

    Match updateMatch(Long id, Match match) throws Exception;

//    Page<Match> findAllPages(MatchFiltered matchFiltered, Pageable pageable) throws Exception;

    Page<Match> findPageOfMatch(Pageable pageable);

    List<Match> findAll() throws Exception;


    @Data
    class MatchFiltered {

        private Long id;

        private TypeOfMatch type;

        private Region region;

    }

}
