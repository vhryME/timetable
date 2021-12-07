package com.vhry.user.person.service;

import com.vhry.user.common.port.in.UserSearchUseCase;
import com.vhry.user.person.domain.Person;
import com.vhry.user.person.port.in.AuthUseCase;
import com.vhry.user.person.port.in.PersonSpecUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService implements AuthUseCase {

    private final UserSearchUseCase userSearchUseCase;

    private final PersonSpecUseCase personSpecUseCase;


    @Override
    public Person me(String email) {
        return personSpecUseCase.findByUser(
                userSearchUseCase.findUserByEmail(email));
    }

}
