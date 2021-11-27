package com.vhry.timetable.dto.faculty.in;

import com.vhry.common.DtoInAccessor;
import com.vhry.timetable.dto.speciality.in.SpecialityDtoIn;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
public class FacultyDtoIn extends DtoInAccessor {

    @NotBlank
    @Size(max = 40)
    private String name;

    @NotBlank
    @Size(max = 7)
    private String shortName;

    @NotNull
    @Valid
    private Set<SpecialityDtoIn> specialities;

}
