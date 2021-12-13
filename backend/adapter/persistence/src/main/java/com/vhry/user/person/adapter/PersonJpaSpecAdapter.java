package com.vhry.user.person.adapter;

import com.vhry.mapper.JpaMapper;
import com.vhry.user.common.domain.User;
import com.vhry.user.person.domain.Person;
import com.vhry.user.person.domain.PersonJpa;
import com.vhry.user.person.mapper.PersonJpaMapper;
import com.vhry.user.person.port.out.PersonSpecPort;
import com.vhry.user.person.reposirory.PersonJpaRepository;
import com.vhry.user.person.specification.PersonSpecifications;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonJpaSpecAdapter implements PersonSpecPort {

    private final PersonJpaRepository jpaSpecificationExecutor;

    private final PersonJpaMapper jpaMapper;


    @Override
    public JpaSpecificationExecutor<PersonJpa> getJpaSpecificationExecutor() {
        return jpaSpecificationExecutor;
    }

    @Override
    public JpaMapper<Person, PersonJpa> getJpaMapper() {
        return jpaMapper;
    }

    @Override
    public Person findByUser(User user) {
        return (Person) findOneBySpec(PersonSpecifications.findByUserId(user.getId()));
    }

}
