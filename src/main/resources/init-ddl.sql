-- DDL

CREATE TABLE IF NOT EXISTS stormtrooper (
	stormtrooper_id BIGSERIAL PRIMARY KEY,
	stormtrooper_name VARCHAR(255),
	stormtrooper_age INT
);

CREATE TABLE IF NOT EXISTS weapon (
	weapon_id BIGSERIAL PRIMARY KEY,
	weapon_name VARCHAR (255),
	stormtrooper_id INT,
	CONSTRAINT fk_stormtrooper FOREIGN KEY (stormtrooper_id)
	REFERENCES stormtrooper (stormtrooper_id) ON DELETE CASCADE
);

TRUNCATE TABLE stormtrooper CASCADE;
