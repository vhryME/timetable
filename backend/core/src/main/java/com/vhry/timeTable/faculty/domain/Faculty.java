package com.vhry.timeTable.faculty.domain;

import com.vhry.domain.IdAccessorUpdated;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
public class Faculty extends IdAccessorUpdated {

    private String name;

    private String shortName;

    private Set<Speciality> specialities;

}
