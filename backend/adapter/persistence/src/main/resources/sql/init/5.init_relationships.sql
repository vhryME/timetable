----------------------------------------------  RELATIONSHIPS INIT -----------------------------------------------------

CREATE TABLE timetable.persons_university_roles_relation
(
    person_id          BIGINT NOT NULL,
    university_role_id BIGINT NOT NULL,
    CONSTRAINT university_roles_persons_fkey FOREIGN KEY (person_id) REFERENCES timetable.persons (id),
    CONSTRAINT persons_university_roles_fkey FOREIGN KEY (university_role_id) REFERENCES timetable.university_roles_dict (id)
);

CREATE TABLE timetable.time_table_rows_lessons_relation
(
    time_table_row_id BIGINT NOT NULL,
    lesson_id         BIGINT NOT NULL,
    CONSTRAINT time_table_rows_lessons_fkey FOREIGN KEY (lesson_id) REFERENCES timetable.lessons (id),
    CONSTRAINT lessons_time_table_rows_fkey FOREIGN KEY (time_table_row_id) REFERENCES timetable.time_table_rows (id)
);

------------------------------------------------------------------------------------------------------------------------