-- DML

SELECT s.stormtrooper_id, stormtrooper_name, stormtrooper_age, w.weapon_name
      FROM stormtrooper AS s
      LEFT JOIN weapon AS w
      ON s.stormtrooper_id = w.stormtrooper_id;

INSERT INTO stormtrooper (stormtrooper_name, stormtrooper_age) VALUES (?, ?);
INSERT INTO weapon (weapon_name, stormtrooper_id) VALUES (?, ?);

DELETE FROM stormtrooper WHERE stormtrooper_id = ?;
