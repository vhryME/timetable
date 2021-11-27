package com.vhry.user.common.port.in;

import com.vhry.user.common.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigInteger;
import java.util.List;

public interface UserCrudUseCase {

    User persist(User user);

    void persistAll(List<User> entities);

    User findById(BigInteger id);

    void delete(BigInteger id);

    Page<User> findAll(Pageable page);

    List<User> findAll();

}
