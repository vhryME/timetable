package com.vhry.common;

import com.vhry.dictionary.lessonType.LessonType;
import com.vhry.dictionary.lessonType.LessonTypeJpa;
import com.vhry.dictionary.role.Role;
import com.vhry.dictionary.role.RoleJpa;
import com.vhry.dictionary.universityRole.UniversityRole;
import com.vhry.dictionary.universityRole.UniversityRoleJpa;
import com.vhry.user.common.domain.User;
import com.vhry.timeTable.faculty.domain.Faculty;
import com.vhry.timeTable.domain.faculty.domain.FacultyJpa;
import com.vhry.timeTable.faculty.domain.Speciality;
import com.vhry.timeTable.group.domain.Group;
import com.vhry.timeTable.domain.group.domain.GroupJpa;
import com.vhry.timeTable.lesson.domain.Lesson;
import com.vhry.timeTable.domain.lesson.domain.LessonJpa;
import com.vhry.user.person.domain.Person;
import com.vhry.user.domain.person.domain.PersonJpa;
import com.vhry.timetable.domain.speciality.domain.SpecialityJpa;
import com.vhry.timeTable.common.domain.TimeTableRow;
import com.vhry.timetable.domain.TimeTableRowJpa;
import com.vhry.user.domain.UserJpa;
import org.mapstruct.*;

@MapperConfig(mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_ALL_FROM_CONFIG)
@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface MappingsJpaTemplate {

    /*----------------------------------   COMMON   -------------------------------*/
    String IN = "in";



    /*----------------------------------   DICTIONARY   -------------------------------*/
    String LESSON_TYPE_MAPPING = "lessonType";
    String ROLE_MAPPING = "role";
    String UNIVERSITY_ROLE_MAPPING = "universityRole";


    @Named(LESSON_TYPE_MAPPING)
    LessonType map(LessonTypeJpa lessonTypeJpa);

    @Named(LESSON_TYPE_MAPPING + IN)
    LessonTypeJpa map(LessonType lessonType);


    @Named(ROLE_MAPPING)
    Role map(RoleJpa roleJpa);

    @Named(ROLE_MAPPING + IN)
    RoleJpa map(Role role);


    @Named(UNIVERSITY_ROLE_MAPPING)
    UniversityRole map(UniversityRoleJpa universityRoleJpa);

    @Named(UNIVERSITY_ROLE_MAPPING + IN)
    UniversityRoleJpa map(UniversityRole universityRole);



    /*----------------------------------   ENTITIES   -------------------------------*/
    String USER_MAPPING = "user";
    String LESSON_MAPPING = "lesson";
    String PERSON_MAPPING = "person";
    String GROUP_MAPPING = "group";
    String SPECIALITY_MAPPING = "speciality";
    String FACULTY_MAPPING = "faculty";
    String TIMETABLE_MAPPING = "timetable";


    @Named(USER_MAPPING)
    @Mapping(target = "role", qualifiedByName = ROLE_MAPPING)
    User map(UserJpa universityRoleJpa);

    @Named(USER_MAPPING + IN)
    @Mapping(target = "role", qualifiedByName = ROLE_MAPPING + IN)
    UserJpa map(User universityRole);


    @Named(LESSON_MAPPING)
    @Mapping(target = "type", qualifiedByName = LESSON_TYPE_MAPPING)
    Lesson map(LessonJpa universityRoleJpa);

    @Named(LESSON_MAPPING + IN)
    @Mapping(target = "type", qualifiedByName = LESSON_TYPE_MAPPING + IN)
    LessonJpa map(Lesson universityRole);


    @Named(PERSON_MAPPING)
    @Mapping(target = "user", qualifiedByName = USER_MAPPING)
    @Mapping(target = "universityRoles", qualifiedByName = UNIVERSITY_ROLE_MAPPING)
    Person map(PersonJpa universityRoleJpa);

    @Named(PERSON_MAPPING + IN)
    @Mapping(target = "user", qualifiedByName = USER_MAPPING + IN)
    @Mapping(target = "universityRoles", qualifiedByName = UNIVERSITY_ROLE_MAPPING + IN)
    PersonJpa map(Person universityRole);


    @Named(GROUP_MAPPING)
    @Mapping(target = "curator", qualifiedByName = PERSON_MAPPING)
    @Mapping(target = "students", qualifiedByName = PERSON_MAPPING)
    Group map(GroupJpa universityRoleJpa);

    @Named(GROUP_MAPPING + IN)
    @Mapping(target = "curator", qualifiedByName = PERSON_MAPPING + IN)
    @Mapping(target = "students", qualifiedByName = PERSON_MAPPING + IN)
    GroupJpa map(Group universityRole);


    @Named(SPECIALITY_MAPPING)
    @Mapping(target = "groups", qualifiedByName = GROUP_MAPPING)
    Speciality map(SpecialityJpa universityRoleJpa);

    @Named(SPECIALITY_MAPPING + IN)
    @Mapping(target = "groups", qualifiedByName = GROUP_MAPPING + IN)
    SpecialityJpa map(Speciality universityRole);


    @Named(FACULTY_MAPPING)
    @Mapping(target = "specialities", qualifiedByName = SPECIALITY_MAPPING)
    Faculty map(FacultyJpa universityRoleJpa);

    @Named(FACULTY_MAPPING + IN)
    @Mapping(target = "specialities", qualifiedByName = SPECIALITY_MAPPING + IN)
    FacultyJpa map(Faculty universityRole);


    @Named(TIMETABLE_MAPPING)
    @Mapping(target = "group", qualifiedByName = GROUP_MAPPING)
    @Mapping(target = "lessons", qualifiedByName = LESSON_MAPPING)
    TimeTableRow map(TimeTableRowJpa universityRoleJpa);

    @Named(TIMETABLE_MAPPING + IN)
    @Mapping(target = "group", qualifiedByName = GROUP_MAPPING + IN)
    @Mapping(target = "lessons", qualifiedByName = LESSON_MAPPING + IN)
    TimeTableRowJpa map(TimeTableRow universityRole);

}
