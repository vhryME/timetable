package com.vhry.timeTable.faculty.domain;

import com.vhry.domain.IdAccessorUpdated;
import com.vhry.timeTable.group.domain.Group;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
public class Speciality extends IdAccessorUpdated {

    private String name;

    private Set<Group> groups;

}
