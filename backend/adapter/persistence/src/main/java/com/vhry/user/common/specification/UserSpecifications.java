package com.vhry.user.common.specification;

import com.vhry.user.common.domain.UserJpa;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecifications {

    public static Specification<UserJpa> findByUserName(String userName) {
        return (root, query, cb) -> cb.equal(root.get("username"), userName);
    }

    public static Specification<UserJpa> findByEmail(String email) {
        return (root, query, cb) -> cb.equal(root.get("email"), email);
    }

    public static Specification<UserJpa> findByRole(Long roleId) {
        return (root, query, cb) -> cb.equal(root.get("role").get("id"), roleId);
    }

}
