/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50556
Source Host           : localhost:3306
Source Database       : ktdm

Target Server Type    : MYSQL
Target Server Version : 50556
File Encoding         : 65001

Date: 2018-04-23 09:11:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `tid` int(11) NOT NULL AUTO_INCREMENT,
  `tname` varchar(20) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `sex` char(4) DEFAULT NULL,
  `password` varchar(20) NOT NULL,
  `c_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`tid`),
  KEY `course_id` (`c_id`),
  CONSTRAINT `course_id` FOREIGN KEY (`c_id`) REFERENCES `course` (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', '张文', '36', '男', '123456', '1');
