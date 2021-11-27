package com.vhry.user.common.service;

import com.vhry.dictionary.role.RoleEnum;
import com.vhry.user.common.domain.User;
import com.vhry.user.common.port.in.UserSearchUseCase;
import com.vhry.user.common.port.out.UserSearchPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserSearchService implements UserSearchUseCase {

    private final UserSearchPort searchPort;


    @Override
    public User findUserByUserName(String userName) {
        return searchPort.findUserByUserName(userName);
    }

    @Override
    public List<User> findUsersByRole(RoleEnum role) {
        return searchPort.findUsersByRole(role.id);
    }

}
