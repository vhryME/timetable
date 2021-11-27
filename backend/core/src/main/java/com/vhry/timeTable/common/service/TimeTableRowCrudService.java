package com.vhry.timeTable.common.service;

import com.vhry.port.out.CrudPort;
import com.vhry.timeTable.common.port.in.TimeTableRowCrudUseCase;
import com.vhry.timeTable.common.port.out.TimeTableRowCrudPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TimeTableRowCrudService implements TimeTableRowCrudUseCase {

    private final TimeTableRowCrudPort crudPort;


    @Override
    public CrudPort getCrudPort() {
        return crudPort;
    }

}
