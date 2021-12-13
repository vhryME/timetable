package com.vhry.user.person.dto.out;

import com.vhry.common.DtoOutAccessor;
import com.vhry.dictionary.DictionaryDtoOut;
import com.vhry.timetable.common.dto.group.out.GroupDtoOut;
import com.vhry.user.common.dto.out.UserDtoOut;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
public class PersonDtoOut extends DtoOutAccessor {

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @NotBlank
    private String lastname;

    @NotBlank
    private String fullName;

    @NotNull
    @Valid
    private UserDtoOut user;

    @NotNull
    @Valid
    private Set<DictionaryDtoOut> universityRoles;

    @NotNull
    @Valid
    private GroupDtoOut group;

    @NotBlank
    private String admissionDate;

}
