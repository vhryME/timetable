package com.vhry.timeTable.domain.group.mapper;

import com.vhry.common.MappingsJpaTemplate;
import com.vhry.timeTable.group.domain.Group;
import com.vhry.timeTable.domain.group.domain.GroupJpa;
import com.vhry.mapper.JpaMapper;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static com.vhry.common.MappingsJpaTemplate.IN;
import static com.vhry.common.MappingsJpaTemplate.PERSON_MAPPING;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, uses = {MappingsJpaTemplate.class})
public interface GroupJpaMapper extends JpaMapper<Group, GroupJpa> {

    @Override
    @Mapping(target = "students", qualifiedByName = PERSON_MAPPING)
    Group fromJpaEntity(GroupJpa groupJpa);

    @Override
    @Mapping(target = "students", qualifiedByName = PERSON_MAPPING + IN)
    GroupJpa toJpaEntity(Group group);
}
