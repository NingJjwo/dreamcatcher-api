ALTER TABLE api.idols ADD COLUMN IF NOT EXISTS nationality VARCHAR(50);

UPDATE api.idols SET nationality = 'Chinese' WHERE stage_name = 'Handong';

UPDATE api.idols SET nationality = 'South Korean' WHERE nationality IS NULL;

ALTER TABLE api.idols ALTER COLUMN nationality SET NOT NULL;
