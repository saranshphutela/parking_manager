/*
Navicat MySQL Data Transfer

Source Server         : bce
Source Server Version : 50136
Source Host           : localhost:3306
Source Database       : carparking

Target Server Type    : MYSQL
Target Server Version : 50136
File Encoding         : 65001

Date: 2018-08-18 19:14:29
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `customerconsole`
-- ----------------------------
DROP TABLE IF EXISTS `customerconsole`;
CREATE TABLE `customerconsole` (
  `mob` varchar(20) NOT NULL DEFAULT '',
  `name` varchar(20) DEFAULT NULL,
  `address` varchar(20) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `veh` varchar(20) DEFAULT NULL,
  `eid` varchar(50) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`mob`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of customerconsole
-- ----------------------------
INSERT INTO `customerconsole` VALUES ('1234567', 'Harsh', 'Bathinda', 'Bathinda', '1010', 'sdfdg', 'Two Wheeler');
INSERT INTO `customerconsole` VALUES ('23439894', 'Rajdeep', 'Bathinda', 'Bathinda', '1111', 'sdfdg', 'Two Wheeler');
INSERT INTO `customerconsole` VALUES ('23454533', 'Mohandass', 'Bathinda', 'Bathinda', '8080', 'sdfdg', 'Two Wheeler');
INSERT INTO `customerconsole` VALUES ('398439234', 'Mohan', 'Bathinda', 'Bathinda', '7070', 'sdfdg', 'Two Wheeler');
INSERT INTO `customerconsole` VALUES ('47387483', 'Lalit', 'Bathinda', 'Bathinda', '6060', 'sdfdg', 'Two Wheeler');
INSERT INTO `customerconsole` VALUES ('67348323', 'Raka', 'Bathinda', 'Bathinda', '5050', 'sdfdg', 'Two Wheeler');
INSERT INTO `customerconsole` VALUES ('73438748', 'Raman', 'Bathinda', 'Bathinda', '3030', 'sdfdg', 'Two Wheeler');
INSERT INTO `customerconsole` VALUES ('7343874890', 'Ramandeep', 'Bathinda', 'Bathinda', '4040', 'sdfdg444', 'Two Wheeler');
INSERT INTO `customerconsole` VALUES ('769623423', 'Harshit', 'Home', 'Kot Kapura', 'PB 05J 7696', 'hgarg@gmail.com', 'Two Wheeler');
INSERT INTO `customerconsole` VALUES ('7829349827', 'Rajdeep', 'Bathinda', 'Bathinda', '9090', 'sdfdg', 'Two Wheeler');
INSERT INTO `customerconsole` VALUES ('8264301657', 'saransh', 'patel nagar	', 'abohar', '0869', 'saransh@gmail.com', 'Two Wheeler');
INSERT INTO `customerconsole` VALUES ('8699238392', 'Anubhav Garg', 'Prem Nagar', 'Kot Kapura', 'PB 04 J 5958', 'avigarg100@gmail.com', 'Four Wheeler');
INSERT INTO `customerconsole` VALUES ('9023709291', 'Saransh', 'Home', 'Abohar', 'PB 04 J 1130', 'saransh@fb.com', 'Two Wheeler');
INSERT INTO `customerconsole` VALUES ('9814085557', 'Chaman', 'Kot Kapura', 'Kot Kapura', '2222', 'asdfsdfg', 'Four Wheeler');
INSERT INTO `customerconsole` VALUES ('98765321', 'Harshita', 'Bathinda', 'Bathinda', '2020', 'sdfdg', 'Four Wheeler');

-- ----------------------------
-- Table structure for `login`
-- ----------------------------
DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `uid` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of login
-- ----------------------------
INSERT INTO `login` VALUES ('admin', 'welcomeadmin');

-- ----------------------------
-- Table structure for `parkingplan`
-- ----------------------------
DROP TABLE IF EXISTS `parkingplan`;
CREATE TABLE `parkingplan` (
  `floor` varchar(20) NOT NULL DEFAULT '',
  `slot` varchar(20) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  `booked` varchar(20) DEFAULT NULL,
  `free` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`floor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of parkingplan
-- ----------------------------
INSERT INTO `parkingplan` VALUES ('1', '2', 'Two Wheeler', '2', '0');
INSERT INTO `parkingplan` VALUES ('2', '3', 'Two Wheeler', '3', '0');
INSERT INTO `parkingplan` VALUES ('3', '4', 'Four Wheeler', '1', '3');
INSERT INTO `parkingplan` VALUES ('4', '5', 'Four Wheeler', '0', '5');
INSERT INTO `parkingplan` VALUES ('5', '2', 'Two Wheeler', '2', '0');
INSERT INTO `parkingplan` VALUES ('7', '20', 'Two Wheeler', '1', '19');

-- ----------------------------
-- Table structure for `vehicleentry`
-- ----------------------------
DROP TABLE IF EXISTS `vehicleentry`;
CREATE TABLE `vehicleentry` (
  `mob` varchar(20) NOT NULL DEFAULT '',
  `veh` varchar(20) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  `indate` varchar(20) DEFAULT NULL,
  `intime` varchar(20) DEFAULT NULL,
  `outdate` varchar(20) DEFAULT NULL,
  `outtime` varchar(20) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `floor` varchar(20) DEFAULT NULL,
  `amount` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`mob`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of vehicleentry
-- ----------------------------
INSERT INTO `vehicleentry` VALUES ('1234567', '1010', 'Two Wheeler', '2017-07-11', '14:54:53', '2017-07-12', '12:57:07', '0', '1', '30');
INSERT INTO `vehicleentry` VALUES ('23439894', '1111', 'Two Wheeler', '2017-07-11', '14:55:43', '2017-07-12', '13:00:31', '0', '1', '30');
INSERT INTO `vehicleentry` VALUES ('23454533', '1080', 'Two Wheeler', '2017-07-11', '14:56:18', '2017-07-12', '13:02:52', '0', '', '30');
INSERT INTO `vehicleentry` VALUES ('67348323', '5050', 'Two Wheeler', '2017-07-11', '15:12:57', '2017-07-12', '13:04:03', '0', null, '30');
INSERT INTO `vehicleentry` VALUES ('73438748', '3030', 'Two Wheeler', '2017-07-11', '15:14:04', '2017-10-23', '22:24:12', '0', null, '10');
INSERT INTO `vehicleentry` VALUES ('7343874890', '4040', 'Two Wheeler', '2017-07-11', '15:13:38', '2017-10-13', '21:11:16', '0', null, '20');
INSERT INTO `vehicleentry` VALUES ('8264301657', '0869', 'Two Wheeler', '2017-10-13', '20:28:39', '2017-10-23', '20:28:59', '0', null, '15');
INSERT INTO `vehicleentry` VALUES ('98765321', '2020', 'Four Wheeler', '2017-07-11', '15:13:56', '2017-07-12', '13:01:39', '0', '3', '40');
