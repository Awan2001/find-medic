-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Feb 09, 2024 at 01:35 PM
-- Server version: 10.5.20-MariaDB
-- PHP Version: 7.3.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `id21835479_publicapiarep`
--

-- --------------------------------------------------------

--
-- Table structure for table `comments`
--

CREATE TABLE `comments` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `ip_address` varchar(64) NOT NULL,
  `date` datetime NOT NULL DEFAULT current_timestamp(),
  `user_agent` varchar(256) NOT NULL,
  `comments` text NOT NULL,
  `lat` varchar(30) NOT NULL,
  `lng` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `comments`
--

INSERT INTO `comments` (`id`, `name`, `email`, `ip_address`, `date`, `user_agent`, `comments`, `lat`, `lng`) VALUES
(1, 'test', 'test@test', '127.0.0.1', '0000-00-00 00:00:00', 'Pass/1.0', 'testing comments', '0.0000000000', '0.0000000000'),
(2, 'Ahmad Dahlan', 'ahmad@example.com', '127.0.0.1', '2021-07-08 15:50:01', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36', 'hi salam....', '0.0000000000', '0.0000000000'),
(3, 'Mohammad Hafiz Ismail', 'hafiz@example.com', '127.0.0.1', '2021-07-08 15:58:13', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36', 'testing comments on home made web api', '0.0000000000', '0.0000000000'),
(4, '', '', '192.168.0.128', '2021-07-12 16:15:04', 'Dalvik/2.1.0 (Linux; U; Android 10; Android SDK built for x86 Build/QSR1.190920.001)', '', '0.0000000000', '0.0000000000'),
(5, 'sadsa', 'sadsa', '192.168.0.128', '2021-07-12 16:15:11', 'Dalvik/2.1.0 (Linux; U; Android 10; Android SDK built for x86 Build/QSR1.190920.001)', 'sdadg', '0.0000000000', '0.0000000000'),
(6, 'arep', 'arep@mail.com', '2001:e68:5403:4801:9c0b:c7ed:4f35:f779', '2024-02-04 19:25:36', 'Dalvik/2.1.0 (Linux; U; Android 13; SM-A326B Build/TP1A.220624.014)', 'arep@mail.com', '0.0000000000', '0.0000000000'),
(7, 'arep', 'iyuu@mail.com', '2001:e68:5403:4801:9c0b:c7ed:4f35:f779', '2024-02-04 19:29:55', 'Dalvik/2.1.0 (Linux; U; Android 13; SM-A326B Build/TP1A.220624.014)', 'bjsjsjsj', '0.0000000000', '0.0000000000'),
(8, 'ahmad', 'nazir@gmail.com', '2001:e68:5403:4801:9c0b:c7ed:4f35:f779', '2024-02-04 19:33:07', 'Dalvik/2.1.0 (Linux; U; Android 13; SM-A326B Build/TP1A.220624.014)', 'second', '0.0000000000', '0.0000000000'),
(9, 'arep', 'arep@mail.com', '2001:d08:1400:2518:17b1:7862:542:ccef', '2024-02-07 17:39:29', 'Dalvik/2.1.0 (Linux; U; Android 13; SM-A326B Build/TP1A.220624.014)', 'test latlng', '6.4480193', '100.2819111'),
(10, 'Tanuki', 'tanuki@mail.com', '2001:d08:1400:4f96:17b1:b005:5d70:a001', '2024-02-08 17:23:22', 'Dalvik/2.1.0 (Linux; U; Android 13; SM-A326B Build/TP1A.220624.014)', 'Tect implement in code piqa', '6.4477842', '100.2822561'),
(11, 'Hadi', 'hadi@gmail.com', '2001:e68:5403:6fba:5d1:2db4:aae2:8829', '2024-02-09 09:25:38', 'Dalvik/2.1.0 (Linux; U; Android 13; SM-A326B Build/TP1A.220624.014)', 'saya di perlis', '6.4571371', '100.270199'),
(12, 'MUHAMMAD ARIF BIN MOHD SABRI', 'arifeducation2001@gmail.com', '2001:e68:5403:6fba:5d1:2db4:aae2:8829', '2024-02-09 13:19:55', 'Dalvik/2.1.0 (Linux; U; Android 13; SM-A326B Build/TP1A.220624.014)', 'lah\n\n', '6.4570905', '100.2702047'),
(13, 'MUHAMMAD ARIF BIN MOHD SABRI', 'arifeducation2001@gmail.com', '2001:e68:5403:6fba:5d1:2db4:aae2:8829', '2024-02-09 13:19:55', 'Dalvik/2.1.0 (Linux; U; Android 13; SM-A326B Build/TP1A.220624.014)', 'lah\n\n', '6.4570905', '100.2702047'),
(14, 'Arif Awan', 'arepawan2001@gmail.com', '2001:e68:5403:6fba:5d1:2db4:aae2:8829', '2024-02-09 13:21:28', 'Dalvik/2.1.0 (Linux; U; Android 13; SM-A326B Build/TP1A.220624.014)', 'arifah', '6.4570905', '100.2702047');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `comments`
--
ALTER TABLE `comments`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `comments`
--
ALTER TABLE `comments`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
