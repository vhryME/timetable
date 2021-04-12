package com.epolsoft.match.port.out;


import com.epolsoft.match.domain.Map;
import com.epolsoft.match.domain.Match;
import com.epolsoft.match.domain.Region;
import com.epolsoft.match.domain.TypeOfMatch;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;


public interface MatchPort {

    Match findMatchById(Integer id) throws Exception;

    void deleteMatch(Integer id) throws Exception;

    Match saveNewMatch(Match match) throws Exception;

    Match updateMatch(Integer id, Match match) throws Exception;

    List<Match> findAllMatches() throws Exception;

    Page<Match> findPageOfMatch(Pageable pageable) throws Exception;

    Page<Match> findPageOfMatchFiltered(Pageable pageable, MatchFiltered matchFiltered) throws Exception;


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    class MatchFiltered {

        private TypeOfMatch type;

        private LocalDate date;

        private Region region;

        private Double duration;

        private Set<Map> maps;

    }

}
