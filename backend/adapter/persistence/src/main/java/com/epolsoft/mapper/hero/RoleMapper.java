package com.epolsoft.mapper.hero;


import com.epolsoft.domain.hero.Role;
import com.epolsoft.dto.hero.RoleJpa;
import org.mapstruct.EnumMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface RoleMapper {

    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    @EnumMapping
    Role roleJpaToRole(RoleJpa roleJpa);

    @EnumMapping
    RoleJpa roleToRoleJpa(Role role);

}