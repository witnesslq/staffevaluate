/*
Navicat MySQL Data Transfer

Source Server         : Mysql60
Source Server Version : 50537
Source Host           : localhost:3306
Source Database       : staffevaluatedb

Target Server Type    : MYSQL
Target Server Version : 50537
File Encoding         : 65001

Date: 2016-12-22 22:14:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for businesshall
-- ----------------------------
DROP TABLE IF EXISTS `businesshall`;
CREATE TABLE `businesshall` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `unit_id` int(11) DEFAULT NULL,
  `no` varchar(11) DEFAULT NULL,
  `level` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `unit_id` (`unit_id`),
  CONSTRAINT `unit_id` FOREIGN KEY (`unit_id`) REFERENCES `unit` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for czzn
-- ----------------------------
DROP TABLE IF EXISTS `czzn`;
CREATE TABLE `czzn` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for evaluate
-- ----------------------------
DROP TABLE IF EXISTS `evaluate`;
CREATE TABLE `evaluate` (
  `evaluate_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`evaluate_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for post
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post` (
  `post_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`post_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for staff
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `staff_no` varchar(20) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(6) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `sex` char(1) DEFAULT NULL,
  `photo` varchar(100) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `post_id` int(11) DEFAULT NULL,
  `businesshall_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `role_id` (`role_id`),
  KEY `post_id` (`post_id`),
  KEY `FK4B8CAC03B509ACB` (`businesshall_id`),
  CONSTRAINT `FK4B8CAC03B509ACB` FOREIGN KEY (`businesshall_id`) REFERENCES `businesshall` (`id`),
  CONSTRAINT `post_id` FOREIGN KEY (`post_id`) REFERENCES `post` (`post_id`),
  CONSTRAINT `role_id` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for subindex
-- ----------------------------
DROP TABLE IF EXISTS `subindex`;
CREATE TABLE `subindex` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `evaluate_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `evaluate_id` (`evaluate_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for unit
-- ----------------------------
DROP TABLE IF EXISTS `unit`;
CREATE TABLE `unit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user_evaluate
-- ----------------------------
DROP TABLE IF EXISTS `user_evaluate`;
CREATE TABLE `user_evaluate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `evaluate_id` int(11) DEFAULT NULL,
  `staff_id` int(11) DEFAULT NULL,
  `evaluateUserPhone` varchar(11) DEFAULT NULL COMMENT '??\n\n????Ա?ĵ绰',
  `date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `isReturn` char(1) DEFAULT '0',
  `isValid` char(1) DEFAULT '0' COMMENT '????Ĭ??Ϊ0??????????',
  `subindex_ids` varchar(20) DEFAULT NULL,
  `satisfaction` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `evaluate_id` (`evaluate_id`),
  KEY `staff_id` (`staff_id`),
  CONSTRAINT `evaluate_id` FOREIGN KEY (`evaluate_id`) REFERENCES `evaluate` (`evaluate_id`),
  CONSTRAINT `staff_id` FOREIGN KEY (`staff_id`) REFERENCES `staff` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for xtjs
-- ----------------------------
DROP TABLE IF EXISTS `xtjs`;
CREATE TABLE `xtjs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `xtjstxt` text,
  `fsize` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for zcfg
-- ----------------------------
DROP TABLE IF EXISTS `zcfg`;
CREATE TABLE `zcfg` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `zcfgtxt` varchar(500) DEFAULT NULL,
  `fsize` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
