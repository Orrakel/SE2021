-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Erstellungszeit: 29. Jan 2021 um 10:09
-- Server-Version: 10.4.17-MariaDB
-- PHP-Version: 7.3.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `flatchmatch`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `apartment`
--

CREATE TABLE `apartment` (
  `city` char(20) NOT NULL,
  `zip` char(10) NOT NULL,
  `street` char(30) NOT NULL,
  `housenumber` char(10) NOT NULL,
  `email` char(30) NOT NULL,
  `size` float DEFAULT NULL,
  `petallowed` char(10) DEFAULT NULL,
  `room` int(11) DEFAULT NULL,
  `costs` float DEFAULT NULL,
  `commercialusage` char(10) DEFAULT NULL,
  `furnishing` char(10) DEFAULT NULL,
  `description` char(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `apartment`
--

INSERT INTO `apartment` (`city`, `zip`, `street`, `housenumber`, `email`, `size`, `petallowed`, `room`, `costs`, `commercialusage`, `furnishing`, `description`) VALUES
('BadSalzuflen', '12345', 'Mindenstraße', '14', 'abcd@e-mail.de', 450, 'yes', 4, 500, 'no', 'yes', 'BilligesApartmentmitgroßenRäumenundsogarBadezimmer'),
('BadSalzuflen', '12345', 'Mindenstraße', '24', 'efgh@e-mail.de', 450, 'yes', 4, 500, 'no', 'yes', 'BilligesApartmentmitgroßenRäumenundsogarBadezimmer'),
('BadSalzuflen', '12345', 'Mindenstraße', '34', 'ijkl@e-mail.de', 450, 'yes', 4, 500, 'no', 'yes', 'BilligesApartmentmitgroßenRäumenundsogarBadezimmer'),
('BadSalzuflen', '12345', 'Mindenstraße', '4', 'nkoetter@e-mail.de', 450, 'yes', 4, 500, 'no', 'yes', 'BilligesApartmentmitgroßenRäumenundsogarBadezimmer'),
('BadSalzuflen', '12345', 'Mindenstraße', '5', 'nkoetter@e-mail.de', 450, 'yes', 4, 500, 'no', 'yes', 'BilligesApartmentmitgroßenRäumenundsogarBadezimmer'),
('BadSalzuflen', '32107', 'DetmolderWeg', '17', 'abcd@e-mail.de', 120, 'yes', 2, 750, 'no', 'yes', 'HierwohnteeineBerühmtheitdasistwahrglaubensiemir.'),
('BadSalzuflen', '32107', 'DetmolderWeg', '27', 'efgh@e-mail.de', 120, 'yes', 2, 750, 'no', 'yes', 'HierwohnteeineBerühmtheitdasistwahrglaubensiemir.'),
('BadSalzuflen', '32107', 'DetmolderWeg', '3', 'nkoetter@e-mail.de', 120, 'yes', 2, 750, 'no', 'yes', 'HierwohnteeineBerühmtheitdasistwahrglaubensiemir.'),
('BadSalzuflen', '32107', 'DetmolderWeg', '37', 'ijkl@e-mail.de', 120, 'yes', 2, 750, 'no', 'yes', 'HierwohnteeineBerühmtheitdasistwahrglaubensiemir.'),
('BadSalzuflen', '32107', 'DetmolderWeg', '7', 'nkoetter@e-mail.de', 120, 'yes', 2, 750, 'no', 'yes', 'HierwohnteeineBerühmtheitdasistwahrglaubensiemir.'),
('Berlin', '32107', 'DetmolderWeg', '1', 'nkoetter@e-mail.de', 120, 'yes', 2, 750, 'no', 'yes', 'HierwohnteeineBerühmtheitdasistwahrglaubensiemir.'),
('Berlin', '32107', 'DetmolderWeg', '11', 'abcd@e-mail.de', 120, 'yes', 2, 750, 'no', 'yes', 'HierwohnteeineBerühmtheitdasistwahrglaubensiemir.'),
('Berlin', '32107', 'DetmolderWeg', '21', 'efgh@e-mail.de', 120, 'yes', 2, 750, 'no', 'yes', 'HierwohnteeineBerühmtheitdasistwahrglaubensiemir.'),
('Berlin', '32107', 'DetmolderWeg', '3', 'nkoetter@e-mail.de', 120, 'yes', 2, 750, 'no', 'yes', 'HierwohnteeineBerühmtheitdasistwahrglaubensiemir.'),
('Berlin', '32107', 'DetmolderWeg', '31', 'ijkl@e-mail.de', 120, 'yes', 2, 750, 'no', 'yes', 'HierwohnteeineBerühmtheitdasistwahrglaubensiemir.'),
('Berlin', '33881', 'Telefonstraße', '1', 'wreger@e-mail.de', 220, 'no', 3, 450, 'no', 'no', 'EineWohnunginBielefeld'),
('Berlin', '33881', 'Telefonstraße', '18', 'abcd@e-mail.de', 220, 'no', 3, 450, 'no', 'no', 'EineWohnunginBielefeld'),
('Berlin', '33881', 'Telefonstraße', '28', 'efgh@e-mail.de', 220, 'no', 3, 450, 'no', 'no', 'EineWohnunginBielefeld'),
('Berlin', '33881', 'Telefonstraße', '38', 'ijkl@e-mail.de', 220, 'no', 3, 450, 'no', 'no', 'EineWohnunginBielefeld'),
('Berlin', '33881', 'Telefonstraße', '8', 'wreger@e-mail.de', 220, 'no', 3, 450, 'no', 'no', 'EineWohnunginBielefeld'),
('Berlin', '66666', 'BerlinerWeg', '2656', 'efgh@e-mail.de', 20, 'no', 1, 3000, 'yes', 'no', 'KleinaberfeinunddaszueinembilligenPreis.'),
('Berlin', '66666', 'BerlinerWeg', '3656', 'ijkl@e-mail.de', 20, 'no', 1, 3000, 'yes', 'no', 'KleinaberfeinunddaszueinembilligenPreis.'),
('Berlin', '66666', 'BerlinerWeg', '656', 'wreger@e-mail.de', 20, 'no', 1, 3000, 'yes', 'no', 'KleinaberfeinunddaszueinembilligenPreis.'),
('Berlin', '66666', 'BerlinerWeg', '6561', 'abcd@e-mail.de', 20, 'no', 1, 3000, 'yes', 'no', 'KleinaberfeinunddaszueinembilligenPreis.'),
('Berlin', '66666', 'BerlinerWeg', '666', 'wreger@e-mail.de', 20, 'no', 1, 3000, 'yes', 'no', 'KleinaberfeinunddaszueinembilligenPreis.'),
('Bielefeld', '33881', 'Telefonstraße', '1', 'wreger@e-mail.de', 220, 'no', 3, 450, 'no', 'no', 'EineWohnunginBielefeld'),
('Bielefeld', '33881', 'Telefonstraße', '12', 'abcd@e-mail.de', 220, 'no', 3, 450, 'no', 'no', 'EineWohnunginBielefeld'),
('Bielefeld', '33881', 'Telefonstraße', '2', 'wreger@e-mail.de', 220, 'no', 3, 450, 'no', 'no', 'EineWohnunginBielefeld'),
('Bielefeld', '33881', 'Telefonstraße', '22', 'efgh@e-mail.de', 220, 'no', 3, 450, 'no', 'no', 'EineWohnunginBielefeld'),
('Bielefeld', '33881', 'Telefonstraße', '32', 'ijkl@e-mail.de', 220, 'no', 3, 450, 'no', 'no', 'EineWohnunginBielefeld'),
('Dortmund', '33881', 'Telefonstraße', '1', 'wreger@e-mail.de', 220, 'no', 3, 450, 'no', 'no', 'EineWohnunginBielefeld'),
('Dortmund', '33881', 'Telefonstraße', '17', 'abcd@e-mail.de', 220, 'no', 3, 450, 'no', 'no', 'EineWohnunginBielefeld'),
('Dortmund', '33881', 'Telefonstraße', '27', 'efgh@e-mail.de', 220, 'no', 3, 450, 'no', 'no', 'EineWohnunginBielefeld'),
('Dortmund', '33881', 'Telefonstraße', '37', 'ijkl@e-mail.de', 220, 'no', 3, 450, 'no', 'no', 'EineWohnunginBielefeld'),
('Dortmund', '33881', 'Telefonstraße', '7', 'wreger@e-mail.de', 220, 'no', 3, 450, 'no', 'no', 'EineWohnunginBielefeld'),
('Kiel', '66666', 'BerlinerWeg', '1616', 'abcd@e-mail.de', 20, 'no', 1, 3000, 'yes', 'no', 'KleinaberfeinunddaszueinembilligenPreis.'),
('Kiel', '66666', 'BerlinerWeg', '2616', 'efgh@e-mail.de', 20, 'no', 1, 3000, 'yes', 'no', 'KleinaberfeinunddaszueinembilligenPreis.'),
('Kiel', '66666', 'BerlinerWeg', '3616', 'ijkl@e-mail.de', 20, 'no', 1, 3000, 'yes', 'no', 'KleinaberfeinunddaszueinembilligenPreis.'),
('Kiel', '66666', 'BerlinerWeg', '616', 'wreger@e-mail.de', 20, 'no', 1, 3000, 'yes', 'no', 'KleinaberfeinunddaszueinembilligenPreis.'),
('Kiel', '66666', 'BerlinerWeg', '666', 'wreger@e-mail.de', 20, 'no', 1, 3000, 'yes', 'no', 'KleinaberfeinunddaszueinembilligenPreis.'),
('Köln', '66666', 'BerlinerWeg', '1665', 'abcd@e-mail.de', 20, 'no', 1, 3000, 'yes', 'no', 'KleinaberfeinunddaszueinembilligenPreis.'),
('Köln', '66666', 'BerlinerWeg', '2665', 'efgh@e-mail.de', 20, 'no', 1, 3000, 'yes', 'no', 'KleinaberfeinunddaszueinembilligenPreis.'),
('Köln', '66666', 'BerlinerWeg', '3665', 'ijkl@e-mail.de', 20, 'no', 1, 3000, 'yes', 'no', 'KleinaberfeinunddaszueinembilligenPreis.'),
('Köln', '66666', 'BerlinerWeg', '665', 'wreger@e-mail.de', 20, 'no', 1, 3000, 'yes', 'no', 'KleinaberfeinunddaszueinembilligenPreis.'),
('Köln', '66666', 'BerlinerWeg', '666', 'wreger@e-mail.de', 20, 'no', 1, 3000, 'yes', 'no', 'KleinaberfeinunddaszueinembilligenPreis.'),
('Leopoldshöhe', '32107', 'DetmolderWeg', '12', 'abcd@e-mail.de', 120, 'yes', 2, 750, 'no', 'yes', 'HierwohnteeineBerühmtheitdasistwahrglaubensiemir.'),
('Leopoldshöhe', '32107', 'DetmolderWeg', '2', 'nkoetter@e-mail.de', 120, 'yes', 2, 750, 'no', 'yes', 'HierwohnteeineBerühmtheitdasistwahrglaubensiemir.'),
('Leopoldshöhe', '32107', 'DetmolderWeg', '22', 'efgh@e-mail.de', 120, 'yes', 2, 750, 'no', 'yes', 'HierwohnteeineBerühmtheitdasistwahrglaubensiemir.'),
('Leopoldshöhe', '32107', 'DetmolderWeg', '3', 'nkoetter@e-mail.de', 120, 'yes', 2, 750, 'no', 'yes', 'HierwohnteeineBerühmtheitdasistwahrglaubensiemir.'),
('Leopoldshöhe', '32107', 'DetmolderWeg', '32', 'ijkl@e-mail.de', 120, 'yes', 2, 750, 'no', 'yes', 'HierwohnteeineBerühmtheitdasistwahrglaubensiemir.'),
('Minden', '12345', 'Mindenstraße', '11', 'abcd@e-mail.de', 450, 'yes', 4, 500, 'no', 'yes', 'BilligesApartmentmitgroßenRäumenundsogarBadezimmer'),
('Minden', '12345', 'Mindenstraße', '21', 'efgh@e-mail.de', 450, 'yes', 4, 500, 'no', 'yes', 'BilligesApartmentmitgroßenRäumenundsogarBadezimmer'),
('Minden', '12345', 'Mindenstraße', '31', 'ijkl@e-mail.de', 450, 'yes', 4, 500, 'no', 'yes', 'BilligesApartmentmitgroßenRäumenundsogarBadezimmer'),
('Minden', '12345', 'Mindenstraße', '5', 'nkoetter@e-mail.de', 450, 'yes', 4, 500, 'no', 'yes', 'BilligesApartmentmitgroßenRäumenundsogarBadezimmer'),
('Minden', '12345', 'Mindenstraße', '6', 'nkoetter@e-mail.de', 450, 'yes', 4, 500, 'no', 'yes', 'BilligesApartmentmitgroßenRäumenundsogarBadezimmer'),
('Minden', '33881', 'Telefonstraße', '1', 'wreger@e-mail.de', 220, 'no', 3, 450, 'no', 'no', 'EineWohnunginBielefeld'),
('Minden', '33881', 'Telefonstraße', '12', 'abcd@e-mail.de', 220, 'no', 3, 450, 'no', 'no', 'EineWohnunginBielefeld'),
('Minden', '33881', 'Telefonstraße', '2', 'wreger@e-mail.de', 220, 'no', 3, 450, 'no', 'no', 'EineWohnunginBielefeld'),
('Minden', '33881', 'Telefonstraße', '22', 'efgh@e-mail.de', 220, 'no', 3, 450, 'no', 'no', 'EineWohnunginBielefeld'),
('Minden', '33881', 'Telefonstraße', '32', 'ijkl@e-mail.de', 220, 'no', 3, 450, 'no', 'no', 'EineWohnunginBielefeld'),
('München', '32107', 'DetmolderWeg', '14', 'abcd@e-mail.de', 120, 'yes', 2, 750, 'no', 'yes', 'HierwohnteeineBerühmtheitdasistwahrglaubensiemir.'),
('München', '32107', 'DetmolderWeg', '24', 'efgh@e-mail.de', 120, 'yes', 2, 750, 'no', 'yes', 'HierwohnteeineBerühmtheitdasistwahrglaubensiemir.'),
('München', '32107', 'DetmolderWeg', '3', 'nkoetter@e-mail.de', 120, 'yes', 2, 750, 'no', 'yes', 'HierwohnteeineBerühmtheitdasistwahrglaubensiemir.'),
('München', '32107', 'DetmolderWeg', '34', 'ijkl@e-mail.de', 120, 'yes', 2, 750, 'no', 'yes', 'HierwohnteeineBerühmtheitdasistwahrglaubensiemir.'),
('München', '32107', 'DetmolderWeg', '4', 'nkoetter@e-mail.de', 120, 'yes', 2, 750, 'no', 'yes', 'HierwohnteeineBerühmtheitdasistwahrglaubensiemir.'),
('Neustadt', '12345', 'Mindenstraße', '13', 'abcd@e-mail.de', 450, 'yes', 4, 500, 'no', 'yes', 'BilligesApartmentmitgroßenRäumenundsogarBadezimmer'),
('Neustadt', '12345', 'Mindenstraße', '23', 'efgh@e-mail.de', 450, 'yes', 4, 500, 'no', 'yes', 'BilligesApartmentmitgroßenRäumenundsogarBadezimmer'),
('Neustadt', '12345', 'Mindenstraße', '3', 'nkoetter@e-mail.de', 450, 'yes', 4, 500, 'no', 'yes', 'BilligesApartmentmitgroßenRäumenundsogarBadezimmer'),
('Neustadt', '12345', 'Mindenstraße', '33', 'ijkl@e-mail.de', 450, 'yes', 4, 500, 'no', 'yes', 'BilligesApartmentmitgroßenRäumenundsogarBadezimmer'),
('Neustadt', '12345', 'Mindenstraße', '5', 'nkoetter@e-mail.de', 450, 'yes', 4, 500, 'no', 'yes', 'BilligesApartmentmitgroßenRäumenundsogarBadezimmer'),
('Potsdam', '66666', 'BerlinerWeg', '1626', 'abcd@e-mail.de', 20, 'no', 1, 3000, 'yes', 'no', 'KleinaberfeinunddaszueinembilligenPreis.'),
('Potsdam', '66666', 'BerlinerWeg', '2626', 'efgh@e-mail.de', 20, 'no', 1, 3000, 'yes', 'no', 'KleinaberfeinunddaszueinembilligenPreis.'),
('Potsdam', '66666', 'BerlinerWeg', '3626', 'ijkl@e-mail.de', 20, 'no', 1, 3000, 'yes', 'no', 'KleinaberfeinunddaszueinembilligenPreis.'),
('Potsdam', '66666', 'BerlinerWeg', '626', 'wreger@e-mail.de', 20, 'no', 1, 3000, 'yes', 'no', 'KleinaberfeinunddaszueinembilligenPreis.'),
('Potsdam', '66666', 'BerlinerWeg', '666', 'wreger@e-mail.de', 20, 'no', 1, 3000, 'yes', 'no', 'KleinaberfeinunddaszueinembilligenPreis.'),
('Potsdamn', '12345', 'Mindenstraße', '1', 'nkoetter@e-mail.de', 450, 'yes', 4, 500, 'no', 'yes', 'BilligesApartmentmitgroßenRäumenundsogarBadezimmer'),
('Potsdamn', '12345', 'Mindenstraße', '11', 'abcd@e-mail.de', 450, 'yes', 4, 500, 'no', 'yes', 'BilligesApartmentmitgroßenRäumenundsogarBadezimmer'),
('Potsdamn', '12345', 'Mindenstraße', '21', 'efgh@e-mail.de', 450, 'yes', 4, 500, 'no', 'yes', 'BilligesApartmentmitgroßenRäumenundsogarBadezimmer'),
('Potsdamn', '12345', 'Mindenstraße', '31', 'ijkl@e-mail.de', 450, 'yes', 4, 500, 'no', 'yes', 'BilligesApartmentmitgroßenRäumenundsogarBadezimmer'),
('Potsdamn', '12345', 'Mindenstraße', '5', 'nkoetter@e-mail.de', 450, 'yes', 4, 500, 'no', 'yes', 'BilligesApartmentmitgroßenRäumenundsogarBadezimmer');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `lessor`
--

CREATE TABLE `lessor` (
  `email` char(30) NOT NULL,
  `password` char(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `lessor`
--

INSERT INTO `lessor` (`email`, `password`) VALUES
('abcd@e-mail.de', 'abcd'),
('efgh@e-mail.de', 'efgh'),
('ijkl@e-mail.de', 'ijkl'),
('nkoetter@e-mail.de', '1234'),
('test@e-mail.de', '1234'),
('wreger@e-mail.de', '4321');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `likes`
--

CREATE TABLE `likes` (
  `city` char(20) NOT NULL,
  `zip` char(10) NOT NULL,
  `street` char(30) NOT NULL,
  `housenumber` char(10) NOT NULL,
  `email` char(30) NOT NULL,
  `email_0` char(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `likes`
--

INSERT INTO `likes` (`city`, `zip`, `street`, `housenumber`, `email`, `email_0`) VALUES
('BadSalzuflen', '12345', 'Mindenstraße', '14', 'kneitmann@e-mail.de', 'abcd@e-mail.de'),
('BadSalzuflen', '32107', 'DetmolderWeg', '3', 'anolting@e-mail.de', 'nkoetter@e-mail.de'),
('BadSalzuflen', '32107', 'DetmolderWeg', '3', 'kneitmann@e-mail.de', 'nkoetter@e-mail.de'),
('Berlin', '32107', 'DetmolderWeg', '1', 'kneitmann@e-mail.de', 'nkoetter@e-mail.de'),
('Berlin', '32107', 'DetmolderWeg', '11', 'kneitmann@e-mail.de', 'abcd@e-mail.de');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `matches`
--

CREATE TABLE `matches` (
  `Usersemail` char(30) NOT NULL,
  `lessoremail` char(30) NOT NULL,
  `city` char(20) NOT NULL,
  `zip` char(10) NOT NULL,
  `street` char(30) NOT NULL,
  `housenumber` char(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `matches`
--

INSERT INTO `matches` (`Usersemail`, `lessoremail`, `city`, `zip`, `street`, `housenumber`) VALUES
('nkoetter@e-mail.de', 'kneitmann@e-mail.de', 'Minden', '12345', 'Mindenstraße', '5');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `users`
--

CREATE TABLE `users` (
  `email` char(30) NOT NULL,
  `password` char(10) DEFAULT NULL,
  `Firstname` char(10) DEFAULT NULL,
  `Lastname` char(10) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `picture` char(30) DEFAULT NULL,
  `income` float DEFAULT NULL,
  `job` char(10) DEFAULT NULL,
  `schufa` char(10) DEFAULT NULL,
  `pet` char(10) DEFAULT NULL,
  `persons` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `users`
--

INSERT INTO `users` (`email`, `password`, `Firstname`, `Lastname`, `age`, `picture`, `income`, `job`, `schufa`, `pet`, `persons`) VALUES
('anolting@e-mail.de', '1234', 'Alex', 'Sucher', 27, 'test', 1000, 'bubun', 'yes', 'yes', 1),
('kneitmann@e-mail.de', '4321', 'Waldemar', 'Reger', 25, 'Waldemar', 5000, 'IT', 'yes', 'yes', 3);

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `apartment`
--
ALTER TABLE `apartment`
  ADD PRIMARY KEY (`city`,`zip`,`street`,`housenumber`,`email`),
  ADD KEY `FK_Apartment_0` (`email`);

--
-- Indizes für die Tabelle `lessor`
--
ALTER TABLE `lessor`
  ADD PRIMARY KEY (`email`);

--
-- Indizes für die Tabelle `likes`
--
ALTER TABLE `likes`
  ADD PRIMARY KEY (`city`,`zip`,`street`,`housenumber`,`email`,`email_0`),
  ADD KEY `FK_like_0` (`city`,`zip`,`street`,`housenumber`,`email_0`),
  ADD KEY `FK_like_1` (`email`);

--
-- Indizes für die Tabelle `matches`
--
ALTER TABLE `matches`
  ADD PRIMARY KEY (`Usersemail`,`lessoremail`,`city`,`zip`,`street`,`housenumber`),
  ADD KEY `FK_match_1` (`lessoremail`),
  ADD KEY `FK_match_2` (`city`,`zip`,`street`,`housenumber`,`Usersemail`);

--
-- Indizes für die Tabelle `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`email`);

--
-- Constraints der exportierten Tabellen
--

--
-- Constraints der Tabelle `apartment`
--
ALTER TABLE `apartment`
  ADD CONSTRAINT `FK_Apartment_0` FOREIGN KEY (`email`) REFERENCES `lessor` (`email`);

--
-- Constraints der Tabelle `likes`
--
ALTER TABLE `likes`
  ADD CONSTRAINT `FK_like_0` FOREIGN KEY (`city`,`zip`,`street`,`housenumber`,`email_0`) REFERENCES `apartment` (`city`, `zip`, `street`, `housenumber`, `email`),
  ADD CONSTRAINT `FK_like_1` FOREIGN KEY (`email`) REFERENCES `users` (`email`);

--
-- Constraints der Tabelle `matches`
--
ALTER TABLE `matches`
  ADD CONSTRAINT `FK_match_0` FOREIGN KEY (`Usersemail`) REFERENCES `lessor` (`email`),
  ADD CONSTRAINT `FK_match_1` FOREIGN KEY (`lessoremail`) REFERENCES `users` (`email`),
  ADD CONSTRAINT `FK_match_2` FOREIGN KEY (`city`,`zip`,`street`,`housenumber`,`Usersemail`) REFERENCES `apartment` (`city`, `zip`, `street`, `housenumber`, `email`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
