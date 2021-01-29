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


INSERT INTO lessor (email, password) 
VALUES 
('nkoetter@e-mail.de', '1234'), 
('wreger@e-mail.de', '4321');

INSERT INTO Users (email, password, Firstname, Lastname, age, picture, income, job, schufa, pet, persons) 
VALUES 
('kneitmann@e-mail.de', '4321', 'Waldemar', 'Reger', '25', 'Waldemar', '5000', 'IT', 'yes', 'yes', '3');

INSERT INTO Users (email, password, Firstname, Lastname, age, picture, income, job, schufa, pet, persons) 
VALUES 
('anolting@e-mail.de', '1234', 'Alexander', 'Nolting', '28', 'Noltinger', '5000', 'IT', 'yes', 'yes', '3');

INSERT INTO apartment (city, zip, street, housenumber, email, size, petallowed, room, costs, commercialusage, furnishing, description) 
VALUES 
('Minden', '12345', 'Mindenstrasse', '5', 'nkoetter@e-mail.de', '450', 'yes', '4', '500', 'no', 'yes', 'BilligesApartmentmitgrossenRäumenundsogarBadezimmer.'), 
('BadSalzuflen', '32107', 'DetmolderWeg', '3', 'nkoetter@e-mail.de', '120', 'yes', '2', '750', 'no', 'yes', 'HierwohnteeineBerühmtheitdasistwahrglaubensiemir.'),
('Berlin', '66666', 'BerlinerWeg', '666', 'wreger@e-mail.de', '20', 'no', '1', '3000', 'yes', 'no', 'KleinaberfeinunddaszueinembilligenPreis.'), 
('Bielefeld', '33881', 'Telefonstrasse', '1', 'wreger@e-mail.de', '220', 'no', '3', '450', 'no', 'no', 'EineWohnunginBielefeld'),
('BadSalzuflen', '12345', 'Mindenstrasse', '5', 'nkoetter@e-mail.de', '450', 'yes', '4', '500', 'no', 'yes', 'BilligesApartmentmitgrossenRäumenundsogarBadezimmer.'), 
('Berlin', '32107', 'DetmolderWeg', '3', 'nkoetter@e-mail.de', '120', 'yes', '2', '750', 'no', 'yes', 'HierwohnteeineBerühmtheitdasistwahrglaubensiemir.'),
('Potsdam', '66666', 'BerlinerWeg', '666', 'wreger@e-mail.de', '20', 'no', '1', '3000', 'yes', 'no', 'KleinaberfeinunddaszueinembilligenPreis.'), 
('Berlin', '33881', 'Telefonstrasse', '1', 'wreger@e-mail.de', '220', 'no', '3', '450', 'no', 'no', 'EineWohnunginBielefeld'),
('Potsdamn', '12345', 'Mindenstrasse', '5', 'nkoetter@e-mail.de', '450', 'yes', '4', '500', 'no', 'yes', 'BilligesApartmentmitgrossenRäumenundsogarBadezimmer.'), 
('Leopoldshöhe', '32107', 'DetmolderWeg', '3', 'nkoetter@e-mail.de', '120', 'yes', '2', '750', 'no', 'yes', 'HierwohnteeineBerühmtheitdasistwahrglaubensiemir.'),
('Kiel', '66666', 'BerlinerWeg', '666', 'wreger@e-mail.de', '20', 'no', '1', '3000', 'yes', 'no', 'KleinaberfeinunddaszueinembilligenPreis.'), 
('Minden', '33881', 'Telefonstrasse', '1', 'wreger@e-mail.de', '220', 'no', '3', '450', 'no', 'no', 'EineWohnunginBielefeld'),
('Neustadt', '12345', 'Mindenstrasse', '5', 'nkoetter@e-mail.de', '450', 'yes', '4', '500', 'no', 'yes', 'BilligesApartmentmitgrossenRäumenundsogarBadezimmer.'), 
('München', '32107', 'DetmolderWeg', '3', 'nkoetter@e-mail.de', '120', 'yes', '2', '750', 'no', 'yes', 'HierwohnteeineBerühmtheitdasistwahrglaubensiemir.'),
('Köln', '66666', 'BerlinerWeg', '666', 'wreger@e-mail.de', '20', 'no', '1', '3000', 'yes', 'no', 'KleinaberfeinunddaszueinembilligenPreis.'), 
('Dortmund', '33881', 'Telefonstrasse', '1', 'wreger@e-mail.de', '220', 'no', '3', '450', 'no', 'no', 'EineWohnunginBielefeld'),
('Minden', '12345', 'Mindenstrasse', '6', 'nkoetter@e-mail.de', '450', 'yes', '4', '500', 'no', 'yes', 'BilligesApartmentmitgrossenRäumenundsogarBadezimmer.'), 
('BadSalzuflen', '32107', 'DetmolderWeg', '7', 'nkoetter@e-mail.de', '120', 'yes', '2', '750', 'no', 'yes', 'HierwohnteeineBerühmtheitdasistwahrglaubensiemir.'),
('Berlin', '66666', 'BerlinerWeg', '656', 'wreger@e-mail.de', '20', 'no', '1', '3000', 'yes', 'no', 'KleinaberfeinunddaszueinembilligenPreis.'), 
('Bielefeld', '33881', 'Telefonstrasse', '2', 'wreger@e-mail.de', '220', 'no', '3', '450', 'no', 'no', 'EineWohnunginBielefeld'),
('BadSalzuflen', '12345', 'Mindenstrasse', '4', 'nkoetter@e-mail.de', '450', 'yes', '4', '500', 'no', 'yes', 'BilligesApartmentmitgrossenRäumenundsogarBadezimmer.'), 
('Berlin', '32107', 'DetmolderWeg', '1', 'nkoetter@e-mail.de', '120', 'yes', '2', '750', 'no', 'yes', 'HierwohnteeineBerühmtheitdasistwahrglaubensiemir.'),
('Potsdam', '66666', 'BerlinerWeg', '626', 'wreger@e-mail.de', '20', 'no', '1', '3000', 'yes', 'no', 'KleinaberfeinunddaszueinembilligenPreis.'), 
('Berlin', '33881', 'Telefonstrasse', '8', 'wreger@e-mail.de', '220', 'no', '3', '450', 'no', 'no', 'EineWohnunginBielefeld'),
('Potsdamn', '12345', 'Mindenstrasse', '1', 'nkoetter@e-mail.de', '450', 'yes', '4', '500', 'no', 'yes', 'BilligesApartmentmitgrossenRäumenundsogarBadezimmer.'), 
('Leopoldshöhe', '32107', 'DetmolderWeg', '2', 'nkoetter@e-mail.de', '120', 'yes', '2', '750', 'no', 'yes', 'HierwohnteeineBerühmtheitdasistwahrglaubensiemir.'),
('Kiel', '66666', 'BerlinerWeg', '616', 'wreger@e-mail.de', '20', 'no', '1', '3000', 'yes', 'no', 'KleinaberfeinunddaszueinembilligenPreis.'), 
('Minden', '33881', 'Telefonstrasse', '2', 'wreger@e-mail.de', '220', 'no', '3', '450', 'no', 'no', 'EineWohnunginBielefeld'),
('Neustadt', '12345', 'Mindenstrasse', '3', 'nkoetter@e-mail.de', '450', 'yes', '4', '500', 'no', 'yes', 'BilligesApartmentmitgrossenRäumenundsogarBadezimmer.'), 
('München', '32107', 'DetmolderWeg', '4', 'nkoetter@e-mail.de', '120', 'yes', '2', '750', 'no', 'yes', 'HierwohnteeineBerühmtheitdasistwahrglaubensiemir.'),
('Köln', '66666', 'BerlinerWeg', '665', 'wreger@e-mail.de', '20', 'no', '1', '3000', 'yes', 'no', 'KleinaberfeinunddaszueinembilligenPreis.'), 
('Dortmund', '33881', 'Telefonstrasse', '7', 'wreger@e-mail.de', '220', 'no', '3', '450', 'no', 'no', 'EineWohnunginBielefeld'),
('Minden', '12345', 'Mindenstrasse', '11', 'abcd@e-mail.de', '450', 'yes', '4', '500', 'no', 'yes', 'BilligesApartmentmitgrossenRäumenundsogarBadezimmer.'), 
('BadSalzuflen', '32107', 'DetmolderWeg', '17', 'abcd@e-mail.de', '120', 'yes', '2', '750', 'no', 'yes', 'HierwohnteeineBerühmtheitdasistwahrglaubensiemir.'),
('Berlin', '66666', 'BerlinerWeg', '6561', 'abcd@e-mail.de', '20', 'no', '1', '3000', 'yes', 'no', 'KleinaberfeinunddaszueinembilligenPreis.'), 
('Bielefeld', '33881', 'Telefonstrasse', '12', 'abcd@e-mail.de', '220', 'no', '3', '450', 'no', 'no', 'EineWohnunginBielefeld'),
('BadSalzuflen', '12345', 'Mindenstrasse', '14', 'abcd@e-mail.de', '450', 'yes', '4', '500', 'no', 'yes', 'BilligesApartmentmitgrossenRäumenundsogarBadezimmer.'), 
('Berlin', '32107', 'DetmolderWeg', '11', 'abcd@e-mail.de', '120', 'yes', '2', '750', 'no', 'yes', 'HierwohnteeineBerühmtheitdasistwahrglaubensiemir.'),
('Potsdam', '66666', 'BerlinerWeg', '1626', 'abcd@e-mail.de', '20', 'no', '1', '3000', 'yes', 'no', 'KleinaberfeinunddaszueinembilligenPreis.'), 
('Berlin', '33881', 'Telefonstrasse', '18', 'abcd@e-mail.de', '220', 'no', '3', '450', 'no', 'no', 'EineWohnunginBielefeld'),
('Potsdamn', '12345', 'Mindenstrasse', '11', 'abcd@e-mail.de', '450', 'yes', '4', '500', 'no', 'yes', 'BilligesApartmentmitgrossenRäumenundsogarBadezimmer.'), 
('Leopoldshöhe', '32107', 'DetmolderWeg', '12', 'abcd@e-mail.de', '120', 'yes', '2', '750', 'no', 'yes', 'HierwohnteeineBerühmtheitdasistwahrglaubensiemir.'),
('Kiel', '66666', 'BerlinerWeg', '1616', 'abcd@e-mail.de', '20', 'no', '1', '3000', 'yes', 'no', 'KleinaberfeinunddaszueinembilligenPreis.'), 
('Minden', '33881', 'Telefonstrasse', '12', 'abcd@e-mail.de', '220', 'no', '3', '450', 'no', 'no', 'EineWohnunginBielefeld'),
('Neustadt', '12345', 'Mindenstrasse', '13', 'abcd@e-mail.de', '450', 'yes', '4', '500', 'no', 'yes', 'BilligesApartmentmitgrossenRäumenundsogarBadezimmer.'), 
('München', '32107', 'DetmolderWeg', '14', 'abcd@e-mail.de', '120', 'yes', '2', '750', 'no', 'yes', 'HierwohnteeineBerühmtheitdasistwahrglaubensiemir.'),
('Köln', '66666', 'BerlinerWeg', '1665', 'abcd@e-mail.de', '20', 'no', '1', '3000', 'yes', 'no', 'KleinaberfeinunddaszueinembilligenPreis.'), 
('Dortmund', '33881', 'Telefonstrasse', '17', 'abcd@e-mail.de', '220', 'no', '3', '450', 'no', 'no', 'EineWohnunginBielefeld'),
('Minden', '12345', 'Mindenstrasse', '21', 'efgh@e-mail.de', '450', 'yes', '4', '500', 'no', 'yes', 'BilligesApartmentmitgrossenRäumenundsogarBadezimmer.'), 
('BadSalzuflen', '32107', 'DetmolderWeg', '27', 'efgh@e-mail.de', '120', 'yes', '2', '750', 'no', 'yes', 'HierwohnteeineBerühmtheitdasistwahrglaubensiemir.'),
('Berlin', '66666', 'BerlinerWeg', '2656', 'efgh@e-mail.de', '20', 'no', '1', '3000', 'yes', 'no', 'KleinaberfeinunddaszueinembilligenPreis.'), 
('Bielefeld', '33881', 'Telefonstrasse', '22', 'efgh@e-mail.de', '220', 'no', '3', '450', 'no', 'no', 'EineWohnunginBielefeld'),
('BadSalzuflen', '12345', 'Mindenstrasse', '24', 'efgh@e-mail.de', '450', 'yes', '4', '500', 'no', 'yes', 'BilligesApartmentmitgrossenRäumenundsogarBadezimmer.'), 
('Berlin', '32107', 'DetmolderWeg', '21', 'efgh@e-mail.de', '120', 'yes', '2', '750', 'no', 'yes', 'HierwohnteeineBerühmtheitdasistwahrglaubensiemir.'),
('Potsdam', '66666', 'BerlinerWeg', '2626', 'efgh@e-mail.de', '20', 'no', '1', '3000', 'yes', 'no', 'KleinaberfeinunddaszueinembilligenPreis.'), 
('Berlin', '33881', 'Telefonstrasse', '28', 'efgh@e-mail.de', '220', 'no', '3', '450', 'no', 'no', 'EineWohnunginBielefeld'),
('Potsdamn', '12345', 'Mindenstrasse', '21', 'efgh@e-mail.de', '450', 'yes', '4', '500', 'no', 'yes', 'BilligesApartmentmitgrossenRäumenundsogarBadezimmer.'), 
('Leopoldshöhe', '32107', 'DetmolderWeg', '22', 'efgh@e-mail.de', '120', 'yes', '2', '750', 'no', 'yes', 'HierwohnteeineBerühmtheitdasistwahrglaubensiemir.'),
('Kiel', '66666', 'BerlinerWeg', '2616', 'efgh@e-mail.de', '20', 'no', '1', '3000', 'yes', 'no', 'KleinaberfeinunddaszueinembilligenPreis.'), 
('Minden', '33881', 'Telefonstrasse', '22', 'efgh@e-mail.de', '220', 'no', '3', '450', 'no', 'no', 'EineWohnunginBielefeld'),
('Neustadt', '12345', 'Mindenstrasse', '23', 'efgh@e-mail.de', '450', 'yes', '4', '500', 'no', 'yes', 'BilligesApartmentmitgrossenRäumenundsogarBadezimmer.'), 
('München', '32107', 'DetmolderWeg', '24', 'efgh@e-mail.de', '120', 'yes', '2', '750', 'no', 'yes', 'HierwohnteeineBerühmtheitdasistwahrglaubensiemir.'),
('Köln', '66666', 'BerlinerWeg', '2665', 'efgh@e-mail.de', '20', 'no', '1', '3000', 'yes', 'no', 'KleinaberfeinunddaszueinembilligenPreis.'), 
('Dortmund', '33881', 'Telefonstrasse', '27', 'efgh@e-mail.de', '220', 'no', '3', '450', 'no', 'no', 'EineWohnunginBielefeld'),
('Minden', '12345', 'Mindenstrasse', '31', 'ijkl@e-mail.de', '450', 'yes', '4', '500', 'no', 'yes', 'BilligesApartmentmitgrossenRäumenundsogarBadezimmer.'), 
('BadSalzuflen', '32107', 'DetmolderWeg', '37', 'ijkl@e-mail.de', '120', 'yes', '2', '750', 'no', 'yes', 'HierwohnteeineBerühmtheitdasistwahrglaubensiemir.'),
('Berlin', '66666', 'BerlinerWeg', '3656', 'ijkl@e-mail.de', '20', 'no', '1', '3000', 'yes', 'no', 'KleinaberfeinunddaszueinembilligenPreis.'), 
('Bielefeld', '33881', 'Telefonstrasse', '32', 'ijkl@e-mail.de', '220', 'no', '3', '450', 'no', 'no', 'EineWohnunginBielefeld'),
('BadSalzuflen', '12345', 'Mindenstrasse', '34', 'ijkl@e-mail.de', '450', 'yes', '4', '500', 'no', 'yes', 'BilligesApartmentmitgrossenRäumenundsogarBadezimmer.'), 
('Berlin', '32107', 'DetmolderWeg', '31', 'ijkl@e-mail.de', '120', 'yes', '2', '750', 'no', 'yes', 'HierwohnteeineBerühmtheitdasistwahrglaubensiemir.'),
('Potsdam', '66666', 'BerlinerWeg', '3626', 'ijkl@e-mail.de', '20', 'no', '1', '3000', 'yes', 'no', 'KleinaberfeinunddaszueinembilligenPreis.'), 
('Berlin', '33881', 'Telefonstrasse', '38', 'ijkl@e-mail.de', '220', 'no', '3', '450', 'no', 'no', 'EineWohnunginBielefeld'),
('Potsdamn', '12345', 'Mindenstrasse', '31', 'ijkl@e-mail.de', '450', 'yes', '4', '500', 'no', 'yes', 'BilligesApartmentmitgrossenRäumenundsogarBadezimmer.'), 
('Leopoldshöhe', '32107', 'DetmolderWeg', '32', 'ijkl@e-mail.de', '120', 'yes', '2', '750', 'no', 'yes', 'HierwohnteeineBerühmtheitdasistwahrglaubensiemir.'),
('Kiel', '66666', 'BerlinerWeg', '3616', 'ijkl@e-mail.de', '20', 'no', '1', '3000', 'yes', 'no', 'KleinaberfeinunddaszueinembilligenPreis.'), 
('Minden', '33881', 'Telefonstrasse', '32', 'ijkl@e-mail.de', '220', 'no', '3', '450', 'no', 'no', 'EineWohnunginBielefeld'),
('Neustadt', '12345', 'Mindenstrasse', '33', 'ijkl@e-mail.de', '450', 'yes', '4', '500', 'no', 'yes', 'BilligesApartmentmitgrossenRäumenundsogarBadezimmer.'), 
('München', '32107', 'DetmolderWeg', '34', 'ijkl@e-mail.de', '120', 'yes', '2', '750', 'no', 'yes', 'HierwohnteeineBerühmtheitdasistwahrglaubensiemir.'),
('Köln', '66666', 'BerlinerWeg', '3665', 'ijkl@e-mail.de', '20', 'no', '1', '3000', 'yes', 'no', 'KleinaberfeinunddaszueinembilligenPreis.'), 
('Dortmund', '33881', 'Telefonstrasse', '37', 'ijkl@e-mail.de', '220', 'no', '3', '450', 'no', 'no', 'EineWohnunginBielefeld');


INSERT INTO likes (city, zip, street, housenumber, email, email_0) 
VALUES 
('BadSalzuflen', '32107', 'DetmolderWeg', '3', 'kneitmann@e-mail.de', 'nkoetter@e-mail.de');

INSERT INTO matches (Usersemail, lessoremail, city, zip, street, housenumber) 
VALUES 
('nkoetter@e-mail.de', 'kneitmann@e-mail.de', 'Minden', '12345', 'Mindenstrasse', '5');













