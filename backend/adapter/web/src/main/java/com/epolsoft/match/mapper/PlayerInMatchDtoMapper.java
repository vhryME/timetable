package com.epolsoft.match.mapper;


import com.epolsoft.hero.mapper.HeroDtoMapper;
import com.epolsoft.hero.mapper.TalentDtoMapper;
import com.epolsoft.match.domain.PlayerInMatch;
import com.epolsoft.match.dto.in.PlayerInMatchDtoIn;
import com.epolsoft.match.dto.out.PlayerInMatchDtoOut;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(uses = {PlayerDtoMapper.class, HeroDtoMapper.class, TalentDtoMapper.class, StatisticDtoMapper.class})
public interface PlayerInMatchDtoMapper {

    PlayerInMatch playerInMatchDtoInToPlayerInMatch(PlayerInMatchDtoIn playerInMatchDtoIn);


    PlayerInMatchDtoOut playerInMatchToPlayerInMatchDtoOut(PlayerInMatch playerInMatch);

}