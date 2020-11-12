-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: alquilercoches
-- ------------------------------------------------------
-- Server version	8.0.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `fichero_cliente`
--

DROP TABLE IF EXISTS `fichero_cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fichero_cliente` (
  `id_cliente` int NOT NULL,
  PRIMARY KEY (`id_cliente`),
  UNIQUE KEY `id_cliente_UNIQUE` (`id_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `fichero_coche`
--

DROP TABLE IF EXISTS `fichero_coche`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fichero_coche` (
  `matricula` int NOT NULL AUTO_INCREMENT,
  `id_modelo` int NOT NULL,
  `id_franquicia` int NOT NULL,
  `letras_matrícula` varchar(3) NOT NULL,
  `estado_coche` varchar(45) NOT NULL,
  PRIMARY KEY (`matricula`,`id_modelo`,`id_franquicia`),
  UNIQUE KEY `matricula_UNIQUE` (`matricula`),
  KEY `fk_Fichero_coche_Fichero_modelo_idx` (`id_modelo`),
  KEY `fk_Fichero_coche_Fichero_franquicia1_idx` (`id_franquicia`),
  CONSTRAINT `fk_Fichero_coche_Fichero_franquicia1` FOREIGN KEY (`id_franquicia`) REFERENCES `fichero_franquicia` (`id_franquicia`) ON UPDATE CASCADE,
  CONSTRAINT `fk_Fichero_coche_Fichero_modelo` FOREIGN KEY (`id_modelo`) REFERENCES `fichero_modelo` (`id_modelo`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9739 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `fichero_extras`
--

DROP TABLE IF EXISTS `fichero_extras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fichero_extras` (
  `id_extra` int NOT NULL AUTO_INCREMENT,
  `id_modelo` int NOT NULL,
  `tipo` varchar(45) NOT NULL,
  `coste_adicional` double NOT NULL,
  PRIMARY KEY (`id_extra`,`id_modelo`),
  UNIQUE KEY `id_extra_UNIQUE` (`id_extra`),
  KEY `fk_Fichero_extras_Fichero_modelo1_idx` (`id_modelo`),
  CONSTRAINT `id_modelo` FOREIGN KEY (`id_modelo`) REFERENCES `fichero_modelo` (`id_modelo`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `fichero_factura`
--

DROP TABLE IF EXISTS `fichero_factura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fichero_factura` (
  `id_factura` int NOT NULL AUTO_INCREMENT,
  `id_tarifa` int NOT NULL,
  `importe` double NOT NULL,
  `estado_factura` varchar(45) NOT NULL,
  `tipo_pago` varchar(45) NOT NULL,
  PRIMARY KEY (`id_factura`,`id_tarifa`),
  UNIQUE KEY `id_factura_UNIQUE` (`id_factura`),
  KEY `fk_Fichero_factura_Fichero_tarifa1_idx` (`id_tarifa`),
  CONSTRAINT `fk_Fichero_factura_Fichero_tarifa1` FOREIGN KEY (`id_tarifa`) REFERENCES `fichero_tarifa` (`id_tarifa`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `fichero_franquicia`
--

DROP TABLE IF EXISTS `fichero_franquicia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fichero_franquicia` (
  `id_franquicia` int NOT NULL AUTO_INCREMENT,
  `provincia` varchar(45) NOT NULL,
  `ciudad` varchar(45) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  PRIMARY KEY (`id_franquicia`),
  UNIQUE KEY `id_franquicia_UNIQUE` (`id_franquicia`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `fichero_modelo`
--

DROP TABLE IF EXISTS `fichero_modelo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fichero_modelo` (
  `id_modelo` int NOT NULL AUTO_INCREMENT,
  `marca` varchar(45) NOT NULL,
  `categoria_modelo` varchar(45) NOT NULL,
  `nombre_modelo` varchar(45) NOT NULL,
  `manual/automatico` varchar(45) NOT NULL,
  `tipo_techo` varchar(45) NOT NULL,
  `combustible` varchar(45) NOT NULL,
  `num_plazas` int NOT NULL,
  `año` int NOT NULL,
  PRIMARY KEY (`id_modelo`),
  UNIQUE KEY `id_modelo_UNIQUE` (`id_modelo`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `fichero_reserva`
--

DROP TABLE IF EXISTS `fichero_reserva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fichero_reserva` (
  `id_reserva` int NOT NULL,
  `id_coche` int NOT NULL,
  `id_modelo` int NOT NULL,
  `id_franquicia` int NOT NULL,
  `id_factura` int NOT NULL,
  `estado_reserva` varchar(45) NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_fin` date NOT NULL,
  `id_cliente` int NOT NULL,
  PRIMARY KEY (`id_coche`,`id_modelo`,`id_franquicia`,`id_factura`,`id_cliente`,`id_reserva`),
  UNIQUE KEY `id_reserva_UNIQUE` (`id_reserva`),
  KEY `fk_Fichero_reserva_Fichero_coche1_idx` (`id_coche`,`id_modelo`,`id_franquicia`),
  KEY `fk_Fichero_reserva_Fichero_factura1_idx` (`id_factura`),
  KEY `fk_Fichero_reserva_Fichero_cliente1_idx` (`id_cliente`),
  CONSTRAINT `fk_Fichero_reserva_Fichero_cliente1` FOREIGN KEY (`id_cliente`) REFERENCES `fichero_cliente` (`id_cliente`) ON UPDATE CASCADE,
  CONSTRAINT `fk_Fichero_reserva_Fichero_coche1` FOREIGN KEY (`id_coche`, `id_modelo`, `id_franquicia`) REFERENCES `fichero_coche` (`matricula`, `id_modelo`, `id_franquicia`) ON UPDATE CASCADE,
  CONSTRAINT `fk_Fichero_reserva_Fichero_factura1` FOREIGN KEY (`id_factura`) REFERENCES `fichero_factura` (`id_factura`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `fichero_tarifa`
--

DROP TABLE IF EXISTS `fichero_tarifa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fichero_tarifa` (
  `id_tarifa` int NOT NULL AUTO_INCREMENT,
  `tipo_tarifa` varchar(45) NOT NULL,
  `cambio_importe` varchar(45) NOT NULL,
  PRIMARY KEY (`id_tarifa`),
  UNIQUE KEY `id_tarifa_UNIQUE` (`id_tarifa`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `reserva_tiene_extras`
--

DROP TABLE IF EXISTS `reserva_tiene_extras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reserva_tiene_extras` (
  `Fichero_extras_id_extra` int NOT NULL,
  `Fichero_extras_id_modelo` int NOT NULL,
  `Fichero_factura_id_factura` int NOT NULL,
  `Fichero_factura_id_tarifa` int NOT NULL,
  PRIMARY KEY (`Fichero_extras_id_modelo`,`Fichero_factura_id_factura`,`Fichero_factura_id_tarifa`,`Fichero_extras_id_extra`),
  KEY `fk_Fichero_extras_has_Fichero_factura_Fichero_factura1_idx` (`Fichero_factura_id_factura`,`Fichero_factura_id_tarifa`),
  KEY `fk_Fichero_extras_has_Fichero_factura_Fichero_extras1_idx` (`Fichero_extras_id_extra`,`Fichero_extras_id_modelo`),
  CONSTRAINT `fk_Fichero_extras_Fichero_extras` FOREIGN KEY (`Fichero_extras_id_extra`, `Fichero_extras_id_modelo`) REFERENCES `fichero_extras` (`id_extra`, `id_modelo`) ON UPDATE CASCADE,
  CONSTRAINT `fk_Fichero_extras_has_Fichero_factura_Fichero_factura1` FOREIGN KEY (`Fichero_factura_id_factura`, `Fichero_factura_id_tarifa`) REFERENCES `fichero_factura` (`id_factura`, `id_tarifa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;



/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-12 11:08:10
