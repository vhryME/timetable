package com.epolsoft.match.mapper;


import com.epolsoft.match.domain.Player;
import com.epolsoft.match.jpa.PlayerJpa;
import org.mapstruct.Mapper;


@Mapper
public interface PlayerMapper {

    Player playerJpaToPlayer(PlayerJpa playerJpa);

    PlayerJpa playerToPlayerJpa(Player player);

}