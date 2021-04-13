package com.epolsoft.match.mapper;


import com.epolsoft.match.domain.Match;
import com.epolsoft.match.dto.in.MatchDtoIn;
import com.epolsoft.match.dto.out.MatchDtoOut;
import org.mapstruct.Mapper;


@Mapper
public interface MatchDtoMapper {

    Match matchDtoInToMatch(MatchDtoIn matchDtoIn);

    MatchDtoOut matchToMatchDtoOut(Match match);

}