package com.epolsoft.mapper.match;


import com.epolsoft.domain.match.TypeOfMatch;
import com.epolsoft.dto.match.TypeOfMatchJpa;
import org.mapstruct.EnumMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface TypeOfMatchMapper {

    TypeOfMatchMapper INSTANCE = Mappers.getMapper(TypeOfMatchMapper.class);

    @EnumMapping
    TypeOfMatch typeToTypeJpa(TypeOfMatchJpa typeOfMatchJpa);

    @EnumMapping
    TypeOfMatchJpa typeJpaToType(TypeOfMatch typeOfMatch);

}
