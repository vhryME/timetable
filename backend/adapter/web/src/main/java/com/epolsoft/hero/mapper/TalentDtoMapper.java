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
import com.epolsoft.match.mapper.PlayerInMatchDtoMapper;
import org.mapstruct.Mapper;


@Mapper(uses = {PlayerInMatchDtoMapper.class})
public interface TalentDtoMapper {

//    default Talent talentDtoInToTalentWithInheritance(TalentDtoIn talentDtoIn) {
//        if(talentDtoIn instanceof ActiveTalentDtoIn) {
//            return activeTalentDtoInToActiveTalent((ActiveTalentDtoIn) talentDtoIn);
//        } else if(talentDtoIn instanceof PassiveTalentDtoIn) {
//            return passiveTalentDtoInToPassiveTalent((PassiveTalentDtoIn) talentDtoIn);
//        }
//
//        return talentDtoInToTalent(talentDtoIn);
//    };
//
//
//    default TalentDtoOut talentToTalentDtoOutWithInheritance(Talent talent) {
//        if(talent instanceof ActiveTalent) {
//            return activeTalentToActiveTalentDtoOut((ActiveTalent) talent);
//        } else if(talent instanceof PassiveTalent) {
//            return passiveTalentToPassiveTalentDtoOut((PassiveTalent) talent);
//        }
//
//        return talentToTalentDtoOut(talent);
//    };

//
//    Talent talentDtoInToTalent(TalentDtoIn talentDtoIn);
//
//
//    TalentDtoOut talentToTalentDtoOut(Talent talent);


    ActiveTalent activeTalentDtoInToActiveTalent(ActiveTalentDtoIn activeTalentDtoIn);


    PassiveTalent passiveTalentDtoInToPassiveTalent(PassiveTalentDtoIn activeTalentDtoIn);


    ActiveTalentDtoOut activeTalentToActiveTalentDtoOut(ActiveTalent activeTalent);


    PassiveTalentDtoOut passiveTalentToPassiveTalentDtoOut(PassiveTalent activeTalentDtoOut);
}