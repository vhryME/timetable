package com.vhry.user.person.service;

import com.vhry.user.common.domain.User;
import com.vhry.user.person.domain.Person;
import com.vhry.user.person.port.in.PersonSpecUseCase;
import com.vhry.user.person.port.out.PersonSpecPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonSpecService implements PersonSpecUseCase {

    private final PersonSpecPort specPort;


    @Override
    public Person findByUser(User user) {
        return specPort.findByUser(user);
    }

}
