package com.epolsoft.match.validator;


import com.epolsoft.hero.dto.in.TalentDtoIn;
import com.epolsoft.match.dto.in.PlayerInMatchDtoIn;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.*;


public class TalentDtoInPlayerInMatchValidator implements ConstraintValidator<TalentDtoInConstraint, PlayerInMatchDtoIn> {

    @Override
    public void initialize(TalentDtoInConstraint constraintAnnotation) {}


    @Override
    public boolean isValid(PlayerInMatchDtoIn player, ConstraintValidatorContext context) {
        return player != null && player.getTalents().size() != 0 && areTalentsConsistently(player.getTalents()) &&
                areLevelsOfAccessUnique(player.getTalents());
    }


    private boolean areTalentsConsistently(Set<TalentDtoIn> talents) {
        boolean isIncrease = false;

        ListIterator<TalentDtoIn> iterator = (ListIterator<TalentDtoIn>) talents.iterator();

        while (iterator.hasNext()) {
            isIncrease = iterator.previous().getLevelOfAccess() > iterator.next().getLevelOfAccess();
        }

        return isIncrease;
    }


    private boolean areLevelsOfAccessUnique(Set<TalentDtoIn> talents) {
        List<Integer> levelsList = new ArrayList<>();

        talents.forEach(talent -> levelsList.add(talent.getLevelOfAccess()));

        Set<Integer> levelsSet = new HashSet<>(levelsList);

        return levelsList.size() == levelsSet.size();
    }

}