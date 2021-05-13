DO $$
    DECLARE
    BEGIN
        INSERT INTO public.version(version_number, date_of_migration, status)
        VALUES (DEFAULT, DEFAULT, DEFAULT);
    END;
$$;