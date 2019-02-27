/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : localhost:3306
 Source Schema         : lab_system

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : 65001

 Date: 27/02/2019 18:12:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for equipment
-- ----------------------------
DROP TABLE IF EXISTS `equipment`;
CREATE TABLE `equipment`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `eq_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `ser_numb` bigint(20) DEFAULT NULL COMMENT '编号：ser_numb',
  `rom_id` bigint(20) DEFAULT NULL,
  `eq_class_id` bigint(20) DEFAULT NULL COMMENT '分类=>equipment_class->id:eq_class_id',
  `buy_time` datetime(0) DEFAULT NULL COMMENT '购买时间：buy_time',
  `repair_times` datetime(0) DEFAULT NULL COMMENT '修理时间：repair_times',
  `update_time` datetime(0) DEFAULT NULL COMMENT '信息更新时间：update_time',
  `state` tinyint(4) DEFAULT NULL COMMENT '状态(0正常,1报修,2报废)：state',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for equipment_class
-- ----------------------------
DROP TABLE IF EXISTS `equipment_class`;
CREATE TABLE `equipment_class`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '类别名：type_name',
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
  `user_id` bigint(20) DEFAULT NULL COMMENT '申请人=>users->id:user_id',
  `handle_user_id` bigint(20) DEFAULT NULL COMMENT '处理人=>users->id:handle_user_id',
  `eq_class_id` bigint(20) DEFAULT NULL COMMENT '分类=>equipment_class->id:eq_class_id',
  `type` tinyint(4) DEFAULT NULL COMMENT '类型(0报修,1采购)：type',
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '标题：title',
  `need` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `result` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '处理结果：result',
  `state` tinyint(4) DEFAULT NULL COMMENT '状态(0申请中,1已审批,2已处理):state',
  `creat_time` datetime(0) DEFAULT NULL COMMENT '申请时间：creat_time',
  `handle_time` datetime(0) DEFAULT NULL COMMENT '处理时间：handle_time',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for identity
-- ----------------------------
DROP TABLE IF EXISTS `identity`;
CREATE TABLE `identity`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `identity_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '身份名称：identity_name',
  `level` tinyint(4) DEFAULT NULL COMMENT '等级：level',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '身份表identity' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of identity
-- ----------------------------
INSERT INTO `identity` VALUES (1, 'admin', 0);
INSERT INTO `identity` VALUES (2, '管理员', 1);
INSERT INTO `identity` VALUES (3, '教师', 2);
INSERT INTO `identity` VALUES (4, '设备管理员', 2);

-- ----------------------------
-- Table structure for identity_resourse
-- ----------------------------
DROP TABLE IF EXISTS `identity_resourse`;
CREATE TABLE `identity_resourse`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `identity_id` bigint(20) DEFAULT NULL,
  `resourse_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for resourse
-- ----------------------------
DROP TABLE IF EXISTS `resourse`;
CREATE TABLE `resourse`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `resourse_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '资源名：resourse_name',
  `father_id` bigint(20) DEFAULT NULL COMMENT '父id：father_id',
  `url` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'URL:url',
  `level` tinyint(4) DEFAULT NULL COMMENT '等级(0一级,1二级,2三级)：level',
  `type` tinyint(4) DEFAULT NULL COMMENT '类型(0目录,1按钮)：type',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of resourse
-- ----------------------------
INSERT INTO `resourse` VALUES (1, '用户管理', 0, NULL, 0, 0);
INSERT INTO `resourse` VALUES (2, '实验室场地管理', 0, NULL, 0, 0);
INSERT INTO `resourse` VALUES (3, '仪器设备管理', 0, NULL, 0, 0);
INSERT INTO `resourse` VALUES (4, '设备采购', 0, NULL, 0, 0);
INSERT INTO `resourse` VALUES (5, '账户管理', 1, NULL, 1, 0);
INSERT INTO `resourse` VALUES (6, '职务与权限', 1, NULL, 1, 0);
INSERT INTO `resourse` VALUES (7, '资源模块', 1, NULL, 1, 0);
INSERT INTO `resourse` VALUES (8, '教室管理', 2, NULL, 1, 0);
INSERT INTO `resourse` VALUES (9, '教室申请', 2, NULL, 1, 0);
INSERT INTO `resourse` VALUES (10, '教室审批', 2, NULL, 1, 0);
INSERT INTO `resourse` VALUES (11, '使用分配管理', 3, NULL, 1, 0);
INSERT INTO `resourse` VALUES (12, '库存管理', 3, NULL, 1, 0);
INSERT INTO `resourse` VALUES (13, '设备管理', 3, NULL, 1, 0);
INSERT INTO `resourse` VALUES (14, '报修申请', 3, NULL, 1, 0);
INSERT INTO `resourse` VALUES (15, '处理结果', 3, NULL, 1, 0);
INSERT INTO `resourse` VALUES (16, '设备分类', 4, NULL, 1, 0);
INSERT INTO `resourse` VALUES (17, '采购申请', 4, NULL, 1, 0);
INSERT INTO `resourse` VALUES (18, '采购审批', 4, NULL, 1, 0);

-- ----------------------------
-- Table structure for roms
-- ----------------------------
DROP TABLE IF EXISTS `roms`;
CREATE TABLE `roms`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `rom_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `numb` int(11) DEFAULT NULL COMMENT '教室编号：numb',
  `type` tinyint(4) DEFAULT NULL COMMENT '类型（0办公室，1教室，2其它）：type',
  `person_liable_id` bigint(20) DEFAULT NULL COMMENT '负责人=>users->id:person_liable_id',
  `content` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL COMMENT '状态(0空闲,1使用中):state',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for roms_log
-- ----------------------------
DROP TABLE IF EXISTS `roms_log`;
CREATE TABLE `roms_log`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '申请人=>users->id:user_id',
  `handle_user_id` bigint(20) DEFAULT NULL COMMENT '处理人=>users->id:handle_user_id',
  `rom_id` bigint(20) DEFAULT NULL COMMENT '教室=>rom->id:rom_id',
  `state` tinyint(4) DEFAULT NULL COMMENT '状态(0申请中,1已审批,2未通过审批)：state',
  `creat_time` datetime(0) DEFAULT NULL COMMENT '申请时间：creat_time',
  `handle_time` datetime(0) DEFAULT NULL COMMENT '处理时间：handle_time',
  `start_time` datetime(0) DEFAULT NULL COMMENT '申请开始使用时间:start_time',
  `end_time` datetime(0) DEFAULT NULL COMMENT '申请结束使用时间:end_time',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `identity_id` bigint(20) DEFAULT NULL COMMENT '身份ID=>identity->id:identity_id',
  `user_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户名:user_name',
  `pwd` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '密码：pwd',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '姓名：name',
  `job` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '职务：job',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, 1, 'admin', 'admin', 'admin', 'admin');

-- ----------------------------
-- Procedure structure for acti_
-- ----------------------------
DROP PROCEDURE IF EXISTS `acti_`;
delimiter ;;
CREATE DEFINER=`root`@`%` PROCEDURE `acti_`(IN user_id bigint,IN id bigint)
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
CREATE DEFINER=`root`@`%` PROCEDURE `acti_1`(IN user_id bigint,IN id bigint)
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
CREATE DEFINER=`root`@`%` PROCEDURE `acti_2`(IN user_id bigint,IN id bigint)
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
CREATE DEFINER=`root`@`%` PROCEDURE `acti_task`(IN user_id bigint,IN id bigint)
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
CREATE DEFINER=`root`@`%` PROCEDURE `acti_weighting_user`(IN user_id bigint,IN id bigint)
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
CREATE DEFINER=`root`@`%` PROCEDURE `app_user_invite_his`(IN user_id bigint,IN id bigint)
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
CREATE DEFINER=`root`@`%` PROCEDURE `collect_project`(IN user_id bigint,IN id bigint)
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
CREATE DEFINER=`root`@`%` PROCEDURE `update_user`(IN user_id bigint,IN id bigint)
BEGIN
		UPDATE company_user a JOIN acti_weighting_user b ON a.id = b.com_user_id  
      set b.com_user_id = user_id 
      WHERE a.id = id;
			   END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
