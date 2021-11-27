package com.vhry.timetable.dto.timetable.in;

import com.vhry.common.DtoInAccessor;
import com.vhry.timetable.dto.group.in.GroupDtoIn;
import com.vhry.timetable.dto.lesson.in.LessonDtoIn;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
public class TimeTableRowDtoIn extends DtoInAccessor {

    @NotNull
    @Valid
    private GroupDtoIn group;

    @NotNull
    @Valid
    private Set<LessonDtoIn> lessons;

}
