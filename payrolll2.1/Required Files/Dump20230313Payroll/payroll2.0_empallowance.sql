-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: payroll2.0
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `empallowance`
--

DROP TABLE IF EXISTS `empallowance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empallowance` (
  `empid` int NOT NULL,
  `allowance_id` int NOT NULL,
  `allowance_name` varchar(45) NOT NULL,
  `allowance_amt` int NOT NULL,
  PRIMARY KEY (`empid`,`allowance_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empallowance`
--

LOCK TABLES `empallowance` WRITE;
/*!40000 ALTER TABLE `empallowance` DISABLE KEYS */;
INSERT INTO `empallowance` VALUES (0,1,'Home',500),(1,1,'Basic',10000),(1,2,'HRA',1000),(1,3,'DA',500),(1,4,'Medical Allowance',200),(1,6,'Performance Bonus',500),(2,1,'Basic',7000),(2,2,'HRA',800),(2,3,'DA',500),(2,4,'Medical Allowance',100),(2,5,'Special Allowance',700),(3,1,'Basic',5000),(3,2,'HRA',500),(3,3,'DA',200),(3,4,'Medical Allowance',600),(3,6,'Performance Bonus',9000),(4,2,'Travel',45),(5,1,'Basic',8000),(5,2,'HRA',500),(5,3,'DA',200),(5,4,'Medical Allowance',1000),(5,6,'Performance Bonus',8000),(6,1,'Basic',8000),(6,2,'HRA',500),(6,3,'DA',300),(6,5,'Special Allowance',100);
/*!40000 ALTER TABLE `empallowance` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-03-13 22:03:34
