-- ----------------------------------------------  TRIGGERS INIT ----------------------------------------------------------
--
--
-- CREATE FUNCTION timetable.audit_trigger() RETURNS TRIGGER
--     LANGUAGE plpgsql AS
-- $audit_trigger$
-- BEGIN
--     INSERT INTO timetable.event_log(object_old, object_new, operation, table_name, message)
--     VALUES (row_to_json(NEW), row_to_json(OLD), TG_OP::VARCHAR(6), TG_TABLE_NAME::VARCHAR(50),
--             TG_OP || 'ED');
--
--     IF TG_OP = 'DELETE' THEN
--         RETURN OLD;
--     ELSE
--         RETURN NEW;
--     END if;
--
-- EXCEPTION
--     WHEN OTHERS THEN
--         INSERT INTO timetable.event_log(object_old, object_new, operation, table_name, message)
--         VALUES (row_to_json(NEW), row_to_json(OLD), TG_OP::VARCHAR(6), TG_TABLE_NAME::VARCHAR(50),
--                 SQLERRM::TEXT);
--
--         IF TG_OP = 'DELETE' THEN
--             RETURN OLD;
--         ELSE
--             RETURN NEW;
--         END IF;
-- END;
-- $audit_trigger$;
--
--
-- DO
-- $$
--     DECLARE
--         tables_array CURSOR FOR
--             SELECT quote_ident(table_name) as tab_name
--             FROM information_schema.tables
--             WHERE table_schema IN ('timetable')
--               AND table_name NOT LIKE ('%_relation')
--               AND table_name NOT LIKE ('event_log');
--     BEGIN
--         FOR tabl_name IN tables_array
--             LOOP
--                 RAISE NOTICE '%', tabl_name;
--
--                 EXECUTE 'CREATE TRIGGER ' ||
--                         substring(CAST(tabl_name as VARCHAR(2000)) from 2 for
--                                   (LENGTH(CAST(tabl_name as VARCHAR(2000))) - 2)) ||
--                         '_audit_trigger BEFORE INSERT OR UPDATE OR DELETE ON timetable.' ||
--                         substring(CAST(tabl_name as VARCHAR(2000)) from 2 for
--                                   (LENGTH(CAST(tabl_name as VARCHAR(2000))) - 2)) ||
--                         ' FOR EACH ROW EXECUTE PROCEDURE timetable.audit_trigger()';
--             END LOOP;
--     END
-- $$;
--
--
CREATE FUNCTION timetable.create_person_full_name() RETURNS TRIGGER
    LANGUAGE plpgsql AS
$person_full_name$
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
$person_full_name$;

CREATE TRIGGER document_type_dictionary_trigger_after_delete
    BEFORE INSERT OR UPDATE OR DELETE
    ON timetable.persons
    FOR EACH ROW
EXECUTE PROCEDURE timetable.create_person_full_name();
--
--
-- ------------------------------------------------------------------------------------------------------------------------