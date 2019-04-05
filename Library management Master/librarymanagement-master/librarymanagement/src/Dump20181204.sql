CREATE DATABASE  IF NOT EXISTS `library` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `library`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: library
-- ------------------------------------------------------
-- Server version	5.7.21-log

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
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) NOT NULL,
  `author` varchar(45) DEFAULT NULL,
  `publisher` varchar(45) DEFAULT NULL,
  `count` varchar(45) DEFAULT NULL,
  `placestored` varchar(45) DEFAULT NULL,
  `version` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2006 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (2000,'C programming','Balaguruswamy','Tata','4','R1-4','2.0','1'),(2001,'java','Herbert Schildt','Tata','0','M1-3','1.9','1'),(2002,'python','satish','satish','4','M1-4','1.0','1'),(2003,'C++ programming','Balaguruswamy','Tata','3','R1-4',NULL,'1'),(2004,'programming principles','Balaguruswamy','Tata','3','R1-4',NULL,'1'),(2005,'python','Balaguruswamy','Tata','3','R1-4',NULL,'1');
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `c_type`
--

DROP TABLE IF EXISTS `c_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `c_type` (
  `c_id` int(11) NOT NULL,
  `type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `c_type`
--

LOCK TABLES `c_type` WRITE;
/*!40000 ALTER TABLE `c_type` DISABLE KEYS */;
INSERT INTO `c_type` VALUES (1,'Book'),(2,'Journel');
/*!40000 ALTER TABLE `c_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `issued`
--

DROP TABLE IF EXISTS `issued`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `issued` (
  `idIssued` int(11) NOT NULL AUTO_INCREMENT,
  `person` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `date` datetime DEFAULT CURRENT_TIMESTAMP,
  `returndate` varchar(45) DEFAULT NULL,
  `bookid` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idIssued`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `issued`
--

LOCK TABLES `issued` WRITE;
/*!40000 ALTER TABLE `issued` DISABLE KEYS */;
INSERT INTO `issued` VALUES (1,'1213','1','2018-11-08 00:00:00','2018-11-22\n    ','2000'),(2,'1213','1','2018-11-08 00:00:00','2018-11-22\n    ','2000'),(3,'1213','1','2018-11-08 00:00:00','2018-11-22\n    ','2001'),(4,'1213','1','2018-11-08 00:00:00','2018-11-22\n    ','2000'),(5,'1213','1','2018-11-08 00:00:00','2018-11-22\n    ','2000'),(6,'1213','1','2018-11-08 00:00:00',NULL,'2000'),(7,'1213','1','2018-11-08 00:00:00',NULL,'2000'),(8,'1213','1','2018-11-08 00:00:00',NULL,'2000'),(9,'1213','1','2018-11-08 00:00:00',NULL,'2000');
/*!40000 ALTER TABLE `issued` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person` (
  `idperson` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idperson`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (1,'Satish','594B andrew','snulaka@lakeheadu.ca','970370383'),(2,'Satish','594B andrew','snulaka@lakeheadu.ca','970370383'),(3,'Satish','594B andrew','snulaka@lakeheadu.ca','970370383'),(4,'Satish','594B andrew','snulaka@lakeheadu.ca','970370383'),(5,'Satish','594B andrew','snulaka@lakeheadu.ca','970370383'),(6,'Satish','594B andrew','snulaka@lakeheadu.ca','970370383'),(7,'Satish','594B andrew','snulaka@lakeheadu.ca','970370383'),(8,'Satish','594B andrew','snulaka@lakeheadu.ca','970370383'),(9,'Satish','594B andrew','snulaka@lakeheadu.ca','970370383');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `return`
--

DROP TABLE IF EXISTS `return`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `return` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bookid` varchar(45) DEFAULT NULL,
  `personid` varchar(45) DEFAULT NULL,
  `fine` varchar(45) DEFAULT NULL,
  `date` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `return`
--

LOCK TABLES `return` WRITE;
/*!40000 ALTER TABLE `return` DISABLE KEYS */;
/*!40000 ALTER TABLE `return` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-04  1:18:17
