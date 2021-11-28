package com.vhry.user.common.mapper;

import com.vhry.common.MappingsJpaTemplate;
import com.vhry.user.common.domain.User;
import com.vhry.mapper.JpaMapper;
import com.vhry.user.common.domain.UserJpa;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static com.vhry.common.MappingsJpaTemplate.IN;
import static com.vhry.common.MappingsJpaTemplate.ROLE_MAPPING;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, uses = {MappingsJpaTemplate.class})
public interface UserJpaMapper extends JpaMapper<User, UserJpa> {

    @Override
    @Mapping(target = "role", qualifiedByName = ROLE_MAPPING)
    User fromJpaEntity(UserJpa userJpa);

    @Override
    @Mapping(target = "role", qualifiedByName = ROLE_MAPPING + IN)
    UserJpa toJpaEntity(User user);
}
