CREATE TABLE role(
    id BIGINT PRIMARY KEY,
    role VARCHAR(255) NOT NULL
);

CREATE TABLE map(
    id BIGINT PRIMARY KEY,
    map VARCHAR(255) NOT NULL
);

CREATE TABLE region(
    id BIGINT PRIMARY KEY,
    region VARCHAR(255) NOT NULL
);

CREATE TABLE type(
    id BIGINT PRIMARY KEY,
    type VARCHAR(255) NOT NULL
);

CREATE TABLE hero(
    id BIGINT PRIMARY KEY ,
    name VARCHAR(255) NOT NULL,
    icon VARCHAR(255) NOT NULL,
    role BIGINT REFERENCES role(id) ON DELETE CASCADE ON UPDATE CASCADE,
    is_melee BOOLEAN NOT NULL,
    date_of_creation TIMESTAMP WITHOUT TIME ZONE
);

CREATE TABLE spell(
    id BIGINT PRIMARY KEY ,
    uuid VARCHAR(255) UNIQUE,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(2555) NOT NULL,
    icon VARCHAR(255) NOT NULL,
    key VARCHAR(255) NOT NULL,
    level_of_access INT,
    hero_id BIGINT REFERENCES hero(id) ON UPDATE CASCADE
);

CREATE TABLE talent(
    id BIGINT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(2555) NOT NULL,
    icon VARCHAR(255) NOT NULL,
    key VARCHAR(255) NOT NULL,
    level_of_access INT NOT NULL
);

CREATE TABLE active_talent(
    id BIGINT PRIMARY KEY,
    mana_cost INT,
    cooldown FLOAT,
    FOREIGN KEY (id) REFERENCES talent(id) ON UPDATE CASCADE
);

CREATE TABLE passive_talent(
    id BIGINT PRIMARY KEY,
    spell_id BIGINT REFERENCES spell(id) ON UPDATE CASCADE ,
    FOREIGN KEY (id) REFERENCES talent(id) ON UPDATE CASCADE
);

CREATE TABLE hero_talent(
    hero_id   BIGINT REFERENCES hero(id) ON UPDATE CASCADE,
    talent_id BIGINT REFERENCES talent(id) ON UPDATE CASCADE,
    PRIMARY KEY (hero_id, talent_id)
);

CREATE TABLE player(
    id BIGINT PRIMARY KEY,
    login VARCHAR(255) NOT NULL
);

CREATE TABLE statistic(
    id BIGINT PRIMARY KEY,
    level INT NOT NULL,
    kills INT NOT NULL,
    assist INT NOT NULL,
    kill_streak INT NOT NULL,
    death INT NOT NULL,
    damage_to_enemy FLOAT NOT NULL,
    damage_to_npc FLOAT NOT NULL,
    heal_to_team_mate FLOAT NOT NULL,
    heal_to_yourself FLOAT NOT NULL,
    damage_to_yourself FLOAT NOT NULL,
    experience FLOAT NOT NULL,
    time_in_revive FLOAT NOT NULL,
    take_camps INT NOT NULL
);

CREATE TABLE team(
    id BIGINT PRIMARY KEY,
    is_winner BOOLEAN NOT NULL,
    level_of_team INT NOT NULL,
    experience_of_team FLOAT NOT NULL
);

CREATE TABLE player_in_match(
    id BIGINT PRIMARY KEY,
    player BIGINT REFERENCES player(id) ON UPDATE CASCADE,
    hero BIGINT REFERENCES hero(id)  ON UPDATE CASCADE,
    statistic BIGINT REFERENCES statistic(id) ON UPDATE CASCADE,
    team BIGINT REFERENCES team(id) ON UPDATE CASCADE
);

CREATE TABLE match(
    id BIGINT PRIMARY KEY,
    type BIGINT REFERENCES type(id) ON UPDATE CASCADE,
    date TIMESTAMP,
    duration FLOAT NOT NULL,
    map BIGINT REFERENCES map(id) ON UPDATE CASCADE,
    region BIGINT REFERENCES region(id) ON UPDATE CASCADE,
    team1 BIGINT REFERENCES team(id) ON UPDATE CASCADE,
    team2 BIGINT REFERENCES team(id) ON UPDATE CASCADE
);

CREATE TABLE player_in_match_talent(
    player_in_match_id BIGINT REFERENCES player_in_match(id) ON UPDATE CASCADE,
    talent_id BIGINT REFERENCES talent(id) ON UPDATE CASCADE,
    PRIMARY KEY (player_in_match_id, talent_id)
);

CREATE SEQUENCE role_id_seq START 1000000;
ALTER TABLE role ALTER COLUMN id SET DEFAULT nextval('role_id_seq');

CREATE SEQUENCE map_id_seq START 1000000;
ALTER TABLE map ALTER COLUMN id SET DEFAULT nextval('map_id_seq');

CREATE SEQUENCE region_id_seq START 1000000;
ALTER TABLE region ALTER COLUMN id SET DEFAULT nextval('region_id_seq');

CREATE SEQUENCE type_id_seq  START 1000000;
ALTER TABLE type ALTER COLUMN id SET DEFAULT nextval('type_id_seq');

CREATE SEQUENCE hero_id_seq START 1000000;
ALTER TABLE hero ALTER COLUMN id SET DEFAULT nextval('hero_id_seq');

CREATE SEQUENCE talent_id_seq START 1000000;
ALTER TABLE talent ALTER COLUMN id SET DEFAULT nextval('talent_id_seq');

CREATE SEQUENCE spell_id_seq START 1000000;
ALTER TABLE spell ALTER COLUMN id SET DEFAULT nextval('spell_id_seq');

CREATE SEQUENCE player_id_seq START 1000000;
ALTER TABLE player ALTER COLUMN id SET DEFAULT nextval('player_id_seq');

CREATE SEQUENCE statistic_id_seq START 1000000;
ALTER TABLE statistic ALTER COLUMN id SET DEFAULT nextval('statistic_id_seq');

CREATE SEQUENCE team_id_seq START 1000000;
ALTER TABLE team ALTER COLUMN id SET DEFAULT nextval('team_id_seq');

CREATE SEQUENCE player_in_match_id_seq START 1000000;
ALTER TABLE player_in_match ALTER COLUMN id SET DEFAULT nextval('player_in_match_id_seq');

CREATE SEQUENCE match_id_seq START 1000000;
ALTER TABLE match ALTER COLUMN id SET DEFAULT nextval('match_id_seq');

CREATE SEQUENCE active_talent_seq START 1000000;
ALTER TABLE active_talent ALTER COLUMN id SET DEFAULT nextval('active_talent_seq');

CREATE SEQUENCE passive_talent_seq START 1000000;
ALTER TABLE passive_talent ALTER COLUMN id SET DEFAULT nextval('passive_talent_seq');