DROP TABLE IF EXISTS dress;
CREATE TABLE dress (
    dress_id INT NOT NULL AUTO_INCREMENT,
    dress_name VARCHAR(30) NOT NULL UNIQUE,
    PRIMARY KEY (dress_id)
);

DROP TABLE IF EXISTS rent;
CREATE TABLE rent (
    rent_id INT NOT NULL AUTO_INCREMENT,
    client VARCHAR(50) NOT NULL,
    rent_date DATE NOT NULL,
    dress_id INT NOT NULL,
    PRIMARY KEY (rent_id),
    CONSTRAINT un_dress_id_rent_date UNIQUE (dress_id, rent_date),
    FOREIGN KEY (dress_id) REFERENCES dress(dress_id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
);
