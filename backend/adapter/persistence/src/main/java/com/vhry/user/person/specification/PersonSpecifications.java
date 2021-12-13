package com.vhry.user.person.specification;

import com.vhry.user.common.domain.UserJpa;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigInteger;

public class PersonSpecifications {

    public static Specification<UserJpa> findByUserId(BigInteger userId) {
        return (root, query, cb) -> cb.equal(root
                .get("user")
                .get("id"), userId);
    }

}
