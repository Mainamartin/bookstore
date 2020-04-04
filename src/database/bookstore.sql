-- MySQL dump 10.17  Distrib 10.3.22-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: bookstore
-- ------------------------------------------------------
-- Server version	10.3.22-MariaDB-1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `booksdb`
--

DROP TABLE IF EXISTS `booksdb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `booksdb` (
  `bookname` varchar(50) NOT NULL,
  `writername` varchar(50) NOT NULL,
  `datePublished` date NOT NULL,
  `price` int(10) unsigned NOT NULL,
  `publishername` varchar(50) NOT NULL,
  `source` varchar(30) NOT NULL,
  `bookcondition` enum('Old','New') NOT NULL,
  `subject` varchar(30) NOT NULL,
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  UNIQUE KEY `bookname` (`bookname`,`writername`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booksdb`
--

LOCK TABLES `booksdb` WRITE;
/*!40000 ALTER TABLE `booksdb` DISABLE KEYS */;
INSERT INTO `booksdb` VALUES ('Computer Graphics','Benson Mwangi','2004-06-15',3500,'Mwanikis\'s Publishers','Archive','New','Computer',1),('Pure Mathematics','J.K. Some Craydic','2000-00-01',300,'Longman Publishers','archive','Old','Mathematics',3),('English Aid 6','M.S. PATEL','2007-06-01',250,'Jyoti Bindu Publication Ltd','God is Light','Old','English',4),('Across The Bridge','Hebrew Martins','1995-04-25',250,'JKF','Lib','Old','English',5);
/*!40000 ALTER TABLE `booksdb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `history`
--

DROP TABLE IF EXISTS `history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `history` (
  `username` varchar(50) NOT NULL,
  `bookname` varchar(50) NOT NULL,
  `bookprice` int(10) unsigned NOT NULL,
  `booksubject` varchar(50) NOT NULL,
  `dateborrowed` date DEFAULT curdate(),
  `dateapproved` date DEFAULT NULL,
  `datedisbursed` date DEFAULT NULL,
  `bookrecycled` enum('False','True') DEFAULT 'False'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `history`
--

LOCK TABLES `history` WRITE;
/*!40000 ALTER TABLE `history` DISABLE KEYS */;
INSERT INTO `history` VALUES ('johnkamau','Pure Mathematics',300,'Mathematics','2020-03-31','2020-04-02','2020-04-02','False');
/*!40000 ALTER TABLE `history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loggedin`
--

DROP TABLE IF EXISTS `loggedin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `loggedin` (
  `username` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loggedin`
--

LOCK TABLES `loggedin` WRITE;
/*!40000 ALTER TABLE `loggedin` DISABLE KEYS */;
/*!40000 ALTER TABLE `loggedin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `requestorname` varchar(30) NOT NULL,
  `bookName` varchar(30) NOT NULL,
  `bookid` int(10) unsigned NOT NULL,
  `dateordered` date DEFAULT curdate(),
  `dateapproved` date DEFAULT NULL,
  `bookprice` int(10) unsigned NOT NULL,
  `orderId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `noofbooksordered` int(10) unsigned DEFAULT 1,
  `orderstatus` enum('Approved','Not Approved','Denied') DEFAULT 'Not Approved',
  PRIMARY KEY (`orderId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES ('johnkamau','Pure Mathematics',3,'2020-03-31','2020-04-02',300,1,1,'Approved');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `requested`
--

DROP TABLE IF EXISTS `requested`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `requested` (
  `bookname` varchar(30) NOT NULL,
  `bookwriter` varchar(30) DEFAULT NULL,
  `booksubject` varchar(50) NOT NULL,
  `bookadded` enum('Yes','No') DEFAULT 'No',
  `daterequested` date DEFAULT curdate(),
  `dateadded` date DEFAULT NULL,
  UNIQUE KEY `bookname` (`bookname`,`booksubject`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `requested`
--

LOCK TABLES `requested` WRITE;
/*!40000 ALTER TABLE `requested` DISABLE KEYS */;
INSERT INTO `requested` VALUES ('C++ Programming','John Hagee','Computer','No','2020-04-01',NULL),('History Form IV','Catherine Mwaniki','History','No','2020-04-01',NULL),('Mathematics For Science','John M Mwai','Mathematics','No','2020-04-01',NULL);
/*!40000 ALTER TABLE `requested` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `userclass` enum('Admin','User') DEFAULT 'User',
  `password` text NOT NULL,
  `first_name` varchar(23) NOT NULL,
  `last_name` varchar(23) NOT NULL,
  `email` varchar(23) NOT NULL,
  `phone_number` varchar(23) NOT NULL,
  `username` varchar(23) NOT NULL,
  `image` longblob DEFAULT NULL,
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `email_2` (`email`),
  UNIQUE KEY `phone_number` (`phone_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('Admin','0f457c31567f0255625118352d51185f6b5c3f1c','ADMIN','ADMIN','admin@admin.com','1111 222 333','Admin',NULL),('User','324348537d412d1e654d7634482a1f45531f730c','BENJAMIN','KIMANI','benjamin@kimani.com','0701 123 456','benjaminkimani',NULL),('User','026e593f7c102915365b35391c49292938135d69','JOHN','KAMAU','john@kamau.bkst','0712 345 678','johnkamau',NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-02 10:52:59
