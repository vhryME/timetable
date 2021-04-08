package com.epolsoft.match.specification;

import com.epolsoft.match.domain.Region;
import com.epolsoft.match.domain.TypeOfMatch;
import com.epolsoft.match.dto.MatchJpa;
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
