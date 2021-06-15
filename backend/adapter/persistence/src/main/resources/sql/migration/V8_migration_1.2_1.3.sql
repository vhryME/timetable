DO $$
    DECLARE
    BEGIN
        call check_version_db('1.2');
        UPDATE public.version SET version_number = '1.3' WHERE version_number = '1.2';

        ALTER TABLE spell
        ADD COLUMN mana_cost INT DEFAULT 0,
        ADD COLUMN cooldown FLOAT DEFAULT 0.00;

        ALTER TABLE passive_talent
        RENAME COLUMN spell_id TO spell_uuid;


        ALTER TABLE passive_talent
            DROP CONSTRAINT passive_talent_spell_id_fkey,
            ALTER COLUMN spell_uuid TYPE TEXT;

        ALTER TABLE passive_talent
            ADD CONSTRAINT passive_talent_spell_uuid_fkey FOREIGN KEY (spell_uuid)
                REFERENCES spell(uuid);

        ALTER TABLE statistic
            RENAME COLUMN death TO deaths;
        ALTER TABLE statistic
            RENAME COLUMN damage_to_enemy TO damage_to_enemies;
        ALTER TABLE  statistic
            RENAME COLUMN heal_to_team_mate TO heal_to_teammate;


        UPDATE public.version SET date_of_migration = NOW();
        UPDATE public.version SET status = 'Успешно';
    EXCEPTION
        WHEN OTHERS THEN
            UPDATE public.version SET date_of_migration = NOW();
            UPDATE public.version SET status = 'Не успешно';
    END;
$$;