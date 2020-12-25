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
-- Table structure for table `kupno`
--

DROP TABLE IF EXISTS `kupno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kupno` (
  `IdKupna` int NOT NULL,
  `DataZamowienia` date NOT NULL,
  `DataDostarczenia` date NOT NULL,
  `Kwota` float NOT NULL,
  `CzyZaplacono` tinyint(1) NOT NULL,
  `IdKlienta` int NOT NULL,
  PRIMARY KEY (`IdKupna`),
  KEY `IdKlienta` (`IdKlienta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kupno`
--

LOCK TABLES `kupno` WRITE;
/*!40000 ALTER TABLE `kupno` DISABLE KEYS */;
INSERT INTO `kupno` VALUES (1,'2020-12-25','2021-01-01',30.6,1,1),(2,'2020-12-25','2021-01-01',72.2,1,1),(3,'2020-12-25','2021-01-01',112.6,1,2),(4,'2020-12-25','2021-01-01',99.5,1,2),(5,'2020-12-25','2021-01-01',24.8,1,3),(6,'2020-12-25','2021-01-01',29.5,1,4),(7,'2020-12-25','2021-01-01',13.5,1,4),(8,'2020-12-25','2021-01-01',33.6,1,4),(9,'2020-12-25','2021-01-01',90.9,1,4),(10,'2020-12-25','2021-01-01',52.1,1,2);
/*!40000 ALTER TABLE `kupno` ENABLE KEYS */;
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
