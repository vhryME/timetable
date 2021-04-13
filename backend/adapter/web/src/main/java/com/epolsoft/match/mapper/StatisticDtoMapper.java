package com.epolsoft.match.mapper;


import com.epolsoft.match.domain.Statistic;
import com.epolsoft.match.dto.in.StatisticDtoIn;
import com.epolsoft.match.dto.out.StatisticDtoOut;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface StatisticDtoMapper {

    Statistic statisticJpaToStatistic(StatisticDtoOut statisticDtoOut);

    StatisticDtoIn statisticToStatisticDtoIn(Statistic statistic);

}