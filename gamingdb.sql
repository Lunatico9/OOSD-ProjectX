-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Ago 09, 2017 alle 15:29
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
-- Database: `gamingdb`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `game`
--

CREATE TABLE `game` (
  `idGame` int(4) NOT NULL,
  `name` varchar(50) NOT NULL,
  `points` int(3) NOT NULL DEFAULT '10'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dump dei dati per la tabella `game`
--

INSERT INTO `game` (`idGame`, `name`, `points`) VALUES
(1, 'Civilization VI', 10),
(2, 'Crash Bandicoot: N. Sane Trilogy', 10),
(3, 'For Honor', 10),
(4, 'The Legend of Zelda: Breath of the Wild', 10),
(5, 'Destiny 2', 10),
(6, 'Fifa 17', 10),
(7, 'Resident Evil 7: Biohazard', 10),
(8, 'Mass Effect: Andromeda', 10),
(9, 'Dark Souls III', 10),
(10, 'Watch Dogs', 10);

-- --------------------------------------------------------

--
-- Struttura della tabella `review`
--

CREATE TABLE `review` (
  `idReview` int(4) NOT NULL,
  `Text` varchar(256) NOT NULL,
  `Approved` tinyint(1) NOT NULL DEFAULT '0',
  `Game_idGame` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dump dei dati per la tabella `review`
--

INSERT INTO `review` (`idReview`, `Text`, `Approved`, `Game_idGame`) VALUES
(1, 'Recensione positiva', 0, 9),
(2, 'Recensione negativa', 1, 3),
(3, 'Recensione positiva', 0, 2),
(4, 'Recensione negativa', 1, 10);

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
(3, 'Matteo', 'Ficorilli', 'matteoficorilli@outlook.com', 'Fico', '1234', 'giocatore'),
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
  `Game_idGame` int(4) NOT NULL,
  `User_idUser` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dump dei dati per la tabella `vote`
--

INSERT INTO `vote` (`idVote`, `vote`, `Game_idGame`, `User_idUser`) VALUES
(1, 4, 9, 1),
(2, 3, 10, 2),
(3, 5, 2, 3),
(4, 3, 3, 4);

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
  ADD PRIMARY KEY (`idReview`),
  ADD KEY `fk_Review_Game_idx` (`Game_idGame`);

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
  ADD PRIMARY KEY (`idVote`,`Game_idGame`,`User_idUser`),
  ADD KEY `fk_Vote_Game1_idx` (`Game_idGame`),
  ADD KEY `fk_Vote_User1_idx` (`User_idUser`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

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
-- Limiti per la tabella `review`
--
ALTER TABLE `review`
  ADD CONSTRAINT `fk_Review_Game` FOREIGN KEY (`Game_idGame`) REFERENCES `game` (`idGame`) ON DELETE NO ACTION ON UPDATE NO ACTION;

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
  ADD CONSTRAINT `fk_Vote_Game1` FOREIGN KEY (`Game_idGame`) REFERENCES `game` (`idGame`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Vote_User1` FOREIGN KEY (`User_idUser`) REFERENCES `user` (`idUser`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
