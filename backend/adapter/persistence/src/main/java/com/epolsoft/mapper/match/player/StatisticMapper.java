package com.epolsoft.mapper.match.player;


import com.epolsoft.domain.match.player.Statistic;
import com.epolsoft.dto.match.player.StatisticJpa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;


@Mapper
public interface StatisticMapper {

    StatisticMapper INSTANCE = Mappers.getMapper(StatisticMapper.class);

    @Mappings({
            @Mapping(source = "statisticJpa.id", target = "id"),
            @Mapping(source = "statisticJpa.level", target = "level"),
            @Mapping(source = "statisticJpa.kills", target = "kills"),
            @Mapping(source = "statisticJpa.assist", target = "assist"),
            @Mapping(source = "statisticJpa.killStreak", target = "killStreak"),
            @Mapping(source = "statisticJpa.deaths", target = "deaths"),
            @Mapping(source = "statisticJpa.damageToEnemies", target = "damageToEnemies"),
            @Mapping(source = "statisticJpa.damageToNPC", target = "damageToNPC"),
            @Mapping(source = "statisticJpa.healToTeammate", target = "healToTeammate"),
            @Mapping(source = "statisticJpa.damageToYourself", target = "damageToYourself"),
            @Mapping(source = "statisticJpa.experience", target = "experience"),
            @Mapping(source = "statisticJpa.timeInRevive", target = "timeInRevive"),
            @Mapping(source = "statisticJpa.takeCamps", target = "takeCamps"),
    })
    Statistic statisticJpaToStatistic(StatisticJpa statisticJpa);

    @Mappings({
            @Mapping(source = "statistic.id", target = "id"),
            @Mapping(source = "statistic.level", target = "level"),
            @Mapping(source = "statistic.kills", target = "kills"),
            @Mapping(source = "statistic.assist", target = "assist"),
            @Mapping(source = "statistic.killStreak", target = "killStreak"),
            @Mapping(source = "statistic.deaths", target = "deaths"),
            @Mapping(source = "statistic.damageToEnemies", target = "damageToEnemies"),
            @Mapping(source = "statistic.damageToNPC", target = "damageToNPC"),
            @Mapping(source = "statistic.healToTeammate", target = "healToTeammate"),
            @Mapping(source = "statistic.damageToYourself", target = "damageToYourself"),
            @Mapping(source = "statistic.experience", target = "experience"),
            @Mapping(source = "statistic.timeInRevive", target = "timeInRevive"),
            @Mapping(source = "statistic.takeCamps", target = "takeCamps"),
    })
    StatisticJpa statisticToStatisticJpa(Statistic statistic);

}