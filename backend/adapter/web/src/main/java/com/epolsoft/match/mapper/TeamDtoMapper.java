package com.epolsoft.match.mapper;


import com.epolsoft.mapper.DtoMapper;
import com.epolsoft.match.domain.Team;
import com.epolsoft.match.dto.in.TeamDtoIn;
import com.epolsoft.match.dto.out.TeamDtoOut;
import org.mapstruct.Mapper;


@Mapper(uses = {PlayerInMatchDtoMapper.class})
public interface TeamDtoMapper extends DtoMapper<TeamDtoIn, Team, TeamDtoOut> {}