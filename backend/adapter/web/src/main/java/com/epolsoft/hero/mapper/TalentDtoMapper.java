package com.epolsoft.hero.mapper;


import com.epolsoft.hero.domain.ActiveTalent;
import com.epolsoft.hero.domain.PassiveTalent;
import com.epolsoft.hero.domain.Talent;
import com.epolsoft.hero.dto.in.ActiveTalentDtoIn;
import com.epolsoft.hero.dto.in.PassiveTalentDtoIn;
import com.epolsoft.hero.dto.in.TalentDtoIn;
import com.epolsoft.hero.dto.out.ActiveTalentDtoOut;
import com.epolsoft.hero.dto.out.PassiveTalentDtoOut;
import com.epolsoft.hero.dto.out.TalentDtoOut;
import com.epolsoft.mapper.DtoMapper;
import com.epolsoft.match.mapper.PlayerInMatchDtoMapper;
import org.mapstruct.Mapper;

import java.util.HashSet;
import java.util.Set;


@Mapper(uses = {PlayerInMatchDtoMapper.class})
public interface TalentDtoMapper {

    default Set<Talent> talentDtoInToTalentWithInheritance(Set<TalentDtoIn> talents) {
        if(talents != null) {
            Set<Talent> talentsWithInheritance = new HashSet<>();

            talents.forEach(talentDtoIn -> {
                if (talentDtoIn instanceof ActiveTalentDtoIn) {
                    talentsWithInheritance.add(activeTalentDtoInToActiveTalent((ActiveTalentDtoIn) talentDtoIn));
                } else if (talentDtoIn instanceof PassiveTalentDtoIn) {
                    talentsWithInheritance.add(passiveTalentDtoInToPassiveTalent((PassiveTalentDtoIn) talentDtoIn));
                }
            });

            return talentsWithInheritance;
        }

        return null;
    }


    default Set<TalentDtoOut> talentToTalentDtoOutWithInheritance(Set<Talent> talents) {
        if (talents != null) {
            Set<TalentDtoOut> talentsWithInheritance = new HashSet<>();

            talents.forEach(talent -> {
                if (talent instanceof ActiveTalent) {
                    talentsWithInheritance.add(activeTalentToActiveTalentDtoOut((ActiveTalent) talent));
                } else if (talent instanceof PassiveTalent) {
                    talentsWithInheritance.add(passiveTalentToPassiveTalentDtoOut((PassiveTalent) talent));
                }
            });

            return talentsWithInheritance;
        }

        return null;
    }


    ActiveTalent activeTalentDtoInToActiveTalent(ActiveTalentDtoIn activeTalentDtoIn);


    PassiveTalent passiveTalentDtoInToPassiveTalent(PassiveTalentDtoIn activeTalentDtoIn);


    ActiveTalentDtoOut activeTalentToActiveTalentDtoOut(ActiveTalent activeTalent);


    PassiveTalentDtoOut passiveTalentToPassiveTalentDtoOut(PassiveTalent activeTalentDtoOut);

}
