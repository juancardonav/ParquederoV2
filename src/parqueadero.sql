-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 20-11-2021 a las 02:55:57
-- Versión del servidor: 10.4.19-MariaDB
-- Versión de PHP: 8.0.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `parqueadero`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `parqueadero`
--

CREATE TABLE `parqueadero` (
  `idParqueadero` int(11) NOT NULL,
  `limited` int(11) DEFAULT NULL,
  `tarifa` int(11) DEFAULT NULL,
  `celdasDisponibles` int(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `parqueadero`
--

INSERT INTO `parqueadero` (`idParqueadero`, `limited`, `tarifa`, `celdasDisponibles`) VALUES
(1, 20, 100, 20);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `propietarios`
--

CREATE TABLE `propietarios` (
  `cedula` varchar(11) NOT NULL,
  `nombres` varchar(50) DEFAULT NULL,
  `telefonoF` varchar(10) DEFAULT NULL,
  `telefonoM` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `propietarios`
--

INSERT INTO `propietarios` (`cedula`, `nombres`, `telefonoF`, `telefonoM`) VALUES
('1000', 'juan', '6666', NULL),
('439865236', 'yma', '1010', NULL),
('8899', 'juan', '9988', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vehiculos`
--

CREATE TABLE `vehiculos` (
  `placa` varchar(6) NOT NULL,
  `idPropietario` varchar(11) DEFAULT NULL,
  `dateEntry` datetime DEFAULT NULL,
  `dateOut` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `vehiculos`
--

INSERT INTO `vehiculos` (`placa`, `idPropietario`, `dateEntry`, `dateOut`) VALUES
('jj22', '1000', '2021-11-19 20:29:29', NULL),
('jj33', '8899', '2021-11-19 20:32:42', NULL),
('kbu729', '439865236', NULL, NULL);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `parqueadero`
--
ALTER TABLE `parqueadero`
  ADD PRIMARY KEY (`idParqueadero`);

--
-- Indices de la tabla `propietarios`
--
ALTER TABLE `propietarios`
  ADD PRIMARY KEY (`cedula`);

--
-- Indices de la tabla `vehiculos`
--
ALTER TABLE `vehiculos`
  ADD PRIMARY KEY (`placa`),
  ADD KEY `idPropietario` (`idPropietario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `parqueadero`
--
ALTER TABLE `parqueadero`
  MODIFY `idParqueadero` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `vehiculos`
--
ALTER TABLE `vehiculos`
  ADD CONSTRAINT `vehiculos_ibfk_1` FOREIGN KEY (`idPropietario`) REFERENCES `propietarios` (`cedula`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
