package com.epolsoft.mapper.match.player;


import com.epolsoft.domain.match.player.Player;
import com.epolsoft.dto.match.player.PlayerJpa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;


@Mapper
public interface PlayerMapper {

    PlayerMapper INSTANCE = Mappers.getMapper(PlayerMapper.class);

    @Mappings({
            @Mapping(source = "playerJpa.id", target = "id"),
            @Mapping(source = "playerJpa.login", target = "login"),
    })
    Player playerJpaToPlayer(PlayerJpa playerJpa);

    @Mappings({
            @Mapping(source = "player.id", target = "id"),
            @Mapping(source = "player.login", target = "login"),
    })
    PlayerJpa playerToPlayerJpa(Player player);

}