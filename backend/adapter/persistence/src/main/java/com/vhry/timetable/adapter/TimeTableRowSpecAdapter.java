package com.vhry.timetable.adapter;

import com.vhry.mapper.JpaMapper;
import com.vhry.timeTable.common.domain.TimeTableRow;
import com.vhry.timeTable.common.port.out.TimeTableRowSpecPort;
import com.vhry.timeTable.faculty.domain.Faculty;
import com.vhry.timeTable.group.domain.Group;
import com.vhry.timetable.domain.TimeTableRowJpa;
import com.vhry.timetable.mapper.TimeTableRowJpaMapper;
import com.vhry.timetable.repository.TimeTableRowJpaRepository;
import com.vhry.timetable.specification.TimeTableSpecifications;
import com.vhry.user.person.domain.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
public class TimeTableRowSpecAdapter implements TimeTableRowSpecPort {

    private final TimeTableRowJpaRepository jpaSpecificationExecutor;

    private final TimeTableRowJpaMapper jpaMapper;


    @Override
    public JpaSpecificationExecutor<TimeTableRowJpa> getJpaSpecificationExecutor() {
        return jpaSpecificationExecutor;
    }

    @Override
    public JpaMapper<TimeTableRow, TimeTableRowJpa> getJpaMapper() {
        return jpaMapper;
    }


    @Override
    public List<TimeTableRow> findByDate(LocalDate date) {
        return findBySpec(TimeTableSpecifications.findByDate(date));
    }

    @Override
    public List<TimeTableRow> findByDateBetween(LocalDate from, LocalDate to) {
        return findBySpec(TimeTableSpecifications.findByDateBetween(from, to));
    }

    @Override
    public List<TimeTableRow> findByFaculty(Faculty faculty) {
        return findBySpec(TimeTableSpecifications.findByFaculty(faculty.getId()));
    }

    @Override
    public List<TimeTableRow> findByDateAndFaculty(LocalDate date, Faculty faculty) {
        return findBySpec(Specification
                .where(TimeTableSpecifications.findByFaculty(faculty.getId()))
                .and(TimeTableSpecifications.findByDate(date)));
    }

    @Override
    public List<TimeTableRow> findByBetweenDateAndFaculty(LocalDate from, LocalDate to, Faculty faculty) {
        return findBySpec(Specification
                .where(TimeTableSpecifications.findByFaculty(faculty.getId()))
                .and(TimeTableSpecifications.findByDateBetween(from, to)));
    }

    @Override
    public List<TimeTableRow> findByGroup(Group group) {
        return findBySpec(TimeTableSpecifications.findByGroup(group.getId()));
    }

    @Override
    public List<TimeTableRow> findByGroupAndDate(Group group, LocalDate date) {
        return findBySpec(Specification
                .where(TimeTableSpecifications.findByGroup(group.getId()))
                .and(TimeTableSpecifications.findByDate(date)));
    }

    @Override
    public List<TimeTableRow> findByBetweenDateAndGroup(LocalDate from, LocalDate to, Group group) {
        return findBySpec(Specification
                .where(TimeTableSpecifications.findByGroup(group.getId()))
                .and(TimeTableSpecifications.findByDateBetween(from, to)));
    }

    @Override
    public List<TimeTableRow> findByStudent(Person person) {
        return findBySpec(TimeTableSpecifications.findByStudent(person.getId()));
    }

    @Override
    public List<TimeTableRow> findByStudentAndDate(Person person, LocalDate date) {
        return findBySpec(Specification
                .where(TimeTableSpecifications.findByStudent(person.getId()))
                .and(TimeTableSpecifications.findByDate(date)));
    }

    @Override
    public List<TimeTableRow> findByBetweenDateAndStudent(LocalDate from, LocalDate to, Person person) {
        return findBySpec(Specification
                .where(TimeTableSpecifications.findByStudent(person.getId()))
                .and(TimeTableSpecifications.findByDateBetween(from, to)));
    }

}
