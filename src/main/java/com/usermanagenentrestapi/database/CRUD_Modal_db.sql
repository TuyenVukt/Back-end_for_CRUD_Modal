CREATE DATABASE  IF NOT EXISTS `myemployee` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `myemployee`;
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: myemployee
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
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone` varchar(13) COLLATE utf8_bin DEFAULT NULL,
  `status` int NOT NULL DEFAULT '1',
  `email` varchar(45) COLLATE utf8_bin DEFAULT 'abc',
  `avatar` varchar(45) COLLATE utf8_bin DEFAULT 'avatar.img',
  `password` varchar(200) COLLATE utf8_bin NOT NULL DEFAULT '12345678',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (10,'Nguyên Hồng Ngọc','099378877',1,'abc','avatar.img','12345678'),(11,'Nguyễn Hằng Nga','0987678657',1,'tuyen1.vd@gmail.com','avatar.img','$2a$12$Gsjzg2SiPt6HXhWR9O718.04ROlR2553TEIYeEv2vs9NAOxFLV1PW'),(12,'Vũ Đức Tuyên','0987654342',1,'tuyen.vd12@gmail.com',NULL,'$2a$12$VRG790mnn8F8FZUG8SLQcu72GjPLe4DKWkqk8cQUAiEeX6pSBeGfK'),(13,'Nguyễn Xuân Thành','20184032',1,'thanh.nx23@gmail.com','avatar.img','12345678'),(14,'Phạm Tuấn Việt','20184335',1,'viet.pt@gmail.com','avatar.img','12345678'),(15,'Phạm Đức Vượng','20198787',1,'vuong.pd@gmail.com','avatar.img','12345678'),(16,'Phạm Thị Mai Tuyết','20187676',1,'tuyet.ptm@gmail.com','avatar.img','12345678'),(17,'Lê Vân Anh','12345678',1,'abc','avatar.img','12345678'),(18,'Lưu Đức Anh','20178787',1,'abc','avatar.img','12345678'),(19,'Đặng Đình Long','20988767',1,'abc','avatar.img','12345678'),(20,'John Witch','76765454',1,'abc','avatar.img','12345678'),(23,'Trần Huy Tú','0986542960',1,'tuyen.vd@gmail.com',NULL,'$2a$12$mi481cWO/vlBxMR3xRSuFeGKb0fojzl1vyLtf1bgmqTYgdDaUFc0K'),(24,'Đặng Đình Long','0986542961',1,'long.đ@gmail.com',NULL,'$2a$12$Q5iLSl6HU.z1crHJSTrsWeBzV8Bm4CnAzkG9FokB5R3bqEBZhPdWm'),(28,'Hoàng Ngọc Bảo','0986542960',1,'bao.hn@gmail.com',NULL,'$2a$12$YKK0XfWMqoX.0JCAs179M.DsFZpHAoWQdSUM.HB65o10CRr2rD08O'),(29,'Nguyễn Hải Yến','0987963456',1,'yen.vd@gmail.com',NULL,'$2a$12$O5K8wtmJVSJZTAqK1A5zveWY3.SrFu3IisV33tfG5oqr97eBQtkdm'),(30,'Nguyễn Lương Hải','0986542960',1,'hai.nl@gmail.com',NULL,'$2a$12$bxVzctbdwi9TR2pYX0ZiOey9QGblMyXtfbQmkK9fdb5B0FavsfYVy');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (31);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL,
  `avatar` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `phone` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `status` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (21,NULL,'tuyen.vd@gmail.com','Vu Duc Tuyen','$2a$12$SI2bv7T8lwLz5fNN8w1vZ.cHI0XPBfeBM3FvIHGtbCPBc0jJBynj2','0986542960',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-20 16:07:25
