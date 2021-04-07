package com.epolsoft.port.out.match;


import com.epolsoft.domain.match.Match;
import com.epolsoft.domain.match.Region;
import com.epolsoft.domain.match.TypeOfMatch;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface MatchQueryPort {

    Match findMatchById(Long id) throws Exception;

    void deleteMatch(Long id) throws Exception;

    Match saveNewMatch(Match match) throws Exception;

    Match updateMatch(Long id, Match match) throws Exception;

    Page<Match> findPageOfMatch(MatchFiltered matchFiltered, Pageable pageable) throws Exception;

    List<Match> findAll() throws Exception;


    @Data
    class MatchFiltered {

        private Long id;

        private TypeOfMatch type;

        private Region region;

    }

}
