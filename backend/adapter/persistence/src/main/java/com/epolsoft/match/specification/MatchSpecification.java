package com.epolsoft.match.specification;


import com.epolsoft.match.dto.MatchJpa;
import com.epolsoft.match.dto.RegionJpa;
import com.epolsoft.match.dto.TypeOfMatchJpa;
import org.springframework.data.jpa.domain.Specification;


public class MatchSpecification {

    public static Specification<MatchJpa> findByType(TypeOfMatchJpa type) {
        return (root, criteriaQuery, criteriaBuilder) -> type == null ? null : criteriaBuilder.equal(root.get("type"), type);
    }


    public static Specification<MatchJpa> findByRegion(RegionJpa region) {
        return (root, criteriaQuery, criteriaBuilder) -> region == null ? null : criteriaBuilder.equal(root.get("region"), region);
    }

}