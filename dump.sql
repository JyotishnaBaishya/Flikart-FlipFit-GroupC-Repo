-- MySQL dump 10.13  Distrib 8.1.0, for macos13.3 (arm64)
--
-- Host: localhost    Database: FlipFit
-- ------------------------------------------------------
-- Server version	8.0.34

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Booking`
--

DROP TABLE IF EXISTS `Booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Booking` (
  `bookingID` int NOT NULL AUTO_INCREMENT,
  `slotID` int NOT NULL,
  `customerID` int NOT NULL,
  PRIMARY KEY (`bookingID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Booking`
--

LOCK TABLES `Booking` WRITE;
/*!40000 ALTER TABLE `Booking` DISABLE KEYS */;
INSERT INTO `Booking` VALUES (1,2,1);
/*!40000 ALTER TABLE `Booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Gym`
--

DROP TABLE IF EXISTS `Gym`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Gym` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `gymOwnerID` int DEFAULT NULL,
  `location` varchar(45) DEFAULT NULL,
  `noOfSeats` varchar(45) DEFAULT NULL,
  `isApproved` tinyint DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Gym`
--

LOCK TABLES `Gym` WRITE;
/*!40000 ALTER TABLE `Gym` DISABLE KEYS */;
INSERT INTO `Gym` VALUES (1,1,'loc1','20',0);
/*!40000 ALTER TABLE `Gym` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `GymOwner`
--

DROP TABLE IF EXISTS `GymOwner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `GymOwner` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `aadharcard` varchar(45) DEFAULT NULL,
  `gstin` varchar(45) DEFAULT NULL,
  `isApproved` tinyint DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `aadharcard_UNIQUE` (`aadharcard`),
  UNIQUE KEY `gstin_UNIQUE` (`gstin`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `GymOwner`
--

LOCK TABLES `GymOwner` WRITE;
/*!40000 ALTER TABLE `GymOwner` DISABLE KEYS */;
INSERT INTO `GymOwner` VALUES (1,'GymOwner1','pass','1234-2345-1234','22AAAAA0000A1Z5',0),(2,'GymOwner2','pass1','1239-2345-1234','22AAAAB0000A1Z5',0);
/*!40000 ALTER TABLE `GymOwner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TimeSlot`
--

DROP TABLE IF EXISTS `TimeSlot`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TimeSlot` (
  `slotID` int NOT NULL AUTO_INCREMENT,
  `slotHour` int NOT NULL,
  `gymID` int NOT NULL,
  `availableSeats` int NOT NULL,
  `day` datetime NOT NULL,
  PRIMARY KEY (`slotID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TimeSlot`
--

LOCK TABLES `TimeSlot` WRITE;
/*!40000 ALTER TABLE `TimeSlot` DISABLE KEYS */;
INSERT INTO `TimeSlot` VALUES (1,2,1,20,'2023-09-17 00:00:00'),(2,2,1,20,'2023-09-17 00:00:00');
/*!40000 ALTER TABLE `TimeSlot` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `User` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `role` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
INSERT INTO `User` VALUES (1,'customer1','pass','Customer'),(2,'customer2','pass','Customer'),(3,'customer3','pass','Customer'),(4,'customer4','pass','Customer');
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-17 15:11:30
