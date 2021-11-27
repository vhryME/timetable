package com.vhry.dictionary.lessonType;

import com.vhry.mapper.DictionaryJpaMapper;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface LessonTypeDictionaryJpaMapper extends DictionaryJpaMapper<LessonType, LessonTypeJpa> {

}
