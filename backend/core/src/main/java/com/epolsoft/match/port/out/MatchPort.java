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

    Match find(Long id) throws Exception;

    void delete(Long id) throws Exception;

    Match create(Match match) throws Exception;

    Match update(Long id, Match match) throws Exception;

    List<Match> findAll() throws Exception;

    Page<Match> findPageOfMatch(Pageable pageable) throws Exception;

    Page<Match> findPageOfMatchFiltered(Pageable pageable, MatchFiltered matchFiltered) throws Exception;


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    class MatchFiltered {

        private String type;

        private LocalDate date;

        private String region;

        private Double duration;

        private String map;

    }

}
