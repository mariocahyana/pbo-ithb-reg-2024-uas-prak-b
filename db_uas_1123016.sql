-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3312
-- Generation Time: Jan 10, 2025 at 05:52 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_uas_1123016`
--

-- --------------------------------------------------------

--
-- Table structure for table `categorydelivery`
--

CREATE TABLE `categorydelivery` (
  `id` int(11) NOT NULL,
  `name` varchar(88) NOT NULL,
  `fee_per_kg` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `categorydelivery`
--

INSERT INTO `categorydelivery` (`id`, `name`, `fee_per_kg`) VALUES
(1, 'Building Materials', 1000),
(2, 'House Moving', 2000),
(3, 'Instant Delivery', 3000);

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `id` int(11) NOT NULL,
  `password` varchar(255) NOT NULL,
  `name` varchar(100) NOT NULL,
  `address` text NOT NULL,
  `phone` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id`, `password`, `name`, `address`, `phone`) VALUES
(1, '123', 'mario', 'tki@a', '088'),
(2, '123', 'mar', 'mar@a', '123'),
(3, '123', 'koko', 'koko@a', '0881'),
(4, '123', 'Ruth', 'mar@aa', '888'),
(5, '123', 'Jokowi', 'mar@aaa', '777'),
(6, '123', 'joker', 'mar@s', '666'),
(7, '123', 'jo', 'mar@x', '111'),
(8, '123', 'Mar', 'mar@ax', '11');

-- --------------------------------------------------------

--
-- Table structure for table `deliverydetails`
--

CREATE TABLE `deliverydetails` (
  `id` int(11) NOT NULL,
  `transaction_id` int(11) NOT NULL,
  `status` enum('pending','in_progress','on_delivery','arrived') DEFAULT 'pending',
  `current_position` varchar(100) DEFAULT NULL,
  `evidence` varchar(255) DEFAULT NULL,
  `date` date DEFAULT curdate(),
  `updated_by` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `deliverydetails`
--

INSERT INTO `deliverydetails` (`id`, `transaction_id`, `status`, `current_position`, `evidence`, `date`, `updated_by`) VALUES
(1, 1, 'arrived', 'rumah', 'UAS\\\\src\\\\Asset\\\\logo2.png', '2025-01-10', 'joko'),
(4, 5, 'pending', 'bandung', 'logo.png', '2025-01-10', 'marrr'),
(5, 6, 'pending', 'taman', 'logo.png', '2025-01-10', 'joyy');

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE `transaction` (
  `id` int(11) NOT NULL,
  `customer_id` int(11) NOT NULL,
  `delivery_type` varchar(50) NOT NULL,
  `expected_weight` int(11) NOT NULL,
  `total_cost` int(11) NOT NULL,
  `created_at` date DEFAULT curdate(),
  `receipt_name` varchar(100) NOT NULL,
  `receipt_address` text NOT NULL,
  `receipt_phone` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `transaction`
--

INSERT INTO `transaction` (`id`, `customer_id`, `delivery_type`, `expected_weight`, `total_cost`, `created_at`, `receipt_name`, `receipt_address`, `receipt_phone`) VALUES
(1, 1, 'House Moving', 1, 2000, '2025-01-10', 'mario', 'tki', '088'),
(2, 1, 'Building Materials', 11, 11000, '2025-01-10', 'Mess', 'tki', '0812'),
(3, 1, 'Instant Delivery', 10, 30000, '2025-01-10', 'Joko', 'Manglid', '555'),
(4, 1, 'Building Materials', 10, 10000, '2025-01-10', 'jo', 'tki', '11'),
(5, 1, 'Instant Delivery', 10, 30000, '2025-01-10', 'marko', 'thi', '222'),
(6, 1, 'Instant Delivery', 10, 30000, '2025-01-10', 'Joke', 'tki', '0888'),
(7, 1, 'Building Materials', 10, 10000, '2025-01-10', 'yoo', 'bdg', '10'),
(8, 1, 'Building Materials', 10, 10000, '2025-01-10', 'jooo', 'jkt', '123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `categorydelivery`
--
ALTER TABLE `categorydelivery`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `phone` (`phone`);

--
-- Indexes for table `deliverydetails`
--
ALTER TABLE `deliverydetails`
  ADD PRIMARY KEY (`id`),
  ADD KEY `transaction_id` (`transaction_id`);

--
-- Indexes for table `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`id`),
  ADD KEY `customer_id` (`customer_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `categorydelivery`
--
ALTER TABLE `categorydelivery`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `deliverydetails`
--
ALTER TABLE `deliverydetails`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `transaction`
--
ALTER TABLE `transaction`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `deliverydetails`
--
ALTER TABLE `deliverydetails`
  ADD CONSTRAINT `deliverydetails_ibfk_1` FOREIGN KEY (`transaction_id`) REFERENCES `transaction` (`id`);

--
-- Constraints for table `transaction`
--
ALTER TABLE `transaction`
  ADD CONSTRAINT `transaction_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
