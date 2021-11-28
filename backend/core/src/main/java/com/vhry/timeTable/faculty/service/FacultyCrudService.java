package com.vhry.timeTable.faculty.service;

import com.vhry.port.out.CrudPort;
import com.vhry.timeTable.faculty.port.in.FacultyCrudUseCase;
import com.vhry.timeTable.faculty.port.out.FacultyCrudPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FacultyCrudService implements FacultyCrudUseCase {

    private final FacultyCrudPort facultyCrudPort;


    @Override
    public CrudPort getCrudPort() {
        return facultyCrudPort;
    }

}
