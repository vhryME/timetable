package com.vhry.common;

import com.vhry.dictionary.Dictionary;
import com.vhry.dictionary.DictionaryDtoIn;
import com.vhry.dictionary.DictionaryDtoOut;
import com.vhry.dictionary.lessonType.LessonType;
import com.vhry.dictionary.role.Role;
import com.vhry.dictionary.universityRole.UniversityRole;
import com.vhry.user.common.domain.User;
import com.vhry.timeTable.faculty.domain.Faculty;
import com.vhry.timeTable.faculty.domain.Speciality;
import com.vhry.timetable.dto.faculty.in.FacultyDtoIn;
import com.vhry.timetable.dto.speciality.in.SpecialityDtoIn;
import com.vhry.timetable.dto.faculty.out.FacultyDtoOut;
import com.vhry.timetable.dto.speciality.out.SpecialityDtoOut;
import com.vhry.timeTable.group.domain.Group;
import com.vhry.timetable.dto.group.in.GroupDtoIn;
import com.vhry.timetable.dto.group.out.GroupDtoOut;
import com.vhry.timeTable.lesson.domain.Lesson;
import com.vhry.timetable.dto.lesson.in.LessonDtoIn;
import com.vhry.timetable.dto.lesson.out.LessonDtoOut;
import com.vhry.user.person.domain.Person;
import com.vhry.user.person.dto.in.PersonDtoIn;
import com.vhry.user.person.dto.out.PersonDtoOut;
import com.vhry.timeTable.common.domain.TimeTableRow;
import com.vhry.timetable.dto.timetable.in.TimeTableRowDtoIn;
import com.vhry.timetable.dto.timetable.out.TimeTableRowDtoOut;
import com.vhry.user.common.dto.in.UserDtoIn;
import com.vhry.user.common.dto.out.UserDtoOut;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface MappingsDtoTemplate {

    /*----------------------------------   COMMON   -------------------------------*/
    String IN = "In";
    String OUT = "Out";


    /*----------------------------------   DICTIONARY   -------------------------------*/
    String ROLE_DTO_MAPPING = "roleDto";
    String UNIVERSITY_ROLE_DTO_MAPPING = "universityRoleDto";
    String LESSON_TYPE_DTO_MAPPING = "lessonTypeDto";
    String DICTIONARY_DTO_MAPPING = "dictionaryDto";


    @Named(DICTIONARY_DTO_MAPPING + IN)
    Dictionary map(DictionaryDtoIn role);


    @Named(ROLE_DTO_MAPPING + IN)
    Role fromInRole(DictionaryDtoIn dictionaryDtoIn);

    @Named(ROLE_DTO_MAPPING + OUT)
    DictionaryDtoOut map(Role role);



    @Named(UNIVERSITY_ROLE_DTO_MAPPING + IN)
    UniversityRole fromInUniversityRole(DictionaryDtoIn dictionaryDtoIn);

    @Named(UNIVERSITY_ROLE_DTO_MAPPING + OUT)
    DictionaryDtoOut map(UniversityRole universityRole);


    @Named(LESSON_TYPE_DTO_MAPPING + IN)
    LessonType fromInLessonType(DictionaryDtoIn dictionaryDtoIn);

    @Named(LESSON_TYPE_DTO_MAPPING + OUT)
    DictionaryDtoOut map(LessonType lessonType);


    /*----------------------------------   ENTITIES   -------------------------------*/
    String USER_DTO_MAPPING = "userDto";
    String LESSON_DTO_MAPPING = "lessonDto";
    String PERSON_DTO_MAPPING = "personDto";
    String GROUP_DTO_MAPPING = "groupDto";
    String SPECIALITY_DTO_MAPPING = "specialityDto";
    String FACULTY_DTO_MAPPING = "facultyDto";
    String TIMETABLE_DTO_MAPPING = "timetableDto";


    @Named(USER_DTO_MAPPING + IN)
    @Mapping(target = "role", qualifiedByName = ROLE_DTO_MAPPING + IN)
    User map(UserDtoIn universityRoleDtoIn);

    @Named(USER_DTO_MAPPING + OUT)
    @Mapping(target = "role", qualifiedByName = ROLE_DTO_MAPPING + OUT)
    UserDtoOut map(User universityRole);


    @Named(LESSON_DTO_MAPPING + IN)
    @Mapping(target = "type", qualifiedByName = LESSON_TYPE_DTO_MAPPING + IN)
    Lesson map(LessonDtoIn universityRoleDtoIn);

    @Named(LESSON_DTO_MAPPING + OUT)
    @Mapping(target = "type", qualifiedByName = LESSON_TYPE_DTO_MAPPING + OUT)
    LessonDtoOut map(Lesson universityRole);


    @Named(PERSON_DTO_MAPPING + IN)
    @Mapping(target = "user", qualifiedByName = USER_DTO_MAPPING + IN)
    @Mapping(target = "universityRoles", qualifiedByName = UNIVERSITY_ROLE_DTO_MAPPING + IN)
    Person map(PersonDtoIn universityRoleDtoIn);

    @Named(PERSON_DTO_MAPPING + OUT)
    @Mapping(target = "user", qualifiedByName = USER_DTO_MAPPING + OUT)
    @Mapping(target = "universityRoles", qualifiedByName = UNIVERSITY_ROLE_DTO_MAPPING + OUT)
    PersonDtoOut map(Person universityRole);


    @Named(GROUP_DTO_MAPPING + IN)
    @Mapping(target = "curator", qualifiedByName = PERSON_DTO_MAPPING + IN)
    @Mapping(target = "students", qualifiedByName = PERSON_DTO_MAPPING + IN)
    Group map(GroupDtoIn universityRoleDtoIn);

    @Named(GROUP_DTO_MAPPING + OUT)
    @Mapping(target = "curator", qualifiedByName = PERSON_DTO_MAPPING + OUT)
    @Mapping(target = "students", qualifiedByName = PERSON_DTO_MAPPING + OUT)
    GroupDtoOut map(Group universityRole);


    @Named(SPECIALITY_DTO_MAPPING + IN)
    @Mapping(target = "groups", qualifiedByName = GROUP_DTO_MAPPING + IN)
    Speciality map(SpecialityDtoIn universityRoleDtoIn);

    @Named(SPECIALITY_DTO_MAPPING + OUT)
    @Mapping(target = "groups", qualifiedByName = GROUP_DTO_MAPPING + OUT)
    SpecialityDtoOut map(Speciality universityRole);


    @Named(FACULTY_DTO_MAPPING + IN)
    @Mapping(target = "specialities", qualifiedByName = SPECIALITY_DTO_MAPPING + IN)
    Faculty map(FacultyDtoIn universityRoleDtoIn);

    @Named(FACULTY_DTO_MAPPING + OUT)
    @Mapping(target = "specialities", qualifiedByName = SPECIALITY_DTO_MAPPING + OUT)
    FacultyDtoOut map(Faculty universityRole);


    @Named(TIMETABLE_DTO_MAPPING + IN)
    @Mapping(target = "group", qualifiedByName = GROUP_DTO_MAPPING + IN)
    @Mapping(target = "lessons", qualifiedByName = LESSON_DTO_MAPPING + IN)
    TimeTableRow map(TimeTableRowDtoIn universityRoleDtoIn);

    @Named(TIMETABLE_DTO_MAPPING + OUT)
    @Mapping(target = "group", qualifiedByName = GROUP_DTO_MAPPING + OUT)
    @Mapping(target = "lessons", qualifiedByName = LESSON_DTO_MAPPING + OUT)
    TimeTableRowDtoOut map(TimeTableRow universityRole);

}
