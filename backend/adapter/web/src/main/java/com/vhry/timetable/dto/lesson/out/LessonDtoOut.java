package com.vhry.timetable.dto.lesson.out;

import com.vhry.common.DtoOutAccessor;
import com.vhry.dictionary.DictionaryDtoOut;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@EqualsAndHashCode(callSuper = true)
public class LessonDtoOut extends DtoOutAccessor {

    @NotBlank
    @Size(max = 60)
    private String name;

    @NotBlank
    @Size(max = 5)
    private String shortName;

    @NotNull
    @Valid
    private DictionaryDtoOut type;

    @NotBlank
    private String date;

    @NotBlank
    private String startDateTime;

    @NotBlank
    private String endDateTime;

}
