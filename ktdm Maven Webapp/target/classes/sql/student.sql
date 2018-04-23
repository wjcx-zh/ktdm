/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50556
Source Host           : localhost:3306
Source Database       : ktdm

Target Server Type    : MYSQL
Target Server Version : 50556
File Encoding         : 65001

Date: 2018-04-23 09:10:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `sname` varchar(20) DEFAULT NULL,
  `snum` int(8) DEFAULT NULL,
  `sex` char(4) DEFAULT NULL,
  `c_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`sid`),
  KEY `课程编号` (`c_id`),
  CONSTRAINT `课程编号` FOREIGN KEY (`c_id`) REFERENCES `course` (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '小白虫', '18120101', '男', '1');
