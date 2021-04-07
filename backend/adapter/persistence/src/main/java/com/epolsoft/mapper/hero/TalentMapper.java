package com.epolsoft.mapper.hero;


import com.epolsoft.domain.hero.Talent;
import com.epolsoft.dto.hero.TalentJpa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;


@Mapper
public interface TalentMapper {

    TalentMapper INSTANCE = Mappers.getMapper(TalentMapper.class);

    @Mappings({
            @Mapping(source = "talentJpa.id", target = "id"),
            @Mapping(source = "talentJpa.name", target = "name"),
            @Mapping(source = "talentJpa.description", target = "description"),
            @Mapping(source = "talentJpa.icon", target = "icon"),
            @Mapping(source = "talentJpa.key", target = "key"),
            @Mapping(source = "talentJpa.levelOfAccess", target = "levelOfAccess"),
    })
    Talent talentJpaToTalent(TalentJpa talentJpa);

    @Mappings({
            @Mapping(source = "talent.id", target = "id"),
            @Mapping(source = "talent.name", target = "name"),
            @Mapping(source = "talent.description", target = "description"),
            @Mapping(source = "talent.icon", target = "icon"),
            @Mapping(source = "talent.key", target = "key"),
            @Mapping(source = "talent.levelOfAccess", target = "levelOfAccess"),
    })
    TalentJpa talentToTalentJpa(Talent talent);

}