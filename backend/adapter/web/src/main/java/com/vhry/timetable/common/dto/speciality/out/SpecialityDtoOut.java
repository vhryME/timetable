package com.vhry.timetable.common.dto.speciality.out;

import com.vhry.common.DtoOutAccessor;
import com.vhry.timetable.common.dto.group.out.GroupDtoOut;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
public class SpecialityDtoOut extends DtoOutAccessor {

    @NotBlank
    @Size(max = 128)
    private String name;

    @NotNull
    @Valid
    private Set<GroupDtoOut> groups;

}
