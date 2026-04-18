CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255),
    provider VARCHAR(50) NOT NULL DEFAULT 'LOCAL',
    role VARCHAR(50) NOT NULL DEFAULT 'ROLE_USER',
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);

CREATE TABLE teams (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    fifa_code VARCHAR(3) NOT NULL UNIQUE,
    group_name VARCHAR(2) NOT NULL,
    flag_url VARCHAR(500)
);

CREATE TABLE matches (
    id BIGSERIAL PRIMARY KEY,
    home_team_id BIGINT NOT NULL REFERENCES teams(id),
    away_team_id BIGINT NOT NULL REFERENCES teams(id),
    home_score INTEGER,
    away_score INTEGER,
    phase VARCHAR(50) NOT NULL,
    venue VARCHAR(255) NOT NULL,
    start_time TIMESTAMPTZ NOT NULL,
    status VARCHAR(50) NOT NULL DEFAULT 'SCHEDULED'
);

CREATE TABLE predictions (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL REFERENCES users(id),
    match_id BIGINT NOT NULL REFERENCES matches(id),
    home_score INTEGER NOT NULL,
    away_score INTEGER NOT NULL,
    points INTEGER,
    created_at TIMESTAMPTZ NOT NULL,
    CONSTRAINT uk_prediction_user_match UNIQUE (user_id, match_id)
);
