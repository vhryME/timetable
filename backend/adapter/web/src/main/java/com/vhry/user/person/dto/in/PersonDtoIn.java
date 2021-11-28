package com.vhry.user.person.dto.in;

import com.vhry.common.DtoInAccessor;
import com.vhry.dictionary.DictionaryDtoIn;
import com.vhry.timetable.dto.group.in.GroupDtoIn;
import com.vhry.user.common.dto.in.UserDtoIn;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
public class PersonDtoIn extends DtoInAccessor {

    @NotBlank
    @Size(max = 50)
    private String name;

    @NotBlank
    @Size(max = 50)
    private String surname;

    @NotBlank
    @Size(max = 50)
    private String lastname;

    @NotBlank
    @Size(max = 152)
    private String fullName;

    @NotNull
    @Valid
    private UserDtoIn user;

    @NotNull
    @Valid
    private Set<DictionaryDtoIn> universityRoles;

    @NotNull
    @Valid
    private GroupDtoIn group;

    @NotBlank
    private String admissionDate;
}
