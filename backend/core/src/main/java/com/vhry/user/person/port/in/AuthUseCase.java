package com.vhry.user.person.port.in;

import com.vhry.user.person.domain.Person;

public interface AuthUseCase {

    Person me(String email);

}
