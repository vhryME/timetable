package com.epolsoft.hero.mapper;


import com.epolsoft.hero.domain.Talent;
import com.epolsoft.hero.dto.in.TalentDtoIn;
import com.epolsoft.hero.dto.out.TalentDtoOut;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface TalentDtoMapper {

    TalentDtoMapper INSTANCE = Mappers.getMapper(TalentDtoMapper.class);

    Talent talentDtoOutToTalent(TalentDtoOut talentDtoOut);

    TalentDtoIn talentToTalentDtoIn(Talent talent);

}