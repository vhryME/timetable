package com.vhry.timeTable.common.domain;

import com.vhry.domain.IdAccessorUpdated;
import com.vhry.timeTable.group.domain.Group;
import com.vhry.timeTable.lesson.domain.Lesson;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
public class TimeTableRowWithWorkingDays extends IdAccessorUpdated {

    private Group group;

    private Set<Lesson> monday;

    private Set<Lesson> tuesday;

    private Set<Lesson> wednesday;

    private Set<Lesson> thursday;

    private Set<Lesson> friday;

}
