package com.epolsoft.match.mapper;


import com.epolsoft.match.domain.Match;
import com.epolsoft.match.dto.in.MatchDtoIn;
import com.epolsoft.match.dto.in.MatchDtoInFiltered;
import com.epolsoft.match.dto.out.MatchDtoOut;
import com.epolsoft.match.port.out.MatchPort;
import org.mapstruct.Mapper;


@Mapper
public interface MatchDtoMapper {

    Match matchDtoInToMatch(MatchDtoIn matchDtoIn);

    MatchDtoOut matchToMatchDtoOut(Match match);

    MatchPort.MatchFiltered matchDtoInFilteredToMatchFiltered(MatchDtoInFiltered matchDtoInFiltered);

}