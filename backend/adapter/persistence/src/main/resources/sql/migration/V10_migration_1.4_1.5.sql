DO $$
    DECLARE
    BEGIN
        call check_version_db('1.4');
        UPDATE public.version SET version_number = '1.5' WHERE version_number = '1.4';


        CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

        CREATE TABLE file (
            uuid UUID PRIMARY KEY DEFAULT uuid_generate_v1(),
            root TEXT NOT NULL,
            date_of_creation TIMESTAMP NOT NULL
        );

        CREATE TYPE status AS ENUM(
            'DRAFT', 'ACTIVE', 'DELETE'
        );

        ALTER TABLE hero
        ADD COLUMN status status;

        UPDATE public.version SET date_of_migration = NOW();
        UPDATE public.version SET status = 'Успешно';
    EXCEPTION
        WHEN OTHERS THEN
            UPDATE public.version SET date_of_migration = NOW();
            UPDATE public.version SET status = 'Не успешно';
    END;
$$;
