package com.vhry.user.common.adapter;

import com.vhry.user.common.domain.User;
import com.vhry.mapper.JpaMapper;
import com.vhry.user.common.mapper.UserJpaMapper;
import com.vhry.user.common.repository.UserJpaRepository;
import com.vhry.user.common.specification.UserSpecifications;
import com.vhry.user.common.domain.UserJpa;
import com.vhry.user.common.port.out.UserSearchPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserSearchAdapter implements UserSearchPort {

    private final UserJpaRepository jpaSpecificationExecutor;

    private final UserJpaMapper jpaMapper;


    @Override
    public JpaSpecificationExecutor<UserJpa> getJpaSpecificationExecutor() {
        return jpaSpecificationExecutor;
    }

    @Override
    public JpaMapper<User, UserJpa> getJpaMapper() {
        return jpaMapper;
    }

    @Override
    public User findUserByUserName(String userName) {
        return (User) findOneBySpec(UserSpecifications.findByUserName(userName));
    }

    @Override
    public List<User> findUsersByRole(Long roleId) {
        return findBySpec(UserSpecifications.findByRole(roleId));
    }

}
