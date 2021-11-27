package com.vhry.user.common.mapper;

import com.vhry.common.MappingsDtoTemplate;
import com.vhry.user.common.domain.User;
import com.vhry.mapper.DtoMapper;
import com.vhry.user.common.dto.out.UserDtoOut;
import com.vhry.user.common.dto.in.UserDtoIn;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static com.vhry.common.MappingsDtoTemplate.IN;
import static com.vhry.common.MappingsDtoTemplate.OUT;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, uses = {MappingsDtoTemplate.class})
public interface UserDtoMapper extends DtoMapper<UserDtoIn, User, UserDtoOut> {

    @Override
    @Mapping(target = "role", qualifiedByName = MappingsDtoTemplate.ROLE_DTO_MAPPING + IN)
    User fromIn(UserDtoIn dtoIn);

    @Override
    @Mapping(target = "role", qualifiedByName = MappingsDtoTemplate.ROLE_DTO_MAPPING + OUT)
    UserDtoOut toOut(User entity);

}
