----------------------------------------------  DICTIONARIES INIT  -----------------------------------------------------

CREATE TABLE timetable.roles_dict
(
    id    BIGINT      NOT NULL PRIMARY KEY,
    value VARCHAR(15) NOT NULL,
    roleName VARCHAR(10) NOT NULL
);

CREATE TABLE timetable.university_roles_dict
(
    id    BIGINT      NOT NULL PRIMARY KEY,
    value VARCHAR(15) NOT NULL
);

CREATE TABLE timetable.lesson_types_dict
(
    id    BIGINT      NOT NULL PRIMARY KEY,
    value VARCHAR(20) NOT NULL
);

------------------------------------------------------------------------------------------------------------------------


----------------------------------------------  DICTIONARIES INSERTS  --------------------------------------------------

INSERT INTO timetable.roles_dict(id, value, roleName) VALUES (1, 'Администратор', 'ROLE_ADMIN');
INSERT INTO timetable.roles_dict(id, value, roleName) VALUES (2, 'Пользователь', 'ROLE_ISER');

INSERT INTO timetable.university_roles_dict(id, value) VALUES (1, 'Студент');
INSERT INTO timetable.university_roles_dict(id, value) VALUES (2, 'Староста');
INSERT INTO timetable.university_roles_dict(id, value) VALUES (3, 'Член профкома');
INSERT INTO timetable.university_roles_dict(id, value) VALUES (4, 'Преподаватель');
INSERT INTO timetable.university_roles_dict(id, value) VALUES (5, 'Куратор');

INSERT INTO timetable.lesson_types_dict(id, value) VALUES (1, 'Лекция');
INSERT INTO timetable.lesson_types_dict(id, value) VALUES (2, 'Лабораторная работа');
INSERT INTO timetable.lesson_types_dict(id, value) VALUES (3, 'Практическое занятие');
INSERT INTO timetable.lesson_types_dict(id, value) VALUES (4, 'Семинар');
INSERT INTO timetable.lesson_types_dict(id, value) VALUES (5, 'Экзамен');

------------------------------------------------------------------------------------------------------------------------