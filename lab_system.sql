/*
 Navicat Premium Data Transfer

 Source Server         : root
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : localhost:3306
 Source Schema         : lab_system

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : 65001

 Date: 12/04/2019 23:00:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `course_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '课程名称：course_name',
  `teacher_user_id` bigint(20) NULL DEFAULT NULL COMMENT '教师ID：teacher_user_id',
  `total_score` int(11) NULL DEFAULT NULL COMMENT '总学分：total_score',
  `start_date` date NULL DEFAULT NULL COMMENT '开始时间：start_date',
  `end_date` date NULL DEFAULT NULL COMMENT '结束日期：end_date',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '课程表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (1, 'aaa', 0, 11, NULL, NULL);
INSERT INTO `course` VALUES (2, '4', 13, 4, NULL, NULL);
INSERT INTO `course` VALUES (3, '5', 13, 5, NULL, NULL);
INSERT INTO `course` VALUES (4, '6', 13, 6, NULL, NULL);
INSERT INTO `course` VALUES (5, 'a', 13, 2, NULL, NULL);
INSERT INTO `course` VALUES (6, '444', 13, 4, '2019-03-06', '2019-03-27');
INSERT INTO `course` VALUES (7, '大学英语', 15, 2, '2019-03-02', '2019-03-28');
INSERT INTO `course` VALUES (8, '高等数学', 15, 4, '2019-04-17', '2019-06-14');

-- ----------------------------
-- Table structure for equipment
-- ----------------------------
DROP TABLE IF EXISTS `equipment`;
CREATE TABLE `equipment`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `eq_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `ser_numb` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '编号：ser_numb',
  `rom_id` bigint(20) NULL DEFAULT 0,
  `eq_class_id` bigint(20) NULL DEFAULT NULL COMMENT '分类=>equipment_class->id:eq_class_id',
  `buy_time` datetime(0) NULL DEFAULT NULL COMMENT '购买时间：buy_time',
  `repair_times` datetime(0) NULL DEFAULT NULL COMMENT '修理时间：repair_times',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '信息更新时间：update_time',
  `state` tinyint(4) NULL DEFAULT NULL COMMENT '状态(0正常,1报修,2报废)：state',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of equipment
-- ----------------------------
INSERT INTO `equipment` VALUES (1, NULL, 'D186B44BAF0540A992B6B6764CF3CD3D', NULL, 2, '2019-04-13 06:52:41', '1970-01-01 08:00:00', '2019-04-12 22:52:00', 0);

-- ----------------------------
-- Table structure for equipment_class
-- ----------------------------
DROP TABLE IF EXISTS `equipment_class`;
CREATE TABLE `equipment_class`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类别名：type_name',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of equipment_class
-- ----------------------------
INSERT INTO `equipment_class` VALUES (1, '办公设备');
INSERT INTO `equipment_class` VALUES (2, '科研设备');
INSERT INTO `equipment_class` VALUES (3, '教学设备');

-- ----------------------------
-- Table structure for equipment_log
-- ----------------------------
DROP TABLE IF EXISTS `equipment_log`;
CREATE TABLE `equipment_log`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '申请人=>users->id:user_id',
  `handle_user_id` bigint(20) NULL DEFAULT NULL COMMENT '处理人=>users->id:handle_user_id',
  `eq_class_id` bigint(20) NULL DEFAULT NULL COMMENT '分类=>equipment_class->id:eq_class_id',
  `type` tinyint(4) NULL DEFAULT NULL COMMENT '类型(0报修,1采购)：type',
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '标题：title',
  `need` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `result` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '处理结果：result',
  `state` tinyint(4) NULL DEFAULT NULL COMMENT '状态(0申请中,1已审批,2已处理):state',
  `creat_time` datetime(0) NULL DEFAULT NULL COMMENT '申请时间：creat_time',
  `handle_time` datetime(0) NULL DEFAULT NULL COMMENT '处理时间：handle_time',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for exp_report
-- ----------------------------
DROP TABLE IF EXISTS `exp_report`;
CREATE TABLE `exp_report`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `tesk_id` bigint(20) NULL DEFAULT NULL COMMENT '任务ID：tesk_id',
  `student_user_id` bigint(20) NULL DEFAULT NULL COMMENT '学生ID：student_user_id',
  `content` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '内容：content',
  `student_file_url` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '学生附件:student_file_url',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间：update_time',
  `score` int(11) NULL DEFAULT 0 COMMENT '获得分数：score',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '实验报告表exp_report' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of exp_report
-- ----------------------------
INSERT INTO `exp_report` VALUES (1, 6, 27, '<p>完成试卷一的内容</p>', '', '2019-04-12 05:39:40', 85);
INSERT INTO `exp_report` VALUES (2, 12, 27, '<p>十篇</p>', '', '2019-04-12 05:39:33', 90);
INSERT INTO `exp_report` VALUES (3, 7, 28, '<p>1222</p>', '', '2019-04-12 06:07:16', 96);
INSERT INTO `exp_report` VALUES (4, 10, 29, '2', '', '2019-04-12 06:09:33', NULL);
INSERT INTO `exp_report` VALUES (5, 7, 29, '1', '', '2019-04-12 06:14:34', NULL);
INSERT INTO `exp_report` VALUES (6, 8, 29, '1', '', '2019-04-12 06:15:18', NULL);

-- ----------------------------
-- Table structure for exp_tesk
-- ----------------------------
DROP TABLE IF EXISTS `exp_tesk`;
CREATE TABLE `exp_tesk`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `course_id` bigint(20) NULL DEFAULT NULL COMMENT '课程ID：course_id',
  `rom_id` bigint(20) NULL DEFAULT NULL COMMENT '实验教室ID：rom_id',
  `title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '标题:title',
  `content` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '内容：content',
  `start_time` datetime(0) NULL DEFAULT NULL COMMENT '开始时间：start_time',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '结束时间：end_time',
  `file_url` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '课件:file_url',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '实验任务表exp_tesk' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of exp_tesk
-- ----------------------------
INSERT INTO `exp_tesk` VALUES (1, 0, 0, 'string', 'string', NULL, NULL, 'string');
INSERT INTO `exp_tesk` VALUES (2, 2, 0, '7', '4', NULL, NULL, '');
INSERT INTO `exp_tesk` VALUES (3, 3, NULL, '11', '1', NULL, NULL, '');
INSERT INTO `exp_tesk` VALUES (4, 7, NULL, '英语试卷一1', '完成试卷一的内容', NULL, NULL, '');
INSERT INTO `exp_tesk` VALUES (5, 7, NULL, '英语试卷二', '完成写作', NULL, NULL, '');
INSERT INTO `exp_tesk` VALUES (6, 7, NULL, '英语试卷一1', '完成试卷一的内容', '2019-03-14 00:00:00', '2019-03-28 00:00:00', '');
INSERT INTO `exp_tesk` VALUES (7, 7, NULL, '111', '1', '2019-03-27 00:00:00', '2019-03-28 00:00:00', '');
INSERT INTO `exp_tesk` VALUES (8, 7, NULL, '111', '1', '2019-03-27 00:00:00', NULL, '');
INSERT INTO `exp_tesk` VALUES (9, 7, NULL, '1111', '1', NULL, NULL, '');
INSERT INTO `exp_tesk` VALUES (10, 7, NULL, '2', '2', '2019-03-26 00:00:00', '2019-03-22 00:00:00', '');
INSERT INTO `exp_tesk` VALUES (11, 7, NULL, '111', '11111', '2019-03-19 00:00:00', '2019-03-26 00:00:00', 'http://localhost:8081/upload_tmp/2019-03-27/xls/1553700044425-15计科非师2班-3-4周.xls');
INSERT INTO `exp_tesk` VALUES (12, 7, NULL, '英语阅读', '十篇', '2019-03-26 00:00:00', '2019-04-05 00:00:00', 'http://localhost:8081/upload_tmp/2019-03-27/xls/1553701444185-15计科非师2班-3-4周.xls');
INSERT INTO `exp_tesk` VALUES (13, 8, NULL, '高等数学实验一', '<p>11111</p>', '2019-04-11 00:00:00', '2019-06-06 00:00:00', '');

-- ----------------------------
-- Table structure for identity
-- ----------------------------
DROP TABLE IF EXISTS `identity`;
CREATE TABLE `identity`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `identity_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '身份名称：identity_name',
  `level` tinyint(4) NULL DEFAULT NULL COMMENT '等级：level',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '身份表identity' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of identity
-- ----------------------------
INSERT INTO `identity` VALUES (1, '管理员', 0);
INSERT INTO `identity` VALUES (2, '教师', 1);
INSERT INTO `identity` VALUES (3, '设备管理员', 2);
INSERT INTO `identity` VALUES (4, '学生', 3);
INSERT INTO `identity` VALUES (5, '测试', 4);
INSERT INTO `identity` VALUES (6, '测试', 4);

-- ----------------------------
-- Table structure for roms
-- ----------------------------
DROP TABLE IF EXISTS `roms`;
CREATE TABLE `roms`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `numb` int(11) NULL DEFAULT NULL COMMENT '教室编号：numb',
  `rom_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '教室名称：rom_name',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '负责人id:user_id',
  `content` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述：content',
  `state` tinyint(4) NULL DEFAULT NULL COMMENT '状态(0空闲,1使用中):state',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '实验室表roms' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of roms
-- ----------------------------
INSERT INTO `roms` VALUES (1, 1, '教室1', 13, '计算机', 0);
INSERT INTO `roms` VALUES (2, 2, '教室2', 13, '科研', 0);
INSERT INTO `roms` VALUES (3, 3, '教室3', 13, '自习室', 0);

-- ----------------------------
-- Table structure for roms_log
-- ----------------------------
DROP TABLE IF EXISTS `roms_log`;
CREATE TABLE `roms_log`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '申请人=>users->id:user_id',
  `handle_user_id` bigint(20) NULL DEFAULT NULL COMMENT '处理人=>users->id:handle_user_id',
  `rom_id` bigint(20) NULL DEFAULT NULL COMMENT '教室=>rom->id:rom_id',
  `state` tinyint(4) NULL DEFAULT NULL COMMENT '状态(0申请中,1已审批,2未通过审批)：state',
  `creat_time` datetime(0) NULL DEFAULT NULL COMMENT '申请时间：creat_time',
  `handle_time` datetime(0) NULL DEFAULT NULL COMMENT '处理时间：handle_time',
  `start_time` datetime(0) NULL DEFAULT NULL COMMENT '申请开始使用时间:start_time',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '申请结束使用时间:end_time',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of roms_log
-- ----------------------------
INSERT INTO `roms_log` VALUES (1, 15, NULL, 1, 0, '2019-04-12 22:44:05', NULL, '2019-04-12 00:00:00', '2019-05-15 02:00:00');

-- ----------------------------
-- Table structure for user_activity
-- ----------------------------
DROP TABLE IF EXISTS `user_activity`;
CREATE TABLE `user_activity`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `student_id` bigint(20) NULL DEFAULT 0 COMMENT '学生ID：student_id',
  `teacher_user_id` bigint(20) NULL DEFAULT 0 COMMENT '教师ID：teacher_user_id',
  `course_id` bigint(20) NULL DEFAULT 0 COMMENT '课程ID：course_id',
  `achieve` double NULL DEFAULT 0 COMMENT '成绩：achieve',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户活动表user_activity' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_activity
-- ----------------------------
INSERT INTO `user_activity` VALUES (1, 27, 15, 7, 1.75);
INSERT INTO `user_activity` VALUES (2, 28, 15, 7, 1.92);
INSERT INTO `user_activity` VALUES (3, 29, 15, 7, 1.9);
INSERT INTO `user_activity` VALUES (4, 27, 15, 8, 0);
INSERT INTO `user_activity` VALUES (5, 28, 15, 8, 0);
INSERT INTO `user_activity` VALUES (6, 29, 15, 8, 0);

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `identity_id` bigint(20) NULL DEFAULT NULL COMMENT '身份ID=>identity->id:identity_id',
  `user_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户名:user_name',
  `pwd` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码：pwd',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '姓名：name',
  `job` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '职务：job',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (13, 1, 'admin', 'admin', 'admin', '');
INSERT INTO `users` VALUES (15, 2, '4', '4', '4', '4');
INSERT INTO `users` VALUES (27, 4, '2015102201', '111111', '胡三', '');
INSERT INTO `users` VALUES (28, 4, '2015102202', '111111', '张翰', '');
INSERT INTO `users` VALUES (29, 4, '2015102203', '111111', '蔡三', NULL);
INSERT INTO `users` VALUES (30, 3, 'wzq', '111111', '翁先生', '');

-- ----------------------------
-- Procedure structure for acti_
-- ----------------------------
DROP PROCEDURE IF EXISTS `acti_`;
delimiter ;;
CREATE PROCEDURE `acti_`(IN user_id bigint,IN id bigint)
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
delimiter ;

-- ----------------------------
-- Procedure structure for acti_1
-- ----------------------------
DROP PROCEDURE IF EXISTS `acti_1`;
delimiter ;;
CREATE PROCEDURE `acti_1`(IN user_id bigint,IN id bigint)
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
delimiter ;

-- ----------------------------
-- Procedure structure for acti_2
-- ----------------------------
DROP PROCEDURE IF EXISTS `acti_2`;
delimiter ;;
CREATE PROCEDURE `acti_2`(IN user_id bigint,IN id bigint)
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
delimiter ;

-- ----------------------------
-- Procedure structure for acti_task
-- ----------------------------
DROP PROCEDURE IF EXISTS `acti_task`;
delimiter ;;
CREATE PROCEDURE `acti_task`(IN user_id bigint,IN id bigint)
BEGIN
      UPDATE company_user a JOIN acti_task b ON a.id = b.creator_user_id  
			set b.creator_user_id = user_id 
			WHERE a.id = id;
    END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for acti_weighting_user
-- ----------------------------
DROP PROCEDURE IF EXISTS `acti_weighting_user`;
delimiter ;;
CREATE PROCEDURE `acti_weighting_user`(IN user_id bigint,IN id bigint)
BEGIN
      UPDATE company_user a JOIN acti_weighting_user b ON a.id = b.com_user_id  
			set b.com_user_id = user_id 
			WHERE a.id = id;
    END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for app_user_invite_his
-- ----------------------------
DROP PROCEDURE IF EXISTS `app_user_invite_his`;
delimiter ;;
CREATE PROCEDURE `app_user_invite_his`(IN user_id bigint,IN id bigint)
BEGIN
      UPDATE company_user a JOIN app_user_invite_his b ON a.id = b.user_id  
			set b.user_id = user_id 
			WHERE a.id = id;
    END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for collect_project
-- ----------------------------
DROP PROCEDURE IF EXISTS `collect_project`;
delimiter ;;
CREATE PROCEDURE `collect_project`(IN user_id bigint,IN id bigint)
BEGIN
      UPDATE company_user a JOIN collect_project b ON a.id = b.user_id  
			set b.user_id = user_id 
			WHERE a.id = id;
    END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for update_user
-- ----------------------------
DROP PROCEDURE IF EXISTS `update_user`;
delimiter ;;
CREATE PROCEDURE `update_user`(IN user_id bigint,IN id bigint)
BEGIN
		UPDATE company_user a JOIN acti_weighting_user b ON a.id = b.com_user_id  
      set b.com_user_id = user_id 
      WHERE a.id = id;
			   END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
