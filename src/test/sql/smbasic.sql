/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50549
Source Host           : localhost:3306
Source Database       : smbasic

Target Server Type    : MYSQL
Target Server Version : 50549
File Encoding         : 65001

Date: 2018-02-10 16:08:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tb_area`
-- ----------------------------
DROP TABLE IF EXISTS `tb_area`;
CREATE TABLE `tb_area` (
  `area_id` int(2) NOT NULL AUTO_INCREMENT,
  `area_name` varchar(200) NOT NULL,
  `priority` int(2) NOT NULL DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
  `last_edit_time` datetime DEFAULT NULL,
  PRIMARY KEY (`area_id`),
  UNIQUE KEY `UK_AREA` (`area_name`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_area
-- ----------------------------
INSERT INTO `tb_area` VALUES ('1', 'AAA', '2', null, null);
INSERT INTO `tb_area` VALUES ('2', 'BBB', '1', null, null);
INSERT INTO `tb_area` VALUES ('3', 'CCC', '0', '2018-02-10 14:14:58', '2018-02-10 14:17:55');
INSERT INTO `tb_area` VALUES ('7', 'DDD', '0', '2018-02-10 14:54:57', null);
