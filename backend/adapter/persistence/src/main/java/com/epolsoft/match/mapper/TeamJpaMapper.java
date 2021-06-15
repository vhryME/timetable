package com.epolsoft.match.mapper;

import com.epolsoft.mapper.JpaMapper;
import com.epolsoft.match.domain.Team;
import com.epolsoft.match.domain.TeamJpa;
import org.mapstruct.Mapper;

@Mapper(uses = {PlayerInMatchJpaMapper.class})
public interface TeamJpaMapper extends JpaMapper<TeamJpa, Team> {
}
