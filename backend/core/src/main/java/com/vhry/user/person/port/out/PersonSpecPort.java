package com.vhry.user.person.port.out;

import com.vhry.port.out.SpecPort;
import com.vhry.user.common.domain.User;
import com.vhry.user.person.domain.Person;

public interface PersonSpecPort extends SpecPort {

    Person findByUser(User user);

}
