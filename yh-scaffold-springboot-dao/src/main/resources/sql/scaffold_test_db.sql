# ************************************************************
# Sequel Ace SQL dump
# Version 3041
#
# https://sequel-ace.com/
# https://github.com/Sequel-Ace/Sequel-Ace
#
# Host: localhost (MySQL 8.0.22)
# Database: test_db
# Generation Time: 2021-11-01 10:19:54 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
SET NAMES utf8mb4;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE='NO_AUTO_VALUE_ON_ZERO', SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table test_1
# ------------------------------------------------------------

DROP TABLE IF EXISTS `test_1`;

CREATE TABLE `test_1` (
                          `id` int unsigned NOT NULL AUTO_INCREMENT,
                          `version` bigint DEFAULT NULL COMMENT '锁标识',
                          `code` varchar(200) DEFAULT NULL,
                          `name` varchar(200) DEFAULT NULL,
                          `description` varchar(200) DEFAULT NULL,
                          `created_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
                          `is_delete` bit(1) DEFAULT b'0' COMMENT '是否有效(0:未删除的有效记录,1:逻辑删除的无效记录)',
                          `created_at` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                          `updated_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改人',
                          `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `test_1` WRITE;
/*!40000 ALTER TABLE `test_1` DISABLE KEYS */;

INSERT INTO `test_1` (`id`, `version`, `code`, `name`, `description`, `created_by`, `is_delete`, `created_at`, `updated_by`, `updated_at`)
VALUES
(1,NULL,'T001','test001','desc001',NULL,b'0','2021-08-10 15:54:56',NULL,'2021-08-10 15:54:56');

/*!40000 ALTER TABLE `test_1` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
