ALTER TABLE medico add COLUMN  isActive BOOLEAN NOT NULL;
UPDATE medico set isActive = TRUE;