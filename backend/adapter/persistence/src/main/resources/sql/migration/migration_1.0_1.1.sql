DO $$
    DECLARE
    BEGIN
        call check_version_db('1.0');
        UPDATE public.version SET version_number = '1.1' WHERE version_number = '1.0';

        --SOME CHANGES

        UPDATE public.version SET date_of_migration = NOW();
        UPDATE public.version SET status = 'Успешно';
EXCEPTION
        WHEN OTHERS THEN
            UPDATE public.version SET date_of_migration = NOW();
            UPDATE public.version SET status = 'Не успешно';
    END;
$$;