package com.epolsoft.match.mapper;

import com.epolsoft.mapper.JpaMapper;
import com.epolsoft.match.domain.Map;
import com.epolsoft.match.domain.MapJpa;
import com.epolsoft.match.domain.Match;
import com.epolsoft.match.domain.MatchJpa;
import org.mapstruct.Mapper;

@Mapper
public interface MapJpaMapper extends JpaMapper<MapJpa, Map>{
}
