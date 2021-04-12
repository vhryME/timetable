package com.epolsoft.match.mapper;


import com.epolsoft.match.domain.Player;
import com.epolsoft.match.dto.in.PlayerDtoIn;
import com.epolsoft.match.dto.out.PlayerDtoOut;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface PlayerDtoMapper {

    PlayerDtoMapper INSTANCE = Mappers.getMapper(PlayerDtoMapper.class);


    Player playerDtoOutToPlayer(PlayerDtoOut playerDtoOut);

    PlayerDtoIn playerToPlayerDtoIn(Player player);

}