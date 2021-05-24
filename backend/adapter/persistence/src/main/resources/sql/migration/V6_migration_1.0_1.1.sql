DO $$
    DECLARE
    BEGIN
        call check_version_db('1.0');
        UPDATE public.version SET version_number = '1.1' WHERE version_number = '1.0';

        CREATE TABLE hero_history (
                                      id BIGINT PRIMARY KEY NOT NULL,
                                      hero json NOT NULL,
                                      revision_by TEXT NOT NULL,
                                      revision_timestamp TIMESTAMP NOT NULL,
                                      revision_action VARCHAR(6) NOT NULL
        );

        CREATE SEQUENCE hero_history_id_seq START 1;
        ALTER TABLE hero_history ALTER COLUMN id SET DEFAULT nextval('hero_history_id_seq');

        CREATE OR REPLACE FUNCTION hero_history_trigger() RETURNS trigger AS
        $hero_trigger$
        DECLARE
            spells json;
            talents json;
            hero_object json;
        BEGIN
            IF (TG_OP = 'DELETE') THEN
                spells := (SELECT json_agg(spell) FROM spell WHERE OLD.id = spell.hero_id);
                talents := (SELECT json_agg(hero_talent) FROM hero_talent WHERE OLD.id = hero_talent.hero_id);

                hero_object := (SELECT (to_jsonb(OLD.*) || jsonb_build_object('spells', spells) || jsonb_build_object('talents', talents)));

                INSERT INTO hero_history (hero, revision_by, revision_timestamp, revision_action)
                VALUES (hero_object, current_user, current_timestamp, 'UPDATE');

                RETURN OLD;
            ELSIF (TG_OP = 'UPDATE') THEN
                spells := (SELECT json_agg(spell) FROM spell WHERE NEW.id = spell.hero_id);
                talents := (SELECT json_agg(hero_talent) FROM hero_talent WHERE NEW.id = hero_talent.hero_id);

                hero_object := (SELECT (to_jsonb(NEW.*) || jsonb_build_object('spells', spells) || jsonb_build_object('talents', talents)));

                INSERT INTO hero_history (hero, revision_by, revision_timestamp, revision_action)
                VALUES (hero_object, current_user, current_timestamp, 'UPDATE');

                RETURN NEW;
            ELSIF (TG_OP = 'INSERT') THEN
                spells := (SELECT json_agg(spell) FROM spell WHERE NEW.id = spell.hero_id);
                talents := (SELECT json_agg(hero_talent) FROM hero_talent WHERE NEW.id = hero_talent.hero_id);

                hero_object := (SELECT (to_jsonb(NEW.*) || jsonb_build_object('spells', spells) || jsonb_build_object('talents', talents)));

                INSERT INTO hero_history (hero, revision_by, revision_timestamp, revision_action)
                VALUES (hero_object, current_user, current_timestamp, 'INSERT');
                RETURN NEW;
            END IF;

            RETURN NULL;
        END;
        $hero_trigger$
            LANGUAGE plpgsql;

        CREATE TRIGGER hero_history_trigger
            AFTER INSERT OR UPDATE OR DELETE ON hero
            FOR EACH ROW EXECUTE PROCEDURE hero_history_trigger();

        UPDATE public.version SET date_of_migration = NOW();
        UPDATE public.version SET status = 'Успешно';
    EXCEPTION
        WHEN OTHERS THEN
            UPDATE public.version SET date_of_migration = NOW();
            UPDATE public.version SET status = 'Не успешно';
    END;
$$;
