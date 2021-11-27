package com.vhry.timetable.dto.lesson.in;

import com.vhry.common.DtoInAccessor;
import com.vhry.dictionary.DictionaryDtoIn;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@EqualsAndHashCode(callSuper = true)
public class LessonDtoIn extends DtoInAccessor {

    @NotBlank
    @Size(max = 60)
    private String name;

    @NotBlank
//    @Size(max = 5)
    private String shortName;

    @NotNull
    @Valid
    private DictionaryDtoIn type;

    @NotBlank
    private String date;

    @NotBlank
    private String startDateTime;

    @NotBlank
    private String endDateTime;

}
