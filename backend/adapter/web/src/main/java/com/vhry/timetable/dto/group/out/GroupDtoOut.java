package com.vhry.timetable.dto.group.out;

import com.vhry.common.DtoOutAccessor;
import com.vhry.user.person.dto.out.PersonDtoOut;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
public class GroupDtoOut extends DtoOutAccessor {

    @NotBlank
    @Size(max = 7)
    private String name;

    @NotNull
    @Valid
    private PersonDtoOut curator;

    @NotNull
    @Valid
    private Set<PersonDtoOut> students;

}
