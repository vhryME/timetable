package com.epolsoft.match.mapper;


import com.epolsoft.match.domain.Statistic;
import com.epolsoft.match.dto.StatisticJpa;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface StatisticMapper {

    StatisticMapper INSTANCE = Mappers.getMapper(StatisticMapper.class);


    Statistic statisticJpaToStatistic(StatisticJpa statisticJpa);

    StatisticJpa statisticToStatisticJpa(Statistic statistic);

}