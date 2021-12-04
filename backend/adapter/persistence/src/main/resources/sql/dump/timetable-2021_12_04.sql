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
BEGIN
    IF TG_OP = 'INSERT' THEN
        IF NEW.fullname IS NULL THEN
            NEW.fullname = (NEW.name || ' ' || NEW.surname || ' ' || NEW.lastname);
            RETURN NEW;
        END IF;

        RETURN NEW;
    END IF;

    RETURN NULL;
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
    name character varying(50) NOT NULL,
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
    speciality_id bigint NOT NULL,
    updated_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_by character varying(128) DEFAULT CURRENT_USER NOT NULL
);


ALTER TABLE timetable.groups OWNER TO postgres;

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
    group_id bigint NOT NULL,
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
    name character varying(70) NOT NULL,
    short_name character varying(7) NOT NULL,
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
1	Факультет электронно-информационных систем	ФЭИС	2021-12-04 11:22:24.957525	postgres
2	Факультет инженерных систем и экологии	ФИСиЭ	2021-12-04 11:22:24.957525	postgres
3	Экономический факультет	ЭФ	2021-12-04 11:22:24.957525	postgres
4	Машиностроительный факультет	МФ	2021-12-04 11:22:24.957525	postgres
\.


--
-- Data for Name: groups; Type: TABLE DATA; Schema: timetable; Owner: postgres
--

COPY timetable.groups (id, name, speciality_id, updated_at, updated_by) FROM stdin;
1	ВИСиС	1	2021-12-04 11:22:24.957525	postgres
2	АСОИ	2	2021-12-04 11:22:24.957525	postgres
3	ИИ	3	2021-12-04 11:22:24.957525	postgres
4	ПЭ	4	2021-12-04 11:22:24.957525	postgres
5	МС	5	2021-12-04 11:22:24.957525	postgres
6	ПО	6	2021-12-04 11:22:24.957525	postgres
7	ВВиОВР	7	2021-12-04 11:22:24.957525	postgres
8	МиВХ	8	2021-12-04 11:22:24.957525	postgres
9	ТВиОВБ	9	2021-12-04 11:22:24.957525	postgres
10	ПД	10	2021-12-04 11:22:24.957525	postgres
11	МРиОЗ	11	2021-12-04 11:22:24.957525	postgres
12	Э	12	2021-12-04 11:22:24.957525	postgres
13	М	13	2021-12-04 11:22:24.957525	postgres
14	БУАиА	14	2021-12-04 11:22:24.957525	postgres
15	ФиК	15	2021-12-04 11:22:24.957525	postgres
16	ЭиУНП	16	2021-12-04 11:22:24.957525	postgres
17	Л	17	2021-12-04 11:22:24.957525	postgres
18	ЭМ	18	2021-12-04 11:22:24.957525	postgres
19	ЭЭБ	19	2021-12-04 11:22:24.957525	postgres
20	ТМ	20	2021-12-04 11:22:24.957525	postgres
21	ТОМП	21	2021-12-04 11:22:24.957525	postgres
22	АТПИП	22	2021-12-04 11:22:24.957525	postgres
23	А	23	2021-12-04 11:22:24.957525	postgres
24	МиАПП	24	2021-12-04 11:22:24.957525	postgres
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
1	Тестовое занятие 1	ТЗ	2021-12-04	2021-12-04 14:56:28	2021-12-04 14:57:30	1	2021-12-04 14:56:28	postgres
2	Тестовое занятие 1	ТЗ	2021-12-04	2021-12-04 14:57:28	2021-12-04 14:58:30	2	2021-12-04 14:57:28	postgres
3	Тестовое занятие 1	ТЗ	2021-12-04	2021-12-04 14:58:28	2021-12-04 14:59:30	3	2021-12-04 14:58:28	postgres
4	Тестовое занятие 1	ТЗ	2021-12-04	2021-12-04 14:59:28	2021-12-04 15:00:30	4	2021-12-04 14:59:28	postgres
5	Тестовое занятие 1	ТЗ	2021-12-04	2021-12-04 15:00:28	2021-12-04 15:01:30	5	2021-12-04 15:00:28	postgres
6	Тестовое занятие 1	ТЗ	2021-12-04	2021-12-04 15:01:28	2021-12-04 15:02:30	1	2021-12-04 15:01:28	postgres
7	Тестовое занятие 1	ТЗ	2021-12-04	2021-12-04 15:02:28	2021-12-04 15:03:30	2	2021-12-04 15:02:28	postgres
8	Тестовое занятие 1	ТЗ	2021-12-04	2021-12-04 15:03:28	2021-12-04 15:04:30	3	2021-12-04 15:03:28	postgres
9	Тестовое занятие 1	ТЗ	2021-12-04	2021-12-04 15:04:28	2021-12-04 15:05:30	4	2021-12-04 15:04:28	postgres
10	Тестовое занятие 1	ТЗ	2021-12-04	2021-12-04 15:05:28	2021-12-04 15:06:30	1	2021-12-04 11:56:41.536924	postgres
11	Тестовое занятие 1	ТЗ	2021-12-04	2021-12-04 15:06:28	2021-12-04 15:07:30	2	2021-12-04 11:56:41.536924	postgres
12	Тестовое занятие 1	ТЗ	2021-12-04	2021-12-04 15:07:28	2021-12-04 15:08:30	3	2021-12-04 11:56:41.536924	postgres
13	Тестовое занятие 1	ТЗ	2021-12-04	2021-12-04 15:08:28	2021-12-04 15:09:30	4	2021-12-04 11:56:41.536924	postgres
\.


--
-- Data for Name: persons; Type: TABLE DATA; Schema: timetable; Owner: postgres
--

COPY timetable.persons (id, name, surname, lastname, fullname, admission_date, user_id, group_id, updated_at, updated_by) FROM stdin;
1	Виталий	Грицук	Вячеславович	Виталий Грицук Вячеславович	2021-12-04 14:49:48	1000001	1	2021-12-04 11:22:24.957525	postgres
2	Юрий	Махнолов	Георгиевич	Юрий Махнолов Георгиевич	2021-12-04 14:49:48	1000002	1	2021-12-04 11:22:24.957525	postgres
3	Атрохов	Дмитрий	Сергеевич	Атрохов Дмитрий Сергеевич	2021-12-04 14:49:48	1000003	1	2021-12-04 11:22:24.957525	postgres
4	Аршинов	Никита	Андреевич	Аршинов Никита Андреевич	2021-12-04 14:49:48	1000004	1	2021-12-04 11:22:24.957525	postgres
\.


--
-- Data for Name: persons_university_roles_relation; Type: TABLE DATA; Schema: timetable; Owner: postgres
--

COPY timetable.persons_university_roles_relation (person_id, university_role_id) FROM stdin;
1	4
2	1
3	1
4	1
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

COPY timetable.specialities (id, name, short_name, faculty_id, updated_at, updated_by) FROM stdin;
1	Вычислительные машины, системы и сети	ВИСиС	1	2021-12-04 11:22:24.957525	postgres
2	Автоматизированные системы обработки информации	АСОИ	1	2021-12-04 11:22:24.957525	postgres
3	Искусственный интеллект	ИИ	1	2021-12-04 11:22:24.957525	postgres
4	Промышленная электроника	ПЭ	1	2021-12-04 11:22:24.957525	postgres
5	Программируемые мобильные системы	МС	1	2021-12-04 11:22:24.957525	postgres
6	Программное обеспечение информационных технологий	ПО	1	2021-12-04 11:22:24.957525	postgres
7	Водоснабжение, водоотведение и охрана водных ресурсов	ВВиОВР	2	2021-12-04 11:22:24.957525	postgres
8	Мелиорация и водное хозяйство	МиВХ	2	2021-12-04 11:22:24.957525	postgres
9	Теплогазоснабжение, вентиляция и охрана воздушного бассейна	ТВиОВБ	2	2021-12-04 11:22:24.957525	postgres
10	Природоохранная деятельность	ПД	2	2021-12-04 11:22:24.957525	postgres
11	Мелиорация, рекультивация и охрана земель	МРиОЗ	2	2021-12-04 11:22:24.957525	postgres
12	Экология	Э	2	2021-12-04 11:22:24.957525	postgres
13	Маркетинг	М	3	2021-12-04 11:22:24.957525	postgres
14	Бухгалтерский учет, анализ и аудит	БУАиА	3	2021-12-04 11:22:24.957525	postgres
15	Финансы и кредит	ФиК	3	2021-12-04 11:22:24.957525	postgres
16	Экономика и управление на предприятии	ЭиУНП	3	2021-12-04 11:22:24.957525	postgres
17	Логистика	Л	3	2021-12-04 11:22:24.957525	postgres
18	Электронный маркетинг	ЭМ	3	2021-12-04 11:22:24.957525	postgres
19	Экономика электронного бизнеса	ЭЭБ	3	2021-12-04 11:22:24.957525	postgres
20	Технология машиностроения	ТМ	4	2021-12-04 11:22:24.957525	postgres
21	Технологическое оборудование машиностроительного производства	ТОМП	4	2021-12-04 11:22:24.957525	postgres
22	Автоматизация технологических процессов и производств	АТПИП	4	2021-12-04 11:22:24.957525	postgres
23	Автосервис	А	4	2021-12-04 11:22:24.957525	postgres
24	Машины и аппараты пищевых производств	МиАПП	4	2021-12-04 11:22:24.957525	postgres
\.


--
-- Data for Name: time_table_rows; Type: TABLE DATA; Schema: timetable; Owner: postgres
--

COPY timetable.time_table_rows (id, group_id, updated_at, updated_by) FROM stdin;
1	1	2021-12-04 11:22:24.957525	postgres
2	2	2021-12-04 11:22:24.957525	postgres
3	3	2021-12-04 11:22:24.957525	postgres
4	4	2021-12-04 11:22:24.957525	postgres
5	5	2021-12-04 11:22:24.957525	postgres
6	6	2021-12-04 11:22:24.957525	postgres
7	7	2021-12-04 11:22:24.957525	postgres
8	8	2021-12-04 11:22:24.957525	postgres
9	9	2021-12-04 11:22:24.957525	postgres
10	10	2021-12-04 11:22:24.957525	postgres
11	11	2021-12-04 11:22:24.957525	postgres
12	12	2021-12-04 11:22:24.957525	postgres
13	13	2021-12-04 11:22:24.957525	postgres
14	14	2021-12-04 11:22:24.957525	postgres
15	15	2021-12-04 11:22:24.957525	postgres
16	16	2021-12-04 11:22:24.957525	postgres
17	17	2021-12-04 11:22:24.957525	postgres
18	18	2021-12-04 11:22:24.957525	postgres
19	19	2021-12-04 11:22:24.957525	postgres
20	20	2021-12-04 11:22:24.957525	postgres
21	21	2021-12-04 11:22:24.957525	postgres
22	22	2021-12-04 11:22:24.957525	postgres
23	23	2021-12-04 11:22:24.957525	postgres
24	24	2021-12-04 11:22:24.957525	postgres
\.


--
-- Data for Name: time_table_rows_lessons_relation; Type: TABLE DATA; Schema: timetable; Owner: postgres
--

COPY timetable.time_table_rows_lessons_relation (time_table_row_id, lesson_id) FROM stdin;
1	1
1	2
1	3
1	4
1	5
1	6
2	7
2	8
2	9
2	10
2	11
2	12
2	13
\.


--
-- Data for Name: university_roles_dict; Type: TABLE DATA; Schema: timetable; Owner: postgres
--

COPY timetable.university_roles_dict (id, value) FROM stdin;
1	Студент
2	Староста
3	Член профкома
4	Преподаватель
5	Куратор
\.


--
-- Data for Name: users; Type: TABLE DATA; Schema: timetable; Owner: postgres
--

COPY timetable.users (id, username, email, role_id, updated_at, updated_by) FROM stdin;
1000001	grits.0123@gmail.com	grits.0123@gmail.com	1	2021-11-30 15:24:04.249881	postgres
1000002	qwerty@gmail.com	qwerty@gmail.com	2	2021-11-30 15:24:04.249881	postgres
1000003	sasasa@gmail.com	sasasa@gmail.com	1	2021-11-30 15:24:04.249881	postgres
1000004	mail@gmail.com	mail@gmail.com	2	2021-11-30 15:24:04.249881	postgres
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

SELECT pg_catalog.setval('timetable.time_table_rows_seq', 1, false);


--
-- Name: users_seq; Type: SEQUENCE SET; Schema: timetable; Owner: postgres
--

SELECT pg_catalog.setval('timetable.users_seq', 1, true);


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
-- Name: groups group_speciality_fkey; Type: FK CONSTRAINT; Schema: timetable; Owner: postgres
--

ALTER TABLE ONLY timetable.groups
    ADD CONSTRAINT group_speciality_fkey FOREIGN KEY (speciality_id) REFERENCES timetable.specialities(id);


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
-- Name: persons persons_groups_fkey; Type: FK CONSTRAINT; Schema: timetable; Owner: postgres
--

ALTER TABLE ONLY timetable.persons
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

