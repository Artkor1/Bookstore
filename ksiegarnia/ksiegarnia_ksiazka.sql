-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: ksiegarnia
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `ksiazka`
--

DROP TABLE IF EXISTS `ksiazka`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ksiazka` (
  `IdKsiazki` int NOT NULL,
  `Tytul` varchar(100) COLLATE utf8_polish_ci NOT NULL,
  `RokWydania` int NOT NULL,
  `Cena` float NOT NULL,
  `Oprawka` enum('Twarda','Miękka') COLLATE utf8_polish_ci NOT NULL,
  `IdAutora` int NOT NULL,
  PRIMARY KEY (`IdKsiazki`),
  KEY `IdAutora` (`IdAutora`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ksiazka`
--

LOCK TABLES `ksiazka` WRITE;
/*!40000 ALTER TABLE `ksiazka` DISABLE KEYS */;
INSERT INTO `ksiazka` VALUES (1,'Krzyżacy',1900,24.8,'Miękka',1),(2,'Quo Vadis',1896,22.9,'Miękka',1),(3,'Quo Vadis',1896,24.3,'Twarda',1),(4,'W pustyni i w puszczy',1911,23.1,'Miękka',1),(5,'Akademia pana Kleksa',1946,14.5,'Miękka',2),(6,'Na wyspach Bergamutach',1948,15,'Twarda',2),(7,'Nad Niemnem',1888,21.5,'Miękka',3),(8,'Gloria victis',1910,10.5,'Miękka',3),(9,'Trzej muszkieterowie',1844,16.5,'Twarda',4),(10,'Hrabia Monte Cristo',1844,14.1,'Twarda',4),(11,'Opowieść wigilijna',1843,16.5,'Twarda',5),(12,'Przedwiośnie',1924,18.5,'Miękka',6),(13,'Syzyfowe prace',1897,13.5,'Miękka',6),(14,'Ludzie bezdomni',1900,17.5,'Miękka',6),(15,'Hobbit',1937,21.7,'Miękka',8),(16,'Władca Pierścieni tom 1-3',1954,90.9,'Miękka',8),(17,'Sherlock Holmes wydanie kompletne',1892,99.5,'Miękka',7);
/*!40000 ALTER TABLE `ksiazka` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-25 15:37:11
