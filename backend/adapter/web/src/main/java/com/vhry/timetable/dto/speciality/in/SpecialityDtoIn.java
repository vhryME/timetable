package com.vhry.timetable.dto.speciality.in;

import com.vhry.common.DtoInAccessor;
import com.vhry.timetable.dto.group.in.GroupDtoIn;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
public class SpecialityDtoIn extends DtoInAccessor {

    @NotBlank
    @Size(max = 128)
    private String name;

    @NotNull
    @Valid
    private Set<GroupDtoIn> groups;

}
