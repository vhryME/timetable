package com.epolsoft.hero.mapper;


import com.epolsoft.hero.domain.Talent;
import com.epolsoft.hero.dto.TalentJpa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;


@Mapper
public interface TalentMapper {

    TalentMapper INSTANCE = Mappers.getMapper(TalentMapper.class);

    Talent talentJpaToTalent(TalentJpa talentJpa);

    TalentJpa talentToTalentJpa(Talent talent);

}