package com.epolsoft.hero.specification;


import com.epolsoft.hero.domain.HeroJpa;
import com.epolsoft.hero.domain.Spell;
import com.epolsoft.hero.domain.Talent;
import com.epolsoft.hero.port.out.HeroPort;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class HeroSpecification {

    public static Specification<HeroJpa> filter (HeroPort.HeroFiltered heroFiltered) {
        return (Specification<HeroJpa>) (root, criteriaQuery, criteriaBuilder) -> {
            if(heroFiltered != null) {
                List<Predicate> predicates = new ArrayList<>();

                if(heroFiltered.getName() != null) {
                    predicates.add(filterByName(heroFiltered.getName()).toPredicate(root, criteriaQuery, criteriaBuilder));
                }

                if(heroFiltered.getRoleId() != null) {
                    predicates.add(filterByRoleId(heroFiltered.getRoleId()).toPredicate(root, criteriaQuery, criteriaBuilder));
                }

                if(heroFiltered.getIsMelee() != null) {
                    predicates.add(filterByIsMelee(heroFiltered.getIsMelee()).toPredicate(root, criteriaQuery, criteriaBuilder));
                }

                if(heroFiltered.getDateOfCreation() != null) {
                    predicates.add(filterByDateOfCreation(heroFiltered.getDateOfCreation()).toPredicate(root, criteriaQuery, criteriaBuilder));
                }

                if(heroFiltered.getSpells() != null) {
                    predicates.add(filterBySpells(heroFiltered.getSpells()).toPredicate(root, criteriaQuery, criteriaBuilder));
                }

                if(heroFiltered.getTalents() != null) {
                    predicates.add(filterByTalents(heroFiltered.getTalents()).toPredicate(root, criteriaQuery, criteriaBuilder));
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            }

            return null;
        };
    }


    public static Specification<HeroJpa> filterByName (String name) {
        return (Specification<HeroJpa>) (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.like(root.get("name"), name + "%");
    }


    public static Specification<HeroJpa> filterByRoleId (Integer roleId) {
        return (Specification<HeroJpa>) (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("role"), roleId);

    }


    public static Specification<HeroJpa> filterByIsMelee (Boolean isMelee) {
        return (Specification<HeroJpa>) (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("isMelee"), isMelee);

    }


    public static Specification<HeroJpa> filterByDateOfCreation (LocalDate dateOfCreation) {
        return (Specification<HeroJpa>) (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("dateOfCreation"), dateOfCreation);

    }


    public static Specification<HeroJpa> filterBySpells (Set<Spell> spells) {
        return (Specification<HeroJpa>) (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("spells"), spells);

    }


    public static Specification<HeroJpa> filterByTalents (Set<Talent> talents) {
        return (Specification<HeroJpa>) (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("talents"), talents);

    }

}