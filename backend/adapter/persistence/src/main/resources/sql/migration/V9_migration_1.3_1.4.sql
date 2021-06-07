DO $$
    DECLARE
    BEGIN
        call check_version_db('1.3');
        UPDATE public.version SET version_number = '1.4' WHERE version_number = '1.3';

        CREATE OR REPLACE FUNCTION spell_audit_trigger() RETURNS trigger AS
        $spell_trigger$
        BEGIN
            IF (TG_OP = 'DELETE') THEN
                INSERT INTO spell_audit(spell_id, uuid, name, description, icon, key, mana_cost, cooldown,
                                        hero_id, revision_by, revision_date, revision_action)
                VALUES (OLD.id, OLD.uuid, OLD.name, OLD.description, OLD.icon, OLD.key, OLD.mana_cost, OLD.cooldown,
                        OLD.hero_id, current_user, current_timestamp, 'DELETE');

                RETURN OLD;
            ELSIF (TG_OP = 'UPDATE') THEN
                INSERT INTO spell_audit(spell_id, uuid, name, description, icon, key, mana_cost, cooldown,
                                        hero_id, revision_by, revision_date, revision_action)
                VALUES (NEW.id, NEW.uuid, NEW.name, NEW.description, NEW.icon, NEW.key, NEW.mana_cost, NEW.cooldown,
                        NEW.hero_id, current_user, current_timestamp, 'UPDATE');

                RETURN NEW;
            ELSIF (TG_OP = 'INSERT') THEN
                INSERT INTO spell_audit(spell_id, uuid, name, description, icon, key, mana_cost, cooldown,
                                        hero_id, revision_by, revision_date, revision_action)
                VALUES (NEW.id, NEW.uuid, NEW.name, NEW.description, NEW.icon, NEW.key, NEW.mana_cost, NEW.cooldown,
                        NEW.hero_id, current_user, current_timestamp, 'INSERT');

                RETURN NEW;
            END IF;

            RETURN NULL;
        END;
        $spell_trigger$
            LANGUAGE plpgsql;

        CREATE TRIGGER spell_audit_trigger
            AFTER INSERT OR UPDATE OR DELETE ON spell
            FOR EACH ROW EXECUTE PROCEDURE spell_audit_trigger();

        UPDATE public.version SET date_of_migration = NOW();
        UPDATE public.version SET status = 'Успешно';
    EXCEPTION
        WHEN OTHERS THEN
            UPDATE public.version SET date_of_migration = NOW();
            UPDATE public.version SET status = 'Не успешно';
    END;
$$;
