package com.vhry.timetable.dto.timetable.out;

import com.vhry.common.DtoOutAccessor;
import com.vhry.timetable.dto.group.out.GroupDtoOut;
import com.vhry.timetable.dto.lesson.out.LessonDtoOut;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
public class TimeTableRowDtoOut extends DtoOutAccessor {

    @NotNull
    @Valid
    private GroupDtoOut group;

    @NotNull
    @Valid
    private Set<LessonDtoOut> lessons;

}
