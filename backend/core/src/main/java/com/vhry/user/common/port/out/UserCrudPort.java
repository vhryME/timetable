package com.vhry.user.common.port.out;

import com.vhry.user.common.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigInteger;
import java.util.List;

public interface UserCrudPort {

    User persist(User user);

    User findById(BigInteger id);

    void delete(BigInteger id);

    Page<User> findAll(Pageable page);

    List<User> findAll();

}
