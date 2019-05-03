/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : lab_system

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2019-05-03 13:22:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `course_name` varchar(50) DEFAULT NULL COMMENT '课程名称：course_name',
  `teacher_user_id` bigint(20) DEFAULT NULL COMMENT '教师ID：teacher_user_id',
  `total_score` int(11) DEFAULT NULL COMMENT '总学分：total_score',
  `start_date` date DEFAULT NULL COMMENT '开始时间：start_date',
  `end_date` date DEFAULT NULL COMMENT '结束日期：end_date',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='课程表';

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', 'aaa', '0', '11', null, null);
INSERT INTO `course` VALUES ('2', '4', '13', '4', null, null);
INSERT INTO `course` VALUES ('3', '5', '13', '5', null, null);
INSERT INTO `course` VALUES ('4', '6', '13', '6', null, null);
INSERT INTO `course` VALUES ('5', 'a', '13', '2', null, null);
INSERT INTO `course` VALUES ('6', '444', '13', '4', '2019-03-06', '2019-03-27');
INSERT INTO `course` VALUES ('7', '大学英语', '15', '2', '2019-03-02', '2019-03-28');
INSERT INTO `course` VALUES ('8', '高等数学', '15', '3', '2019-04-17', '2019-06-14');
INSERT INTO `course` VALUES ('9', '计算机应用', '15', '2', '2019-05-03', '2019-05-31');

-- ----------------------------
-- Table structure for equipment
-- ----------------------------
DROP TABLE IF EXISTS `equipment`;
CREATE TABLE `equipment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `eq_name` varchar(50) DEFAULT NULL,
  `ser_numb` varchar(50) DEFAULT NULL COMMENT '编号：ser_numb',
  `rom_id` bigint(20) DEFAULT '0',
  `eq_class_id` bigint(20) DEFAULT NULL COMMENT '分类=>equipment_class->id:eq_class_id',
  `buy_time` datetime DEFAULT NULL COMMENT '购买时间：buy_time',
  `repair_times` datetime DEFAULT NULL COMMENT '修理时间：repair_times',
  `update_time` datetime DEFAULT NULL COMMENT '信息更新时间：update_time',
  `state` tinyint(4) DEFAULT NULL COMMENT '状态(0正常,1报修,2报废)：state',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of equipment
-- ----------------------------
INSERT INTO `equipment` VALUES ('1', null, 'D186B44BAF0540A992B6B6764CF3CD3D', null, '2', '2019-04-13 06:52:41', '1970-01-01 08:00:00', '2019-04-12 22:52:00', '0');
INSERT INTO `equipment` VALUES ('2', null, '497C053B6A0E4D5FA1CB11E1C6587D34', null, '2', '2019-05-02 08:33:17', '1970-01-01 08:00:00', '2019-05-02 00:32:42', '0');
INSERT INTO `equipment` VALUES ('3', null, '94B6332DC83E45159E72F05DD6AF7112', null, '3', '2019-05-02 00:00:00', '2019-05-17 00:00:00', '2019-05-02 09:39:14', '1');
INSERT INTO `equipment` VALUES ('4', null, 'B83D1B01653C480A931A126646AE2E2D', '2', '1', '2019-05-02 00:00:00', '2019-05-18 00:00:00', '2019-05-02 09:39:11', '0');
INSERT INTO `equipment` VALUES ('7', null, 'FC164F058E204B4BA299A8C9736B4F50', '3', '3', '2019-05-02 00:00:00', '1970-01-01 00:00:00', '2019-05-02 09:39:16', '0');
INSERT INTO `equipment` VALUES ('8', null, 'CE30FD716E924A109776793B9507A281', '2', '3', '2019-05-02 00:00:00', '2019-05-16 00:00:00', '2019-05-02 09:39:08', '0');
INSERT INTO `equipment` VALUES ('9', null, 'A1970C68D5114333ADE147F0E274B52D', null, '3', '2019-05-02 17:25:34', '2019-05-17 00:00:00', '2019-05-02 09:25:34', '0');
INSERT INTO `equipment` VALUES ('10', null, 'C4A9D0A22FF640B3BCF492E96A1DA5CB', '2', '3', '2019-05-02 00:00:00', '2019-05-24 00:00:00', '2019-05-02 09:39:05', '0');
INSERT INTO `equipment` VALUES ('11', null, '143F014CC93B458980B13B866172B445', null, '2', '2019-05-02 17:43:48', '2019-05-18 00:00:00', '2019-05-02 09:43:48', '0');
INSERT INTO `equipment` VALUES ('12', null, 'FE628505C4BB462A953747FDD43CB890', null, '3', '2019-05-02 17:52:23', '2019-05-02 00:00:00', '2019-05-02 09:52:23', '0');
INSERT INTO `equipment` VALUES ('13', null, '292DC3590D454C768DE9AFE535602E92', null, '3', '2019-05-02 17:52:33', '2019-05-17 00:00:00', '2019-05-02 09:52:33', '0');

-- ----------------------------
-- Table structure for equipment_class
-- ----------------------------
DROP TABLE IF EXISTS `equipment_class`;
CREATE TABLE `equipment_class` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(20) DEFAULT NULL COMMENT '类别名：type_name',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of equipment_class
-- ----------------------------
INSERT INTO `equipment_class` VALUES ('1', '办公设备');
INSERT INTO `equipment_class` VALUES ('2', '科研设备');
INSERT INTO `equipment_class` VALUES ('3', '教学设备');
INSERT INTO `equipment_class` VALUES ('4', '科研设备11');

-- ----------------------------
-- Table structure for equipment_log
-- ----------------------------
DROP TABLE IF EXISTS `equipment_log`;
CREATE TABLE `equipment_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '申请人=>users->id:user_id',
  `handle_user_id` bigint(20) DEFAULT NULL COMMENT '处理人=>users->id:handle_user_id',
  `eq_class_id` bigint(20) DEFAULT NULL COMMENT '分类=>equipment_class->id:eq_class_id',
  `type` tinyint(4) DEFAULT NULL COMMENT '类型(0报修,1采购)：type',
  `title` varchar(50) DEFAULT NULL COMMENT '标题：title',
  `need` varchar(500) DEFAULT NULL,
  `result` varchar(500) DEFAULT NULL COMMENT '处理结果：result',
  `state` tinyint(4) DEFAULT NULL COMMENT '状态(0申请中,1已审批,2已处理):state',
  `creat_time` datetime DEFAULT NULL COMMENT '申请时间：creat_time',
  `handle_time` datetime DEFAULT NULL COMMENT '处理时间：handle_time',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of equipment_log
-- ----------------------------

-- ----------------------------
-- Table structure for exp_report
-- ----------------------------
DROP TABLE IF EXISTS `exp_report`;
CREATE TABLE `exp_report` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `tesk_id` bigint(20) DEFAULT NULL COMMENT '任务ID：tesk_id',
  `student_user_id` bigint(20) DEFAULT NULL COMMENT '学生ID：student_user_id',
  `content` varchar(2000) DEFAULT NULL COMMENT '内容：content',
  `student_file_url` varchar(500) DEFAULT NULL COMMENT '学生附件:student_file_url',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间：update_time',
  `score` int(11) DEFAULT '0' COMMENT '获得分数：score',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='实验报告表exp_report';

-- ----------------------------
-- Records of exp_report
-- ----------------------------
INSERT INTO `exp_report` VALUES ('1', '6', '27', '<p>完成试卷一的内容</p>', '', '2019-04-12 05:39:40', '85');
INSERT INTO `exp_report` VALUES ('2', '12', '27', '<p>十篇</p>', '', '2019-04-12 05:39:33', '90');
INSERT INTO `exp_report` VALUES ('3', '7', '28', '<p>1222</p>', '', '2019-04-12 06:07:16', '96');
INSERT INTO `exp_report` VALUES ('4', '10', '29', '2', '', '2019-04-12 06:09:33', '0');
INSERT INTO `exp_report` VALUES ('5', '7', '29', '1', '', '2019-04-12 06:14:34', '0');
INSERT INTO `exp_report` VALUES ('6', '8', '29', '1', '', '2019-04-12 06:15:18', '0');
INSERT INTO `exp_report` VALUES ('7', '13', '28', 'defef', null, '2019-04-12 06:15:18', '84');
INSERT INTO `exp_report` VALUES ('8', '14', '28', 'uiygjy', null, '2019-04-12 06:15:18', '99');
INSERT INTO `exp_report` VALUES ('9', '15', '28', '<p>htttjt</p>', null, '2019-05-03 20:30:57', '40');
INSERT INTO `exp_report` VALUES ('10', '14', '27', ';o;oo;', null, '2019-04-12 06:15:18', '55');
INSERT INTO `exp_report` VALUES ('11', '13', '29', 'uyyyy', null, '2019-04-12 06:15:18', '33');

-- ----------------------------
-- Table structure for exp_tesk
-- ----------------------------
DROP TABLE IF EXISTS `exp_tesk`;
CREATE TABLE `exp_tesk` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `course_id` bigint(20) DEFAULT NULL COMMENT '课程ID：course_id',
  `rom_id` bigint(20) DEFAULT NULL COMMENT '实验教室ID：rom_id',
  `title` varchar(100) DEFAULT NULL COMMENT '标题:title',
  `content` varchar(2000) DEFAULT NULL COMMENT '内容：content',
  `start_time` datetime DEFAULT NULL COMMENT '开始时间：start_time',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间：end_time',
  `file_url` varchar(500) DEFAULT NULL COMMENT '课件:file_url',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='实验任务表exp_tesk';

-- ----------------------------
-- Records of exp_tesk
-- ----------------------------
INSERT INTO `exp_tesk` VALUES ('1', '0', '0', 'string', 'string', null, null, 'string');
INSERT INTO `exp_tesk` VALUES ('2', '2', '0', '7', '4', null, null, '');
INSERT INTO `exp_tesk` VALUES ('3', '3', null, '11', '1', null, null, '');
INSERT INTO `exp_tesk` VALUES ('4', '7', null, '英语试卷一1', '完成试卷一的内容', null, null, '');
INSERT INTO `exp_tesk` VALUES ('5', '7', null, '英语试卷二', '完成写作', null, null, '');
INSERT INTO `exp_tesk` VALUES ('6', '7', null, '英语试卷一1', '完成试卷一的内容', '2019-03-14 00:00:00', '2019-03-28 00:00:00', '');
INSERT INTO `exp_tesk` VALUES ('7', '7', null, '111', '1', '2019-03-27 00:00:00', '2019-03-28 00:00:00', '');
INSERT INTO `exp_tesk` VALUES ('8', '7', null, '111', '1', '2019-03-27 00:00:00', null, '');
INSERT INTO `exp_tesk` VALUES ('9', '7', null, '1111', '1', null, null, '');
INSERT INTO `exp_tesk` VALUES ('10', '7', null, '2', '2', '2019-03-26 00:00:00', '2019-03-22 00:00:00', '');
INSERT INTO `exp_tesk` VALUES ('11', '7', null, '111', '11111', '2019-03-19 00:00:00', '2019-03-26 00:00:00', 'http://localhost:8081/upload_tmp/2019-03-27/xls/1553700044425-15计科非师2班-3-4周.xls');
INSERT INTO `exp_tesk` VALUES ('12', '7', null, '英语阅读', '十篇', '2019-03-26 00:00:00', '2019-04-05 00:00:00', 'http://localhost:8081/upload_tmp/2019-03-27/xls/1553701444185-15计科非师2班-3-4周.xls');
INSERT INTO `exp_tesk` VALUES ('13', '8', null, '高等数学实验一', '<p>11111</p>', '2019-04-11 00:00:00', '2019-06-06 00:00:00', '');
INSERT INTO `exp_tesk` VALUES ('14', '8', null, 'wdwdw', 'dsfsefsd', '2019-04-12 06:15:18', '2019-04-12 06:15:18', null);
INSERT INTO `exp_tesk` VALUES ('15', '8', null, 'feffdxvccb', 'gghghghg', '2019-04-12 06:15:18', '2019-04-12 06:15:18', null);
INSERT INTO `exp_tesk` VALUES ('16', '9', null, '实验1', '<p>实验一思言而</p>', '2019-05-03 00:00:00', '2019-05-24 00:00:00', 'http://localhost:8081/upload_tmp/2019-05-03/doc/1556851430194-社团登记表 （模板）.doc');
INSERT INTO `exp_tesk` VALUES ('17', '9', null, '22', '<p>222211</p>', '2019-05-16 00:00:00', '2019-05-30 00:00:00', '');
INSERT INTO `exp_tesk` VALUES ('18', '9', null, 'shiyan', '<p>shiyan111</p>', '2019-05-15 00:00:00', '2019-05-16 00:00:00', '');
INSERT INTO `exp_tesk` VALUES ('19', '9', null, '实验2', '<p>实验二实验二  说的 说的是的发</p>', '2019-05-03 00:00:00', '2019-05-17 00:00:00', '');

-- ----------------------------
-- Table structure for identity
-- ----------------------------
DROP TABLE IF EXISTS `identity`;
CREATE TABLE `identity` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `identity_name` varchar(50) DEFAULT NULL COMMENT '身份名称：identity_name',
  `level` tinyint(4) DEFAULT NULL COMMENT '等级：level',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='身份表identity';

-- ----------------------------
-- Records of identity
-- ----------------------------
INSERT INTO `identity` VALUES ('1', '管理员', '0');
INSERT INTO `identity` VALUES ('2', '教师', '1');
INSERT INTO `identity` VALUES ('3', '设备管理员', '2');
INSERT INTO `identity` VALUES ('4', '学生', '3');
INSERT INTO `identity` VALUES ('7', '测试', '4');

-- ----------------------------
-- Table structure for roms
-- ----------------------------
DROP TABLE IF EXISTS `roms`;
CREATE TABLE `roms` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `numb` int(11) DEFAULT NULL COMMENT '教室编号：numb',
  `rom_name` varchar(50) DEFAULT NULL COMMENT '教室名称：rom_name',
  `user_id` bigint(20) DEFAULT NULL COMMENT '负责人id:user_id',
  `content` varchar(100) DEFAULT NULL COMMENT '描述：content',
  `state` tinyint(4) DEFAULT NULL COMMENT '状态(0空闲,1使用中):state',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='实验室表roms';

-- ----------------------------
-- Records of roms
-- ----------------------------
INSERT INTO `roms` VALUES ('1', '1', '教室1', '13', '计算机', '0');
INSERT INTO `roms` VALUES ('2', '2', '教室2', '13', '科研1', '0');
INSERT INTO `roms` VALUES ('3', '3', '教室3', '13', '自习室', '0');
INSERT INTO `roms` VALUES ('4', '4', '实验室3', '13', '实验室实验室111', '0');

-- ----------------------------
-- Table structure for roms_log
-- ----------------------------
DROP TABLE IF EXISTS `roms_log`;
CREATE TABLE `roms_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '申请人=>users->id:user_id',
  `handle_user_id` bigint(20) DEFAULT NULL COMMENT '处理人=>users->id:handle_user_id',
  `rom_id` bigint(20) DEFAULT NULL COMMENT '教室=>rom->id:rom_id',
  `state` tinyint(4) DEFAULT NULL COMMENT '状态(0申请中,1已审批,2未通过审批)：state',
  `creat_time` datetime DEFAULT NULL COMMENT '申请时间：creat_time',
  `handle_time` datetime DEFAULT NULL COMMENT '处理时间：handle_time',
  `start_time` datetime DEFAULT NULL COMMENT '申请开始使用时间:start_time',
  `end_time` datetime DEFAULT NULL COMMENT '申请结束使用时间:end_time',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of roms_log
-- ----------------------------
INSERT INTO `roms_log` VALUES ('3', '15', null, '2', '0', '2019-05-03 13:11:35', null, '2019-05-08 00:00:00', '2019-05-10 00:00:00');
INSERT INTO `roms_log` VALUES ('4', '15', '13', '3', '1', '2019-05-03 13:11:49', '2019-05-03 21:19:00', '2019-05-17 00:00:00', '2019-05-17 00:00:00');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `identity_id` bigint(20) DEFAULT NULL COMMENT '身份ID=>identity->id:identity_id',
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户名:user_name',
  `pwd` varchar(50) DEFAULT NULL COMMENT '密码：pwd',
  `name` varchar(20) DEFAULT NULL COMMENT '姓名：name',
  `job` varchar(20) DEFAULT NULL COMMENT '职务：job',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('13', '1', 'admin', 'admin', 'admin', '');
INSERT INTO `users` VALUES ('15', '2', '4', '4', '4', '高数老师');
INSERT INTO `users` VALUES ('27', '4', '2015102201', '111111', '胡三', '');
INSERT INTO `users` VALUES ('29', '4', '2015102203', '111111', '蔡三', null);
INSERT INTO `users` VALUES ('30', '3', 'wzq', '111111', '翁先生', '');
INSERT INTO `users` VALUES ('31', '3', '2015102222', '123456', '吴三', '');
INSERT INTO `users` VALUES ('32', '4', '2015', '1111', '余', null);

-- ----------------------------
-- Table structure for user_activity
-- ----------------------------
DROP TABLE IF EXISTS `user_activity`;
CREATE TABLE `user_activity` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `student_id` bigint(20) DEFAULT '0' COMMENT '学生ID：student_id',
  `teacher_user_id` bigint(20) DEFAULT '0' COMMENT '教师ID：teacher_user_id',
  `course_id` bigint(20) DEFAULT '0' COMMENT '课程ID：course_id',
  `achieve` double DEFAULT '0' COMMENT '成绩：achieve',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='用户活动表user_activity';

-- ----------------------------
-- Records of user_activity
-- ----------------------------
INSERT INTO `user_activity` VALUES ('1', '27', '15', '7', '1.75');
INSERT INTO `user_activity` VALUES ('2', '28', '15', '7', '1.92');
INSERT INTO `user_activity` VALUES ('3', '29', '15', '7', '1.9');
INSERT INTO `user_activity` VALUES ('4', '27', '15', '8', '1.65');
INSERT INTO `user_activity` VALUES ('5', '28', '15', '8', '2.23');
INSERT INTO `user_activity` VALUES ('6', '29', '15', '8', '0.99');
INSERT INTO `user_activity` VALUES ('7', '32', '15', '8', '0');
INSERT INTO `user_activity` VALUES ('8', '32', '15', '9', '0');

-- ----------------------------
-- Procedure structure for acti_
-- ----------------------------
DROP PROCEDURE IF EXISTS `acti_`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `acti_`(IN user_id bigint,IN id bigint)
BEGIN
      UPDATE company_user a JOIN acti_weighting_user b ON a.id = b.com_user_id  
      set b.com_user_id = user_id 
      WHERE a.id = id;
			
      UPDATE company_user a JOIN acti_sub b ON a.id = b.creator_user_id  
      set b.creator_user_id = user_id 
      WHERE a.id = id;

      UPDATE company_user a JOIN acti_weighting_user b ON a.id = b.com_user_id  
      set b.acti_weighting_user = user_id 
      WHERE a.id = id;


    END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for acti_1
-- ----------------------------
DROP PROCEDURE IF EXISTS `acti_1`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `acti_1`(IN user_id bigint,IN id bigint)
BEGIN
      UPDATE company_user a JOIN acti_weighting_user b ON a.id = b.com_user_id  
      set b.com_user_id = user_id 
      WHERE a.id = id;
			
      UPDATE company_user a JOIN acti_sub b ON a.id = b.creator_user_id  
      set b.creator_user_id = user_id 
      WHERE a.id = id;

      UPDATE company_user a JOIN acti_weighting_user b ON a.id = b.com_user_id  
      set b.acti_weighting_user = user_id 
      WHERE a.id = id;


    END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for acti_2
-- ----------------------------
DROP PROCEDURE IF EXISTS `acti_2`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `acti_2`(IN user_id bigint,IN id bigint)
BEGIN
      UPDATE company_user a JOIN acti_weighting_user b ON a.id = b.com_user_id  
      set b.com_user_id = user_id 
      WHERE a.id = id;
			
      UPDATE company_user a JOIN acti_sub b ON a.id = b.creator_user_id  
      set b.creator_user_id = user_id 
      WHERE a.id = id;

      UPDATE company_user a JOIN acti_weighting_user b ON a.id = b.com_user_id  
      set b.acti_weighting_user = user_id 
      WHERE a.id = id;


    END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for acti_task
-- ----------------------------
DROP PROCEDURE IF EXISTS `acti_task`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `acti_task`(IN user_id bigint,IN id bigint)
BEGIN
      UPDATE company_user a JOIN acti_task b ON a.id = b.creator_user_id  
			set b.creator_user_id = user_id 
			WHERE a.id = id;
    END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for acti_weighting_user
-- ----------------------------
DROP PROCEDURE IF EXISTS `acti_weighting_user`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `acti_weighting_user`(IN user_id bigint,IN id bigint)
BEGIN
      UPDATE company_user a JOIN acti_weighting_user b ON a.id = b.com_user_id  
			set b.com_user_id = user_id 
			WHERE a.id = id;
    END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for app_user_invite_his
-- ----------------------------
DROP PROCEDURE IF EXISTS `app_user_invite_his`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `app_user_invite_his`(IN user_id bigint,IN id bigint)
BEGIN
      UPDATE company_user a JOIN app_user_invite_his b ON a.id = b.user_id  
			set b.user_id = user_id 
			WHERE a.id = id;
    END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for collect_project
-- ----------------------------
DROP PROCEDURE IF EXISTS `collect_project`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `collect_project`(IN user_id bigint,IN id bigint)
BEGIN
      UPDATE company_user a JOIN collect_project b ON a.id = b.user_id  
			set b.user_id = user_id 
			WHERE a.id = id;
    END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for update_user
-- ----------------------------
DROP PROCEDURE IF EXISTS `update_user`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `update_user`(IN user_id bigint,IN id bigint)
BEGIN
		UPDATE company_user a JOIN acti_weighting_user b ON a.id = b.com_user_id  
      set b.com_user_id = user_id 
      WHERE a.id = id;
			   END
;;
DELIMITER ;
