-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 26, 2024 at 05:24 AM
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
-- Database: `ordermakanan`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id_admin` varchar(5) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id_admin`, `username`, `password`) VALUES
('A01', 'rolis', '123'),
('A02', 'rafa', '123'),
('A03', 'seno', '123'),
('A04', 'syafiq', '123');

-- --------------------------------------------------------

--
-- Table structure for table `keranjang`
--

CREATE TABLE `keranjang` (
  `keranjang_id` int(11) NOT NULL,
  `menu_id` varchar(10) DEFAULT NULL,
  `pelanggan_id` varchar(10) NOT NULL,
  `nama_menu` varchar(50) DEFAULT NULL,
  `harga` decimal(10,2) DEFAULT NULL,
  `jumlah` int(11) DEFAULT NULL,
  `total` decimal(10,2) DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `meja`
--

CREATE TABLE `meja` (
  `meja_id` varchar(2) NOT NULL,
  `no_meja` int(2) NOT NULL,
  `status` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `meja`
--

INSERT INTO `meja` (`meja_id`, `no_meja`, `status`) VALUES
('M1', 1, 0),
('M2', 2, 0),
('M3', 3, 0),
('M4', 4, 0),
('M5', 5, 0),
('M6', 6, 0),
('M7', 7, 0),
('M8', 8, 0),
('M9', 9, 0);

-- --------------------------------------------------------

--
-- Table structure for table `menu`
--

CREATE TABLE `menu` (
  `menu_id` varchar(50) NOT NULL,
  `nama_menu` varchar(50) NOT NULL,
  `kategori` enum('promo','makanan','minuman','lainnya') DEFAULT NULL,
  `harga` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `menu`
--

INSERT INTO `menu` (`menu_id`, `nama_menu`, `kategori`, `harga`) VALUES
('L001', 'Ice Cream Corn', 'lainnya', 12000.00),
('L002', 'Gedagedi Nuggets', 'lainnya', 20000.00),
('L003', 'Onion Rings', 'lainnya', 15000.00),
('L004', 'Ice Cream Cup', 'lainnya', 10000.00),
('L005', 'Cookies', 'lainnya', 10000.00),
('MA001', 'Deluxe Burger', 'makanan', 32000.00),
('MA002', 'Chicken Burger', 'makanan', 30000.00),
('MA003', 'Ayam + Nasi', 'makanan', 15000.00),
('MA004', 'Chicken Bucket', 'makanan', 95000.00),
('MA005', 'Rice', 'makanan', 6000.00),
('MI001', 'Ice Cappucino', 'minuman', 10000.00),
('MI002', 'Ice Chocolate', 'minuman', 10000.00),
('MI003', 'Kelp Special Edition', 'minuman', 75000.00),
('MI004', 'Coca Cola', 'minuman', 8000.00),
('MI005', 'Le Mineral', 'minuman', 5000.00),
('P001', 'Beef Burger', 'promo', 20000.00),
('P002', 'Chezzzz Burger', 'promo', 25000.00),
('P003', 'French Fries', 'promo', 12000.00),
('P004', 'ChocoNut Ais', 'promo', 7000.00),
('P005', 'HotDog', 'promo', 17000.00);

-- --------------------------------------------------------

--
-- Table structure for table `pelanggan`
--

CREATE TABLE `pelanggan` (
  `pelanggan_id` varchar(10) NOT NULL,
  `nama_pelanggan` varchar(255) NOT NULL,
  `no_meja` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `riwayat`
--

CREATE TABLE `riwayat` (
  `riwayat_id` int(11) NOT NULL,
  `pelanggan_id` varchar(10) NOT NULL,
  `keranjang_id` int(11) DEFAULT NULL,
  `menu_id` varchar(10) NOT NULL,
  `nama_menu` varchar(100) DEFAULT NULL,
  `harga` double DEFAULT NULL,
  `jumlah` int(11) DEFAULT NULL,
  `total` double DEFAULT NULL,
  `status_pembayaran` enum('Paid','Unpaid') DEFAULT 'Paid',
  `status_pesanan` enum('Diproses','Selesai') DEFAULT 'Diproses',
  `tanggal_pemesanan` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id_admin`);

--
-- Indexes for table `keranjang`
--
ALTER TABLE `keranjang`
  ADD PRIMARY KEY (`keranjang_id`),
  ADD KEY `pelanggan_id` (`pelanggan_id`),
  ADD KEY `keranjang_id` (`keranjang_id`);

--
-- Indexes for table `meja`
--
ALTER TABLE `meja`
  ADD PRIMARY KEY (`meja_id`),
  ADD UNIQUE KEY `no_meja` (`no_meja`);

--
-- Indexes for table `menu`
--
ALTER TABLE `menu`
  ADD PRIMARY KEY (`menu_id`);

--
-- Indexes for table `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`pelanggan_id`),
  ADD KEY `no_meja` (`no_meja`),
  ADD KEY `pelanggan_id` (`pelanggan_id`);

--
-- Indexes for table `riwayat`
--
ALTER TABLE `riwayat`
  ADD PRIMARY KEY (`riwayat_id`),
  ADD KEY `pelanggan_id` (`pelanggan_id`),
  ADD KEY `fk_keranjang_id` (`keranjang_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `keranjang`
--
ALTER TABLE `keranjang`
  MODIFY `keranjang_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=166;

--
-- AUTO_INCREMENT for table `riwayat`
--
ALTER TABLE `riwayat`
  MODIFY `riwayat_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=138;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `keranjang`
--
ALTER TABLE `keranjang`
  ADD CONSTRAINT `keranjang_ibfk_1` FOREIGN KEY (`pelanggan_id`) REFERENCES `pelanggan` (`pelanggan_id`) ON DELETE CASCADE;

--
-- Constraints for table `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD CONSTRAINT `pelanggan_ibfk_1` FOREIGN KEY (`no_meja`) REFERENCES `meja` (`no_meja`);

--
-- Constraints for table `riwayat`
--
ALTER TABLE `riwayat`
  ADD CONSTRAINT `fk_keranjang_id` FOREIGN KEY (`keranjang_id`) REFERENCES `keranjang` (`keranjang_id`) ON DELETE CASCADE,
  ADD CONSTRAINT `riwayat_ibfk_1` FOREIGN KEY (`pelanggan_id`) REFERENCES `pelanggan` (`pelanggan_id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
