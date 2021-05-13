CREATE OR REPLACE PROCEDURE public.check_version_db(db_version text)
    language plpgsql
AS
$$
    DECLARE
    BEGIN
       IF NOT EXISTS (SELECT version_number FROM public.version WHERE version_number = db_version) THEN
            RAISE EXCEPTION 'Incorrect database version';
       END IF;
    END;
$$;

call check_version_db('1.0');