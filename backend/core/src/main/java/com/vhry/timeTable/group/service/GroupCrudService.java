package com.vhry.timeTable.group.service;

import com.vhry.port.out.CrudPort;
import com.vhry.timeTable.group.port.in.GroupCrudUseCase;
import com.vhry.timeTable.group.port.out.GroupCrudPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GroupCrudService implements GroupCrudUseCase {

    private final GroupCrudPort crudPort;


    @Override
    public CrudPort getCrudPort() {
        return crudPort;
    }

}
