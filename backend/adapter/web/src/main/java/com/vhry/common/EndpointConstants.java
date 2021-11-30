package com.vhry.common;

public class EndpointConstants {

    /* ---------------------------------------- COMMON ---------------------------------------------------------------*/
    public static final String TIMETABLE = "/timetables";
    public static final String API = "/api";
    public static final String TIMETABLE_PROJECT_API = TIMETABLE + API;

    /* ---------------------------------------- AUTHORIZATION --------------------------------------------------------*/
    public static final String AUTH_API = "/authorization";
    public static final String AUTH_LOGIN = "/login";
    public static final String AUTH_LOGOUT = "/logout";
    public static final String AUTH_REGISTRATION = "/registration";

    /* ---------------------------------------- DICTIONARIES ---------------------------------------------------------*/
    public static final String DICTIONARY_API = TIMETABLE_PROJECT_API + "/dictionary";

    /* ---------------------------------------- ENTITIES -------------------------------------------------------------*/
    //TIMETABLE
    public static final String TIMETABLE_API = TIMETABLE_PROJECT_API + "/timetable";
    public static final String TIMETABLE_BY_DATE = "/byDate";
    public static final String TIMETABLE_BETWEEN_DATE = "/betweenDate";
    public static final String TIMETABLE_BY_FACULTY = "/byFaculty";
    public static final String TIMETABLE_BY_FACULTY_BY_DATE = TIMETABLE_BY_FACULTY + TIMETABLE_BY_DATE;
    public static final String TIMETABLE_BY_FACULTY_BETWEEN_DATE = TIMETABLE_BY_FACULTY + TIMETABLE_BETWEEN_DATE;
    public static final String TIMETABLE_BY_GROUP = "/byGroup";
    public static final String TIMETABLE_BY_GROUP_BY_DATE = TIMETABLE_BY_GROUP + TIMETABLE_BY_DATE;
    public static final String TIMETABLE_BY_GROUP_BETWEEN_DATE = TIMETABLE_BY_GROUP + TIMETABLE_BETWEEN_DATE;
    public static final String TIMETABLE_BY_STUDENT = "/byStudent";
    public static final String TIMETABLE_BY_STUDENT_BY_DATE = TIMETABLE_BY_STUDENT + TIMETABLE_BY_DATE;
    public static final String TIMETABLE_BY_STUDENT_BETWEEN_DATE = TIMETABLE_BY_STUDENT + TIMETABLE_BETWEEN_DATE;

    //USER
    public static final String USER_API = TIMETABLE_PROJECT_API + "/user";

    //PERSON
    public static final String PERSON_API = TIMETABLE_PROJECT_API + "/person";

    //FILE
    public static final String FILE_API = TIMETABLE_PROJECT_API + "/file";
    public static final String FILE_CONTENT = "/content";

}
