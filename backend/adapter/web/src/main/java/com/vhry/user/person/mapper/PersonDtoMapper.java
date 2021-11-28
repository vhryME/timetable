package com.vhry.user.person.mapper;

import com.vhry.common.MappingsDtoTemplate;
import com.vhry.constants.DateFormatConstants;
import com.vhry.mapper.DateStringMapper;
import com.vhry.mapper.DtoMapper;
import com.vhry.user.person.domain.Person;
import com.vhry.user.person.dto.in.PersonDtoIn;
import com.vhry.user.person.dto.out.PersonDtoOut;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static com.vhry.common.MappingsDtoTemplate.*;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, uses = {MappingsDtoTemplate.class},
        imports = {DateStringMapper.class, DateFormatConstants.class})
public interface PersonDtoMapper extends DtoMapper<PersonDtoIn, Person, PersonDtoOut> {

    @Override
    @Mapping(target = "user", qualifiedByName = USER_DTO_MAPPING + IN)
    @Mapping(target = "universityRoles", qualifiedByName = UNIVERSITY_ROLE_DTO_MAPPING + IN)
    @Mapping(target = "group", qualifiedByName = GROUP_DTO_MAPPING + IN)
    @Mapping(target = "admissionDate",
            expression = "java( DateStringMapper.asLocalDate(personDtoIn.getAdmissionDate(), DateFormatConstants.DATE_FORMAT) )")
    Person fromIn(PersonDtoIn personDtoIn);

    @Override
    @Mapping(target = "user", qualifiedByName = USER_DTO_MAPPING + OUT)
    @Mapping(target = "universityRoles", qualifiedByName = UNIVERSITY_ROLE_DTO_MAPPING + OUT)
    @Mapping(target = "group", qualifiedByName = GROUP_DTO_MAPPING + OUT)
    PersonDtoOut toOut(Person person);

}
