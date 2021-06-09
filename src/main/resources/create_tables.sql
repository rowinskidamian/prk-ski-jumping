
-- author DamianRowinski

CREATE TABLE tournament_jumper_results
(
    tjr_id                  BIGINT AUTO_INCREMENT PRIMARY KEY,
    tjr_rank                INT,
    origin                  VARCHAR(255),
    athlete_name            VARCHAR(255),
    total_points            DOUBLE,
    tournament_world_cup_id BIGINT
);

CREATE TABLE athlete_country_list
(
    acl_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    search_id BIGINT,
    name VARCHAR(255),
    FOREIGN KEY(search_id) REFERENCES history_search(hs_id)
);

CREATE TABLE tournament_id_list
(
    til_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    search_id BIGINT,
    tournament_id BIGINT,
    FOREIGN KEY(search_id) REFERENCES history_search(hs_id)
);

CREATE TABLE history_search
(
    hs_id                   BIGINT AUTO_INCREMENT PRIMARY KEY,
    search_name             VARCHAR(255),
    search_date             DATE,
    search_type             VARCHAR(255),
    tournament_amount       INT
);

-- author RadoslawParol

CREATE TABLE tournament_world_cup
(
    twc_id                      BIGINT AUTO_INCREMENT PRIMARY KEY,
    date                        DATE,
    place                       VARCHAR(255),
    gender                      VARCHAR(255),
    link                        VARCHAR(255)
);