package com.epolsoft.match.specification;


import com.epolsoft.match.jpa.MapJpa;
import com.epolsoft.match.jpa.MatchJpa;
import com.epolsoft.match.jpa.RegionJpa;
import com.epolsoft.match.jpa.TypeOfMatchJpa;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.util.Set;


public class MatchSpecification {

    public static Specification<MatchJpa> findByType(TypeOfMatchJpa type) {
        return (root, criteriaQuery, criteriaBuilder) -> type == null ? null : criteriaBuilder.equal(root.get("type"), type);
    }


    public static Specification<MatchJpa> findByDate(LocalDate date) {
        return (root, criteriaQuery, criteriaBuilder) -> date == null ? null : criteriaBuilder.equal(root.get("date"), date);
    }


    public static Specification<MatchJpa> findByRegion(RegionJpa region) {
        return (root, criteriaQuery, criteriaBuilder) -> region == null ? null : criteriaBuilder.equal(root.get("region"), region);
    }


    public static Specification<MatchJpa> findByDuration(Double duration) {
        return (root, criteriaQuery, criteriaBuilder) -> duration == null ? null : criteriaBuilder.equal(root.get("duration"), duration);
    }


    public static Specification<MatchJpa> findByMaps(Set<MapJpa> maps) {
        return (root, criteriaQuery, criteriaBuilder) -> maps == null ? null : criteriaBuilder.equal(root.get("maps"), maps);
    }

}