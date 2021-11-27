--
-- PostgreSQL database dump
--

-- Dumped from database version 11.11
-- Dumped by pg_dump version 11.11

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: timetable; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA timetable;


ALTER SCHEMA timetable OWNER TO postgres;

--
-- Name: create_person_full_name(); Type: FUNCTION; Schema: timetable; Owner: postgres
--

CREATE FUNCTION timetable.create_person_full_name() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
DECLARE
    _fullname VARCHAR(128);
BEGIN
    IF TG_OP = 'INSERT' THEN
        IF NEW.fullname IS NOT NULL THEN
            _fullname = (NEW.name || ' ' || NEW.surname || ' ' || NEW.lastname);
            RETURN NEW;
        END IF;
    END IF;
END;
$$;


ALTER FUNCTION timetable.create_person_full_name() OWNER TO postgres;

--
-- Name: event_log_seq; Type: SEQUENCE; Schema: timetable; Owner: postgres
--

CREATE SEQUENCE timetable.event_log_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE timetable.event_log_seq OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: db_status; Type: TABLE; Schema: timetable; Owner: postgres
--

CREATE TABLE timetable.db_status (
    id bigint DEFAULT nextval('timetable.event_log_seq'::regclass) NOT NULL,
    version character varying(10) NOT NULL,
    message text NOT NULL,
    updated_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_by character varying(128) DEFAULT CURRENT_USER NOT NULL
);


ALTER TABLE timetable.db_status OWNER TO postgres;

--
-- Name: event_log; Type: TABLE; Schema: timetable; Owner: postgres
--

CREATE TABLE timetable.event_log (
    id bigint DEFAULT nextval('timetable.event_log_seq'::regclass) NOT NULL,
    object_old jsonb NOT NULL,
    object_new jsonb NOT NULL,
    operation character varying(6) NOT NULL,
    table_name character varying(50) NOT NULL,
    message text NOT NULL,
    updated_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_by character varying(128) DEFAULT CURRENT_USER NOT NULL
);


ALTER TABLE timetable.event_log OWNER TO postgres;

--
-- Name: faculties_seq; Type: SEQUENCE; Schema: timetable; Owner: postgres
--

CREATE SEQUENCE timetable.faculties_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE timetable.faculties_seq OWNER TO postgres;

--
-- Name: faculties; Type: TABLE; Schema: timetable; Owner: postgres
--

CREATE TABLE timetable.faculties (
    id bigint DEFAULT nextval('timetable.faculties_seq'::regclass) NOT NULL,
    name character varying(40) NOT NULL,
    short_name character varying(7) NOT NULL,
    updated_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_by character varying(128) DEFAULT CURRENT_USER NOT NULL
);


ALTER TABLE timetable.faculties OWNER TO postgres;

--
-- Name: groups_seq; Type: SEQUENCE; Schema: timetable; Owner: postgres
--

CREATE SEQUENCE timetable.groups_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE timetable.groups_seq OWNER TO postgres;

--
-- Name: groups; Type: TABLE; Schema: timetable; Owner: postgres
--

CREATE TABLE timetable.groups (
    id bigint DEFAULT nextval('timetable.groups_seq'::regclass) NOT NULL,
    name character varying(7) NOT NULL,
    curator_id bigint NOT NULL,
    speciality_id bigint NOT NULL,
    updated_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_by character varying(128) DEFAULT CURRENT_USER NOT NULL
);


ALTER TABLE timetable.groups OWNER TO postgres;

--
-- Name: groups_persons_relation; Type: TABLE; Schema: timetable; Owner: postgres
--

CREATE TABLE timetable.groups_persons_relation (
    group_id bigint NOT NULL,
    person_id bigint NOT NULL
);


ALTER TABLE timetable.groups_persons_relation OWNER TO postgres;

--
-- Name: lesson_types_dict; Type: TABLE; Schema: timetable; Owner: postgres
--

CREATE TABLE timetable.lesson_types_dict (
    id bigint NOT NULL,
    value character varying(20) NOT NULL
);


ALTER TABLE timetable.lesson_types_dict OWNER TO postgres;

--
-- Name: lessons_seq; Type: SEQUENCE; Schema: timetable; Owner: postgres
--

CREATE SEQUENCE timetable.lessons_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE timetable.lessons_seq OWNER TO postgres;

--
-- Name: lessons; Type: TABLE; Schema: timetable; Owner: postgres
--

CREATE TABLE timetable.lessons (
    id bigint DEFAULT nextval('timetable.lessons_seq'::regclass) NOT NULL,
    name character varying(60) NOT NULL,
    short_name character varying(5) NOT NULL,
    date date DEFAULT CURRENT_TIMESTAMP NOT NULL,
    start_date_time timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    end_date_time timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    lesson_type_id bigint NOT NULL,
    updated_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_by character varying(128) DEFAULT CURRENT_USER NOT NULL
);


ALTER TABLE timetable.lessons OWNER TO postgres;

--
-- Name: persons_seq; Type: SEQUENCE; Schema: timetable; Owner: postgres
--

CREATE SEQUENCE timetable.persons_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE timetable.persons_seq OWNER TO postgres;

--
-- Name: persons; Type: TABLE; Schema: timetable; Owner: postgres
--

CREATE TABLE timetable.persons (
    id bigint DEFAULT nextval('timetable.persons_seq'::regclass) NOT NULL,
    name character varying(50) NOT NULL,
    surname character varying(50) NOT NULL,
    lastname character varying(50) NOT NULL,
    fullname character varying(152),
    admission_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    user_id bigint NOT NULL,
    updated_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_by character varying(128) DEFAULT CURRENT_USER NOT NULL
);


ALTER TABLE timetable.persons OWNER TO postgres;

--
-- Name: persons_university_roles_relation; Type: TABLE; Schema: timetable; Owner: postgres
--

CREATE TABLE timetable.persons_university_roles_relation (
    person_id bigint NOT NULL,
    university_role_id bigint NOT NULL
);


ALTER TABLE timetable.persons_university_roles_relation OWNER TO postgres;

--
-- Name: roles_dict; Type: TABLE; Schema: timetable; Owner: postgres
--

CREATE TABLE timetable.roles_dict (
    id bigint NOT NULL,
    value character varying(15) NOT NULL,
    rolename character varying(10) NOT NULL
);


ALTER TABLE timetable.roles_dict OWNER TO postgres;

--
-- Name: specialities_seq; Type: SEQUENCE; Schema: timetable; Owner: postgres
--

CREATE SEQUENCE timetable.specialities_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE timetable.specialities_seq OWNER TO postgres;

--
-- Name: specialities; Type: TABLE; Schema: timetable; Owner: postgres
--

CREATE TABLE timetable.specialities (
    id bigint DEFAULT nextval('timetable.specialities_seq'::regclass) NOT NULL,
    name character varying(40) NOT NULL,
    faculty_id bigint NOT NULL,
    updated_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_by character varying(128) DEFAULT CURRENT_USER NOT NULL
);


ALTER TABLE timetable.specialities OWNER TO postgres;

--
-- Name: time_table_rows_seq; Type: SEQUENCE; Schema: timetable; Owner: postgres
--

CREATE SEQUENCE timetable.time_table_rows_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE timetable.time_table_rows_seq OWNER TO postgres;

--
-- Name: time_table_rows; Type: TABLE; Schema: timetable; Owner: postgres
--

CREATE TABLE timetable.time_table_rows (
    id bigint DEFAULT nextval('timetable.time_table_rows_seq'::regclass) NOT NULL,
    group_id bigint NOT NULL,
    updated_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_by character varying(128) DEFAULT CURRENT_USER NOT NULL
);


ALTER TABLE timetable.time_table_rows OWNER TO postgres;

--
-- Name: time_table_rows_lessons_relation; Type: TABLE; Schema: timetable; Owner: postgres
--

CREATE TABLE timetable.time_table_rows_lessons_relation (
    time_table_row_id bigint NOT NULL,
    lesson_id bigint NOT NULL
);


ALTER TABLE timetable.time_table_rows_lessons_relation OWNER TO postgres;

--
-- Name: university_roles_dict; Type: TABLE; Schema: timetable; Owner: postgres
--

CREATE TABLE timetable.university_roles_dict (
    id bigint NOT NULL,
    value character varying(15) NOT NULL
);


ALTER TABLE timetable.university_roles_dict OWNER TO postgres;

--
-- Name: users_seq; Type: SEQUENCE; Schema: timetable; Owner: postgres
--

CREATE SEQUENCE timetable.users_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE timetable.users_seq OWNER TO postgres;

--
-- Name: users; Type: TABLE; Schema: timetable; Owner: postgres
--

CREATE TABLE timetable.users (
    id bigint DEFAULT nextval('timetable.users_seq'::regclass) NOT NULL,
    username character varying(128) NOT NULL,
    email character varying(128) NOT NULL,
    role_id bigint NOT NULL,
    updated_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_by character varying(128) DEFAULT CURRENT_USER NOT NULL
);


ALTER TABLE timetable.users OWNER TO postgres;

--
-- Data for Name: db_status; Type: TABLE DATA; Schema: timetable; Owner: postgres
--

COPY timetable.db_status (id, version, message, updated_at, updated_by) FROM stdin;
\.


--
-- Data for Name: event_log; Type: TABLE DATA; Schema: timetable; Owner: postgres
--

COPY timetable.event_log (id, object_old, object_new, operation, table_name, message, updated_at, updated_by) FROM stdin;
\.


--
-- Data for Name: faculties; Type: TABLE DATA; Schema: timetable; Owner: postgres
--

COPY timetable.faculties (id, name, short_name, updated_at, updated_by) FROM stdin;
1	string	string	2021-11-25 17:39:19.698873	postgres
\.


--
-- Data for Name: groups; Type: TABLE DATA; Schema: timetable; Owner: postgres
--

COPY timetable.groups (id, name, curator_id, speciality_id, updated_at, updated_by) FROM stdin;
1	string	1	1	2021-11-25 17:39:45.293035	postgres
\.


--
-- Data for Name: groups_persons_relation; Type: TABLE DATA; Schema: timetable; Owner: postgres
--

COPY timetable.groups_persons_relation (group_id, person_id) FROM stdin;
1	2
1	2
\.


--
-- Data for Name: lesson_types_dict; Type: TABLE DATA; Schema: timetable; Owner: postgres
--

COPY timetable.lesson_types_dict (id, value) FROM stdin;
1	Лекция
2	Лабораторная работа
3	Практическое занятие
4	Семинар
5	Экзамен
\.


--
-- Data for Name: lessons; Type: TABLE DATA; Schema: timetable; Owner: postgres
--

COPY timetable.lessons (id, name, short_name, date, start_date_time, end_date_time, lesson_type_id, updated_at, updated_by) FROM stdin;
1	string	str	2021-11-25	2021-11-25 20:40:36	2021-11-25 20:40:37	1	2021-11-25 17:40:47.542667	postgres
\.


--
-- Data for Name: persons; Type: TABLE DATA; Schema: timetable; Owner: postgres
--

COPY timetable.persons (id, name, surname, lastname, fullname, admission_date, user_id, updated_at, updated_by) FROM stdin;
1	string	string	string	string	2021-11-25 20:38:00	1	2021-11-25 17:38:49.955004	postgres
2	string	string	string	string	2021-11-26 20:40:00	2	2021-11-25 17:40:15.876773	postgres
\.


--
-- Data for Name: persons_university_roles_relation; Type: TABLE DATA; Schema: timetable; Owner: postgres
--

COPY timetable.persons_university_roles_relation (person_id, university_role_id) FROM stdin;
2	1
1	4
2	1
1	4
\.


--
-- Data for Name: roles_dict; Type: TABLE DATA; Schema: timetable; Owner: postgres
--

COPY timetable.roles_dict (id, value, rolename) FROM stdin;
1	Администратор	ROLE_ADMIN
2	Пользователь	ROLE_ISER
\.


--
-- Data for Name: specialities; Type: TABLE DATA; Schema: timetable; Owner: postgres
--

COPY timetable.specialities (id, name, faculty_id, updated_at, updated_by) FROM stdin;
1	string	1	2021-11-25 17:39:29.305126	postgres
\.


--
-- Data for Name: time_table_rows; Type: TABLE DATA; Schema: timetable; Owner: postgres
--

COPY timetable.time_table_rows (id, group_id, updated_at, updated_by) FROM stdin;
1	1	2021-11-25 17:42:06.06394	postgres
2	1	2021-11-25 20:49:21.452463	postgres
3	1	2021-11-25 20:51:16.538216	postgres
\.


--
-- Data for Name: time_table_rows_lessons_relation; Type: TABLE DATA; Schema: timetable; Owner: postgres
--

COPY timetable.time_table_rows_lessons_relation (time_table_row_id, lesson_id) FROM stdin;
1	1
1	1
2	1
3	1
\.


--
-- Data for Name: university_roles_dict; Type: TABLE DATA; Schema: timetable; Owner: postgres
--

COPY timetable.university_roles_dict (id, value) FROM stdin;
1	Студент
2	Староста
3	Член профкома
4	Преподаватель
\.


--
-- Data for Name: users; Type: TABLE DATA; Schema: timetable; Owner: postgres
--

COPY timetable.users (id, username, email, role_id, updated_at, updated_by) FROM stdin;
1	string	string@mail.ru	1	2021-11-25 17:38:47.086809	postgres
2	string	string@mail.ru	2	2021-11-25 17:38:47.086809	postgres
\.


--
-- Name: event_log_seq; Type: SEQUENCE SET; Schema: timetable; Owner: postgres
--

SELECT pg_catalog.setval('timetable.event_log_seq', 1, false);


--
-- Name: faculties_seq; Type: SEQUENCE SET; Schema: timetable; Owner: postgres
--

SELECT pg_catalog.setval('timetable.faculties_seq', 1, false);


--
-- Name: groups_seq; Type: SEQUENCE SET; Schema: timetable; Owner: postgres
--

SELECT pg_catalog.setval('timetable.groups_seq', 1, false);


--
-- Name: lessons_seq; Type: SEQUENCE SET; Schema: timetable; Owner: postgres
--

SELECT pg_catalog.setval('timetable.lessons_seq', 1, false);


--
-- Name: persons_seq; Type: SEQUENCE SET; Schema: timetable; Owner: postgres
--

SELECT pg_catalog.setval('timetable.persons_seq', 1, false);


--
-- Name: specialities_seq; Type: SEQUENCE SET; Schema: timetable; Owner: postgres
--

SELECT pg_catalog.setval('timetable.specialities_seq', 1, false);


--
-- Name: time_table_rows_seq; Type: SEQUENCE SET; Schema: timetable; Owner: postgres
--

SELECT pg_catalog.setval('timetable.time_table_rows_seq', 3, true);


--
-- Name: users_seq; Type: SEQUENCE SET; Schema: timetable; Owner: postgres
--

SELECT pg_catalog.setval('timetable.users_seq', 26, true);


--
-- Name: db_status db_status_pkey; Type: CONSTRAINT; Schema: timetable; Owner: postgres
--

ALTER TABLE ONLY timetable.db_status
    ADD CONSTRAINT db_status_pkey PRIMARY KEY (id);


--
-- Name: event_log event_log_pkey; Type: CONSTRAINT; Schema: timetable; Owner: postgres
--

ALTER TABLE ONLY timetable.event_log
    ADD CONSTRAINT event_log_pkey PRIMARY KEY (id);


--
-- Name: faculties faculties_pkey; Type: CONSTRAINT; Schema: timetable; Owner: postgres
--

ALTER TABLE ONLY timetable.faculties
    ADD CONSTRAINT faculties_pkey PRIMARY KEY (id);


--
-- Name: groups groups_pkey; Type: CONSTRAINT; Schema: timetable; Owner: postgres
--

ALTER TABLE ONLY timetable.groups
    ADD CONSTRAINT groups_pkey PRIMARY KEY (id);


--
-- Name: lesson_types_dict lesson_types_dict_pkey; Type: CONSTRAINT; Schema: timetable; Owner: postgres
--

ALTER TABLE ONLY timetable.lesson_types_dict
    ADD CONSTRAINT lesson_types_dict_pkey PRIMARY KEY (id);


--
-- Name: lessons lessons_pkey; Type: CONSTRAINT; Schema: timetable; Owner: postgres
--

ALTER TABLE ONLY timetable.lessons
    ADD CONSTRAINT lessons_pkey PRIMARY KEY (id);


--
-- Name: persons persons_pkey; Type: CONSTRAINT; Schema: timetable; Owner: postgres
--

ALTER TABLE ONLY timetable.persons
    ADD CONSTRAINT persons_pkey PRIMARY KEY (id);


--
-- Name: roles_dict roles_dict_pkey; Type: CONSTRAINT; Schema: timetable; Owner: postgres
--

ALTER TABLE ONLY timetable.roles_dict
    ADD CONSTRAINT roles_dict_pkey PRIMARY KEY (id);


--
-- Name: specialities specialities_pkey; Type: CONSTRAINT; Schema: timetable; Owner: postgres
--

ALTER TABLE ONLY timetable.specialities
    ADD CONSTRAINT specialities_pkey PRIMARY KEY (id);


--
-- Name: time_table_rows time_table_rows_pkey; Type: CONSTRAINT; Schema: timetable; Owner: postgres
--

ALTER TABLE ONLY timetable.time_table_rows
    ADD CONSTRAINT time_table_rows_pkey PRIMARY KEY (id);


--
-- Name: university_roles_dict university_roles_dict_pkey; Type: CONSTRAINT; Schema: timetable; Owner: postgres
--

ALTER TABLE ONLY timetable.university_roles_dict
    ADD CONSTRAINT university_roles_dict_pkey PRIMARY KEY (id);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: timetable; Owner: postgres
--

ALTER TABLE ONLY timetable.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- Name: persons document_type_dictionary_trigger_after_delete; Type: TRIGGER; Schema: timetable; Owner: postgres
--

CREATE TRIGGER document_type_dictionary_trigger_after_delete BEFORE INSERT OR DELETE OR UPDATE ON timetable.persons FOR EACH ROW EXECUTE PROCEDURE timetable.create_person_full_name();


--
-- Name: groups group_persons_fkey; Type: FK CONSTRAINT; Schema: timetable; Owner: postgres
--

ALTER TABLE ONLY timetable.groups
    ADD CONSTRAINT group_persons_fkey FOREIGN KEY (curator_id) REFERENCES timetable.persons(id);


--
-- Name: groups group_speciality_fkey; Type: FK CONSTRAINT; Schema: timetable; Owner: postgres
--

ALTER TABLE ONLY timetable.groups
    ADD CONSTRAINT group_speciality_fkey FOREIGN KEY (speciality_id) REFERENCES timetable.specialities(id);


--
-- Name: groups_persons_relation groups_persons_fkey; Type: FK CONSTRAINT; Schema: timetable; Owner: postgres
--

ALTER TABLE ONLY timetable.groups_persons_relation
    ADD CONSTRAINT groups_persons_fkey FOREIGN KEY (person_id) REFERENCES timetable.persons(id);


--
-- Name: lessons lessons_lesson_types_fkey; Type: FK CONSTRAINT; Schema: timetable; Owner: postgres
--

ALTER TABLE ONLY timetable.lessons
    ADD CONSTRAINT lessons_lesson_types_fkey FOREIGN KEY (lesson_type_id) REFERENCES timetable.lesson_types_dict(id);


--
-- Name: time_table_rows_lessons_relation lessons_time_table_rows_fkey; Type: FK CONSTRAINT; Schema: timetable; Owner: postgres
--

ALTER TABLE ONLY timetable.time_table_rows_lessons_relation
    ADD CONSTRAINT lessons_time_table_rows_fkey FOREIGN KEY (time_table_row_id) REFERENCES timetable.time_table_rows(id);


--
-- Name: groups_persons_relation persons_groups_fkey; Type: FK CONSTRAINT; Schema: timetable; Owner: postgres
--

ALTER TABLE ONLY timetable.groups_persons_relation
    ADD CONSTRAINT persons_groups_fkey FOREIGN KEY (group_id) REFERENCES timetable.groups(id);


--
-- Name: persons_university_roles_relation persons_university_roles_fkey; Type: FK CONSTRAINT; Schema: timetable; Owner: postgres
--

ALTER TABLE ONLY timetable.persons_university_roles_relation
    ADD CONSTRAINT persons_university_roles_fkey FOREIGN KEY (university_role_id) REFERENCES timetable.university_roles_dict(id);


--
-- Name: persons persons_users_fkey; Type: FK CONSTRAINT; Schema: timetable; Owner: postgres
--

ALTER TABLE ONLY timetable.persons
    ADD CONSTRAINT persons_users_fkey FOREIGN KEY (user_id) REFERENCES timetable.users(id);


--
-- Name: specialities speciality_faculties_fkey; Type: FK CONSTRAINT; Schema: timetable; Owner: postgres
--

ALTER TABLE ONLY timetable.specialities
    ADD CONSTRAINT speciality_faculties_fkey FOREIGN KEY (faculty_id) REFERENCES timetable.faculties(id);


--
-- Name: time_table_rows_lessons_relation time_table_rows_lessons_fkey; Type: FK CONSTRAINT; Schema: timetable; Owner: postgres
--

ALTER TABLE ONLY timetable.time_table_rows_lessons_relation
    ADD CONSTRAINT time_table_rows_lessons_fkey FOREIGN KEY (lesson_id) REFERENCES timetable.lessons(id);


--
-- Name: time_table_rows time_table_rows_specialities_fkey; Type: FK CONSTRAINT; Schema: timetable; Owner: postgres
--

ALTER TABLE ONLY timetable.time_table_rows
    ADD CONSTRAINT time_table_rows_specialities_fkey FOREIGN KEY (group_id) REFERENCES timetable.groups(id);


--
-- Name: persons_university_roles_relation university_roles_persons_fkey; Type: FK CONSTRAINT; Schema: timetable; Owner: postgres
--

ALTER TABLE ONLY timetable.persons_university_roles_relation
    ADD CONSTRAINT university_roles_persons_fkey FOREIGN KEY (person_id) REFERENCES timetable.persons(id);


--
-- Name: users users_roles_fkey; Type: FK CONSTRAINT; Schema: timetable; Owner: postgres
--

ALTER TABLE ONLY timetable.users
    ADD CONSTRAINT users_roles_fkey FOREIGN KEY (role_id) REFERENCES timetable.roles_dict(id);


--
-- PostgreSQL database dump complete
--

