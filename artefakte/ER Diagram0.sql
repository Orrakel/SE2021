CREATE TABLE Entity3 (
);


CREATE TABLE Entity5 (
);


CREATE TABLE Lessor (
 email CHAR(10) NOT NULL,
 password CHAR(10)
);

ALTER TABLE Lessor ADD CONSTRAINT PK_Lessor PRIMARY KEY (email);


CREATE TABLE User (
 email CHAR(10) NOT NULL,
 password CHAR(10),
 Firstname CHAR(10),
 Lastname CHAR(10),
 age CHAR(10),
 picture CHAR(10),
 income CHAR(10),
 job CHAR(10),
 schufa CHAR(10),
 pet CHAR(10),
 persons CHAR(10)
);

ALTER TABLE User ADD CONSTRAINT PK_User PRIMARY KEY (email);


CREATE TABLE Apartment (
 city CHAR(10) NOT NULL,
 zip CHAR(10) NOT NULL,
 street CHAR(10) NOT NULL,
 housenumber CHAR(10) NOT NULL,
 email CHAR(10) NOT NULL,
 size CHAR(10),
 petallowed CHAR(10),
 room CHAR(10),
 costs CHAR(10),
 commercialusage CHAR(10),
 furnishing CHAR(10),
 description CHAR(10)
);

ALTER TABLE Apartment ADD CONSTRAINT PK_Apartment PRIMARY KEY (city,zip,street,housenumber,email);


CREATE TABLE like (
 city CHAR(10) NOT NULL,
 zip CHAR(10) NOT NULL,
 street CHAR(10) NOT NULL,
 housenumber CHAR(10) NOT NULL,
 email CHAR(10) NOT NULL,
 email_0 CHAR(10) NOT NULL
);

ALTER TABLE like ADD CONSTRAINT PK_like PRIMARY KEY (city,zip,street,housenumber,email,email_0);


CREATE TABLE match (
 useremail CHAR(10) NOT NULL,
 lessoremail CHAR(10) NOT NULL,
 city CHAR(10) NOT NULL,
 zip CHAR(10) NOT NULL,
 street CHAR(10) NOT NULL,
 housenumber CHAR(10) NOT NULL
);

ALTER TABLE match ADD CONSTRAINT PK_match PRIMARY KEY (useremail,lessoremail,city,zip,street,housenumber);


ALTER TABLE Apartment ADD CONSTRAINT FK_Apartment_0 FOREIGN KEY (email) REFERENCES Lessor (email);


ALTER TABLE like ADD CONSTRAINT FK_like_0 FOREIGN KEY (city,zip,street,housenumber,email_0) REFERENCES Apartment (city,zip,street,housenumber,email);
ALTER TABLE like ADD CONSTRAINT FK_like_1 FOREIGN KEY (email) REFERENCES User (email);


ALTER TABLE match ADD CONSTRAINT FK_match_0 FOREIGN KEY (useremail) REFERENCES Lessor (email);
ALTER TABLE match ADD CONSTRAINT FK_match_1 FOREIGN KEY (lessoremail) REFERENCES User (email);
ALTER TABLE match ADD CONSTRAINT FK_match_2 FOREIGN KEY (city,zip,street,housenumber,useremail) REFERENCES Apartment (city,zip,street,housenumber,email);


