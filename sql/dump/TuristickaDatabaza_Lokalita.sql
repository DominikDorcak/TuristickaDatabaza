-- MySQL dump 10.13  Distrib 5.7.21, for Linux (x86_64)
--
-- Host: localhost    Database: TuristickaDatabaza
-- ------------------------------------------------------
-- Server version	5.7.21-0ubuntu0.17.10.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Lokalita`
--

DROP TABLE IF EXISTS `Lokalita`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Lokalita` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Region` varchar(45) NOT NULL,
  `Popis` varchar(450) NOT NULL,
  `Schvalena` tinyint(4) NOT NULL,
  `Nazov` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `Nazov_2` (`Nazov`),
  KEY `Nazov` (`Nazov`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Lokalita`
--

LOCK TABLES `Lokalita` WRITE;
/*!40000 ALTER TABLE `Lokalita` DISABLE KEYS */;
INSERT INTO `Lokalita` VALUES (1,'Zemplín','blablabla',1,'Žbince'),(2,'Abov','Jednoducho metropola východu',1,'Košice'),(3,'Zemplín','predmestie Zbiniec :)',1,'Hatalov'),(4,'Abov','Naša škola',1,'UPJŠ'),(32,'Slovensko','popis',1,'Lokalita'),(34,'Košice','tu bývame',1,'Medická');
/*!40000 ALTER TABLE `Lokalita` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-02-06 19:17:20
