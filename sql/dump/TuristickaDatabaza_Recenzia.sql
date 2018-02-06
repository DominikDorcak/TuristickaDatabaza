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
-- Table structure for table `Recenzia`
--

DROP TABLE IF EXISTS `Recenzia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Recenzia` (
  `Text` varchar(300) NOT NULL,
  `Lokalita_id` int(11) NOT NULL,
  `Hodnotenie` smallint(6) DEFAULT NULL,
  `Pouzivatel_login` varchar(32) NOT NULL,
  `datum` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `fk_Recenzia_Lokalita_idx` (`Lokalita_id`),
  KEY `fk_Recenzia_Pouzivatel1_idx` (`Pouzivatel_login`),
  CONSTRAINT `fk_Recenzia_Lokalita` FOREIGN KEY (`Lokalita_id`) REFERENCES `Lokalita` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_Recenzia_Pouzivtel` FOREIGN KEY (`Pouzivatel_login`) REFERENCES `Pouzivatel` (`login`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Recenzia`
--

LOCK TABLES `Recenzia` WRITE;
/*!40000 ALTER TABLE `Recenzia` DISABLE KEYS */;
INSERT INTO `Recenzia` VALUES ('upravene aj druhe',1,5,'admin','2018-02-06 18:05:34',12),('uprava',1,5,'admin','2018-02-06 18:05:48',13),('Tu som!',2,4,'Dominik','2018-02-06 18:10:49',14);
/*!40000 ALTER TABLE `Recenzia` ENABLE KEYS */;
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
