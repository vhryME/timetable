package com.epolsoft.match.mapper;


import com.epolsoft.match.domain.TypeOfMatch;
import com.epolsoft.match.dto.in.TypeOfMatchDtoIn;
import com.epolsoft.match.dto.out.TypeOfMatchDtoOut;
import org.mapstruct.Mapper;
import org.mapstruct.ValueMapping;
import org.mapstruct.ValueMappings;
import org.mapstruct.factory.Mappers;


@Mapper
public interface TypeOfMatchDtoMapper {

    TypeOfMatchDtoMapper INSTANCE = Mappers.getMapper(TypeOfMatchDtoMapper.class);


    @ValueMappings({
            @ValueMapping(source = "QuickMatch", target = "QuickMatch"),
            @ValueMapping(source = "UnrankedDraft", target = "UnrankedDraft"),
            @ValueMapping(source = "HeroLeague", target = "HeroLeague"),
            @ValueMapping(source = "TeamLeague", target = "TeamLeague"),
            @ValueMapping(source = "Brawl", target = "Brawl"),
            @ValueMapping(source = "Unknown", target = "Unknown")
    })
    TypeOfMatch typeToTypeJpa(TypeOfMatchDtoOut typeOfMatchDtoOut);

    @ValueMappings({
            @ValueMapping(source = "QuickMatch", target = "QuickMatch"),
            @ValueMapping(source = "UnrankedDraft", target = "UnrankedDraft"),
            @ValueMapping(source = "HeroLeague", target = "HeroLeague"),
            @ValueMapping(source = "TeamLeague", target = "TeamLeague"),
            @ValueMapping(source = "Brawl", target = "Brawl"),
            @ValueMapping(source = "Unknown", target = "Unknown")
    })
    TypeOfMatchDtoIn typeJpaToType(TypeOfMatch typeOfMatch);

}
