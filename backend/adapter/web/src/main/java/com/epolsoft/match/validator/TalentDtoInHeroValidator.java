package com.epolsoft.match.validator;

import com.epolsoft.hero.dto.in.HeroDtoIn;
import com.epolsoft.hero.dto.in.TalentDtoIn;
import com.epolsoft.match.dto.in.PlayerInMatchDtoIn;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.*;

public class TalentDtoInHeroValidator implements ConstraintValidator<TalentDtoInConstraint, HeroDtoIn> {

    @Override
    public void initialize(TalentDtoInConstraint constraintAnnotation) {}


    @Override
    public boolean isValid(HeroDtoIn hero, ConstraintValidatorContext context) {
        return hero != null && hero.getTalents().size() != 0 && areTalentsConsistently(hero.getTalents()) &&
                areLevelsOfAccessUnique(hero.getTalents());
    }


    private boolean areTalentsConsistently(Set<TalentDtoIn> talents) {
        boolean isIncrease = false;

        List<TalentDtoIn> talentList = new ArrayList<>(talents);
        ListIterator<TalentDtoIn> iterator = talentList.listIterator();

        while (iterator.hasNext()) {
            if(!iterator.hasPrevious()) {
                iterator.next();
                continue;
            }

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
