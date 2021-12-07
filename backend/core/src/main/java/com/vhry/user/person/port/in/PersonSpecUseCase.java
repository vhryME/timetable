package com.vhry.user.person.port.in;

import com.vhry.user.common.domain.User;
import com.vhry.user.person.domain.Person;

public interface PersonSpecUseCase{

    Person findByUser(User user);

}
