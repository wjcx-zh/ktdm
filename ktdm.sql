/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50556
Source Host           : localhost:3306
Source Database       : ktdm

Target Server Type    : MYSQL
Target Server Version : 50556
File Encoding         : 65001

Date: 2018-05-04 09:31:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `cname` varchar(30) NOT NULL,
  `t_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`cid`),
  KEY `FK6b8suop46iw905jf09bd826tq` (`t_id`),
  CONSTRAINT `FK6b8suop46iw905jf09bd826tq` FOREIGN KEY (`t_id`) REFERENCES `teacher` (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', 'JAVA', '1');
INSERT INTO `course` VALUES ('2', 'Web', '1');

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `mid` int(11) NOT NULL AUTO_INCREMENT,
  `mname` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`mid`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES ('1', 'wjcx', '男', '20', '628352');

-- ----------------------------
-- Table structure for sc_mid
-- ----------------------------
DROP TABLE IF EXISTS `sc_mid`;
CREATE TABLE `sc_mid` (
  `c_id` int(11) NOT NULL,
  `s_id` int(11) NOT NULL,
  PRIMARY KEY (`s_id`,`c_id`),
  KEY `FK2el8525p5ywxhcxn7s9p14myk` (`c_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sc_mid
-- ----------------------------
INSERT INTO `sc_mid` VALUES ('1', '1');

-- ----------------------------
-- Table structure for signup
-- ----------------------------
DROP TABLE IF EXISTS `signup`;
CREATE TABLE `signup` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sname` varchar(20) DEFAULT NULL,
  `tname` varchar(20) DEFAULT NULL,
  `cname` varchar(30) DEFAULT NULL,
  `snum` int(11) DEFAULT NULL,
  `signtime` datetime DEFAULT NULL,
  `tp_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `tp_id` (`tp_id`),
  CONSTRAINT `signup_ibfk_1` FOREIGN KEY (`tp_id`) REFERENCES `type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of signup
-- ----------------------------
INSERT INTO `signup` VALUES ('4', '小白虫', '张文', 'JAVA', '18120101', '2018-05-03 14:38:38', '1');
INSERT INTO `signup` VALUES ('5', '冯宝宝', '张文', 'JAVA', '18120102', '2018-05-03 14:40:08', '2');
INSERT INTO `signup` VALUES ('6', '不摇碧莲', '张文', 'JAVA', '18120103', '2018-05-03 14:41:14', '2');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `sname` varchar(20) DEFAULT NULL,
  `snum` int(8) DEFAULT NULL,
  `sex` char(4) DEFAULT NULL,
  PRIMARY KEY (`sid`),
  KEY `snum` (`snum`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '小白虫', '18120101', '男');

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
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', '张文', '36', '男', '123456');

-- ----------------------------
-- Table structure for type
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type` (
  `id` int(11) NOT NULL,
  `type` char(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of type
-- ----------------------------
INSERT INTO `type` VALUES ('1', '学生');
INSERT INTO `type` VALUES ('2', '旁听');
