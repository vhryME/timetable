-- ----------------------------------------------  TRIGGERS INIT ----------------------------------------------------------

CREATE FUNCTION timetable.create_person_full_name() RETURNS TRIGGER
    LANGUAGE plpgsql AS
$person_full_name$
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
$person_full_name$;

CREATE TRIGGER document_type_dictionary_trigger_after_delete
    BEFORE INSERT OR UPDATE OR DELETE
    ON timetable.persons
    FOR EACH ROW
EXECUTE PROCEDURE timetable.create_person_full_name();
--
--
-- ------------------------------------------------------------------------------------------------------------------------