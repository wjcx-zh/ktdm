/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50556
Source Host           : localhost:3306
Source Database       : ktdm

Target Server Type    : MYSQL
Target Server Version : 50556
File Encoding         : 65001

Date: 2018-04-23 09:09:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for signup
-- ----------------------------
DROP TABLE IF EXISTS `signup`;
CREATE TABLE `signup` (
  `id` int(11) NOT NULL,
  `sname` varchar(20) DEFAULT NULL,
  `tname` varchar(20) DEFAULT NULL,
  `cname` varchar(30) DEFAULT NULL,
  `snum` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of signup
-- ----------------------------
