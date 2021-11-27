package com.vhry.user.common.service;

import com.vhry.user.common.domain.User;
import com.vhry.user.common.port.in.UserCrudUseCase;
import com.vhry.user.common.port.out.UserCrudPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
@RequiredArgsConstructor
class UserCrudService implements UserCrudUseCase {

    private final UserCrudPort userCrudPort;

    @Override
    public User persist(User user) {
        return userCrudPort.persist(user);
    }

    @Override
    public void persistAll(List<User> entities) {
        entities.forEach(userCrudPort::persist);
    }

    @Override
    public User findById(BigInteger id) {
        return userCrudPort.findById(id);
    }

    @Override
    public void delete(BigInteger id) {
        userCrudPort.delete(id);
    }

    @Override
    public Page<User> findAll(Pageable page) {
        return userCrudPort.findAll(page);
    }

    @Override
    public List<User> findAll() {
        return userCrudPort.findAll();
    }

}
