package com.epolsoft.hero.mapper;


import com.epolsoft.hero.domain.Role;
import com.epolsoft.hero.dto.RoleJpa;
import org.mapstruct.EnumMapping;
import org.mapstruct.Mapper;
import org.mapstruct.ValueMapping;
import org.mapstruct.ValueMappings;
import org.mapstruct.factory.Mappers;


@Mapper
public interface RoleMapper {

    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);


    @ValueMappings({
            @ValueMapping(source = "Specialist", target = "Specialist"),
            @ValueMapping(source = "Assassin", target = "Assassin"),
            @ValueMapping(source = "Warrior", target = "Warrior"),
            @ValueMapping(source = "Support", target = "Support"),
            @ValueMapping(source = "Multiclass", target = "Multiclass"),
            @ValueMapping(source = "Unknown", target = "Unknown")
    })
    Role roleJpaToRole(RoleJpa roleJpa);


    @ValueMappings({
            @ValueMapping(source = "Specialist", target = "Specialist"),
            @ValueMapping(source = "Assassin", target = "Assassin"),
            @ValueMapping(source = "Warrior", target = "Warrior"),
            @ValueMapping(source = "Support", target = "Support"),
            @ValueMapping(source = "Multiclass", target = "Multiclass"),
            @ValueMapping(source = "Unknown", target = "Unknown")
    })
    RoleJpa roleToRoleJpa(Role role);

}