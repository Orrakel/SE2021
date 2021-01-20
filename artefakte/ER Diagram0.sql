CREATE TABLE Lessor (
 email CHAR(30) NOT NULL,
 password CHAR(10)
);

ALTER TABLE Lessor ADD CONSTRAINT PK_Lessor PRIMARY KEY (email);


CREATE TABLE Users (
 email CHAR(30) NOT NULL,
 password CHAR(10),
 Firstname CHAR(10),
 Lastname CHAR(10),
 age INT,
 picture CHAR(30),
 income FLOAT(10),
 job CHAR(10),
 schufa CHAR(10),
 pet CHAR(10),
 persons INT
);

ALTER TABLE Users ADD CONSTRAINT PK_Users PRIMARY KEY (email);


CREATE TABLE Apartment (
 city CHAR(20) NOT NULL,
 zip CHAR(10) NOT NULL,
 street CHAR(30) NOT NULL,
 housenumber CHAR(10) NOT NULL,
 email CHAR(30) NOT NULL,
 size FLOAT(10),
 petallowed CHAR(10),
 room INT,
 costs FLOAT(10),
 commercialusage CHAR(10),
 furnishing CHAR(10),
 description CHAR(50)
);

ALTER TABLE Apartment ADD CONSTRAINT PK_Apartment PRIMARY KEY (city,zip,street,housenumber,email);


CREATE TABLE likes (
 city CHAR(20) NOT NULL,
 zip CHAR(10) NOT NULL,
 street CHAR(30) NOT NULL,
 housenumber CHAR(10) NOT NULL,
 email CHAR(30) NOT NULL,
 email_0 CHAR(30) NOT NULL
);

ALTER TABLE likes ADD CONSTRAINT PK_like PRIMARY KEY (city,zip,street,housenumber,email,email_0);


CREATE TABLE matches (
 Usersemail CHAR(30) NOT NULL,
 lessoremail CHAR(30) NOT NULL,
 city CHAR(20) NOT NULL,
 zip CHAR(10) NOT NULL,
 street CHAR(30) NOT NULL,
 housenumber CHAR(10) NOT NULL
);

ALTER TABLE matches ADD CONSTRAINT PK_match PRIMARY KEY (Usersemail,lessoremail,city,zip,street,housenumber);


ALTER TABLE Apartment ADD CONSTRAINT FK_Apartment_0 FOREIGN KEY (email) REFERENCES Lessor (email);


ALTER TABLE likes ADD CONSTRAINT FK_like_0 FOREIGN KEY (city,zip,street,housenumber,email_0) REFERENCES Apartment (city,zip,street,housenumber,email);
ALTER TABLE likes ADD CONSTRAINT FK_like_1 FOREIGN KEY (email) REFERENCES Users (email);


ALTER TABLE matches ADD CONSTRAINT FK_match_0 FOREIGN KEY (Usersemail) REFERENCES Lessor (email);
ALTER TABLE matches ADD CONSTRAINT FK_match_1 FOREIGN KEY (lessoremail) REFERENCES Users (email);
ALTER TABLE matches ADD CONSTRAINT FK_match_2 FOREIGN KEY (city,zip,street,housenumber,Usersemail) REFERENCES Apartment (city,zip,street,housenumber,email);


INSERT INTO `lessor` (`email`, password) 
VALUES 
('nkoetter@e-mail.de', '1234'), ('wreger@e-mail.de', '4321');

INSERT INTO `Users` (`email`, `password`, `Firstname`, `Lastname`, `age`, `picture`, `income`, `job`, `schufa`, `pet`, `persons`) 
VALUES 
('wreger@e-mail.de', '4321', 'Waldemar', 'Reger', '25', 'Waldemar', '5000', 'IT', 'yes', 'yes', '3');

INSERT INTO `apartment` (`city`, `zip`, `street`, `housenumber`, `email`, `size`, `petallowed`, `room`, `costs`, `commercialusage`, `furnishing`, `description`) 
VALUES 
('Minden', '12345', 'Mindenstraße', '5a', 'nkoetter@e-mail.de', '450', 'yes', '4', '500', 'no', 'yes', 'Billiges Apartment mit großen Räumen und sogar Badezimmer.'), 
('Bad Salzuflen', '32107', 'Detmolder Weg', '3a', 'nkoetter@e-mail.de', '120', 'yes', '2', '750', 'no', 'yes', 'Hier wohnte eine Berühmtheit, das ist wahr, glauben sie mir.'),
('Berlin', '66666', 'Berliner Weg', '666', 'wreger@e-mail.de', '20', 'no', '1', '3000', 'yes', 'no', 'Klein, aber fein und das zu einem billigen Preis.'), 
('Bielefeld', '33881', 'Telefonstraße', '1', 'wreger@e-mail.de', '220', 'no', '3', '450', 'no', 'no', 'Eine Wohnung in Bielefeld');

INSERT INTO `likes` (`city`, `zip`, `street`, `housenumber`, `email`, `email_0`) 
VALUES 
('Bad Salzuflen', '32107', 'Detmolder Weg', '3a', 'kneitmann@e-mail.de', 'nkoetter@e-mail.de');

INSERT INTO `matches` (`Usersemail`, `lessoremail`, `city`, `zip`, `street`, `housenumber`) 
VALUES 
('nkoetter@e-mail.de', 'kneitmann@e-mail.de', 'Minden', '12345', 'Mindenstraße', '5a');













