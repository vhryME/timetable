package com.vhry.timetable.common.dto.timetable.in;

import com.vhry.common.DtoInAccessor;
import com.vhry.timetable.common.dto.group.in.GroupDtoIn;
import com.vhry.timetable.common.dto.lesson.in.LessonDtoIn;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
public class TimeTableRowWithWorkingDaysDtoIn extends DtoInAccessor {

    @NotNull
    @Valid
    private GroupDtoIn group;

    @NotNull
    @Valid
    private Set<LessonDtoIn> monday;

    @NotNull
    @Valid
    private Set<LessonDtoIn> tuesday;

    @NotNull
    @Valid
    private Set<LessonDtoIn> wednesday;

    @NotNull
    @Valid
    private Set<LessonDtoIn> thursday;

    @NotNull
    @Valid
    private Set<LessonDtoIn> friday;

}
