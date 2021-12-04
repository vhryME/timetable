package com.vhry.timetable.faculty.adapter;

import com.vhry.timeTable.faculty.domain.Faculty;
import com.vhry.timetable.faculty.domain.FacultyJpa;
import com.vhry.timetable.faculty.mapper.FacultyJpaMapper;
import com.vhry.timeTable.faculty.port.out.FacultyCrudPort;
import com.vhry.mapper.JpaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FacultyJpaCrudAdapter implements FacultyCrudPort {

    private final JpaRepository<FacultyJpa, Long> jpaRepository;

    private final FacultyJpaMapper jpaMapper;


    @Override
    public JpaRepository<FacultyJpa, Long> getRepository() {
        return jpaRepository;
    }

    @Override
    public JpaMapper<Faculty, FacultyJpa> getJpaMapper() {
        return jpaMapper;
    }

}
