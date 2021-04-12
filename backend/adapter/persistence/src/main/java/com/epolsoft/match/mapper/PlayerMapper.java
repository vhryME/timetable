package com.epolsoft.match.mapper;


import com.epolsoft.match.domain.Player;
import com.epolsoft.match.jpa.PlayerJpa;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface PlayerMapper {

    PlayerMapper INSTANCE = Mappers.getMapper(PlayerMapper.class);


    Player playerJpaToPlayer(PlayerJpa playerJpa);

    PlayerJpa playerToPlayerJpa(Player player);

}