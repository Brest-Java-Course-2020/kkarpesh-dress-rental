DROP TABLE IF EXISTS dress;
DROP TABLE IF EXISTS rentedDress;

CREATE TABLE dress (
    dressId INT NOT NULL AUTO_INCREMENT,
    dressName VARCHAR(255) NOT NULL UNIQUE,
    PRIMARY KEY (dressId)
);

CREATE TABLE rentedDress {
    rentedDressId INT NOT NULL AUTO_INCREMENT,
    client VARCHAR(50) NULL,
    dateOfRent DATE NOT NULL,
    dressId INT,
    PRIMARY KEY (rentedDressId),
    FOREIGN KEY (dressId) REFERENCES dress(dressId)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
);
