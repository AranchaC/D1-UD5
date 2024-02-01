CREATE TABLE resultado (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    clasificacion VARCHAR(20) NOT NULL,
    puntos INT NOT NULL,
    nombre VARCHAR(100)
);

INSERT INTO resultado (clasificacion, puntos, nombre) VALUES ('GRYFFINDOR', 25, 'Arancha');
INSERT INTO resultado (clasificacion, puntos, nombre) VALUES ('RAVENCLAW', 18, 'Rodri');
INSERT INTO resultado (clasificacion, puntos, nombre) VALUES ('SLYTHERIN', 14, 'Carol');
INSERT INTO resultado (clasificacion, puntos, nombre) VALUES ('HUFFLEPUFF', 8, 'Luis');
