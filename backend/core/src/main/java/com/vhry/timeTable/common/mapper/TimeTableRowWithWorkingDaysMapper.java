package com.vhry.timeTable.common.mapper;

import com.vhry.timeTable.common.domain.TimeTableRow;
import com.vhry.timeTable.common.domain.TimeTableRowWithWorkingDays;
import com.vhry.timeTable.lesson.domain.Lesson;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface TimeTableRowWithWorkingDaysMapper {

    default TimeTableRowWithWorkingDays convertTimeTable(TimeTableRow timeTableRow) {
        TimeTableRowWithWorkingDays timeTableRowWithWorkingDays = new TimeTableRowWithWorkingDays();
        Set<Lesson> mondayLessons = new HashSet<>();
        Set<Lesson> tuesdayLessons = new HashSet<>();
        Set<Lesson> wednesdayLessons = new HashSet<>();
        Set<Lesson> thursdayLessons = new HashSet<>();
        Set<Lesson> fridayLessons = new HashSet<>();

        timeTableRow.getLessons().forEach(lesson -> {
            switch (lesson.getDate().getDayOfWeek()) {
                case MONDAY:
                    mondayLessons.add(lesson);
                    break;

                case TUESDAY:
                    tuesdayLessons.add(lesson);
                    break;

                case WEDNESDAY:
                    wednesdayLessons.add(lesson);
                    break;

                case THURSDAY:
                    thursdayLessons.add(lesson);
                    break;

                case FRIDAY:
                    fridayLessons.add(lesson);
                    break;
            }
        });

        timeTableRowWithWorkingDays.setId(timeTableRow.getId());
        timeTableRowWithWorkingDays.setGroup(timeTableRow.getGroup());
        timeTableRowWithWorkingDays.setMonday(mondayLessons);
        timeTableRowWithWorkingDays.setTuesday(tuesdayLessons);
        timeTableRowWithWorkingDays.setWednesday(wednesdayLessons);
        timeTableRowWithWorkingDays.setThursday(thursdayLessons);
        timeTableRowWithWorkingDays.setFriday(fridayLessons);

        return timeTableRowWithWorkingDays
                .setGroup(timeTableRowWithWorkingDays.getGroup());
    }

    default List<TimeTableRowWithWorkingDays> convertTimeTable(List<TimeTableRow> timeTableRows) {
        return timeTableRows.stream().map(this::convertTimeTable).collect(Collectors.toList());
    }

}
