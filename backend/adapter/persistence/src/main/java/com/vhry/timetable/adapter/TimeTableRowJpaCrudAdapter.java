package com.vhry.timetable.adapter;

import com.vhry.mapper.JpaMapper;
import com.vhry.timeTable.common.domain.TimeTableRow;
import com.vhry.timeTable.common.port.out.TimeTableRowCrudPort;
import com.vhry.timetable.domain.TimeTableRowJpa;
import com.vhry.timetable.mapper.TimeTableRowJpaMapper;
import com.vhry.timetable.repository.TimeTableRowJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TimeTableRowJpaCrudAdapter implements TimeTableRowCrudPort {

    private final TimeTableRowJpaRepository jpaRepository;

    private final TimeTableRowJpaMapper jpaMapper;


    @Override
    public JpaRepository<TimeTableRowJpa, Long> getRepository() {
        return jpaRepository;
    }

    @Override
    public JpaMapper<TimeTableRow, TimeTableRowJpa> getJpaMapper() {
        return jpaMapper;
    }

}
