package com.vhry.user.domain.person.mapper;

import com.vhry.common.MappingsJpaTemplate;
import com.vhry.mapper.JpaMapper;
import com.vhry.user.person.domain.Person;
import com.vhry.user.domain.person.domain.PersonJpa;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static com.vhry.common.MappingsJpaTemplate.*;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, uses = MappingsJpaTemplate.class)
public interface PersonJpaMapper extends JpaMapper<Person, PersonJpa> {

    @Override
    @Mapping(target = "user", qualifiedByName = USER_MAPPING)
    @Mapping(target = "universityRoles", qualifiedByName = UNIVERSITY_ROLE_MAPPING)
    Person fromJpaEntity(PersonJpa personJpa);

    @Override
    @Mapping(target = "user", qualifiedByName = USER_MAPPING + IN)
    @Mapping(target = "universityRoles", qualifiedByName = UNIVERSITY_ROLE_MAPPING + IN)
    PersonJpa toJpaEntity(Person person);
}
