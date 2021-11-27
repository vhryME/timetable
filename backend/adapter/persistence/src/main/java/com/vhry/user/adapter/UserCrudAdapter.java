package com.vhry.user.adapter;

import com.vhry.exception.AppException;
import com.vhry.user.common.domain.User;
import com.vhry.mapper.JpaMapper;
import com.vhry.user.domain.UserJpa;
import com.vhry.user.mapper.UserJpaMapper;
import com.vhry.user.common.port.out.UserCrudPort;
import com.vhry.user.repository.UserJpaRepository;
import com.vhry.util.Maps;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import static com.vhry.exception.ErrorCodeEnum.*;

@Component
@RequiredArgsConstructor
public class UserCrudAdapter implements UserCrudPort {

    private final UserJpaRepository jpaRepository;

    private final UserJpaMapper jpaMapper;


    @Transactional
    @Override
    public User persist(User jpaEntity) {
        return jpaMapper.fromJpaEntity(
                jpaRepository.save(
                        Optional.ofNullable(jpaMapper.toJpaEntity(jpaEntity)).orElseThrow(
                                () -> new AppException(E1001, Maps.<String, Object>builder()
                                        .put("entity", jpaEntity)
                                        .build())
                        )));
    }

    @Override
    public User findById(BigInteger id) {
        return jpaMapper.fromJpaEntity(
                jpaRepository.findById(id).orElse(null));
    }

    @Transactional
    @Override
    public void delete(BigInteger id) {
        if (jpaRepository.existsById(id)) {
            jpaRepository.deleteById(id);
        } else {
            throw new AppException(E1003, Maps.<String, Object>builder()
                    .put("entityId", id)
                    .build());
        }
    }

    @Override
    public Page<User> findAll(Pageable page) {
        return jpaMapper.fromJpaEntities(
                jpaRepository.findAll(page));
    }

    @Override
    public List<User> findAll() {
        return jpaMapper.fromJpaEntities(
                jpaRepository.findAll());
    }

}
