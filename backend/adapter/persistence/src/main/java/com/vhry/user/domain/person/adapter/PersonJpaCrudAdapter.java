package com.vhry.user.domain.person.adapter;

import com.vhry.mapper.JpaMapper;
import com.vhry.user.person.domain.Person;
import com.vhry.user.domain.person.domain.PersonJpa;
import com.vhry.user.domain.person.mapper.PersonJpaMapper;
import com.vhry.user.person.port.out.PersonCrudPort;
import com.vhry.user.domain.person.reposirory.PersonJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonJpaCrudAdapter implements PersonCrudPort {

    private final PersonJpaRepository jpaRepository;

    private final PersonJpaMapper jpaMapper;


    @Override
    public JpaRepository<PersonJpa, Long> getRepository() {
        return jpaRepository;
    }

    @Override
    public JpaMapper<Person, PersonJpa> getJpaMapper() {
        return jpaMapper;
    }

}
