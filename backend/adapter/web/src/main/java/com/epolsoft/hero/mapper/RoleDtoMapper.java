package com.epolsoft.hero.mapper;


import com.epolsoft.hero.domain.Role;
import com.epolsoft.hero.dto.in.RoleDtoIn;
import com.epolsoft.hero.dto.out.RoleDtoOut;
import org.mapstruct.Mapper;
import org.mapstruct.ValueMapping;
import org.mapstruct.ValueMappings;
import org.mapstruct.factory.Mappers;


@Mapper
public interface RoleDtoMapper {

    @ValueMappings({
            @ValueMapping(source = "Specialist", target = "Specialist"),
            @ValueMapping(source = "Assassin", target = "Assassin"),
            @ValueMapping(source = "Warrior", target = "Warrior"),
            @ValueMapping(source = "Support", target = "Support"),
            @ValueMapping(source = "Multiclass", target = "Multiclass"),
            @ValueMapping(source = "Unknown", target = "Unknown")
    })
    Role roleDtoInToRole(RoleDtoIn roleDtoIn);


    @ValueMappings({
            @ValueMapping(source = "Specialist", target = "Specialist"),
            @ValueMapping(source = "Assassin", target = "Assassin"),
            @ValueMapping(source = "Warrior", target = "Warrior"),
            @ValueMapping(source = "Support", target = "Support"),
            @ValueMapping(source = "Multiclass", target = "Multiclass"),
            @ValueMapping(source = "Unknown", target = "Unknown")
    })
    RoleDtoOut roleToRoleDtoOut(Role role);

}