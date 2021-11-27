package com.vhry.user.person.controller;

import com.vhry.common.CrudController;
import com.vhry.mapper.DtoMapper;
import com.vhry.port.in.CrudUseCase;
import com.vhry.user.person.domain.Person;
import com.vhry.user.person.dto.in.PersonDtoIn;
import com.vhry.user.person.dto.out.PersonDtoOut;
import com.vhry.user.person.mapper.PersonDtoMapper;
import com.vhry.user.person.port.in.PersonCrudUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.vhry.common.EndpointConstants.PERSON_API;

@RestController
@RequestMapping(PERSON_API)
@RequiredArgsConstructor
public class PersonController implements CrudController<PersonDtoIn, Person, PersonDtoOut> {

    private final PersonDtoMapper dtoMapper;

    private final PersonCrudUseCase crudUseCase;


    @Override
    public DtoMapper<PersonDtoIn, Person, PersonDtoOut> getDtoMapper() {
        return dtoMapper;
    }

    @Override
    public CrudUseCase<Person> getCrudUseCase() {
        return crudUseCase;
    }

}
