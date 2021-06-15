package com.epolsoft.hero.mapper;


import com.epolsoft.hero.domain.*;
import com.epolsoft.mapper.JpaMapper;
import org.mapstruct.Mapper;

import java.util.HashSet;
import java.util.Set;


@Mapper
public interface TalentJpaMapper extends JpaMapper<TalentJpa, Talent> {

    default Set<Talent> talentJpaToTalentWithInheritance(Set<TalentJpa> talents) {
        if (talents != null) {
            Set<Talent> talentsWithInheritance = new HashSet<>();

            talents.forEach(talentJpa -> {
                if (talentJpa instanceof ActiveTalentJpa) {
                    talentsWithInheritance.add(activeTalentJpaToActiveTalent((ActiveTalentJpa) talentJpa));
                } else if (talentJpa instanceof PassiveTalentJpa) {
                    talentsWithInheritance.add(passiveTalentJpaToPassiveTalent((PassiveTalentJpa) talentJpa));
                }
            });

            return talentsWithInheritance;
        }

        return null;
    }


    default Set<TalentJpa> talentToTalentJpaWithInheritance(Set<Talent> talents) {
        if(talents != null) {
            Set<TalentJpa> talentsWithInheritance = new HashSet<>();

            talents.forEach(talent -> {
                if (talent instanceof ActiveTalent) {
                    talentsWithInheritance.add(activeTalentToActiveTalentJpa((ActiveTalent) talent));
                } else if (talent instanceof PassiveTalent) {
                    talentsWithInheritance.add(passiveTalentToPassiveTalentJpa((PassiveTalent) talent));
                }
            });

            return talentsWithInheritance;
        }

        return null;
    }

    ActiveTalent activeTalentJpaToActiveTalent(ActiveTalentJpa activeTalentJpa);


    PassiveTalent passiveTalentJpaToPassiveTalent(PassiveTalentJpa passiveTalentJpa);


    ActiveTalentJpa activeTalentToActiveTalentJpa(ActiveTalent activeTalent);


    PassiveTalentJpa passiveTalentToPassiveTalentJpa(PassiveTalent passiveTalent);

}