package com.vhry.timetable.faculty.dto.out;

import com.vhry.common.DtoOutAccessor;
import com.vhry.timetable.common.dto.speciality.out.SpecialityDtoOut;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
public class FacultyDtoOut extends DtoOutAccessor {

    @NotBlank
    @Size(max = 40)
    private String name;

    @NotBlank
    @Size(max = 7)
    private String shortName;

    @NotNull
    @Valid
    private Set<SpecialityDtoOut> specialities;

}
