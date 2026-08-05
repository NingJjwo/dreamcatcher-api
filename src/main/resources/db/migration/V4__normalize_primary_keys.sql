ALTER TABLE api.groups RENAME COLUMN group_id TO id;
ALTER SEQUENCE api.groups_group_id_seq RENAME TO groups_id_seq;

ALTER TABLE api.idols RENAME COLUMN idol_id TO id;
ALTER SEQUENCE api.idols_idol_id_seq RENAME TO idols_id_seq;

ALTER TABLE api.positions RENAME COLUMN position_id TO id;
ALTER SEQUENCE api.positions_position_id_seq RENAME TO positions_id_seq;

ALTER TABLE api.albums RENAME COLUMN album_id TO id;
ALTER SEQUENCE api.albums_album_id_seq RENAME TO albums_id_seq;

ALTER TABLE api.songs RENAME COLUMN song_id TO id;
ALTER SEQUENCE api.songs_song_id_seq RENAME TO songs_id_seq;
