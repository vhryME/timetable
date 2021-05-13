CREATE TABLE version(
    version_number TEXT NOT NULL DEFAULT '1.0',
    date_of_migration DATE NOT NULL DEFAULT NOW(),
    status TEXT NOT NULL DEFAULT 'Успешно'
);