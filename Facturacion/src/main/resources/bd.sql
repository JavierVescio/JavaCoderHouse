-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Feb 27, 2024 at 05:16 AM
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
-- Database: `facturacion`
--

-- --------------------------------------------------------

--
-- Table structure for table `cliente`
--

CREATE TABLE `cliente` (
  `id` bigint(20) NOT NULL,
  `activo` tinyint(1) DEFAULT 1,
  `apellido` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `nombre` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `cliente`
--

INSERT INTO `cliente` (`id`, `activo`, `apellido`, `email`, `nombre`) VALUES
(1, 1, 'Tamburello', 'leonardotamburello@gmail.com', 'Leonardo'),
(2, 1, 'Vescio', 'javiervescio@gmail.com', 'Javier');

-- --------------------------------------------------------

--
-- Table structure for table `item_venta`
--

CREATE TABLE `item_venta` (
  `id` bigint(20) NOT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `precio` float DEFAULT NULL,
  `subtotal` float DEFAULT NULL,
  `producto_id` bigint(20) DEFAULT NULL,
  `venta_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `producto`
--

CREATE TABLE `producto` (
  `id` bigint(20) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `precio` float NOT NULL,
  `stock` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `producto`
--

INSERT INTO `producto` (`id`, `nombre`, `precio`, `stock`) VALUES
(1, 'Moto G13', 180000, 64),
(2, 'Samsung J5 2016', 60000, 12),
(3, 'Sony Xperia U', 23000, 3);

-- --------------------------------------------------------

--
-- Table structure for table `venta`
--

CREATE TABLE `venta` (
  `id` bigint(20) NOT NULL,
  `confirmada` tinyint(1) DEFAULT NULL,
  `fecha` datetime(6) DEFAULT NULL,
  `precio_total` float NOT NULL,
  `cliente_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `item_venta`
--
ALTER TABLE `item_venta`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK4vfin5d1lrbavmtaq76ah6qc2` (`producto_id`),
  ADD KEY `FK6ixcdqqa8ren81ahfss5oy5ds` (`venta_id`);

--
-- Indexes for table `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `venta`
--
ALTER TABLE `venta`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKa7yaj59nfh3gft0h38o5bv472` (`cliente_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `item_venta`
--
ALTER TABLE `item_venta`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `producto`
--
ALTER TABLE `producto`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `venta`
--
ALTER TABLE `venta`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `item_venta`
--
ALTER TABLE `item_venta`
  ADD CONSTRAINT `FK4vfin5d1lrbavmtaq76ah6qc2` FOREIGN KEY (`producto_id`) REFERENCES `producto` (`id`),
  ADD CONSTRAINT `FK6ixcdqqa8ren81ahfss5oy5ds` FOREIGN KEY (`venta_id`) REFERENCES `venta` (`id`);

--
-- Constraints for table `venta`
--
ALTER TABLE `venta`
  ADD CONSTRAINT `FKa7yaj59nfh3gft0h38o5bv472` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;