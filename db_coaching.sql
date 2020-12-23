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
  `name` varchar(45) CHARACTER SET utf8 NOT NULL,
  `id_coach` int NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_coach_idx` (`id_coach`),
  CONSTRAINT `fk_coach` FOREIGN KEY (`id_coach`) REFERENCES `coach` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
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
  CONSTRAINT `fk_class_session` FOREIGN KEY (`id_class`) REFERENCES `class` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_session` FOREIGN KEY (`id_session`) REFERENCES `session` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
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
  `id_created_user` int NOT NULL,
  `id_updated_user` int NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `id_person_UNIQUE` (`id_person`),
  KEY `fk_created_user_idx` (`id_created_user`),
  KEY `fk_user_updated_idx` (`id_updated_user`),
  CONSTRAINT `fk_created_user` FOREIGN KEY (`id_created_user`) REFERENCES `user` (`id`),
  CONSTRAINT `fk_person_coach` FOREIGN KEY (`id_person`) REFERENCES `person` (`id`),
  CONSTRAINT `fk_updated_user` FOREIGN KEY (`id_updated_user`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
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
  `id_person` int NOT NULL,
  `id_gender` int NOT NULL,
  `casual_name` varchar(50) CHARACTER SET utf8 NOT NULL,
  `date_birth` date NOT NULL,
  `image` varchar(50) CHARACTER SET utf8 NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `id_created_user` int NOT NULL,
  `id_updated_user` int NOT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci DELAY_KEY_WRITE=1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coachee`
--

LOCK TABLES `coachee` WRITE;
/*!40000 ALTER TABLE `coachee` DISABLE KEYS */;
INSERT INTO `coachee` VALUES (1,2013,2,'SANDRA','1948-02-17','16067580601231.png','2020-11-30 17:41:00','2020-11-30 17:41:00',1,1,'{\"name\": \"sandra giovanna peixoto\", \"email\": \"sandra@domain.com\", \"phone\": \"(51) 9952-8357\", \"document\": \"49971528975\"}'),(2,2014,1,'ISABELA','1944-04-17','1606758132482.png','2020-12-05 22:14:32','2020-12-05 22:14:32',1,1,'{\"name\": \"isabela vera sales\", \"email\": \"isabela@domain.com\", \"phone\": \"(92) 9834-9165\", \"document\": \"65021815547\"}'),(3,2015,2,'ALEXANDRE','1942-06-14','16067584057211.png','2020-12-05 01:15:28','2020-12-05 01:15:28',1,1,'{\"name\": \"alexandre gustavo da cunha peres\", \"email\": \"alexandre@domain.com\", \"phone\": \"(86) 9889-6707\", \"document\": \"79703098363\"}'),(4,2016,2,'RAIMUNDO','1965-03-20','1606758516387.png','2020-11-30 17:48:36','2020-11-30 17:48:36',1,1,'{\"name\": \"raimundo luís pereira\", \"email\": \"raimundo@domain.com\", \"phone\": \"(85) 9814-1656\", \"document\": \"31205619240\"}'),(5,2017,1,'ELOÁ','1959-10-16','1607129719345.png','2020-12-05 00:55:20','2020-12-05 00:55:20',1,1,'{\"name\": \"eloá teresinha baptista\", \"email\": \"eloa@domain.com\", \"phone\": \"(87) 9948-7029\", \"document\": \"72539791840\"}'),(6,2018,2,'TOMAS','1979-02-23','1607129982134.png','2020-12-05 00:59:42','2020-12-05 00:59:42',1,1,'{\"name\": \"tomás lucca ricardo costa\", \"email\": \"tomas@domain.com\", \"phone\": \"(11) 2809-0068\", \"document\": \"58630124121\"}');
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
  `id_person` int NOT NULL,
  `email` varchar(100) CHARACTER SET utf8 NOT NULL,
  `phone` varchar(20) CHARACTER SET utf8 NOT NULL,
  `facebook` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `instagram` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `twitter` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `id_person_UNIQUE` (`id_person`),
  CONSTRAINT `fk_person_contact` FOREIGN KEY (`id_person`) REFERENCES `person` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2015 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contact`
--

LOCK TABLES `contact` WRITE;
/*!40000 ALTER TABLE `contact` DISABLE KEYS */;
INSERT INTO `contact` VALUES (1,1,'FERNANDO.MATHEUSS@HOTMAIL.COM','21981964019',NULL,NULL,NULL),(2008,2013,'SANDRA@DOMAIN.COM','5199528357','','',''),(2009,2014,'ISABELA@DOMAIN.COM','9298349165','','',''),(2010,2015,'ALEXANDRE@DOMAIN.COM','8698896707','','',''),(2011,2016,'RAIMUNDO@DOMAIN.COM','8598141656','','',''),(2012,2017,'ELOA@DOMAIN.COM','8799487029','','',''),(2013,2018,'TOMAS@DOMAIN.COM','1128090068','','','');
/*!40000 ALTER TABLE `contact` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cycle`
--

DROP TABLE IF EXISTS `cycle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cycle` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cycle`
--

LOCK TABLES `cycle` WRITE;
/*!40000 ALTER TABLE `cycle` DISABLE KEYS */;
INSERT INTO `cycle` VALUES (1,'Ciclo 1'),(10,'Ciclo 10'),(2,'Ciclo 2'),(3,'Ciclo 3'),(4,'Ciclo 4'),(5,'Ciclo 5'),(6,'Ciclo 6'),(7,'Ciclo 7'),(8,'Ciclo 8'),(9,'Ciclo 9');
/*!40000 ALTER TABLE `cycle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cycle_generate`
--

DROP TABLE IF EXISTS `cycle_generate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cycle_generate` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_cycle` int NOT NULL,
  `id_coachee` int NOT NULL,
  `cycle_coache` int NOT NULL COMMENT 'Juncao dos campos id_cycle e id_coache',
  `id_created_user` int NOT NULL,
  `id_updated_user` int NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `done` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `idcycle_idcoache_UNIQUE` (`cycle_coache`),
  KEY `fk_cycle_generate_idx` (`id_cycle`),
  KEY `fk_coachee_generate_idx` (`id_coachee`),
  KEY `fk_user1_cycle_idx` (`id_created_user`),
  KEY `fk_user2_cycle_idx` (`id_updated_user`),
  CONSTRAINT `fk_coachee_generate` FOREIGN KEY (`id_coachee`) REFERENCES `coachee` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_cycle_generate` FOREIGN KEY (`id_cycle`) REFERENCES `cycle` (`id`) ON DELETE RESTRICT,
  CONSTRAINT `fk_user1_cycle` FOREIGN KEY (`id_created_user`) REFERENCES `user` (`id`) ON DELETE RESTRICT,
  CONSTRAINT `fk_user2_cycle` FOREIGN KEY (`id_updated_user`) REFERENCES `user` (`id`) ON DELETE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cycle_generate`
--

LOCK TABLES `cycle_generate` WRITE;
/*!40000 ALTER TABLE `cycle_generate` DISABLE KEYS */;
INSERT INTO `cycle_generate` VALUES (31,1,2,12,1,1,'2020-12-21 13:19:49','2020-12-21 13:19:49',0);
/*!40000 ALTER TABLE `cycle_generate` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=2020 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (1,1,'FERNANDO BRAGA MATHEUS','11569191708'),(2013,1,'SANDRA GIOVANNA PEIXOTO','49971528975'),(2014,1,'ISABELA VERA SALES','65021815547'),(2015,1,'ALEXANDRE GUSTAVO DA CUNHA PERES','79703098363'),(2016,1,'RAIMUNDO LUÍS PEREIRA','31205619240'),(2017,1,'ELOÁ TERESINHA BAPTISTA','72539791840'),(2018,1,'TOMÁS LUCCA RICARDO COSTA','58630124121');
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
-- Table structure for table `session_generate`
--

DROP TABLE IF EXISTS `session_generate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `session_generate` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_cycle_generate` int NOT NULL,
  `id_session_step_mapping` int NOT NULL,
  `id_session` int NOT NULL,
  `id_created_user` int NOT NULL,
  `id_updated_user` int NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `done` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_session_stap_mapping_idx` (`id_session_step_mapping`),
  KEY `fk_created_cycle_idx` (`id_created_user`),
  KEY `fk_updated_cycle_idx` (`id_updated_user`),
  KEY `fk_cycle_generate_idx` (`id_cycle_generate`),
  KEY `fk_session_generate_idx` (`id_session`),
  CONSTRAINT `fk_created_cycle` FOREIGN KEY (`id_created_user`) REFERENCES `user` (`id`) ON DELETE RESTRICT,
  CONSTRAINT `fk_cycle_generate_session` FOREIGN KEY (`id_cycle_generate`) REFERENCES `cycle_generate` (`id`),
  CONSTRAINT `fk_session_generate` FOREIGN KEY (`id_session`) REFERENCES `session` (`id`) ON DELETE RESTRICT,
  CONSTRAINT `fk_session_step_mapping` FOREIGN KEY (`id_session_step_mapping`) REFERENCES `session_step_mapping` (`id`) ON DELETE RESTRICT,
  CONSTRAINT `fk_updated_cycle` FOREIGN KEY (`id_updated_user`) REFERENCES `user` (`id`) ON DELETE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `session_generate`
--

LOCK TABLES `session_generate` WRITE;
/*!40000 ALTER TABLE `session_generate` DISABLE KEYS */;
INSERT INTO `session_generate` VALUES (1,31,1,1,1,1,'2020-12-21 13:19:49','2020-12-21 13:19:49',0),(2,31,2,1,1,1,'2020-12-21 13:19:49','2020-12-21 13:19:49',0),(3,31,3,1,1,1,'2020-12-21 13:19:49','2020-12-21 13:19:49',0),(4,31,4,1,1,1,'2020-12-21 13:19:49','2020-12-21 13:19:49',0),(5,31,5,1,1,1,'2020-12-21 13:19:49','2020-12-21 13:19:49',0),(6,31,6,1,1,1,'2020-12-21 13:19:49','2020-12-21 13:19:49',0),(7,31,7,1,1,1,'2020-12-21 13:19:49','2020-12-21 13:19:49',0),(8,31,8,1,1,1,'2020-12-21 13:19:49','2020-12-21 13:19:49',0);
/*!40000 ALTER TABLE `session_generate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `session_step_mapping`
--

DROP TABLE IF EXISTS `session_step_mapping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `session_step_mapping` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_session` int NOT NULL,
  `id_step` int NOT NULL,
  `order` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_session_mapping_idx` (`id_session`),
  KEY `fk_step_mapping_idx` (`id_step`),
  CONSTRAINT `fk_session_mapping` FOREIGN KEY (`id_session`) REFERENCES `session` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_step_mapping` FOREIGN KEY (`id_step`) REFERENCES `step` (`id`) ON DELETE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=108 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `session_step_mapping`
--

LOCK TABLES `session_step_mapping` WRITE;
/*!40000 ALTER TABLE `session_step_mapping` DISABLE KEYS */;
INSERT INTO `session_step_mapping` VALUES (1,1,1,1),(2,1,2,2),(3,1,3,3),(4,1,4,4),(5,1,5,5),(6,1,6,6),(7,1,7,7),(8,1,8,8),(9,2,9,1),(10,2,10,2),(11,2,11,3),(12,2,12,4),(13,2,3,5),(14,2,4,6),(15,2,5,7),(16,2,6,8),(17,2,7,9),(18,2,8,10),(19,2,2,11),(20,3,9,1),(21,3,10,2),(22,3,11,3),(23,3,12,4),(24,3,2,5),(25,3,4,6),(26,3,5,7),(27,3,6,8),(28,3,7,9),(29,3,8,10),(30,3,3,11),(31,4,9,1),(32,4,10,2),(33,4,11,3),(34,4,12,4),(35,4,3,5),(36,4,4,6),(37,4,5,7),(38,4,6,8),(39,4,7,9),(40,4,8,10),(41,4,2,11),(42,5,9,1),(43,5,10,2),(44,5,11,3),(45,5,12,4),(46,5,2,5),(47,5,4,6),(48,5,5,7),(49,5,6,8),(50,5,7,9),(51,5,8,10),(52,5,3,11),(53,6,9,1),(54,6,10,2),(55,6,11,3),(56,6,12,4),(57,6,3,5),(58,6,4,6),(59,6,5,7),(60,6,6,8),(61,6,7,9),(62,6,8,10),(63,6,2,11),(64,7,9,1),(65,7,10,2),(66,7,11,3),(67,7,12,4),(68,7,2,5),(69,7,4,6),(70,7,5,7),(71,7,6,8),(72,7,7,9),(73,7,8,10),(74,7,3,11),(75,8,9,1),(76,8,10,2),(77,8,11,3),(78,8,12,4),(79,8,3,5),(80,8,4,6),(81,8,5,7),(82,8,6,8),(83,8,7,9),(84,8,8,10),(85,8,2,11),(86,9,9,1),(87,9,10,2),(88,9,11,3),(89,9,12,4),(90,9,2,5),(91,9,4,6),(92,9,5,7),(93,9,6,8),(94,9,7,9),(95,9,8,10),(96,9,3,11),(97,10,9,1),(98,10,10,2),(99,10,11,3),(100,10,12,4),(101,10,3,5),(102,10,4,6),(103,10,5,7),(104,10,6,8),(105,10,7,9),(106,10,8,10),(107,10,2,11);
/*!40000 ALTER TABLE `session_step_mapping` ENABLE KEYS */;
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
-- Table structure for table `step`
--

DROP TABLE IF EXISTS `step`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `step` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `step`
--

LOCK TABLES `step` WRITE;
/*!40000 ALTER TABLE `step` DISABLE KEYS */;
INSERT INTO `step` VALUES (7,'Anotações para o Coahee'),(12,'Checar Pontuais'),(11,'Checar Rotineiros'),(1,'Estado Atual'),(6,'Exercício de Casa - Pontuais'),(5,'Exercício de Casa - Rotineiros'),(4,'Exercício de Sala'),(10,'Ganhos'),(8,'Histórico Fotográfico'),(2,'MAAS'),(9,'Mindfulness'),(3,'Objetivos e Metas');
/*!40000 ALTER TABLE `step` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `team`
--

DROP TABLE IF EXISTS `team`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `team` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_coach` int NOT NULL,
  `name` varchar(45) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
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
  `id_person` int NOT NULL,
  `id_status` int NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(100) NOT NULL,
  `avatar` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `Id_UNIQUE` (`id`),
  UNIQUE KEY `Usuario_UNIQUE` (`username`),
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
INSERT INTO `user` VALUES (1,1,1,'FMATHEUS','$2a$10$CsVz6cKsdfWBtXu0Ulzp2.vfL0tVRXiEJ9ANOA1WXjYOxpYeqIu.C','5442147.png');
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

-- Dump completed on 2020-12-23  3:57:46
