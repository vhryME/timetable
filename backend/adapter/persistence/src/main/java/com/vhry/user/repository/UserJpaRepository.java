package com.vhry.user.repository;

import com.vhry.user.domain.UserJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.math.BigInteger;

public interface UserJpaRepository extends JpaRepository<UserJpa, BigInteger>, JpaSpecificationExecutor<UserJpa> {



}
