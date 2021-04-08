package com.epolsoft.match.mapper.player;


import com.epolsoft.match.domain.Statistic;
import com.epolsoft.match.dto.player.StatisticJpa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;


@Mapper
public interface StatisticMapper {

    StatisticMapper INSTANCE = Mappers.getMapper(StatisticMapper.class);


    Statistic statisticJpaToStatistic(StatisticJpa statisticJpa);

    StatisticJpa statisticToStatisticJpa(Statistic statistic);

}