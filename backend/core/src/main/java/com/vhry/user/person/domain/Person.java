package com.vhry.user.person.domain;

import com.vhry.dictionary.universityRole.UniversityRole;
import com.vhry.domain.IdAccessorUpdated;
import com.vhry.user.common.domain.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
public class Person extends IdAccessorUpdated {

    private String name;

    private String surname;

    private String lastname;

    private String fullName;

    private User user;

    private Set<UniversityRole> universityRoles;

    private LocalDate admissionDate;

}
