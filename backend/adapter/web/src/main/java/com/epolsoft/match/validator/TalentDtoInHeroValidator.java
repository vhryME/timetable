package com.epolsoft.match.validator;


import com.epolsoft.hero.dto.in.HeroDtoIn;
import com.epolsoft.hero.dto.in.TalentDtoIn;
import com.google.common.collect.Ordering;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.*;
import java.util.stream.Collectors;


public class TalentDtoInHeroValidator implements ConstraintValidator<TalentConstraint, HeroDtoIn> {

    @Override
    public void initialize(TalentConstraint constraintAnnotation) {}


    @Override
    public boolean isValid(HeroDtoIn hero, ConstraintValidatorContext context) {
        return hero != null && hero.getTalents().size() != 0 && areTalentsConsistently(hero.getTalents()) &&
                areLevelsOfAccessUnique(hero.getTalents());
    }


    private boolean areTalentsConsistently(Set<TalentDtoIn> talents) {
        List<Integer> talentsLevelsSorted = talents.stream().map(TalentDtoIn::getLevelOfAccess).sorted().
                collect(Collectors.toList());

        return Ordering.natural().isOrdered(talentsLevelsSorted);
    }


    private boolean areLevelsOfAccessUnique(Set<TalentDtoIn> talents) {
        List<Integer> levelsList = new ArrayList<>();

        talents.forEach(talent -> levelsList.add(talent.getLevelOfAccess()));

        Set<Integer> levelsSet = new HashSet<>(levelsList);

        return levelsList.size() == levelsSet.size();
    }
}
