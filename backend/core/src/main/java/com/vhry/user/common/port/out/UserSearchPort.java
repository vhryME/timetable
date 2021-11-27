package com.vhry.user.common.port.out;

import com.vhry.port.out.SpecPort;
import com.vhry.user.common.domain.User;

import java.util.List;

public interface UserSearchPort extends SpecPort {

    User findUserByUserName(String userName);

    List<User> findUsersByRole(Long id);

}
