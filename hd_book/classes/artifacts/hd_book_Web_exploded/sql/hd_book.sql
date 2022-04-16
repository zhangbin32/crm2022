/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50536
Source Host           : localhost:3306
Source Database       : hd_book

Target Server Type    : MYSQL
Target Server Version : 50536
File Encoding         : 65001

Date: 2019-07-02 13:49:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `bookid` int(11) NOT NULL AUTO_INCREMENT,
  `bookname` varchar(20) NOT NULL,
  `publish` varchar(20) DEFAULT NULL,
  `author` varchar(20) DEFAULT NULL,
  `bookcount` int(11) NOT NULL,
  `booktype` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`bookid`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', 'JAVA教程', '外国出版社', '刘畅', '0', '计算机');
INSERT INTO `book` VALUES ('2', 'C#教程', '人民出版社', '约翰逊', '10', '计算机');
INSERT INTO `book` VALUES ('3', 'C++教程', '新华出版社', '罗比特', '10', '计算机');
INSERT INTO `book` VALUES ('4', 'PHYTHON教程', '陕西出版社', '赛斯', '10', '计算机');
INSERT INTO `book` VALUES ('5', 'JS教程', '渭南出版社', '王能行', '10', '计算机');
INSERT INTO `book` VALUES ('6', '小号入门教程', '渭南出版社', '王二能', '10', '乐器');
INSERT INTO `book` VALUES ('7', '唢呐艺术', '渭南出版社', '欧阳', '10', '乐器');
INSERT INTO `book` VALUES ('8', '长号入门教程', '渭南出版社', '王二能', '10', '乐器');
INSERT INTO `book` VALUES ('9', 'javaweb基础', '尚硅谷', '孙红康', '10', '计算机');
INSERT INTO `book` VALUES ('10', 'Hadoop从入门到精通', '尚硅谷', '孙红康', '11', '计算机');
INSERT INTO `book` VALUES ('12', '爱情心理学', '宝鸡大学出版社', '蓓邰', '12', '社科类');
INSERT INTO `book` VALUES ('13', 'Hadoop从入门到精通', '尚硅谷', '宋红康', '21', '计算机');
INSERT INTO `book` VALUES ('14', 'JAVA教程', '码歌教育出版社', '张三', '100', '计算机编程');

-- ----------------------------
-- Table structure for `operatebook`
-- ----------------------------
DROP TABLE IF EXISTS `operatebook`;
CREATE TABLE `operatebook` (
  `operatid` int(11) NOT NULL AUTO_INCREMENT,
  `bookid` int(11) NOT NULL,
  `bookname` varchar(20) NOT NULL,
  `userid` int(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  `borrowtime` date NOT NULL,
  `renttime` int(11) NOT NULL,
  `isreturn` tinyint(1) NOT NULL,
  PRIMARY KEY (`operatid`),
  KEY `operatebook_ibfk_2` (`bookid`),
  KEY `operatebook_ibfk_1` (`userid`),
  CONSTRAINT `operatebook_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `users` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `operatebook_ibfk_2` FOREIGN KEY (`bookid`) REFERENCES `book` (`bookid`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of operatebook
-- ----------------------------
INSERT INTO `operatebook` VALUES ('32', '3', 'C++教程', '2', 'ghy', '2018-12-08', '30', '0');
INSERT INTO `operatebook` VALUES ('33', '4', 'PHYTHON教程', '4', 'admin', '2018-12-08', '30', '0');
INSERT INTO `operatebook` VALUES ('34', '4', 'PHYTHON教程', '4', 'admin', '2018-12-08', '30', '0');
INSERT INTO `operatebook` VALUES ('35', '4', 'PHYTHON教程', '4', 'admin', '2018-12-08', '30', '0');
INSERT INTO `operatebook` VALUES ('36', '4', 'PHYTHON教程', '4', 'admin', '2018-12-08', '30', '0');
INSERT INTO `operatebook` VALUES ('37', '4', 'PHYTHON教程', '4', 'admin', '2018-12-08', '30', '0');
INSERT INTO `operatebook` VALUES ('38', '5', 'JS教程', '4', 'admin', '2018-12-08', '30', '1');
INSERT INTO `operatebook` VALUES ('39', '5', 'JS教程', '4', 'admin', '2018-12-08', '30', '1');
INSERT INTO `operatebook` VALUES ('40', '5', 'JS教程', '4', 'admin', '2018-12-08', '30', '1');
INSERT INTO `operatebook` VALUES ('41', '5', 'JS教程', '4', 'admin', '2018-12-08', '30', '1');
INSERT INTO `operatebook` VALUES ('42', '5', 'JS教程', '4', 'admin', '2018-12-08', '30', '1');
INSERT INTO `operatebook` VALUES ('43', '5', 'JS教程', '4', 'admin', '2018-12-08', '30', '1');
INSERT INTO `operatebook` VALUES ('44', '5', 'JS教程', '4', 'admin', '2018-12-08', '30', '1');
INSERT INTO `operatebook` VALUES ('45', '5', 'JS教程', '4', 'admin', '2018-12-08', '30', '1');
INSERT INTO `operatebook` VALUES ('46', '5', 'JS教程', '4', 'admin', '2018-12-08', '30', '1');
INSERT INTO `operatebook` VALUES ('47', '5', 'JS教程', '4', 'admin', '2018-12-08', '30', '1');
INSERT INTO `operatebook` VALUES ('48', '5', 'JS教程', '4', 'admin', '2018-12-08', '30', '1');
INSERT INTO `operatebook` VALUES ('49', '5', 'JS教程', '4', 'admin', '2018-12-08', '30', '1');
INSERT INTO `operatebook` VALUES ('50', '5', 'JS教程', '4', 'admin', '2018-12-08', '30', '1');
INSERT INTO `operatebook` VALUES ('52', '10', 'Hadoop从入门到精通', '3', 'fg', '2018-12-09', '30', '0');
INSERT INTO `operatebook` VALUES ('53', '1', 'JAVA教程', '4', 'admin', '2018-12-13', '30', '0');
INSERT INTO `operatebook` VALUES ('54', '1', 'JAVA教程', '3', 'fg', '2019-07-01', '30', '0');
INSERT INTO `operatebook` VALUES ('55', '1', 'JAVA教程', '3', 'fg', '2019-07-01', '30', '0');
INSERT INTO `operatebook` VALUES ('56', '2', 'C#教程', '3', 'fg', '2019-07-01', '30', '0');
INSERT INTO `operatebook` VALUES ('57', '5', 'JS教程', '3', 'fg', '2019-07-01', '30', '0');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` int(11) DEFAULT NULL,
  `roleName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '-1', '超级管理员');
INSERT INTO `role` VALUES ('2', '0', '图书管理员');
INSERT INTO `role` VALUES ('3', '1', '读者');

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(10) NOT NULL,
  `passwords` varchar(10) NOT NULL,
  `birthday` datetime DEFAULT NULL,
  `sex` varchar(4) DEFAULT NULL,
  `usertype` int(11) NOT NULL,
  `isfull` varchar(2) DEFAULT NULL,
  `money` double DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('2', 'lib_admin', '1234', '2018-12-11 00:00:00', '女', '0', '0', '0');
INSERT INTO `users` VALUES ('3', 'reader', '1234      ', '1998-05-16 00:00:00', '男', '1', '0', '0');
INSERT INTO `users` VALUES ('4', 'admin', '1234', '2018-12-02 00:00:00', '男', '-1', '0', '0');
INSERT INTO `users` VALUES ('11', 'zs', '1234', '2019-02-05 00:00:00', '女', '-1', '0', '0');
INSERT INTO `users` VALUES ('12', 'ls', '1234', '2019-01-28 00:00:00', '男', '0', '0', '0');
INSERT INTO `users` VALUES ('13', 'ww', '1234', '2019-01-29 00:00:00', '男', '1', '0', '0');
INSERT INTO `users` VALUES ('14', 'zl', '1234', '2019-02-05 00:00:00', '女', '0', '0', '0');
INSERT INTO `users` VALUES ('15', 'liuhang', '1234', '1989-08-02 00:00:00', '男', '1', '0', '0');
