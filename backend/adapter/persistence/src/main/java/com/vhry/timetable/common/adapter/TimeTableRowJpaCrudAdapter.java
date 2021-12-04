package com.vhry.timetable.common.adapter;

import com.vhry.mapper.JpaMapper;
import com.vhry.timeTable.common.domain.TimeTableRow;
import com.vhry.timeTable.common.port.out.TimeTableRowCrudPort;
import com.vhry.timetable.common.domain.TimeTableRowJpa;
import com.vhry.timetable.common.repository.TimeTableRowJpaRepository;
import com.vhry.timetable.common.mapper.TimeTableRowJpaMapper;
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
