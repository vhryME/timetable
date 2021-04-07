package com.epolsoft.specification.match;

import com.epolsoft.domain.match.Region;
import com.epolsoft.domain.match.TypeOfMatch;
import com.epolsoft.dto.match.MatchJpa;
import org.springframework.data.jpa.domain.Specification;

public class MatchSpecification {

    public static Specification<MatchJpa> findById(Long id) {
        return (((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), id)));
    }


    public static Specification<MatchJpa> findByType(TypeOfMatch type) {
        return (((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("type"), type)));
    }


    public static Specification<MatchJpa> findByRegion(Region region) {
        return (((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("region"), region)));
    }

}
