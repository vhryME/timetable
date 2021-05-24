package com.epolsoft.match.mapper;


import com.epolsoft.mapper.DtoMapper;
import com.epolsoft.match.domain.Player;
import com.epolsoft.match.dto.in.PlayerDtoIn;
import com.epolsoft.match.dto.out.PlayerDtoOut;
import org.mapstruct.Mapper;


@Mapper
public interface PlayerDtoMapper extends DtoMapper<PlayerDtoIn, Player, PlayerDtoOut> {}