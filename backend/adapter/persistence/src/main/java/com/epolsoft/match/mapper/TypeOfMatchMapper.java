package com.epolsoft.match.mapper;


import com.epolsoft.match.domain.TypeOfMatch;
import com.epolsoft.match.jpa.TypeOfMatchJpa;
import org.mapstruct.Mapper;
import org.mapstruct.ValueMapping;
import org.mapstruct.ValueMappings;
import org.mapstruct.factory.Mappers;


@Mapper
public interface TypeOfMatchMapper {

    TypeOfMatchMapper INSTANCE = Mappers.getMapper(TypeOfMatchMapper.class);


    @ValueMappings({
            @ValueMapping(source = "QuickMatch", target = "QuickMatch"),
            @ValueMapping(source = "UnrankedDraft", target = "UnrankedDraft"),
            @ValueMapping(source = "HeroLeague", target = "HeroLeague"),
            @ValueMapping(source = "TeamLeague", target = "TeamLeague"),
            @ValueMapping(source = "Brawl", target = "Brawl"),
            @ValueMapping(source = "Unknown", target = "Unknown")
    })
    TypeOfMatch typeToTypeJpa(TypeOfMatchJpa typeOfMatchJpa);

    @ValueMappings({
            @ValueMapping(source = "QuickMatch", target = "QuickMatch"),
            @ValueMapping(source = "UnrankedDraft", target = "UnrankedDraft"),
            @ValueMapping(source = "HeroLeague", target = "HeroLeague"),
            @ValueMapping(source = "TeamLeague", target = "TeamLeague"),
            @ValueMapping(source = "Brawl", target = "Brawl"),
            @ValueMapping(source = "Unknown", target = "Unknown")
    })
    TypeOfMatchJpa typeJpaToType(TypeOfMatch typeOfMatch);

}
