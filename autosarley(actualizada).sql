-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 15-04-2024 a las 18:35:12
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `autosarley`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `autos`
--

CREATE TABLE `autos` (
  `marca` varchar(15) NOT NULL,
  `modelo` varchar(15) NOT NULL,
  `año` int(10) NOT NULL,
  `kilometraje` double NOT NULL,
  `transmision` varchar(15) NOT NULL,
  `precio` double NOT NULL,
  `placa` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `autos`
--

INSERT INTO `autos` (`marca`, `modelo`, `año`, `kilometraje`, `transmision`, `precio`, `placa`) VALUES
('Citroen', 'C4', 2006, 161565, 'Manual', 2500300, '751270'),
('Toyota', 'Corolla', 2015, 65899, 'Automatica', 8900500, 'COR456'),
('Subaru', 'Impreza', 2005, 165325, 'Manual', 8955000, 'IMP123'),
('Suzukii', 'Vitara GLS', 2024, 55000, 'Manual', 8500000, 'VIT123');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `id` int(10) NOT NULL,
  `nombre` varchar(15) NOT NULL,
  `apellidos` varchar(15) NOT NULL,
  `correo` varchar(40) NOT NULL,
  `telefono` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`id`, `nombre`, `apellidos`, `correo`, `telefono`) VALUES
(1552, 'Cristhian222', 'Caldera', 'cristhian@correo.com', '44556644'),
(1558333, 'Alex Schnieders', 'Cesar Fajardo', 'alex.fajardo@correo.com', '60827098'),
(102560125, 'Joselyn333', 'Rivera', 'joselyn@correo.com', '11223344'),
(301250325, 'Oscar', 'Gutierrez', 'oscar.correo222', '55449988'),
(401523251, 'Ronny3333', 'Lopez', 'ronny.quesada@correo.com', '85274196');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--

CREATE TABLE `venta` (
  `id` int(11) NOT NULL,
  `idcliente` int(11) NOT NULL,
  `placa` varchar(15) NOT NULL,
  `fecha` varchar(15) NOT NULL,
  `precio` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `venta`
--

INSERT INTO `venta` (`id`, `idcliente`, `placa`, `fecha`, `precio`) VALUES
(1, 1558333, 'VIT123', '14/04/2023', 1585000),
(2, 301250325, 'COR456', '14/042024', 9500500),
(3, 102560125, 'IMP123', '15/04/2024', 8500500);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `autos`
--
ALTER TABLE `autos`
  ADD PRIMARY KEY (`placa`);

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `venta`
--
ALTER TABLE `venta`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `venta`
--
ALTER TABLE `venta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
