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
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `employeeid` int NOT NULL,
  `employeename` varchar(45) NOT NULL,
  `employeeaddress` varchar(200) NOT NULL,
  `employeestate` varchar(200) NOT NULL,
  `employeeemail` varchar(200) NOT NULL,
  `employeemobno` varchar(12) NOT NULL,
  `employeegender` varchar(45) NOT NULL,
  `EmployeePan` varchar(20) NOT NULL,
  `EMPDOJ` date NOT NULL,
  `EmpDepartment` varchar(45) NOT NULL,
  `EmpDesignation` varchar(45) NOT NULL,
  `EmpBankAcc` varchar(45) NOT NULL,
  `EmpBankName` varchar(45) NOT NULL,
  PRIMARY KEY (`employeeid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'Madhav Lonkar','Korhale B.k,Baramati,Pune','Maharashtra','madhavlonkar2@gmail.com','9370548600','Male','BCTPL3461L','2023-01-01','Developing','Admin','919370548600','Paytm'),(2,'Gururaj Yadav','Karad,Satara','Gujarat','Guru@gmail.com','9183849205','Male','ABVHF21FS','2023-01-03','Technical','HR','91948528572','Maharastra Bank Of India'),(3,'Nandkumar Chavan','Malshiras,Indapur','GOA','nandu@gmail.com','7709462232','Male','ABVHF21FF','2023-01-27','Tesing','Team Lead','98765432345','Union Bank Of India'),(4,'Ganesh Misal','Baramati,Pune','Rajasthan','ganesh@gmail.com','2345678987','Male','NHKUG7542L','2023-01-21','Developing','Cyber Security Expert','866557210937','Maharastra Bank Of India');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
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
