-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Ott 12, 2017 alle 23:18
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
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dump dei dati per la tabella `game`
--

INSERT INTO `game` (`idGame`, `name`) VALUES
(1, 'Civilization VI'),
(2, 'Crash Bandicoot N. Sane Trilogy'),
(3, 'For Honor'),
(4, 'The Legend of Zelda Breath of the Wild'),
(5, 'Destiny 2'),
(6, 'Fifa 17'),
(7, 'Resident Evil 7 Biohazard'),
(8, 'Mass Effect Andromeda'),
(9, 'Dark Souls III'),
(10, 'Watch Dogs'),
(11, 'Fallout 3');

-- --------------------------------------------------------

--
-- Struttura della tabella `review`
--

CREATE TABLE `review` (
  `idReview` int(4) NOT NULL,
  `Text` varchar(256) NOT NULL,
  `Approved` tinyint(1) NOT NULL DEFAULT '0',
  `Game_idGame` int(4) NOT NULL DEFAULT '0',
  `user_iduser` int(6) NOT NULL DEFAULT '0',
  `vote` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dump dei dati per la tabella `review`
--

INSERT INTO `review` (`idReview`, `Text`, `Approved`, `Game_idGame`, `user_iduser`, `vote`) VALUES
(1, 'Mi è piaciuto ma mi ha tolto troppo tempo per preparare la Eramo perciò lo boccio.', 1, 9, 1, 5),
(2, 'Mia mamma mi ha detto che è troppo violento ma non capisce niente, mi sono fomentato. Bellissimo.', 1, 3, 4, 8),
(3, 'Mi ha ricordato la mia infanzia ma al gamestop mi hanno dissanguato, adesso lo odio.', 1, 2, 6, 4),
(4, 'Sn un hacker1!!!11!!!!', 1, 10, 2, 9),
(7, 'Bel gioco', 1, 0, 0, 8),
(8, 'sad', 1, 11, 1, 1),
(9, 'Figata', 1, 11, 2, 5);

-- --------------------------------------------------------

--
-- Struttura della tabella `timeline`
--

CREATE TABLE `timeline` (
  `idTimeline` int(10) NOT NULL,
  `Premio` tinytext NOT NULL,
  `data` tinytext NOT NULL,
  `User_idUser` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dump dei dati per la tabella `timeline`
--

INSERT INTO `timeline` (`idTimeline`, `Premio`, `data`, `User_idUser`) VALUES
(1, 'Premio di Benvenuto Lvl.1', '09/09/2017-09:09:15', 1),
(2, 'Premio di Benvenuto Lvl.1', '09/09/2017-09:09:15', 2),
(3, 'Premio di Benvenuto Lvl.1', '09/09/2017-09:09:15', 3),
(4, 'Premio di Benvenuto Lvl.1', '09/09/2017-09:09:15', 4),
(5, 'Premio di Benvenuto Lvl.1', '09/09/2017-09:09:15', 5),
(6, 'Premio di Benvenuto Lvl.1', '09/09/2017-09:09:15', 6),
(7, 'Premio di Benvenuto Lvl.1', '09/09/2017-09:09:15', 7),
(8, 'Premio di Benvenuto Lvl.1', '09/09/2017-09:09:15', 8),
(9, 'Premio di Benvenuto Lvl.1', '09/09/2017-09:09:15', 9),
(10, 'Premio di Benvenuto Lvl.1', '09/09/2017-09:09:15', 10),
(11, 'Premio di Benvenuto Lvl.1', '09/09/2017-09:09:15', 11),
(12, 'Premio di Benvenuto Lvl.1', '09/09/2017-09:09:15', 12),
(13, 'Premio di Benvenuto Lvl.1', '09/09/2017-09:09:15', 13),
(14, 'Premio di Benvenuto Lvl.1', '09/09/2017-09:09:15', 14),
(15, 'Premio Lvl.2', '26/09/2017-03:18:21', 1),
(16, 'Premio lv.2', '03/10/2017-08:35:32', 6),
(17, 'Premio lv.3', '03/10/2017-08:35:38', 6),
(18, 'Premio lv.3', '04/10/2017-11:35:58', 1);

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
  `type` varchar(14) NOT NULL DEFAULT 'giocatore',
  `exp` int(6) NOT NULL,
  `level` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dump dei dati per la tabella `user`
--

INSERT INTO `user` (`idUser`, `name`, `surname`, `email`, `username`, `password`, `type`, `exp`, `level`) VALUES
(1, 'Lorenzo', 'Collevecchio', 'lorenzocollevecchio@outlook.com', 'Coll', '1234', 'moderatore', 350, 3),
(2, 'Francesco', 'Giostra', 'francescogiostra@outlook.com', 'Gios', 'Francesco01', 'moderatore', 0, 1),
(3, 'Matteo', 'Ficorilli', 'matteoficorilli@outlook.com', 'Fico', '1234', 'moderatore', 0, 1),
(4, 'Lorenzo', 'Luna', 'lorenzoluna@outlook.com', 'Luna', '1234', 'moderatore', 0, 1),
(5, 'Elisa', 'Coccia', 'elisacoccia@outlook.com', 'Cocc', '1234', 'giocatore', 0, 1),
(6, 'Filippo', 'Cristofaro', 'filippocristofaro@outlook.com', 'Cris', '1234', 'giocatore', 300, 3),
(7, 'Erika', 'Olivieri', 'erikaolivieri@outlook.com', 'Oliv', '1234', 'giocatore', 0, 1),
(8, 'Valeria', 'Falone', 'valeriafalone@outlook.com', 'Falo', '1234', 'giocatore', 0, 1),
(9, 'Daniela', 'Fascioli', 'danielafascioli@outlook.com', 'Fasc', '1234', 'giocatore', 0, 1),
(10, 'Fabio', 'Capitanio', 'fabiocapitanio@outlook.com', 'Capi', '1234', 'giocatore', 0, 1),
(11, 'Antonio', 'Corsi', 'antoniocorsi@outlook.com', 'Cors', '1234', 'giocatore', 0, 1),
(12, 'Claudia', 'Stella', 'claudiastella@outlook.com', 'Stel', '1234', 'giocatore', 0, 1),
(13, 'Paola', 'Masiello', 'paolamasiello@outlook.com', 'Masi', '1234', 'giocatore', 0, 1),
(14, 'Stefano', 'Pisciella', 'stefanopisciella@outlook.com', 'Pisc', '1234', 'giocatore', 0, 1);

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
  ADD KEY `fk_user_iduser_idx` (`user_iduser`);

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
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `review`
--
ALTER TABLE `review`
  MODIFY `idReview` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT per la tabella `timeline`
--
ALTER TABLE `timeline`
  MODIFY `idTimeline` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
--
-- AUTO_INCREMENT per la tabella `user`
--
ALTER TABLE `user`
  MODIFY `idUser` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `timeline`
--
ALTER TABLE `timeline`
  ADD CONSTRAINT `fk_Timeline_User1` FOREIGN KEY (`User_idUser`) REFERENCES `user` (`idUser`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
