package com.epolsoft.match.mapper;


import com.epolsoft.mapper.DtoMapper;
import com.epolsoft.match.domain.Statistic;
import com.epolsoft.match.dto.in.StatisticDtoIn;
import com.epolsoft.match.dto.out.StatisticDtoOut;
import org.mapstruct.Mapper;


@Mapper
public interface StatisticDtoMapper extends DtoMapper<StatisticDtoIn, Statistic, StatisticDtoOut> {}