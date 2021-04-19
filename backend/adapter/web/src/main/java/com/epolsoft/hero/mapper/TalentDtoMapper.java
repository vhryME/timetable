package com.epolsoft.hero.mapper;


import com.epolsoft.hero.domain.Talent;
import com.epolsoft.hero.dto.in.TalentDtoIn;
import com.epolsoft.hero.dto.out.TalentDtoOut;
import org.mapstruct.Mapper;


@Mapper
public interface TalentDtoMapper {

    Talent talentDtoInToTalent(TalentDtoIn talentDtoIn);


    TalentDtoOut talentToTalentDtoOut(Talent talent);

}