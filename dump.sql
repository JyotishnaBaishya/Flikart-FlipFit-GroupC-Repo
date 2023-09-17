-- MySQL dump 10.13  Distrib 8.1.0, for macos13.3 (arm64)
--
-- Host: localhost    Database: Flipfit
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
-- Table structure for table `Gym`
--

DROP TABLE IF EXISTS `Gym`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Gym` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `gymOwnerID` int DEFAULT NULL,
  `gymName` varchar(45) NOT NULL,
  `location` varchar(45) DEFAULT NULL,
  `noOfSeats` varchar(45) DEFAULT NULL,
  `isApproved` tinyint DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Gym`
--

LOCK TABLES `Gym` WRITE;
/*!40000 ALTER TABLE `Gym` DISABLE KEYS */;
INSERT INTO `Gym` VALUES (1,1,'','BNG','10',1),(2,2,'Gym4','HYD','20',1),(3,55,'gym5','loc5','20',1),(4,55,'gym7','loc5','20',1),(5,55,'gym8','loc5','20',0),(6,55,'gym9','loc5','20',0),(7,55,'Gym1','loc5','20',0),(8,6,'Gym2','Bel','10',1),(9,6,'Gym3','Bel','11',2);
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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `GymOwner`
--

LOCK TABLES `GymOwner` WRITE;
/*!40000 ALTER TABLE `GymOwner` DISABLE KEYS */;
INSERT INTO `GymOwner` VALUES (1,'GymOwner1','pass','1234-2345-1234','22AAAAA0000A1Z5',1),(2,'GymOwner2','pass2','1234-2345-1233','22AAAAA0000A1Z6',2),(6,'GymOwner3','pass3','4567-6543-1234','22AAAAA0000A1Z9',2),(14,'go','pass','4567-6543-9876','22AAAAA9987A1Z9',2);
/*!40000 ALTER TABLE `GymOwner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Notification`
--

DROP TABLE IF EXISTS `Notification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Notification` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userID` int DEFAULT NULL,
  `userType` varchar(45) DEFAULT NULL,
  `content` varchar(45) DEFAULT NULL,
  `isViewed` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Notification`
--

LOCK TABLES `Notification` WRITE;
/*!40000 ALTER TABLE `Notification` DISABLE KEYS */;
INSERT INTO `Notification` VALUES (1,2,'Gymowner','Your Request has been Approved for Gym4','0'),(2,6,'Gymowner','Your Request has been Rejected for Gym3','0'),(3,2,'GymOwner','Something has happened','0');
/*!40000 ALTER TABLE `Notification` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
INSERT INTO `User` VALUES (1,'customer1','pass','Customer'),(2,'customer2','pass','Customer'),(3,'customer3','pass','Customer'),(4,'customer4','pass','Customer'),(6,'gymOwner99','pass','Gymowner'),(7,'admin','pass',NULL),(8,'gymOwer99','pass','Gymowner');
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

-- Dump completed on 2023-09-17 12:24:37
