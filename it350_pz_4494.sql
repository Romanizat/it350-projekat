-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 16, 2022 at 12:16 AM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 7.3.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `it350_pz_4494`
--
CREATE DATABASE IF NOT EXISTS `it350_pz_4494` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `it350_pz_4494`;

-- --------------------------------------------------------

--
-- Table structure for table `arena`
--
-- Creation: Jan 15, 2022 at 02:59 PM
-- Last update: Jan 15, 2022 at 07:06 PM
--

DROP TABLE IF EXISTS `arena`;
CREATE TABLE IF NOT EXISTS `arena` (
  `arena_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(1024) NOT NULL,
  `country` varchar(1024) NOT NULL,
  `city` varchar(1024) NOT NULL,
  PRIMARY KEY (`arena_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

--
-- RELATIONSHIPS FOR TABLE `arena`:
--

--
-- Dumping data for table `arena`
--

INSERT INTO `arena` (`arena_id`, `name`, `country`, `city`) VALUES
(1, 'PGL Major', 'China', 'Beijing'),
(2, 'ELEAGUE Major: Boston', 'USA', 'Boston'),
(3, 'FACEIT Major: London', 'UK', 'London');

-- --------------------------------------------------------

--
-- Table structure for table `game`
--
-- Creation: Jan 15, 2022 at 02:59 PM
-- Last update: Jan 15, 2022 at 03:53 PM
--

DROP TABLE IF EXISTS `game`;
CREATE TABLE IF NOT EXISTS `game` (
  `game_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(1024) NOT NULL,
  `release_year` int(11) NOT NULL,
  `publisher` varchar(1024) NOT NULL,
  PRIMARY KEY (`game_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

--
-- RELATIONSHIPS FOR TABLE `game`:
--

--
-- Dumping data for table `game`
--

INSERT INTO `game` (`game_id`, `name`, `release_year`, `publisher`) VALUES
(1, 'Counter-Strike: Global Offensive\r\n', 2012, 'Valve'),
(2, 'League of Legends', 2009, 'Riot Games'),
(4, 'Fortnite', 2017, 'Epic Games'),
(5, 'Dota 2', 2013, 'Valve');

-- --------------------------------------------------------

--
-- Table structure for table `game_genre`
--
-- Creation: Jan 15, 2022 at 02:59 PM
-- Last update: Jan 15, 2022 at 06:00 PM
--

DROP TABLE IF EXISTS `game_genre`;
CREATE TABLE IF NOT EXISTS `game_genre` (
  `game_genre_id` int(11) NOT NULL AUTO_INCREMENT,
  `genre_id` int(11) NOT NULL,
  `game_id` int(11) NOT NULL,
  PRIMARY KEY (`game_genre_id`,`genre_id`,`game_id`),
  KEY `fk_is` (`genre_id`),
  KEY `fk_is2` (`game_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

--
-- RELATIONSHIPS FOR TABLE `game_genre`:
--   `genre_id`
--       `genre` -> `genre_id`
--   `game_id`
--       `game` -> `game_id`
--

--
-- Dumping data for table `game_genre`
--

INSERT INTO `game_genre` (`game_genre_id`, `genre_id`, `game_id`) VALUES
(1, 5, 1),
(2, 4, 2),
(3, 6, 2);

-- --------------------------------------------------------

--
-- Table structure for table `genre`
--
-- Creation: Jan 15, 2022 at 02:59 PM
-- Last update: Jan 15, 2022 at 05:59 PM
--

DROP TABLE IF EXISTS `genre`;
CREATE TABLE IF NOT EXISTS `genre` (
  `genre_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(1024) NOT NULL,
  PRIMARY KEY (`genre_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

--
-- RELATIONSHIPS FOR TABLE `genre`:
--

--
-- Dumping data for table `genre`
--

INSERT INTO `genre` (`genre_id`, `name`) VALUES
(1, 'Sandbox'),
(2, 'Real-time strategy (RTS)'),
(3, 'RPG'),
(4, 'MOBA'),
(5, 'FPS'),
(6, 'Action-adventure');

-- --------------------------------------------------------

--
-- Table structure for table `host`
--
-- Creation: Jan 15, 2022 at 02:59 PM
-- Last update: Jan 15, 2022 at 06:07 PM
--

DROP TABLE IF EXISTS `host`;
CREATE TABLE IF NOT EXISTS `host` (
  `host_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(1024) NOT NULL,
  `last_name` varchar(1024) NOT NULL,
  `gender` varchar(1024) NOT NULL,
  `jmbg` varchar(13) NOT NULL,
  `years_experience` int(11) NOT NULL,
  PRIMARY KEY (`host_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

--
-- RELATIONSHIPS FOR TABLE `host`:
--

--
-- Dumping data for table `host`
--

INSERT INTO `host` (`host_id`, `first_name`, `last_name`, `gender`, `jmbg`, `years_experience`) VALUES
(1, 'Peter', 'Dean', 'Male', '1234567891011', 5),
(2, 'Nicholas', 'Flamel', 'Male', '5125001232131', 9),
(3, 'Missy', 'Fortune', 'Female', '2910999750074', 2);

-- --------------------------------------------------------

--
-- Table structure for table `pc`
--
-- Creation: Jan 15, 2022 at 02:59 PM
-- Last update: Jan 15, 2022 at 06:13 PM
--

DROP TABLE IF EXISTS `pc`;
CREATE TABLE IF NOT EXISTS `pc` (
  `pc_id` int(11) NOT NULL AUTO_INCREMENT,
  `gpu` varchar(1024) NOT NULL,
  `cpu` varchar(1024) NOT NULL,
  `ram` int(11) NOT NULL,
  `ip_address` varchar(1024) NOT NULL,
  PRIMARY KEY (`pc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

--
-- RELATIONSHIPS FOR TABLE `pc`:
--

--
-- Dumping data for table `pc`
--

INSERT INTO `pc` (`pc_id`, `gpu`, `cpu`, `ram`, `ip_address`) VALUES
(1, 'Nvidia GeForce RTX 3060 Ti', 'Intel i3 Quad Core 3.4GHz', 8, '192.168.12.8'),
(2, 'Nvidia GeForce GTX 650i', 'AMD 2.6GHz', 16, '192.168.11.7'),
(3, 'Nvidia GeForce RTX 1080 Ti\r\n', 'Intel i7 Quad Core 3.4GHz\r\n', 16, '192.168.16.42'),
(4, 'AMD Radeon RX 6600 XT', 'AMD Ryzen 5000', 16, '192.168.18.7');

-- --------------------------------------------------------

--
-- Table structure for table `player`
--
-- Creation: Jan 15, 2022 at 02:59 PM
-- Last update: Jan 15, 2022 at 06:36 PM
--

DROP TABLE IF EXISTS `player`;
CREATE TABLE IF NOT EXISTS `player` (
  `player_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(1024) NOT NULL,
  `last_name` varchar(1024) NOT NULL,
  `gender` varchar(1024) NOT NULL,
  `team_id` int(11) NOT NULL,
  `dob` date NOT NULL,
  `ign` varchar(1024) NOT NULL,
  PRIMARY KEY (`player_id`),
  UNIQUE KEY `ign` (`ign`) USING HASH,
  KEY `fk_has` (`team_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

--
-- RELATIONSHIPS FOR TABLE `player`:
--   `team_id`
--       `team` -> `team_id`
--

--
-- Dumping data for table `player`
--

INSERT INTO `player` (`player_id`, `first_name`, `last_name`, `gender`, `team_id`, `dob`, `ign`) VALUES
(1, 'Abay', 'Khasenov', 'Male', 2, '1996-01-10', 'Hobbit'),
(2, 'Timofey', 'Yakushin', 'Male', 2, '1997-04-14', 'interz'),
(3, 'Sergey', 'Rykhtorov', 'Male', 2, '2002-05-12', 'Ax1Le'),
(4, 'Nemanja', 'Isaković', 'Male', 3, '1998-05-19', 'nexa'),
(5, 'Audric', 'Jug', 'Male', 3, '1993-09-08', 'JACKZ'),
(6, 'Nikola\r\n', 'Kovač', 'Male', 3, '1998-08-05', 'NiKo'),
(7, 'Aleksandr', 'Kostyliev', 'Male', 1, '1998-03-04', 's1mple'),
(8, 'Peter', 'Rasmussen', 'Male', 4, '1992-07-25', 'dupreeh'),
(9, 'Dan', 'Madesclaire', 'Male', 4, '1994-01-28', 'apEX');

-- --------------------------------------------------------

--
-- Table structure for table `prize`
--
-- Creation: Jan 15, 2022 at 02:59 PM
-- Last update: Jan 15, 2022 at 11:02 PM
--

DROP TABLE IF EXISTS `prize`;
CREATE TABLE IF NOT EXISTS `prize` (
  `prize_id` int(11) NOT NULL AUTO_INCREMENT,
  `sponsor_id` int(11) NOT NULL,
  `name` varchar(1024) NOT NULL,
  `description` varchar(1024) NOT NULL,
  PRIMARY KEY (`prize_id`),
  KEY `fk_finances` (`sponsor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

--
-- RELATIONSHIPS FOR TABLE `prize`:
--   `sponsor_id`
--       `sponsor` -> `sponsor_id`
--

--
-- Dumping data for table `prize`
--

INSERT INTO `prize` (`prize_id`, `sponsor_id`, `name`, `description`) VALUES
(1, 4, '1st Place Adria', '1st Place on Adria League'),
(2, 4, '2nd Place Adria', '2nd Place on Adria League'),
(3, 4, '3rd Place Adria', '3rd Place on Adria League'),
(4, 1, '1st Place EU', '1st Place on Euro League'),
(5, 1, '2nd Place EU', '2nd Place on Euro League'),
(6, 1, '3rd Place EU', '3rd Place on Euro League'),
(7, 3, 'das', 'sadfdsf');

-- --------------------------------------------------------

--
-- Table structure for table `sponsor`
--
-- Creation: Jan 15, 2022 at 02:59 PM
-- Last update: Jan 15, 2022 at 06:39 PM
--

DROP TABLE IF EXISTS `sponsor`;
CREATE TABLE IF NOT EXISTS `sponsor` (
  `sponsor_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(1024) NOT NULL,
  PRIMARY KEY (`sponsor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

--
-- RELATIONSHIPS FOR TABLE `sponsor`:
--

--
-- Dumping data for table `sponsor`
--

INSERT INTO `sponsor` (`sponsor_id`, `name`) VALUES
(1, 'Coca-Cola'),
(2, 'Red Bull'),
(3, 'Guarana'),
(4, 'Razer'),
(5, 'HyperX');

-- --------------------------------------------------------

--
-- Table structure for table `team`
--
-- Creation: Jan 15, 2022 at 02:59 PM
-- Last update: Jan 15, 2022 at 06:57 PM
--

DROP TABLE IF EXISTS `team`;
CREATE TABLE IF NOT EXISTS `team` (
  `team_id` int(11) NOT NULL AUTO_INCREMENT,
  `pc_id` int(11) NOT NULL,
  `name` varchar(1024) NOT NULL,
  `year_est` int(11) NOT NULL,
  `tag` varchar(1024) NOT NULL,
  PRIMARY KEY (`team_id`),
  UNIQUE KEY `tag` (`tag`) USING HASH,
  KEY `fk_plays_on` (`pc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

--
-- RELATIONSHIPS FOR TABLE `team`:
--   `pc_id`
--       `pc` -> `pc_id`
--

--
-- Dumping data for table `team`
--

INSERT INTO `team` (`team_id`, `pc_id`, `name`, `year_est`, `tag`) VALUES
(1, 4, 'Natus Vincere', 2021, 'NaVi'),
(2, 2, 'Gambit', 2020, 'Gambit'),
(3, 1, 'G2', 2015, 'G2'),
(4, 3, 'Vitality', 2015, 'Vitality');

-- --------------------------------------------------------

--
-- Stand-in structure for view `team_players`
-- (See below for the actual view)
--
DROP VIEW IF EXISTS `team_players`;
CREATE TABLE IF NOT EXISTS `team_players` (
`tag` varchar(1024)
,`players` bigint(21)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `team_prizes`
-- (See below for the actual view)
--
DROP VIEW IF EXISTS `team_prizes`;
CREATE TABLE IF NOT EXISTS `team_prizes` (
`prize_id` int(11)
,`team_id` int(11)
);

-- --------------------------------------------------------

--
-- Table structure for table `team_sponsor`
--
-- Creation: Jan 15, 2022 at 02:59 PM
-- Last update: Jan 15, 2022 at 06:40 PM
--

DROP TABLE IF EXISTS `team_sponsor`;
CREATE TABLE IF NOT EXISTS `team_sponsor` (
  `team_sponsor_id` int(11) NOT NULL AUTO_INCREMENT,
  `sponsor_id` int(11) NOT NULL,
  `team_id` int(11) NOT NULL,
  PRIMARY KEY (`team_sponsor_id`,`sponsor_id`,`team_id`),
  KEY `fk_sponsored` (`sponsor_id`),
  KEY `fk_sponsored2` (`team_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

--
-- RELATIONSHIPS FOR TABLE `team_sponsor`:
--   `sponsor_id`
--       `sponsor` -> `sponsor_id`
--   `team_id`
--       `team` -> `team_id`
--

--
-- Dumping data for table `team_sponsor`
--

INSERT INTO `team_sponsor` (`team_sponsor_id`, `sponsor_id`, `team_id`) VALUES
(1, 5, 4),
(2, 2, 3),
(3, 3, 2),
(4, 4, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tournament`
--
-- Creation: Jan 15, 2022 at 02:59 PM
-- Last update: Jan 15, 2022 at 06:46 PM
--

DROP TABLE IF EXISTS `tournament`;
CREATE TABLE IF NOT EXISTS `tournament` (
  `tournament_id` int(11) NOT NULL AUTO_INCREMENT,
  `arena_id` int(11) NOT NULL,
  `game_id` int(11) DEFAULT NULL,
  `name` varchar(1024) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`tournament_id`),
  KEY `fk_is_located_at` (`arena_id`),
  KEY `fk_plays` (`game_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

--
-- RELATIONSHIPS FOR TABLE `tournament`:
--   `arena_id`
--       `arena` -> `arena_id`
--   `game_id`
--       `game` -> `game_id`
--

--
-- Dumping data for table `tournament`
--

INSERT INTO `tournament` (`tournament_id`, `arena_id`, `game_id`, `name`, `date`) VALUES
(1, 1, 1, 'CS:GO Major PGL Krakow', '2022-04-01'),
(2, 3, 1, 'CS:GO Major Faceit London', '2022-01-04');

-- --------------------------------------------------------

--
-- Table structure for table `tournament_host`
--
-- Creation: Jan 15, 2022 at 02:59 PM
-- Last update: Jan 15, 2022 at 08:45 PM
--

DROP TABLE IF EXISTS `tournament_host`;
CREATE TABLE IF NOT EXISTS `tournament_host` (
  `tournament_host_id` int(11) NOT NULL AUTO_INCREMENT,
  `host_id` int(11) NOT NULL,
  `tournament_id` int(11) NOT NULL,
  PRIMARY KEY (`tournament_host_id`,`host_id`,`tournament_id`),
  KEY `fk_hosted` (`host_id`),
  KEY `fk_hosted2` (`tournament_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

--
-- RELATIONSHIPS FOR TABLE `tournament_host`:
--   `host_id`
--       `host` -> `host_id`
--   `tournament_id`
--       `tournament` -> `tournament_id`
--

--
-- Dumping data for table `tournament_host`
--

INSERT INTO `tournament_host` (`tournament_host_id`, `host_id`, `tournament_id`) VALUES
(1, 3, 2),
(2, 2, 1),
(3, 3, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tournament_prize`
--
-- Creation: Jan 15, 2022 at 02:59 PM
-- Last update: Jan 15, 2022 at 06:53 PM
--

DROP TABLE IF EXISTS `tournament_prize`;
CREATE TABLE IF NOT EXISTS `tournament_prize` (
  `tournament_prize_id` int(11) NOT NULL AUTO_INCREMENT,
  `prize_id` int(11) NOT NULL,
  `team_id` int(11) NOT NULL,
  `tournament_id` int(11) NOT NULL,
  PRIMARY KEY (`tournament_prize_id`),
  KEY `fk_awards` (`prize_id`),
  KEY `fk_on` (`tournament_id`),
  KEY `fk_won` (`team_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

--
-- RELATIONSHIPS FOR TABLE `tournament_prize`:
--   `prize_id`
--       `prize` -> `prize_id`
--   `tournament_id`
--       `tournament` -> `tournament_id`
--   `team_id`
--       `team` -> `team_id`
--

--
-- Dumping data for table `tournament_prize`
--

INSERT INTO `tournament_prize` (`tournament_prize_id`, `prize_id`, `team_id`, `tournament_id`) VALUES
(1, 4, 3, 2),
(2, 5, 1, 2),
(3, 6, 2, 2),
(4, 1, 4, 1),
(5, 2, 2, 1),
(6, 3, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tournament_team`
--
-- Creation: Jan 15, 2022 at 02:59 PM
-- Last update: Jan 15, 2022 at 06:48 PM
--

DROP TABLE IF EXISTS `tournament_team`;
CREATE TABLE IF NOT EXISTS `tournament_team` (
  `tournament_team_id` int(11) NOT NULL AUTO_INCREMENT,
  `tournament_id` int(11) NOT NULL,
  `team_id` int(11) NOT NULL,
  PRIMARY KEY (`tournament_team_id`,`tournament_id`,`team_id`),
  KEY `fk_participates` (`tournament_id`),
  KEY `fk_participates2` (`team_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

--
-- RELATIONSHIPS FOR TABLE `tournament_team`:
--   `tournament_id`
--       `tournament` -> `tournament_id`
--   `team_id`
--       `team` -> `team_id`
--

--
-- Dumping data for table `tournament_team`
--

INSERT INTO `tournament_team` (`tournament_team_id`, `tournament_id`, `team_id`) VALUES
(1, 2, 2),
(2, 2, 1),
(3, 2, 4),
(4, 1, 3),
(5, 1, 1),
(6, 1, 2),
(7, 1, 4);

-- --------------------------------------------------------

--
-- Structure for view `team_players` exported as a table
--
DROP TABLE IF EXISTS `team_players`;
CREATE TABLE IF NOT EXISTS `team_players`(
    `tag` varchar(1024) COLLATE utf8mb4_general_ci NOT NULL,
    `players` bigint(21) NOT NULL DEFAULT '0'
);

-- --------------------------------------------------------

--
-- Structure for view `team_prizes` exported as a table
--
DROP TABLE IF EXISTS `team_prizes`;
CREATE TABLE IF NOT EXISTS `team_prizes`(
    `prize_id` int(11) NOT NULL,
    `team_id` int(11) NOT NULL
);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `game_genre`
--
ALTER TABLE `game_genre`
  ADD CONSTRAINT `fk_is` FOREIGN KEY (`genre_id`) REFERENCES `genre` (`genre_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_is2` FOREIGN KEY (`game_id`) REFERENCES `game` (`game_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `player`
--
ALTER TABLE `player`
  ADD CONSTRAINT `fk_has` FOREIGN KEY (`team_id`) REFERENCES `team` (`team_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `prize`
--
ALTER TABLE `prize`
  ADD CONSTRAINT `fk_finances` FOREIGN KEY (`sponsor_id`) REFERENCES `sponsor` (`sponsor_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `team`
--
ALTER TABLE `team`
  ADD CONSTRAINT `fk_plays_on` FOREIGN KEY (`pc_id`) REFERENCES `pc` (`pc_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `team_sponsor`
--
ALTER TABLE `team_sponsor`
  ADD CONSTRAINT `fk_sponsored` FOREIGN KEY (`sponsor_id`) REFERENCES `sponsor` (`sponsor_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_sponsored2` FOREIGN KEY (`team_id`) REFERENCES `team` (`team_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tournament`
--
ALTER TABLE `tournament`
  ADD CONSTRAINT `fk_is_located_at` FOREIGN KEY (`arena_id`) REFERENCES `arena` (`arena_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_plays` FOREIGN KEY (`game_id`) REFERENCES `game` (`game_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tournament_host`
--
ALTER TABLE `tournament_host`
  ADD CONSTRAINT `fk_hosted` FOREIGN KEY (`host_id`) REFERENCES `host` (`host_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_hosted2` FOREIGN KEY (`tournament_id`) REFERENCES `tournament` (`tournament_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tournament_prize`
--
ALTER TABLE `tournament_prize`
  ADD CONSTRAINT `fk_awards` FOREIGN KEY (`prize_id`) REFERENCES `prize` (`prize_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_on` FOREIGN KEY (`tournament_id`) REFERENCES `tournament` (`tournament_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_won` FOREIGN KEY (`team_id`) REFERENCES `team` (`team_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tournament_team`
--
ALTER TABLE `tournament_team`
  ADD CONSTRAINT `fk_participates` FOREIGN KEY (`tournament_id`) REFERENCES `tournament` (`tournament_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_participates2` FOREIGN KEY (`team_id`) REFERENCES `team` (`team_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
