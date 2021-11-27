package com.vhry.user.person.service;

import com.vhry.port.out.CrudPort;
import com.vhry.user.person.port.in.PersonCrudUseCase;
import com.vhry.user.person.port.out.PersonCrudPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonCrudService implements PersonCrudUseCase {

    private final PersonCrudPort crudPort;


    @Override
    public CrudPort getCrudPort() {
        return crudPort;
    }

}
