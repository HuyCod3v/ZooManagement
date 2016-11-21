-- MySQL dump 10.13  Distrib 5.7.12, for Win32 (AMD64)
--
-- Host: localhost    Database: ZooManagement
-- ------------------------------------------------------
-- Server version	5.7.16-log

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
-- Table structure for table `animal`
--

DROP TABLE IF EXISTS `animal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `animal` (
  `AnimalID` char(10) NOT NULL,
  `AnimalName` varchar(30) DEFAULT NULL,
  `SpeciesID` char(10) DEFAULT NULL,
  `Gender` tinyint(4) DEFAULT NULL,
  `Weight` double DEFAULT NULL,
  `Height` double DEFAULT NULL,
  `HealthStatus` varchar(30) DEFAULT NULL,
  `Description` varchar(1000) DEFAULT NULL,
  `CellID` char(10) DEFAULT NULL,
  PRIMARY KEY (`AnimalID`),
  KEY `animal_species_fk_idx` (`SpeciesID`),
  KEY `animal_cell_fk_idx` (`CellID`),
  CONSTRAINT `animal_cell_fk` FOREIGN KEY (`CellID`) REFERENCES `cell` (`CellID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `animal_species_fk` FOREIGN KEY (`SpeciesID`) REFERENCES `species` (`SpeciesID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `animal`
--

LOCK TABLES `animal` WRITE;
/*!40000 ALTER TABLE `animal` DISABLE KEYS */;
INSERT INTO `animal` VALUES ('ANI03','Khỉ đột','SPE01',1,98,1,'Tốt','Khỉ ở rừng','Cell01');
/*!40000 ALTER TABLE `animal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cell`
--

DROP TABLE IF EXISTS `cell`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cell` (
  `CellID` char(10) NOT NULL,
  `CellName` varchar(30) DEFAULT NULL,
  `RegionID` char(10) DEFAULT NULL,
  `SpeciesID` char(10) DEFAULT NULL,
  `Capacity` int(11) DEFAULT NULL,
  `CellStatusID` int(11) DEFAULT NULL,
  `Description` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`CellID`),
  KEY `celll_cell_status_fk_idx` (`CellStatusID`),
  KEY `cell_region_fk_idx` (`RegionID`),
  KEY `cell_species_fk_idx` (`SpeciesID`),
  CONSTRAINT `cell_region_fk` FOREIGN KEY (`RegionID`) REFERENCES `region` (`RegionID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `cell_species_fk` FOREIGN KEY (`SpeciesID`) REFERENCES `species` (`SpeciesID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `celll_cell_status_fk` FOREIGN KEY (`CellStatusID`) REFERENCES `cellstatus` (`CellStatusID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cell`
--

LOCK TABLES `cell` WRITE;
/*!40000 ALTER TABLE `cell` DISABLE KEYS */;
INSERT INTO `cell` VALUES ('Cell01','Chuồng 1 Cập nhật','RE02',NULL,34,0,'aaaaaaaaaaaaaaaaa'),('Cell011','Chuồng 11','RE01',NULL,12,0,'1111'),('Cell012','Chuồng 12','RE01',NULL,2,0,'1111'),('Cell013','Chuồng 13','RE01',NULL,2,0,'1111'),('Cell019','1111','RE01',NULL,11,0,'11111'),('Cell04','1111','RE01',NULL,12,0,'11111'),('Cell05','Chuồng 5','RE02',NULL,123,1,'123213213');
/*!40000 ALTER TABLE `cell` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cellstatus`
--

DROP TABLE IF EXISTS `cellstatus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cellstatus` (
  `CellStatusID` int(11) NOT NULL,
  `CellStatusName` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`CellStatusID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cellstatus`
--

LOCK TABLES `cellstatus` WRITE;
/*!40000 ALTER TABLE `cellstatus` DISABLE KEYS */;
INSERT INTO `cellstatus` VALUES (0,'Còn chỗ'),(1,'Đã đầy');
/*!40000 ALTER TABLE `cellstatus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class`
--

DROP TABLE IF EXISTS `class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `class` (
  `ClassID` char(10) NOT NULL,
  `ClassName` varchar(30) DEFAULT NULL,
  `Description` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`ClassID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class`
--

LOCK TABLES `class` WRITE;
/*!40000 ALTER TABLE `class` DISABLE KEYS */;
/*!40000 ALTER TABLE `class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `EmployeeID` char(10) NOT NULL,
  `EmployeeName` varchar(30) DEFAULT NULL,
  `Gender` tinyint(4) DEFAULT NULL,
  `Birthday` date DEFAULT NULL,
  `Phone` varchar(30) DEFAULT NULL,
  `Address` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`EmployeeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES ('A12321','Hà Quang Huy',1,'2016-11-23','','dsad'),('EPL01','Lê Viết Nhựt',1,'2016-11-02','01687184516','Quang Nam');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `job`
--

DROP TABLE IF EXISTS `job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `job` (
  `JobID` int(11) NOT NULL AUTO_INCREMENT,
  `JobDescription` varchar(1000) COLLATE utf8mb4_unicode_ci NOT NULL,
  `JobName` varchar(1000) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`JobID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job`
--

LOCK TABLES `job` WRITE;
/*!40000 ALTER TABLE `job` DISABLE KEYS */;
INSERT INTO `job` VALUES (1,'Nói chung có méo có chi đâu','Công việc 2'),(11,'cũng khoog có chi','Công việc 1');
/*!40000 ALTER TABLE `job` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jobstatus`
--

DROP TABLE IF EXISTS `jobstatus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jobstatus` (
  `JobStatusID` int(11) NOT NULL,
  `JobStatusName` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`JobStatusID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jobstatus`
--

LOCK TABLES `jobstatus` WRITE;
/*!40000 ALTER TABLE `jobstatus` DISABLE KEYS */;
/*!40000 ALTER TABLE `jobstatus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jobtype`
--

DROP TABLE IF EXISTS `jobtype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jobtype` (
  `JobTypeID` int(11) NOT NULL,
  `JobTypeName` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`JobTypeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jobtype`
--

LOCK TABLES `jobtype` WRITE;
/*!40000 ALTER TABLE `jobtype` DISABLE KEYS */;
/*!40000 ALTER TABLE `jobtype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `linkemployeeregion`
--

DROP TABLE IF EXISTS `linkemployeeregion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `linkemployeeregion` (
  `RegionID` char(10) NOT NULL,
  `EmployeeID` char(10) DEFAULT NULL,
  PRIMARY KEY (`RegionID`),
  KEY `link_employee_region_region_fk_idx` (`RegionID`),
  KEY `link_employee_region_employee_fk_idx` (`EmployeeID`),
  CONSTRAINT `link_employee_region_employee_fk` FOREIGN KEY (`EmployeeID`) REFERENCES `employee` (`EmployeeID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `link_employee_region_region_fk` FOREIGN KEY (`RegionID`) REFERENCES `region` (`RegionID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `linkemployeeregion`
--

LOCK TABLES `linkemployeeregion` WRITE;
/*!40000 ALTER TABLE `linkemployeeregion` DISABLE KEYS */;
/*!40000 ALTER TABLE `linkemployeeregion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `linkjobemployee`
--

DROP TABLE IF EXISTS `linkjobemployee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `linkjobemployee` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `JobID` int(11) NOT NULL,
  `EmployeeID` char(10) CHARACTER SET utf8 NOT NULL,
  `startTime` date NOT NULL,
  `endTime` date NOT NULL,
  `Description` varchar(1000) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `JobID` (`JobID`),
  KEY `EmployeeID` (`EmployeeID`),
  CONSTRAINT `linkjobemployee_ibfk_1` FOREIGN KEY (`JobID`) REFERENCES `job` (`JobID`),
  CONSTRAINT `linkjobemployee_ibfk_2` FOREIGN KEY (`EmployeeID`) REFERENCES `employee` (`EmployeeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `linkjobemployee`
--

LOCK TABLES `linkjobemployee` WRITE;
/*!40000 ALTER TABLE `linkjobemployee` DISABLE KEYS */;
/*!40000 ALTER TABLE `linkjobemployee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notification`
--

DROP TABLE IF EXISTS `notification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notification` (
  `NotificationID` char(10) NOT NULL,
  `Title` varchar(250) NOT NULL,
  `EmployeeID` char(10) DEFAULT NULL,
  `Content` varchar(1000) DEFAULT NULL,
  `NotificationDate` datetime DEFAULT NULL,
  PRIMARY KEY (`NotificationID`),
  KEY `notification_employee_fk_idx` (`EmployeeID`),
  CONSTRAINT `notification_employee_fk` FOREIGN KEY (`EmployeeID`) REFERENCES `employee` (`EmployeeID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notification`
--

LOCK TABLES `notification` WRITE;
/*!40000 ALTER TABLE `notification` DISABLE KEYS */;
/*!40000 ALTER TABLE `notification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notificationtype`
--

DROP TABLE IF EXISTS `notificationtype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notificationtype` (
  `NotificationTypeID` int(11) NOT NULL,
  `NotificationTypeName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`NotificationTypeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notificationtype`
--

LOCK TABLES `notificationtype` WRITE;
/*!40000 ALTER TABLE `notificationtype` DISABLE KEYS */;
/*!40000 ALTER TABLE `notificationtype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `region`
--

DROP TABLE IF EXISTS `region`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `region` (
  `RegionID` char(10) NOT NULL,
  `RegionName` varchar(30) DEFAULT NULL,
  `RegionStatusID` int(11) DEFAULT NULL,
  `RegionArea` double DEFAULT NULL,
  `Description` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`RegionID`),
  KEY `region_region_status_fk_idx` (`RegionStatusID`),
  CONSTRAINT `region_region_status_fk` FOREIGN KEY (`RegionStatusID`) REFERENCES `regionstatus` (`RegionStatusID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `region`
--

LOCK TABLES `region` WRITE;
/*!40000 ALTER TABLE `region` DISABLE KEYS */;
INSERT INTO `region` VALUES ('RE01','Trung Tâm',1,120,'very rộng'),('RE02','Phía Tây',0,300,'Phía tây sở thú'),('RE03','Phía Đông Nam',0,122,'123213213213');
/*!40000 ALTER TABLE `region` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `regionstatus`
--

DROP TABLE IF EXISTS `regionstatus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `regionstatus` (
  `RegionStatusID` int(11) NOT NULL,
  `RegionStatusName` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`RegionStatusID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `regionstatus`
--

LOCK TABLES `regionstatus` WRITE;
/*!40000 ALTER TABLE `regionstatus` DISABLE KEYS */;
INSERT INTO `regionstatus` VALUES (0,'Còn chỗ'),(1,'Đã đầy');
/*!40000 ALTER TABLE `regionstatus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `species`
--

DROP TABLE IF EXISTS `species`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `species` (
  `SpeciesID` char(10) NOT NULL,
  `SpeciesName` varchar(30) DEFAULT NULL,
  `Description` varchar(1000) DEFAULT NULL,
  `ClassID` char(10) DEFAULT NULL,
  PRIMARY KEY (`SpeciesID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `species`
--

LOCK TABLES `species` WRITE;
/*!40000 ALTER TABLE `species` DISABLE KEYS */;
INSERT INTO `species` VALUES ('SPE01','Thú ăn thịt người','thú ăn thịt','aa');
/*!40000 ALTER TABLE `species` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `Username` varchar(30) NOT NULL,
  `Password` varchar(30) DEFAULT NULL,
  `UserTypeID` int(11) DEFAULT NULL,
  `EmployeeID` char(10) DEFAULT NULL,
  PRIMARY KEY (`Username`),
  KEY `user_user_type_fk_idx` (`UserTypeID`),
  KEY `user_employee_fk_idx` (`EmployeeID`),
  CONSTRAINT `user_employee_fk` FOREIGN KEY (`EmployeeID`) REFERENCES `employee` (`EmployeeID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `user_user_type_fk` FOREIGN KEY (`UserTypeID`) REFERENCES `usertype` (`UserTypeID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('vietnhut','levietnhut',1,'EPL01');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usertype`
--

DROP TABLE IF EXISTS `usertype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usertype` (
  `UserTypeID` int(11) NOT NULL,
  `UserTypeName` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`UserTypeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usertype`
--

LOCK TABLES `usertype` WRITE;
/*!40000 ALTER TABLE `usertype` DISABLE KEYS */;
INSERT INTO `usertype` VALUES (1,'Admin');
/*!40000 ALTER TABLE `usertype` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-11-21 23:08:54
