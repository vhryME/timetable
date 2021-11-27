----------------------------------------------  UTIL TABLES INIT -------------------------------------------------------


CREATE TABLE timetable.event_log
(
    id         BIGINT       NOT NULL DEFAULT nextval('timetable.event_log_seq'::REGCLASS) PRIMARY KEY,
    object_old JSONB        NOT NULL,
    object_new JSONB        NOT NULL,
    operation  VARCHAR(6)   NOT NULL,
    table_name VARCHAR(50)  NOT NULL,
    message    TEXT         NOT NULL,
    updated_at TIMESTAMP    NOT NULL DEFAULT current_timestamp,
    updated_by VARCHAR(128) NOT NULL DEFAULT current_user
);

CREATE TABLE timetable.db_status
(
    id         BIGINT       NOT NULL DEFAULT nextval('timetable.event_log_seq'::REGCLASS) PRIMARY KEY,
    version    VARCHAR(10)  NOT NULL,
    message    TEXT         NOT NULL,
    updated_at TIMESTAMP    NOT NULL DEFAULT current_timestamp,
    updated_by VARCHAR(128) NOT NULL DEFAULT current_user
);


------------------------------------------------------------------------------------------------------------------------