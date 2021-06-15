package com.epolsoft.match.mapper;

import com.epolsoft.mapper.JpaMapper;
import com.epolsoft.match.domain.Statistic;
import com.epolsoft.match.domain.StatisticJpa;
import org.mapstruct.Mapper;

@Mapper
public interface StatisticJpaMapper extends JpaMapper<StatisticJpa, Statistic>{}
