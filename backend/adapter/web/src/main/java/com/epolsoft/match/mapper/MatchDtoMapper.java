package com.epolsoft.match.mapper;


import com.epolsoft.match.domain.Match;
import com.epolsoft.match.dto.in.MatchDtoIn;
import com.epolsoft.match.dto.out.MatchDtoOut;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface MatchDtoMapper {

    MatchDtoMapper INSTANCE = Mappers.getMapper(MatchDtoMapper.class);


    Match matchDtoOutToMatch(MatchDtoOut matchDtoOut);

    MatchDtoIn matchToMatchDtoIn(Match match);

}