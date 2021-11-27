package com.vhry.dictionary.universityRole;

import com.vhry.mapper.DictionaryJpaMapper;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UniversityDictionaryJpaMapper extends DictionaryJpaMapper<UniversityRole, UniversityRoleJpa> {

}
