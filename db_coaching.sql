CREATE DATABASE  IF NOT EXISTS `coaching` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `coaching`;
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: coaching
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
-- Table structure for table `class`
--

DROP TABLE IF EXISTS `class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `class` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `id_coach` int NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_coach_idx` (`id_coach`),
  CONSTRAINT `fk_coach` FOREIGN KEY (`id_coach`) REFERENCES `coach` (`id`)
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
-- Table structure for table `class_coachee_mapping`
--

DROP TABLE IF EXISTS `class_coachee_mapping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `class_coachee_mapping` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_coachee` int NOT NULL,
  `id_class` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_coachee_idx` (`id_coachee`),
  KEY `fk_class_idx` (`id_class`),
  CONSTRAINT `fk_class` FOREIGN KEY (`id_class`) REFERENCES `class` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_coachee` FOREIGN KEY (`id_coachee`) REFERENCES `coachee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class_coachee_mapping`
--

LOCK TABLES `class_coachee_mapping` WRITE;
/*!40000 ALTER TABLE `class_coachee_mapping` DISABLE KEYS */;
/*!40000 ALTER TABLE `class_coachee_mapping` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class_session_mapping`
--

DROP TABLE IF EXISTS `class_session_mapping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `class_session_mapping` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_class` int NOT NULL,
  `id_session` int NOT NULL,
  `session_date` date NOT NULL,
  `session_hour` time NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_class_idx` (`id_class`),
  KEY `fk_session_idx` (`id_session`),
  CONSTRAINT `fk_session` FOREIGN KEY (`id_session`) REFERENCES `session` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class_session_mapping`
--

LOCK TABLES `class_session_mapping` WRITE;
/*!40000 ALTER TABLE `class_session_mapping` DISABLE KEYS */;
/*!40000 ALTER TABLE `class_session_mapping` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coach`
--

DROP TABLE IF EXISTS `coach`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `coach` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_person` int NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `id_created_user` int NOT NULL,
  `id_updated_user` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `id_person_UNIQUE` (`id_person`),
  KEY `fk_created_user_idx` (`id_created_user`),
  KEY `fk_user_updated_idx` (`id_updated_user`),
  CONSTRAINT `fk_created_user` FOREIGN KEY (`id_created_user`) REFERENCES `user` (`id`),
  CONSTRAINT `fk_updated_user` FOREIGN KEY (`id_updated_user`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coach`
--

LOCK TABLES `coach` WRITE;
/*!40000 ALTER TABLE `coach` DISABLE KEYS */;
/*!40000 ALTER TABLE `coach` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coachee`
--

DROP TABLE IF EXISTS `coachee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `coachee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `casual_name` varchar(50) NOT NULL,
  `date_birth` date NOT NULL,
  `image` varchar(50) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `id_gender` int NOT NULL,
  `id_created_user` int NOT NULL,
  `id_updated_user` int NOT NULL,
  `id_person` int NOT NULL,
  `search` json NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `Id_UNIQUE` (`id`),
  UNIQUE KEY `id_person_UNIQUE` (`id_person`),
  KEY `fk_gender_coachee_idx` (`id_gender`),
  KEY `fk_id_created_user_idx` (`id_created_user`),
  KEY `fk_id_updated_user_idx` (`id_updated_user`),
  CONSTRAINT `fk_gender_coachee` FOREIGN KEY (`id_gender`) REFERENCES `gender` (`id`) ON DELETE RESTRICT,
  CONSTRAINT `fk_id_created_user` FOREIGN KEY (`id_created_user`) REFERENCES `user` (`id`) ON DELETE RESTRICT,
  CONSTRAINT `fk_id_updated_user` FOREIGN KEY (`id_updated_user`) REFERENCES `user` (`id`) ON DELETE RESTRICT,
  CONSTRAINT `fk_person_coachee` FOREIGN KEY (`id_person`) REFERENCES `person` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 DELAY_KEY_WRITE=1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coachee`
--

LOCK TABLES `coachee` WRITE;
/*!40000 ALTER TABLE `coachee` DISABLE KEYS */;
INSERT INTO `coachee` VALUES (1,'SANDRA','1948-02-17','16067580601231.png','2020-11-30 17:41:00','2020-11-30 17:41:00',2,1,1,2013,'{\"name\": \"sandra giovanna peixoto\", \"email\": \"sandra@domain.com\", \"phone\": \"(51) 9952-8357\", \"document\": \"49971528975\"}'),(2,'ISABELA','1944-04-17','1606758132482.png','2020-11-30 17:42:13','2020-11-30 17:42:13',1,1,1,2014,'{\"name\": \"isabela vera sales\", \"email\": \"isabela@domain.com\", \"phone\": \"(92) 9834-9165\", \"document\": \"65021815547\"}'),(3,'ALEXANDRE','1942-06-14','16067584057211.png','2020-11-30 17:46:46','2020-11-30 17:46:46',2,1,1,2015,'{\"name\": \"alexandre gustavo da cunha\", \"email\": \"alexandre@domain.com\", \"phone\": \"(86) 9889-6707\", \"document\": \"79703098363\"}'),(4,'RAIMUNDO','1965-03-20','1606758516387.png','2020-11-30 17:48:36','2020-11-30 17:48:36',2,1,1,2016,'{\"name\": \"raimundo luís pereira\", \"email\": \"raimundo@domain.com\", \"phone\": \"(85) 9814-1656\", \"document\": \"31205619240\"}');
/*!40000 ALTER TABLE `coachee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contact`
--

DROP TABLE IF EXISTS `contact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contact` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(100) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `facebook` varchar(255) DEFAULT NULL,
  `instagram` varchar(255) DEFAULT NULL,
  `twitter` varchar(255) DEFAULT NULL,
  `id_person` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `id_person_UNIQUE` (`id_person`),
  CONSTRAINT `fk_person_contact` FOREIGN KEY (`id_person`) REFERENCES `person` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2012 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contact`
--

LOCK TABLES `contact` WRITE;
/*!40000 ALTER TABLE `contact` DISABLE KEYS */;
INSERT INTO `contact` VALUES (1,'FERNANDO.MATHEUSS@HOTMAIL.COM','21981964019',NULL,NULL,NULL,1),(2008,'SANDRA@DOMAIN.COM','5199528357','','','',2013),(2009,'ISABELA@DOMAIN.COM','9298349165','','','',2014),(2010,'ALEXANDRE@DOMAIN.COM','8698896707','','','',2015),(2011,'RAIMUNDO@DOMAIN.COM','8598141656','','','',2016);
/*!40000 ALTER TABLE `contact` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estage_content_week`
--

DROP TABLE IF EXISTS `estage_content_week`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estage_content_week` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_class` int NOT NULL,
  `id_session` int NOT NULL,
  `description` longtext NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_class_week_idx` (`id_class`),
  KEY `fk_session_week_idx` (`id_session`),
  CONSTRAINT `fk_class_week` FOREIGN KEY (`id_class`) REFERENCES `class` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_session_week` FOREIGN KEY (`id_session`) REFERENCES `session` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estage_content_week`
--

LOCK TABLES `estage_content_week` WRITE;
/*!40000 ALTER TABLE `estage_content_week` DISABLE KEYS */;
/*!40000 ALTER TABLE `estage_content_week` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estage_current_state`
--

DROP TABLE IF EXISTS `estage_current_state`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estage_current_state` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_class` int NOT NULL,
  `id_session` int NOT NULL,
  `description` longtext NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_class_state_idx` (`id_class`),
  KEY `fk_session_state_idx` (`id_session`),
  CONSTRAINT `fk_class_state` FOREIGN KEY (`id_class`) REFERENCES `class` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_session_state` FOREIGN KEY (`id_session`) REFERENCES `session` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estage_current_state`
--

LOCK TABLES `estage_current_state` WRITE;
/*!40000 ALTER TABLE `estage_current_state` DISABLE KEYS */;
/*!40000 ALTER TABLE `estage_current_state` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exercise`
--

DROP TABLE IF EXISTS `exercise`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exercise` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `file` varchar(20) NOT NULL,
  `media` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `file_UNIQUE` (`file`),
  UNIQUE KEY `media_UNIQUE` (`media`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exercise`
--

LOCK TABLES `exercise` WRITE;
/*!40000 ALTER TABLE `exercise` DISABLE KEYS */;
/*!40000 ALTER TABLE `exercise` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gender`
--

DROP TABLE IF EXISTS `gender`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gender` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `Id_UNIQUE` (`id`),
  UNIQUE KEY `Sex_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gender`
--

LOCK TABLES `gender` WRITE;
/*!40000 ALTER TABLE `gender` DISABLE KEYS */;
INSERT INTO `gender` VALUES (1,'FEMININO'),(2,'MASCULINO');
/*!40000 ALTER TABLE `gender` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permission`
--

DROP TABLE IF EXISTS `permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `permission` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `description` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `Id_UNIQUE` (`id`),
  UNIQUE KEY `Nome_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permission`
--

LOCK TABLES `permission` WRITE;
/*!40000 ALTER TABLE `permission` DISABLE KEYS */;
INSERT INTO `permission` VALUES (1,'ADMIN','ACESSO TOTAL AO SISTEMA'),(2,'COACHEE','ACESSO DE ALUNO');
/*!40000 ALTER TABLE `permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_person_type` int NOT NULL,
  `name_companyname` varchar(100) NOT NULL,
  `cpf_cnpj` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `Id_UNIQUE` (`id`),
  UNIQUE KEY `Cpf_Cnpj_UNIQUE` (`cpf_cnpj`),
  KEY `fk_tipo_pessoa_idx` (`id_person_type`),
  CONSTRAINT `fk_persontype` FOREIGN KEY (`id_person_type`) REFERENCES `person_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2017 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (1,1,'FERNANDO BRAGA MATHEUS','11569191708'),(2013,1,'SANDRA GIOVANNA PEIXOTO','49971528975'),(2014,1,'ISABELA VERA SALES','65021815547'),(2015,1,'ALEXANDRE GUSTAVO DA CUNHA','79703098363'),(2016,1,'RAIMUNDO LUÍS PEREIRA','31205619240');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person_type`
--

DROP TABLE IF EXISTS `person_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `Id_UNIQUE` (`id`),
  UNIQUE KEY `Nome_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person_type`
--

LOCK TABLES `person_type` WRITE;
/*!40000 ALTER TABLE `person_type` DISABLE KEYS */;
INSERT INTO `person_type` VALUES (1,'PESSOA FÍSICA'),(2,'PESSOA JURÍDICA');
/*!40000 ALTER TABLE `person_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `session`
--

DROP TABLE IF EXISTS `session`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `session` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `session`
--

LOCK TABLES `session` WRITE;
/*!40000 ALTER TABLE `session` DISABLE KEYS */;
INSERT INTO `session` VALUES (1,'SESSÃO 1'),(10,'SESSÃO 10'),(2,'SESSÃO 2'),(3,'SESSÃO 3'),(4,'SESSÃO 4'),(5,'SESSÃO 5'),(6,'SESSÃO 6'),(7,'SESSÃO 7'),(8,'SESSÃO 8'),(9,'SESSÃO 9');
/*!40000 ALTER TABLE `session` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stage_exercise_room`
--

DROP TABLE IF EXISTS `stage_exercise_room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stage_exercise_room` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `id_class` int NOT NULL,
  `id_session` int NOT NULL,
  `learning` longtext NOT NULL,
  `decision` longtext NOT NULL,
  `observation` longtext,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Id_UNIQUE` (`Id`),
  KEY `fk_class_room_idx` (`id_class`),
  KEY `fk_session_room_idx` (`id_session`),
  CONSTRAINT `fk_class_room` FOREIGN KEY (`id_class`) REFERENCES `class` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_session_room` FOREIGN KEY (`id_session`) REFERENCES `session` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stage_exercise_room`
--

LOCK TABLES `stage_exercise_room` WRITE;
/*!40000 ALTER TABLE `stage_exercise_room` DISABLE KEYS */;
/*!40000 ALTER TABLE `stage_exercise_room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `team`
--

DROP TABLE IF EXISTS `team`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `team` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `id_coach` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_coach_idx` (`id_coach`),
  CONSTRAINT `fk_coach_team` FOREIGN KEY (`id_coach`) REFERENCES `coach` (`id`) ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team`
--

LOCK TABLES `team` WRITE;
/*!40000 ALTER TABLE `team` DISABLE KEYS */;
/*!40000 ALTER TABLE `team` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `team_coachee_mapping`
--

DROP TABLE IF EXISTS `team_coachee_mapping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `team_coachee_mapping` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_coachee` int NOT NULL,
  `id_team` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_team_mapping_idx` (`id_team`),
  KEY `fk_coachee_mapping_idx` (`id_coachee`),
  CONSTRAINT `fk_coachee_mapping` FOREIGN KEY (`id_coachee`) REFERENCES `coachee` (`id`),
  CONSTRAINT `fk_team_mapping` FOREIGN KEY (`id_team`) REFERENCES `team` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team_coachee_mapping`
--

LOCK TABLES `team_coachee_mapping` WRITE;
/*!40000 ALTER TABLE `team_coachee_mapping` DISABLE KEYS */;
/*!40000 ALTER TABLE `team_coachee_mapping` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user` varchar(45) NOT NULL,
  `password` varchar(100) NOT NULL,
  `avatar` varchar(30) NOT NULL,
  `id_status` int NOT NULL,
  `id_person` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `Id_UNIQUE` (`id`),
  UNIQUE KEY `Usuario_UNIQUE` (`user`),
  UNIQUE KEY `Id_Pessoa_UNIQUE` (`id_person`),
  KEY `fk_status_usuario_idx` (`id_status`),
  CONSTRAINT `fk_person` FOREIGN KEY (`id_person`) REFERENCES `person` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_status` FOREIGN KEY (`id_status`) REFERENCES `user_status` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'FMATHEUS','$2a$10$CsVz6cKsdfWBtXu0Ulzp2.vfL0tVRXiEJ9ANOA1WXjYOxpYeqIu.C','5442147.png',1,1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_permission_mapping`
--

DROP TABLE IF EXISTS `user_permission_mapping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_permission_mapping` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_user` int NOT NULL,
  `id_permission` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `Id_UNIQUE` (`id`),
  UNIQUE KEY `Id_Usuario_UNIQUE` (`id_user`),
  KEY `fk_permissao_usuariopermissao_idx` (`id_permission`),
  CONSTRAINT `fk_permission` FOREIGN KEY (`id_permission`) REFERENCES `permission` (`id`),
  CONSTRAINT `fk_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_permission_mapping`
--

LOCK TABLES `user_permission_mapping` WRITE;
/*!40000 ALTER TABLE `user_permission_mapping` DISABLE KEYS */;
INSERT INTO `user_permission_mapping` VALUES (2,1,1);
/*!40000 ALTER TABLE `user_permission_mapping` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_status`
--

DROP TABLE IF EXISTS `user_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_status` (
  `id` int NOT NULL AUTO_INCREMENT,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `Id_UNIQUE` (`id`),
  UNIQUE KEY `Status_UNIQUE` (`status`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_status`
--

LOCK TABLES `user_status` WRITE;
/*!40000 ALTER TABLE `user_status` DISABLE KEYS */;
INSERT INTO `user_status` VALUES (1,'ATIVO'),(2,'INATIVO');
/*!40000 ALTER TABLE `user_status` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-30 20:45:20
