package com.vhry.timeTable.group.domain;

import com.vhry.domain.IdAccessorUpdated;
import com.vhry.user.person.domain.Person;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
public class Group extends IdAccessorUpdated {

    private String name;

    private Person curator;

    private Set<Person> students;

}
