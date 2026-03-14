-- Kevin Rodrigo Lopez Espinoza marzo 2026
-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 11-03-2026 a las 16:15:02
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `subsistemaseguridad`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aplicaciones`
--

CREATE TABLE `aplicaciones` (
  `Aplcodigo` int(11) NOT NULL,
  `Aplnombre` varchar(100) NOT NULL,
  `Aplestado` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `aplicaciones`
--

INSERT INTO `aplicaciones` (`Aplcodigo`, `Aplnombre`, `Aplestado`) VALUES
(1, 'Login', 'Activo'),
(2, 'Seguridad', 'Activo'),
(3, 'Inventario', 'Activo'),
(4, 'Ventas', 'Activo'),
(5, 'Reportes', 'Inactivo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asignacionaplicacionperfil`
--

CREATE TABLE `asignacionaplicacionperfil` (
  `Aplcodigo` int(11) NOT NULL,
  `Percodigo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asignacionaplicacionusuarios`
--

CREATE TABLE `asignacionaplicacionusuarios` (
  `Aplcodigo` int(11) NOT NULL,
  `Usucodigo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asignacionperfilusuario`
--

CREATE TABLE `asignacionperfilusuario` (
  `Usucodigo` int(11) NOT NULL,
  `Percodigo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bitacora`
--

CREATE TABLE `bitacora` (
  `Bitcodigo` int(11) NOT NULL,
  `Usucodigo` int(11) DEFAULT NULL,
  `Aplcodigo` int(11) DEFAULT NULL,
  `Bitfecha` datetime DEFAULT NULL,
  `Bitip` varchar(50) DEFAULT NULL,
  `Bitequipo` varchar(100) DEFAULT NULL,
  `Bitaccion` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `perfiles`
--

CREATE TABLE `perfiles` (
  `Percodigo` int(11) NOT NULL,
  `Pernombre` varchar(100) NOT NULL,
  `Perestado` char(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `Usucodigo` int(11) NOT NULL,
  `Usunombre` varchar(100) NOT NULL,
  `Usucontraseña` varchar(200) NOT NULL,
  `Usuestado` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`Usucodigo`, `Usunombre`, `Usucontraseña`, `Usuestado`) VALUES
(1, 'admin', 'admin123', 'Activo'),
(2, 'maria', 'maria123', 'Activo'),
(3, 'juan', 'juan123', 'Activo'),
(4, 'carlos', 'carlos123', 'Inactivo'),
(5, 'ana', 'ana123', 'Activo');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `aplicaciones`
--
ALTER TABLE `aplicaciones`
  ADD PRIMARY KEY (`Aplcodigo`);

--
-- Indices de la tabla `asignacionaplicacionperfil`
--
ALTER TABLE `asignacionaplicacionperfil`
  ADD PRIMARY KEY (`Aplcodigo`,`Percodigo`),
  ADD KEY `Percodigo` (`Percodigo`);

--
-- Indices de la tabla `asignacionaplicacionusuarios`
--
ALTER TABLE `asignacionaplicacionusuarios`
  ADD PRIMARY KEY (`Aplcodigo`,`Usucodigo`),
  ADD KEY `Usucodigo` (`Usucodigo`);

--
-- Indices de la tabla `asignacionperfilusuario`
--
ALTER TABLE `asignacionperfilusuario`
  ADD PRIMARY KEY (`Usucodigo`,`Percodigo`),
  ADD KEY `Percodigo` (`Percodigo`);

--
-- Indices de la tabla `bitacora`
--
ALTER TABLE `bitacora`
  ADD PRIMARY KEY (`Bitcodigo`),
  ADD KEY `Usucodigo` (`Usucodigo`),
  ADD KEY `Aplcodigo` (`Aplcodigo`);

--
-- Indices de la tabla `perfiles`
--
ALTER TABLE `perfiles`
  ADD PRIMARY KEY (`Percodigo`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`Usucodigo`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `asignacionaplicacionperfil`
--
ALTER TABLE `asignacionaplicacionperfil`
  ADD CONSTRAINT `asignacionaplicacionperfil_ibfk_1` FOREIGN KEY (`Aplcodigo`) REFERENCES `aplicaciones` (`Aplcodigo`),
  ADD CONSTRAINT `asignacionaplicacionperfil_ibfk_2` FOREIGN KEY (`Percodigo`) REFERENCES `perfiles` (`Percodigo`);

--
-- Filtros para la tabla `asignacionaplicacionusuarios`
--
ALTER TABLE `asignacionaplicacionusuarios`
  ADD CONSTRAINT `asignacionaplicacionusuarios_ibfk_1` FOREIGN KEY (`Aplcodigo`) REFERENCES `aplicaciones` (`Aplcodigo`),
  ADD CONSTRAINT `asignacionaplicacionusuarios_ibfk_2` FOREIGN KEY (`Usucodigo`) REFERENCES `usuario` (`Usucodigo`);

--
-- Filtros para la tabla `asignacionperfilusuario`
--
ALTER TABLE `asignacionperfilusuario`
  ADD CONSTRAINT `asignacionperfilusuario_ibfk_1` FOREIGN KEY (`Usucodigo`) REFERENCES `usuario` (`Usucodigo`),
  ADD CONSTRAINT `asignacionperfilusuario_ibfk_2` FOREIGN KEY (`Percodigo`) REFERENCES `perfiles` (`Percodigo`);

--
-- Filtros para la tabla `bitacora`
--
ALTER TABLE `bitacora`
  ADD CONSTRAINT `bitacora_ibfk_1` FOREIGN KEY (`Usucodigo`) REFERENCES `usuario` (`Usucodigo`),
  ADD CONSTRAINT `bitacora_ibfk_2` FOREIGN KEY (`Aplcodigo`) REFERENCES `aplicaciones` (`Aplcodigo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
