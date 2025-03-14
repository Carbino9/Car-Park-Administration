-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 12, 2025 at 10:11 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db`
--

-- --------------------------------------------------------

--
-- Table structure for table `clienti`
--

CREATE TABLE `clienti` (
  `id` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nume_user` varchar(255) DEFAULT NULL,
  `parola` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `clienti`
--

INSERT INTO `clienti` (`id`, `email`, `nume_user`, `parola`) VALUES
(1, 'andrei@gmail.com', 'andrei', 'andrei.'),
(2, 'catalin@outlook.com', 'catalin', 'catalin.');

-- --------------------------------------------------------

--
-- Table structure for table `masini`
--

CREATE TABLE `masini` (
  `id` int(11) NOT NULL,
  `an_fabricatie` int(11) NOT NULL,
  `combust` varchar(255) DEFAULT NULL,
  `inmat` varchar(255) NOT NULL,
  `kilometraj` int(11) NOT NULL,
  `marca` varchar(255) DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  `poza_url` varchar(255) DEFAULT NULL,
  `data_revizie` date DEFAULT NULL,
  `itp` date DEFAULT NULL,
  `rca` date DEFAULT NULL,
  `rovinieta` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `masini`
--

INSERT INTO `masini` (`id`, `an_fabricatie`, `combust`, `inmat`, `kilometraj`, `marca`, `model`, `poza_url`, `data_revizie`, `itp`, `rca`, `rovinieta`) VALUES
(1, 2007, 'Motorină', 'B-123-XYZ', 287300, 'Dacia', 'Logan', 'dacia.jpg', '2025-10-10', '2027-10-10', '2026-01-12', '2027-02-21'),
(2, 2012, 'Benzină', 'BV82ERR', 180210, 'Audi', 'A4', 'audia4.jpg', NULL, '2025-02-03', '2025-01-10', '2026-02-01'),
(3, 2014, 'Benzină', 'IF21GUP', 171250, 'Renault', 'Megane', 'renault.jpg', NULL, '2023-11-07', '2025-02-12', '2026-10-21'),
(4, 2011, 'Motorină', 'VN12MGK', 210655, 'Ford', 'Focus', 'ford.jpg', '2026-10-04', '2025-05-27', '2025-02-20', '2026-11-21'),
(5, 2008, 'Benzină', 'IS31BER', 151021, 'Toyota', 'Yaris', 'toyota.jpg', NULL, '2024-12-11', '2023-09-08', '2025-05-12'),
(6, 2015, 'Benzină', 'TM10NUP', 120123, 'Mercedes', 'Benz', 'mercedes.jpg', NULL, '2025-10-06', '2026-11-24', '2027-02-01');

-- --------------------------------------------------------

--
-- Table structure for table `utilizatori`
--

CREATE TABLE `utilizatori` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) NOT NULL,
  `nume_user` varchar(255) NOT NULL,
  `parola` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `utilizatori`
--

INSERT INTO `utilizatori` (`id`, `email`, `nume_user`, `parola`) VALUES
(1, 'claudiu@yahoo.com', 'claudiu', 'parola');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `clienti`
--
ALTER TABLE `clienti`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `masini`
--
ALTER TABLE `masini`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK6ibwckwyuvubid0txx7h89f1p` (`inmat`);

--
-- Indexes for table `utilizatori`
--
ALTER TABLE `utilizatori`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKif7hnv2efgip4e7prxt14epi3` (`email`),
  ADD UNIQUE KEY `UKi2ctq1elw375ee9v364g9nb1k` (`nume_user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `clienti`
--
ALTER TABLE `clienti`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `masini`
--
ALTER TABLE `masini`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `utilizatori`
--
ALTER TABLE `utilizatori`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
