package com.epolsoft.match.mapper.player;


import com.epolsoft.match.domain.Player;
import com.epolsoft.match.dto.player.PlayerJpa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;


@Mapper
public interface PlayerMapper {

    PlayerMapper INSTANCE = Mappers.getMapper(PlayerMapper.class);


    Player playerJpaToPlayer(PlayerJpa playerJpa);

    PlayerJpa playerToPlayerJpa(Player player);

}