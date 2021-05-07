package com.epolsoft.match.validator;


import com.epolsoft.hero.dto.in.TalentDtoIn;
import com.epolsoft.match.dto.in.PlayerInMatchDtoIn;
import com.google.common.collect.Ordering;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.*;
import java.util.stream.Collectors;


@Component
public class TalentDtoInPlayerInMatchValidator implements ConstraintValidator<TalentConstraint, PlayerInMatchDtoIn> {

    @Override
    public void initialize(TalentConstraint constraintAnnotation) {}


    @Override
    public boolean isValid(PlayerInMatchDtoIn player, ConstraintValidatorContext context) {
        return player != null && player.getTalents().size() != 0 && areTalentsConsistently(player.getTalents()) &&
                areLevelsOfAccessUnique(player.getTalents());
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