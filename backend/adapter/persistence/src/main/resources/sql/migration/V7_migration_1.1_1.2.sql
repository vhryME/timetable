DO $$
    DECLARE
    BEGIN
        call check_version_db('1.1');
        UPDATE public.version SET version_number = '1.2' WHERE version_number = '1.1';

        CREATE TABLE spell_audit (
            id BIGINT,
            spell_id BIGINT NOT NULL,
            uuid VARCHAR(255) NOT NULL,
            name VARCHAR(255) NOT NULL,
            description VARCHAR(255) NOT NULL,
            icon VARCHAR(255) NOT NULL,
            key VARCHAR(255) NOT NULL,
            mana_cost INT NOT NULL,
            cooldown FLOAT NOT NULL,
            hero_id BIGINT REFERENCES hero(id),
            revision_by TEXT DEFAULT current_user,
            revision_date TIMESTAMP DEFAULT current_timestamp,
            revision_action VARCHAR(6) NOT NULL
        );

        CREATE SEQUENCE spell_audit_id_seq START 1;
        ALTER TABLE spell_audit ALTER COLUMN id SET DEFAULT nextval('spell_audit_id_seq');

        UPDATE public.version SET date_of_migration = NOW();
        UPDATE public.version SET status = 'Успешно';
    EXCEPTION
        WHEN OTHERS THEN
            UPDATE public.version SET date_of_migration = NOW();
            UPDATE public.version SET status = 'Не успешно';
    END;
$$;