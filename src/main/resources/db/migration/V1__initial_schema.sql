CREATE SCHEMA IF NOT EXISTS api;

CREATE TABLE IF NOT EXISTS api.groups (
    group_id BIGSERIAL PRIMARY KEY,
    group_name VARCHAR(255),
    agency_name VARCHAR(255),
    concept VARCHAR(255),
    group_image VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS api.idols (
    idol_id BIGSERIAL PRIMARY KEY,
    real_name VARCHAR(255),
    stage_name VARCHAR(255),
    image_url VARCHAR(255),
    lore_concept VARCHAR(255),
    group_id BIGINT REFERENCES api.groups(group_id)
);

CREATE TABLE IF NOT EXISTS api.positions (
    position_id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE,
    category VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS api.idol_positions (
    idol_id BIGINT REFERENCES api.idols(idol_id) ON DELETE CASCADE,
    position_id BIGINT REFERENCES api.positions(position_id) ON DELETE CASCADE,
    PRIMARY KEY (idol_id, position_id)
);

CREATE TABLE IF NOT EXISTS api.albums (
    album_id BIGSERIAL PRIMARY KEY,
    album_title VARCHAR(255),
    track_count INTEGER,
    release_date INTEGER,
    album_type VARCHAR(50),
    album_image VARCHAR(255),
    group_id BIGINT REFERENCES api.groups(group_id)
);

CREATE TABLE IF NOT EXISTS api.songs (
    song_id BIGSERIAL PRIMARY KEY,
    song_name VARCHAR(255),
    track_number INTEGER,
    album_id BIGINT REFERENCES api.albums(album_id) ON DELETE CASCADE
);

CREATE INDEX IF NOT EXISTS idx_albums_title ON api.albums (album_title);
CREATE INDEX IF NOT EXISTS idx_songs_name ON api.songs (song_name);