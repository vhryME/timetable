package com.vhry.user.common.port.in;

import com.vhry.dictionary.role.RoleEnum;
import com.vhry.user.common.domain.User;

import java.util.List;

public interface UserSearchUseCase {

    User findUserByUserName(String userName);

    User findUserByEmail(String email);

    List<User> findUsersByRole(RoleEnum role);

}
