package com.vhry.timetable.group.adapter;

import com.vhry.timeTable.group.domain.Group;
import com.vhry.timetable.group.domain.GroupJpa;
import com.vhry.timetable.group.mapper.GroupJpaMapper;
import com.vhry.timeTable.group.port.out.GroupCrudPort;
import com.vhry.mapper.JpaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GroupJpaCrudAdapter implements GroupCrudPort {

    private final JpaRepository<GroupJpa, Long> jpaRepository;

    private final GroupJpaMapper jpaMapper;


    @Override
    public JpaRepository<GroupJpa, Long> getRepository() {
        return jpaRepository;
    }

    @Override
    public JpaMapper<Group, GroupJpa> getJpaMapper() {
        return jpaMapper;
    }

}
