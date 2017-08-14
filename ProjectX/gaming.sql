-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Ago 14, 2017 alle 18:48
-- Versione del server: 10.1.25-MariaDB
-- Versione PHP: 7.1.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gaming`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `game`
--

CREATE TABLE `game` (
  `idGame` int(4) NOT NULL,
  `name` varchar(50) NOT NULL,
  `datadiuscita` int(8) DEFAULT NULL,
  `genere` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dump dei dati per la tabella `game`
--

INSERT INTO `game` (`idGame`, `name`, `datadiuscita`, `genere`) VALUES
(1, 'Civilization VI', 2016, 'Strategico'),
(2, 'Crash Bandicoot: N. Sane Trilogy', 2017, 'Azione'),
(3, 'For Honor', 2017, 'Azione'),
(4, 'The Legend of Zelda: Breath of the Wild', 2017, 'Avventura'),
(5, 'Destiny 2', 2017, 'RPG'),
(6, 'Fifa 17', 2016, 'Sport'),
(7, 'Resident Evil 7: Biohazard', 2017, 'Sparatutto'),
(8, 'Mass Effect: Andromeda', 2017, 'RPG'),
(9, 'Dark Souls III', 2016, 'RPG'),
(10, 'Watch Dogs', 2014, 'Avventura');

-- --------------------------------------------------------

--
-- Struttura della tabella `review`
--

CREATE TABLE `review` (
  `idReview` int(4) NOT NULL,
  `Text` varchar(256) NOT NULL,
  `Approved` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dump dei dati per la tabella `review`
--

INSERT INTO `review` (`idReview`, `Text`, `Approved`) VALUES
(1, 'Recensione positiva', 0),
(2, 'Recensione negativa', 1),
(3, 'Recensione positiva', 0),
(4, 'Recensione negativa', 1);

-- --------------------------------------------------------

--
-- Struttura della tabella `timeline`
--

CREATE TABLE `timeline` (
  `idTimeline` int(10) NOT NULL,
  `level` int(10) NOT NULL,
  `data` date NOT NULL,
  `User_idUser` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struttura della tabella `user`
--

CREATE TABLE `user` (
  `idUser` int(6) NOT NULL,
  `name` varchar(20) NOT NULL,
  `surname` varchar(20) NOT NULL,
  `email` varchar(40) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(20) NOT NULL,
  `type` varchar(14) NOT NULL DEFAULT 'giocatore'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dump dei dati per la tabella `user`
--

INSERT INTO `user` (`idUser`, `name`, `surname`, `email`, `username`, `password`, `type`) VALUES
(1, 'Lorenzo', 'Collevecchio', 'lorenzocollevecchio@outlook.com', 'Coll', '1234', 'amministratore'),
(2, 'Francesco', 'Giostra', 'francescogiostra@outlook.com', 'Gios', '1234', 'giocatore'),
(3, 'Matteo', 'Ficorilli', 'matteoficorilli@outlook.com', 'Fico', '1234', 'amministratore'),
(4, 'Lorenzo', 'Luna', 'lorenzoluna@outlook.com', 'Luna', '1234', 'moderatore');

-- --------------------------------------------------------

--
-- Struttura della tabella `user_game`
--

CREATE TABLE `user_game` (
  `experiencepoints` int(10) NOT NULL DEFAULT '0',
  `User_idUser` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dump dei dati per la tabella `user_game`
--

INSERT INTO `user_game` (`experiencepoints`, `User_idUser`) VALUES
(50, 1),
(20, 2),
(30, 3),
(40, 4);

-- --------------------------------------------------------

--
-- Struttura della tabella `vote`
--

CREATE TABLE `vote` (
  `idVote` int(10) NOT NULL,
  `vote` int(1) NOT NULL,
  `User_idUser` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dump dei dati per la tabella `vote`
--

INSERT INTO `vote` (`idVote`, `vote`, `User_idUser`) VALUES
(1, 4, 1),
(2, 3, 2),
(3, 5, 3),
(4, 3, 4);

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `game`
--
ALTER TABLE `game`
  ADD PRIMARY KEY (`idGame`);

--
-- Indici per le tabelle `review`
--
ALTER TABLE `review`
  ADD PRIMARY KEY (`idReview`);

--
-- Indici per le tabelle `timeline`
--
ALTER TABLE `timeline`
  ADD PRIMARY KEY (`idTimeline`),
  ADD KEY `fk_Timeline_User1_idx` (`User_idUser`);

--
-- Indici per le tabelle `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`idUser`);

--
-- Indici per le tabelle `user_game`
--
ALTER TABLE `user_game`
  ADD KEY `fk_User_game_User1_idx` (`User_idUser`);

--
-- Indici per le tabelle `vote`
--
ALTER TABLE `vote`
  ADD PRIMARY KEY (`idVote`,`User_idUser`),
  ADD KEY `fk_Vote_User1_idx` (`User_idUser`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `game`
--
ALTER TABLE `game`
  MODIFY `idGame` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT per la tabella `review`
--
ALTER TABLE `review`
  MODIFY `idReview` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT per la tabella `timeline`
--
ALTER TABLE `timeline`
  MODIFY `idTimeline` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT per la tabella `user`
--
ALTER TABLE `user`
  MODIFY `idUser` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT per la tabella `vote`
--
ALTER TABLE `vote`
  MODIFY `idVote` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `timeline`
--
ALTER TABLE `timeline`
  ADD CONSTRAINT `fk_Timeline_User1` FOREIGN KEY (`User_idUser`) REFERENCES `user` (`idUser`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limiti per la tabella `user_game`
--
ALTER TABLE `user_game`
  ADD CONSTRAINT `fk_User_game_User1` FOREIGN KEY (`User_idUser`) REFERENCES `user` (`idUser`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limiti per la tabella `vote`
--
ALTER TABLE `vote`
  ADD CONSTRAINT `fk_Vote_User1` FOREIGN KEY (`User_idUser`) REFERENCES `user` (`idUser`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
