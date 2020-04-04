CREATE DATABASE IF NOT EXISTS `bookstore` ;

USE `bookstore`;


 CREATE  TABLE IF NOT EXISTS `bookstore`.`booksdb` (
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 ;


 CREATE TABLE IF NOT EXISTS `bookstore`.`users` (
  `userclass` enum('Admin','User') DEFAULT 'User',
  `password` text NOT NULL,
  `first_name` varchar(23) NOT NULL,
  `last_name` varchar(23) NOT NULL,
  `email` varchar(23) NOT NULL,
  `phone_number` varchar(23) NOT NULL,
  `username` varchar(23) NOT NULL,
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `email_2` (`email`),
  UNIQUE KEY `phone_number` (`phone_number`)
)ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 ;


CREATE TABLE IF NOT EXISTS `bookstore`.`orders` (
  `requestorname` varchar(30) NOT NULL,
  `bookName` varchar(30) NOT NULL,
  `bookid` int(10) unsigned NOT NULL,
  `orderstatus` tinyint(1) DEFAULT 0,
  `dateordered` date DEFAULT curdate(),
  `dateapproved` date DEFAULT NULL,
  `bookprice` int(10) unsigned NOT NULL,
  `orderId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `noofbooksordered` int(10) unsigned DEFAULT 1,
  PRIMARY KEY (`orderId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ;


CREATE TABLE  IF NOT EXISTS  `bookstore`.`loggedin` (
  `username` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ;


CREATE TABLE IF NOT EXISTS `bookstore`.`history` (
    `username` VARCHAR(50) NOT NULL,
    `bookname` VARCHAR(50) NOT NULL,
    `bookprice` INT unsigned NOT NULL,
    `booksubject` VARCHAR(50) NOT NULL,
    `dateborrowed` DATE DEFAULT CURDATE(),
    `dateapproved` DATE DEFAULT NULL,
    `datedisbursed` DATE DEFAULT NULL,
    `bookrecycled` BOOLEAN DEFAULT FALSE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


 CREATE TABLE IF NOT EXISTS `bookstore`.`requested` (
  `bookname` varchar(30) NOT NULL,
  `bookwriter` varchar(30) DEFAULT NULL,
  `booksubject` varchar(50) NOT NULL,
  `bookadded` enum('Yes','No') DEFAULT 'No',
  `daterequested` date DEFAULT curdate(),
  `dateadded` date DEFAULT NULL,
  UNIQUE KEY `bookname` (`bookname`,`booksubject`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
