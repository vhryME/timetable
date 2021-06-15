package com.epolsoft.match.mapper;

import com.epolsoft.mapper.DateMapper;
import com.epolsoft.mapper.JpaMapper;
import com.epolsoft.match.domain.*;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

@Mapper(uses = {MapJpaMapper.class, DateMapper.class, TeamJpaMapper.class,
        MatchJpaMapper.RegionJpaMapper.class, MatchJpaMapper.TypeOfMatchJpaMapper.class})
public interface MatchJpaMapper extends JpaMapper<MatchJpa, Match> {

    default Page<Match> jpaMatchPageToMatchPage(Page<MatchJpa> matchJpaPage){
        return matchJpaPage.map(this::jpaEntityToEntity);
    }

    @Mapper
    interface TypeOfMatchJpaMapper extends JpaMapper<TypeOfMatchJpa, TypeOfMatch>{}

    @Mapper
    interface RegionJpaMapper extends JpaMapper<RegionJpa, Region>{}
}
