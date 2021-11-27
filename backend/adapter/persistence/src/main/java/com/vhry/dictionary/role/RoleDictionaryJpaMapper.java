package com.vhry.dictionary.role;

import com.vhry.mapper.DictionaryJpaMapper;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface RoleDictionaryJpaMapper extends DictionaryJpaMapper<Role, RoleJpa> {

}
