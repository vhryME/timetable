package com.epolsoft.match.mapper;

import com.epolsoft.mapper.JpaMapper;
import com.epolsoft.match.domain.Player;
import com.epolsoft.match.domain.PlayerJpa;
import org.mapstruct.Mapper;

@Mapper
public interface PlayerJpaMapper extends JpaMapper<PlayerJpa, Player>{}
