-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 20-02-2018 a las 20:52:39
-- Versión del servidor: 10.1.29-MariaDB
-- Versión de PHP: 7.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `paqueteria`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paquetes`
--

CREATE TABLE `paquetes` (
  `id_paquete` int(11) NOT NULL,
  `medida` varchar(50) CHARACTER SET latin1 DEFAULT NULL,
  `fecha_entrega` date DEFAULT NULL,
  `origen` varchar(60) CHARACTER SET latin1 DEFAULT NULL,
  `destino` varchar(60) CHARACTER SET latin1 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `paquetes`
--

INSERT INTO `paquetes` (`id_paquete`, `medida`, `fecha_entrega`, `origen`, `destino`) VALUES
(1, 'pequeño', '2018-02-14', 'Madrid', 'Barcelona'),
(3, 'Grande', '2018-02-14', 'Transversal sexta 5', 'Avda Orovilla 33'),
(12, 'pequeo', '2018-02-23', 'Malpartida de C?ceres, Espa?a', 'Madrid, Espa?a'),
(17, 'mediano', NULL, 'MAdrid', 'Barcelona');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `full_name` varchar(100) NOT NULL,
  `role` varchar(50) NOT NULL,
  `country` varchar(100) NOT NULL,
  `enabled` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`username`, `password`, `full_name`, `role`, `country`, `enabled`) VALUES
('arvind', '$2a$10$Vfs8YMQx1YHI.d0x4WO8n.C.K3prfllnP2uS/j8ChpRirS17y.N42', 'Arvind Rai', 'ROLE_USER', 'India', 1),
('mahesh', '$2a$10$N0eqNiuikWCy9ETQ1rdau.XEELcyEO7kukkfoiNISk/9F7gw6eB0W', 'Mahesh Sharma', 'ROLE_ADMIN', 'India', 1),
('trump', '$2a$10$QifQnP.XqXDW0Lc4hSqEg.GhTqZHoN2Y52/hoWr4I5ePxK7D2Pi8q', 'Donald Trump', 'ROLE_ADMIN', 'US', 1),
('alberto', '$2a$10$OYNCx1FJD4gnjytEfWHmDuCQ5nS/qlNAtbBKfsdujc4.LWroYXEQe', 'AlbertoTG17', 'ROLE_ADMIN', 'Spain', 1),
('alberto', '$2a$10$OYNCx1FJD4gnjytEfWHmDuCQ5nS/qlNAtbBKfsdujc4.LWroYXEQe', 'AlbertoTG17', 'ROLE_ADMIN', 'Spain', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `paquetes`
--
ALTER TABLE `paquetes`
  ADD PRIMARY KEY (`id_paquete`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `paquetes`
--
ALTER TABLE `paquetes`
  MODIFY `id_paquete` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
