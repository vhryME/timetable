package com.epolsoft.match.specification;


import com.epolsoft.match.domain.MatchJpa;
import com.epolsoft.match.port.out.MatchPort;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class MatchSpecification {

    public static Specification<MatchJpa> filter (MatchPort.MatchFiltered matchFiltered) {
        return (Specification<MatchJpa>) (root, criteriaQuery, criteriaBuilder) -> {
            if(matchFiltered != null) {
                List<Predicate> predicates = new ArrayList<>();

                if(matchFiltered.getType() != null) {
                    predicates.add(filterByType(matchFiltered.getType()).toPredicate(root, criteriaQuery, criteriaBuilder));
                }

                if(matchFiltered.getRegion() != null) {
                    predicates.add(filterByRegion(matchFiltered.getRegion()).toPredicate(root, criteriaQuery, criteriaBuilder));
                }

                if(matchFiltered.getDuration() != null) {
                    predicates.add(filterByDuration(matchFiltered.getDuration()).toPredicate(root, criteriaQuery, criteriaBuilder));
                }

                if(matchFiltered.getDate() != null) {
                    predicates.add(filterByDate(matchFiltered.getDate()).toPredicate(root, criteriaQuery, criteriaBuilder));
                }

                if(matchFiltered.getMap() != null) {
                    predicates.add(filterByMap(matchFiltered.getMap()).toPredicate(root, criteriaQuery, criteriaBuilder));
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            }

            return null;
        };
    }


    public static Specification<MatchJpa> filterByType (String type) {
        return (Specification<MatchJpa>) (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.like(root.get("type"), type + "%");
    }


    public static Specification<MatchJpa> filterByRegion (String region) {
        return (Specification<MatchJpa>) (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("region"), region);

    }


    public static Specification<MatchJpa> filterByDuration (Double duration) {
        return (Specification<MatchJpa>) (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("duration"), duration);

    }


    public static Specification<MatchJpa> filterByDate (LocalDate date) {
        return (Specification<MatchJpa>) (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("date"), date);

    }


    public static Specification<MatchJpa> filterByMap (String map) {
        return (Specification<MatchJpa>) (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("map"), map);

    }
}