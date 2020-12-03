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
-- Dumping data for table `fichero_cliente`
--

LOCK TABLES `fichero_cliente` WRITE;
/*!40000 ALTER TABLE `fichero_cliente` DISABLE KEYS */;
INSERT INTO `fichero_cliente` VALUES (1),(30858283),(32399540),(42401030),(76176722),(98999652);
/*!40000 ALTER TABLE `fichero_cliente` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `fichero_coche`
--

LOCK TABLES `fichero_coche` WRITE;
/*!40000 ALTER TABLE `fichero_coche` DISABLE KEYS */;
INSERT INTO `fichero_coche` VALUES (1145,10,1,'CSR','disponible'),(1444,1,2,'PJW','disponible'),(2028,14,5,'JKM','disponible'),(2459,15,12,'CNN','disponible'),(2900,11,3,'LQW','disponible'),(3234,8,11,'BCB','disponible'),(3244,1,1,'BSD','disponible'),(3490,2,1,'LNS','disponible'),(3849,17,6,'GPM','disponible'),(4467,10,2,'JJJ','no_disponible'),(4584,12,10,'LPT','disponible'),(4720,6,3,'GGG','disponible'),(4729,6,8,'GWP','disponible'),(5200,3,7,'DFH','no_disponible'),(5420,2,1,'HKS','disponible'),(5532,7,1,'FPF','disponible'),(5830,18,1,'GPS','disponible'),(5840,16,11,'FXX','disponible'),(5925,11,2,'KLS','no_disponible'),(6579,7,9,'JST','disponible'),(6982,5,6,'JYZ','disponible'),(7659,4,12,'KTQ','disponible'),(7885,9,9,'CPR','disponible'),(8574,19,2,'FTG','disponible'),(8593,19,4,'FPY','disponible'),(8955,7,1,'FFP','disponible'),(9051,17,5,'LPM','disponible'),(9385,13,7,'HYB','no_disponible'),(9582,2,4,'GBC','no_disponible'),(9738,4,10,'LNP','disponible');
/*!40000 ALTER TABLE `fichero_coche` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `fichero_extras`
--

LOCK TABLES `fichero_extras` WRITE;
/*!40000 ALTER TABLE `fichero_extras` DISABLE KEYS */;
INSERT INTO `fichero_extras` VALUES (1,1,'silla bebe',5),(2,3,'navegador',10),(3,3,'navegador y vaca',20),(4,4,'silla bebe',5),(5,6,'cadenas',2.5),(6,9,'navegador',8),(7,11,'vaca',12),(8,15,'silla bebe, navegador y vaca',22),(9,18,'navegador',7),(10,19,'cadenas',2),(11,7,'nitrometano',100);
/*!40000 ALTER TABLE `fichero_extras` ENABLE KEYS */;
UNLOCK TABLES;

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
  `id_reserva` int NOT NULL,
  `matricula` int NOT NULL,
  `id_modelo` int NOT NULL,
  `id_franquicia` int NOT NULL,
  `id_cliente` int NOT NULL,
  PRIMARY KEY (`id_factura`,`id_tarifa`,`id_reserva`,`matricula`,`id_modelo`,`id_franquicia`,`id_cliente`),
  UNIQUE KEY `id_factura_UNIQUE` (`id_factura`),
  KEY `fk_Fichero_factura_Fichero_tarifa1_idx` (`id_tarifa`),
  KEY `fk_Fichero_factura_Fichero_coche1_idx` (`matricula`,`id_modelo`,`id_franquicia`),
  KEY `fk_Fichero_factura_Fichero_reserva1_idx` (`id_reserva`),
  KEY `fk_Fichero_factura_Fichero_cliente1_idx` (`id_cliente`),
  CONSTRAINT `fk_Fichero_factura_Fichero_cliente1` FOREIGN KEY (`id_cliente`) REFERENCES `fichero_cliente` (`id_cliente`) ON UPDATE CASCADE,
  CONSTRAINT `fk_Fichero_factura_Fichero_coche1` FOREIGN KEY (`matricula`, `id_modelo`, `id_franquicia`) REFERENCES `fichero_coche` (`matricula`, `id_modelo`, `id_franquicia`) ON UPDATE CASCADE,
  CONSTRAINT `fk_Fichero_factura_Fichero_reserva1` FOREIGN KEY (`id_reserva`) REFERENCES `fichero_reserva` (`id_reserva`) ON UPDATE CASCADE,
  CONSTRAINT `fk_Fichero_factura_Fichero_tarifa1` FOREIGN KEY (`id_tarifa`) REFERENCES `fichero_tarifa` (`id_tarifa`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fichero_factura`
--

LOCK TABLES `fichero_factura` WRITE;
/*!40000 ALTER TABLE `fichero_factura` DISABLE KEYS */;
/*!40000 ALTER TABLE `fichero_factura` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `fichero_franquicia`
--

LOCK TABLES `fichero_franquicia` WRITE;
/*!40000 ALTER TABLE `fichero_franquicia` DISABLE KEYS */;
INSERT INTO `fichero_franquicia` VALUES (1,'Madrid','Madrid','Calle Embajadores 45'),(2,'Barcelona','Barcelona','Calle Doctor Ventura 22'),(3,'Valencia','Valencia','Avenida Valdelasierra 110'),(4,'La Coruña','Santiago de Compostela','Calle Juan de la Cierva 10'),(5,'Sevilla','Sevilla','Paseo del Guadalquivir 5'),(6,'Murcia','Cartagena','Calle Salva Espín 41'),(7,'Badajoz','Mérida','Avenida Imperio Romano 8'),(8,'Zaragoza','Zaragoza','Paseo Reyes Católicos 19'),(9,'Vitoria','Vitoria','Calle Picasso 34'),(10,'Toledo','Toledo','Calle Mario Entero 11'),(11,'Salamanca','Salamanca','Paseo de la Esperanza 2'),(12,'Valladolid','Valladolid','Avenida del Duero 27');
/*!40000 ALTER TABLE `fichero_franquicia` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `fichero_modelo`
--

LOCK TABLES `fichero_modelo` WRITE;
/*!40000 ALTER TABLE `fichero_modelo` DISABLE KEYS */;
INSERT INTO `fichero_modelo` VALUES (1,'Alfa Romeo','gama media','Giulieta','manual','cerrado','gasolina',5,2017),(2,'Audi','gama media','A4','automático','cerrado','diesel',5,2018),(3,'Audi','gama alta','A3','automático','cerrado','gasolina',5,2017),(4,'BMW','gama media','Serie 1','manual','cerrado','gasolina',5,2004),(5,'BMW','gama alta','Serie 4','manual','cerrado','gasolina',5,2008),(6,'Citroën','gama baja','C1','manual','cerrado','gasolina',4,2005),(7,'Ferrari','gama alta','California','manual','descapotable','gasolina',2,2012),(8,'Jeep','gama media','Compass','automatico','cerrado','diesel',5,2010),(9,'KIA','gama media','Optima','automático','cerrado','híbrido gasolina',5,2018),(10,'Mercedes','gama media','Clase A','automático','cerrado','híbrido gasolina',5,2009),(11,'Mercedes','gama alta','Clase C','automático','cerrado','híbrido gasolina',5,2014),(12,'Mitsubishi','gama media','ASX','manual','Cristalera','gasolina',5,2012),(13,'Peugot','gama baja','207','manual','descapotable','gasolina',4,2006),(14,'Peugot','gama media','208','automático','cerrado','diesel',4,2010),(15,'Porsche','gama alta','Cayenne','automático','cristalera','gasolina',5,2015),(16,'Renault','gama baja','clio','manual','cerrado','diesel',4,2019),(17,'Renault','gama media','espace','automático','cerrado','gasolina',7,2011),(18,'Seat','gama baja','Ibiza','manual','cerrado','gasolina',4,2008),(19,'Toyota','gama media','Verso','manual','cerrado','diesel',7,2013);
/*!40000 ALTER TABLE `fichero_modelo` ENABLE KEYS */;
UNLOCK TABLES;

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
  `estado_reserva` varchar(45) NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_fin` date NOT NULL,
  `id_cliente` int NOT NULL,
  PRIMARY KEY (`id_coche`,`id_modelo`,`id_franquicia`,`id_cliente`,`id_reserva`),
  UNIQUE KEY `id_reserva_UNIQUE` (`id_reserva`),
  KEY `fk_Fichero_reserva_Fichero_coche1_idx` (`id_coche`,`id_modelo`,`id_franquicia`),
  KEY `fk_Fichero_reserva_Fichero_cliente1_idx` (`id_cliente`),
  CONSTRAINT `fk_Fichero_reserva_Fichero_cliente1` FOREIGN KEY (`id_cliente`) REFERENCES `fichero_cliente` (`id_cliente`) ON UPDATE CASCADE,
  CONSTRAINT `fk_Fichero_reserva_Fichero_coche1` FOREIGN KEY (`id_coche`, `id_modelo`, `id_franquicia`) REFERENCES `fichero_coche` (`matricula`, `id_modelo`, `id_franquicia`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fichero_reserva`
--

LOCK TABLES `fichero_reserva` WRITE;
/*!40000 ALTER TABLE `fichero_reserva` DISABLE KEYS */;
INSERT INTO `fichero_reserva` VALUES (1,1444,1,2,'reservado','2020-11-11','2020-11-13',30858283),(5,4467,10,2,'reservado','2020-10-12','2020-10-14',30858283),(6,4467,10,2,'ACEPTADA','2020-10-12','2020-10-14',30858283),(2,5200,3,7,'reservado','2020-10-16','2020-10-19',1),(4,5925,11,2,'reservado','2020-11-12','2020-11-29',1),(3,9385,13,7,'ACEPTADA','2020-10-16','2020-10-19',1),(7,9582,2,4,'reservado','2021-01-01','2021-01-21',30858283),(8,9582,2,4,'ACEPTADA','2021-01-01','2021-01-21',30858283);
/*!40000 ALTER TABLE `fichero_reserva` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fichero_tarifa`
--

LOCK TABLES `fichero_tarifa` WRITE;
/*!40000 ALTER TABLE `fichero_tarifa` DISABLE KEYS */;
INSERT INTO `fichero_tarifa` VALUES (1,'por_dias','40€'),(2,'por_kilometros','0.35€'),(3,'para_100km','30€'),(4,'para_300km','50€'),(5,'para_500km','70€'),(6,'semanal','100€'),(7,'fin de semana','60€'),(8,'gama_baja','0€'),(9,'gama_media','5€'),(10,'gama_alta','10€');
/*!40000 ALTER TABLE `fichero_tarifa` ENABLE KEYS */;
UNLOCK TABLES;

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

--
-- Dumping data for table `reserva_tiene_extras`
--

LOCK TABLES `reserva_tiene_extras` WRITE;
/*!40000 ALTER TABLE `reserva_tiene_extras` DISABLE KEYS */;
/*!40000 ALTER TABLE `reserva_tiene_extras` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-16 18:11:18
