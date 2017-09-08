-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Set 08, 2017 alle 12:59
-- Versione del server: 10.1.26-MariaDB
-- Versione PHP: 7.1.8

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
(4, 'Sn un hacker1!!!11!!!!', 0, 10, 2, 9),
(7, 'Bel gioco', 0, 0, 0, 8);

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `review`
--
ALTER TABLE `review`
  ADD PRIMARY KEY (`idReview`),
  ADD KEY `fk_user_iduser_idx` (`user_iduser`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `review`
--
ALTER TABLE `review`
  MODIFY `idReview` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
