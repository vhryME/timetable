package com.epolsoft.dictionary.mapper;


import com.epolsoft.hero.mapper.HeroDtoMapper;
import com.epolsoft.match.mapper.MapDtoMapper;
import com.epolsoft.match.mapper.MatchDtoMapper;
import com.epolsoft.dictionary.Dictionary;
import com.epolsoft.dictionary.dto.out.DictionaryDtoOut;
import org.mapstruct.Mapper;


@Mapper(uses = {HeroDtoMapper.RoleDtoMapper.class, MapDtoMapper.class, MatchDtoMapper.RegionMapper.class,
        MatchDtoMapper.TypeOfMatchMapper.class})
public interface DictionaryDtoMapper {

    DictionaryDtoOut dictionaryToDictionaryDtoOut(Dictionary dictionary);

}