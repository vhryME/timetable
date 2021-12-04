package com.vhry.timetable.dto.group.in;

import com.vhry.common.DtoInAccessor;
import com.vhry.user.person.dto.in.PersonDtoIn;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
public class GroupDtoIn extends DtoInAccessor {

    @NotBlank
    @Size(max = 7)
    private String name;

    @NotNull
    @Valid
    private Set<PersonDtoIn> students;

}
