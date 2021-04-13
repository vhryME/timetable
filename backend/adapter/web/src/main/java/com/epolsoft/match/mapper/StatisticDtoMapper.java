package com.epolsoft.match.mapper;


import com.epolsoft.match.domain.Statistic;
import com.epolsoft.match.dto.in.StatisticDtoIn;
import com.epolsoft.match.dto.out.StatisticDtoOut;
import org.mapstruct.Mapper;


@Mapper
public interface StatisticDtoMapper {

    Statistic statisticDtoInToStatistic(StatisticDtoIn statisticDtoIn);

    StatisticDtoOut statisticToStatisticDtoOut(Statistic statistic);

}