----------------------------------------------  TABLES INIT ------------------------------------------------------------

CREATE TABLE timetable.users
(
    id         BIGINT       NOT NULL DEFAULT nextval('timetable.users_seq'::REGCLASS) PRIMARY KEY,
    username   VARCHAR(128) NOT NULL,
    email      VARCHAR(128) NOT NULL,
    role_id    BIGINT       NOT NULL,
    updated_at TIMESTAMP    NOT NULL DEFAULT current_timestamp,
    updated_by VARCHAR(128) NOT NULL DEFAULT current_user,
    CONSTRAINT users_roles_fkey FOREIGN KEY (role_id) REFERENCES timetable.roles_dict (id)
);


CREATE TABLE timetable.faculties
(
    id         BIGINT       NOT NULL DEFAULT nextval('timetable.faculties_seq'::REGCLASS) PRIMARY KEY,
    name       VARCHAR(50)  NOT NULL,
    short_name VARCHAR(7)   NOT NULL,
    updated_at TIMESTAMP    NOT NULL DEFAULT current_timestamp,
    updated_by VARCHAR(128) NOT NULL DEFAULT current_user
);

CREATE TABLE timetable.specialities
(
    id         BIGINT       NOT NULL DEFAULT nextval('timetable.specialities_seq'::REGCLASS) PRIMARY KEY,
    name       VARCHAR(70)  NOT NULL,
    short_name VARCHAR(7)   NOT NULL,
    faculty_id BIGINT       NOT NULL,
    updated_at TIMESTAMP    NOT NULL DEFAULT current_timestamp,
    updated_by VARCHAR(128) NOT NULL DEFAULT current_user,
    CONSTRAINT speciality_faculties_fkey FOREIGN KEY (faculty_id) REFERENCES timetable.faculties (id)
);

CREATE TABLE timetable.groups
(
    id            BIGINT       NOT NULL DEFAULT nextval('timetable.groups_seq'::REGCLASS) PRIMARY KEY,
    name          VARCHAR(7)   NOT NULL,
    speciality_id BIGINT       NOT NULL,
    updated_at    TIMESTAMP    NOT NULL DEFAULT current_timestamp,
    updated_by    VARCHAR(128) NOT NULL DEFAULT current_user,
    CONSTRAINT group_speciality_fkey FOREIGN KEY (speciality_id) REFERENCES timetable.specialities (id)
);

CREATE TABLE timetable.persons
(
    id             BIGINT       NOT NULL DEFAULT nextval('timetable.persons_seq'::REGCLASS) PRIMARY KEY,
    name           VARCHAR(50)  NOT NULL,
    surname        VARCHAR(50)  NOT NULL,
    lastname       VARCHAR(50)  NOT NULL,
    fullName       VARCHAR(152), --init in trigger
    admission_date TIMESTAMP    NOT NULL DEFAULT current_timestamp,
    user_id        BIGINT       NOT NULL,
    group_id       BIGINT       NOT NULL,
    updated_at     TIMESTAMP    NOT NULL DEFAULT current_timestamp,
    updated_by     VARCHAR(128) NOT NULL DEFAULT current_user,
    CONSTRAINT persons_users_fkey FOREIGN KEY (user_id) REFERENCES timetable.users (id),
    CONSTRAINT persons_groups_fkey FOREIGN KEY (group_id) REFERENCES timetable.groups (id)
);

CREATE TABLE timetable.lessons
(
    id              BIGINT       NOT NULL DEFAULT nextval('timetable.lessons_seq'::REGCLASS) PRIMARY KEY,
    name            VARCHAR(60)  NOT NULL,
    short_name      VARCHAR(5)   NOT NULL,
    date            DATE         NOT NULL DEFAULT current_timestamp,
    start_date_time TIMESTAMP    NOT NULL DEFAULT current_timestamp,
    end_date_time   TIMESTAMP    NOT NULL DEFAULT current_timestamp,
    lesson_type_id  BIGINT       NOT NULL,
    updated_at      TIMESTAMP    NOT NULL DEFAULT current_timestamp,
    updated_by      VARCHAR(128) NOT NULL DEFAULT current_user,
    CONSTRAINT lessons_lesson_types_fkey FOREIGN KEY (lesson_type_id) REFERENCES timetable.lesson_types_dict (id)
);

CREATE TABLE timetable.time_table_rows
(
    id         BIGINT       NOT NULL DEFAULT nextval('timetable.time_table_rows_seq'::REGCLASS) PRIMARY KEY,
    group_id   BIGINT       NOT NULL,
    updated_at TIMESTAMP    NOT NULL DEFAULT current_timestamp,
    updated_by VARCHAR(128) NOT NULL DEFAULT current_user,
    CONSTRAINT time_table_rows_specialities_fkey FOREIGN KEY (group_id) REFERENCES timetable.groups (id)
);

------------------------------------------------------------------------------------------------------------------------