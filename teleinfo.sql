SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;
-- ----------------------------
-- 先修改配置文件，避免中文乱码
-- https://blog.csdn.net/weixin_48223757/article/details/122416609
-- ProgramData和Program File的my.init都要修改
-- ----------------------------


-- ----------------------------
-- 创建数据库管理员tele_admin和数据库tele_info
-- 密码：admin123
-- ----------------------------
-- drop user if EXISTS 'tele_admin'@%;
drop user 'tele_admin'@`%`;
create user 'tele_admin'@'%' identified by 'admin123';
GRANT ALL PRIVILEGES ON tele_info.* TO tele_admin@`%`;
flush privileges;

--可修改密码
set password for root@localhost = password('???');


-- ----------------------------
-- 用户
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户' ROW_FORMAT = Dynamic;

INSERT INTO `user` VALUES (1, 'admin', '123');
INSERT INTO `user` VALUES (2, 'cindy', '456');
insert into user values(3,'test','123');


-- ----------------------------
-- 方案经理（PM）录入表
-- program managers - PM
-- ----------------------------

DROP TABLE IF EXISTS `PM_entry`;
CREATE TABLE `PM_entry`  (
	`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '表格id',
	`time` datetime(0) NULL DEFAULT NULL COMMENT '表格填写时间',
	`contract_number` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '合同编号',
	`supplier` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '供应商名称',
	`client` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '客户名称',
	`start` int NULL DEFAULT NULL COMMENT '项目起始年份',
	`total` decimal(10, 2) NULL DEFAULT 0.00 COMMENT '总金额（单位：万元）',
	`state` smallint(6) NULL DEFAULT 0 COMMENT '项目状态（0：在途 1：结束 2：中止）',
	`bg` smallint(6) NULL DEFAULT 0 COMMENT '所属BG（0：数字政府，1：大企业，2：智慧城市，3：金融，4：互联网，5：教育，6：卫健）',
	`score` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '方案经理评分（A~E）',
	`PM_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '方案经理名称',
	`department` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '方案经理所属部门',
	`CM_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '客户经理名称',
	`DM_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '交付经理名称',
	`comment` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 67 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '方案经理录入表' ROW_FORMAT = Dynamic;

insert into `PM_entry`(id,time,contract_number,supplier,client,start,total,state,bg,score,PM_name,department,CM_name,DM_name,comment) values ()
INSERT INTO `PM_entry` VALUES ('1','2022-7-29','123456','老总','小王','2019','150','1','0','A','小李','领导','小张','小陈','仍需维护');
insert into `PM_entry` values ('2','2022-8-1','34534','张总','老王','2020','200','0','4','C','小强','领导班子','小红','小王','');

-- ----------------------------
-- 涉及能力
-- ----------------------------
-- ----------------------------
-- DROP TABLE IF EXISTS `client_ability`;
-- CREATE TABLE `client_ablity`  (
--  `ability` smallint(6) NULL DEFAULT 0 COMMENT '涉及能力（0：5G，1：云，2：网，3：物，4：安，5：硬件，6：垫资，7：工程）',
--  `id` datetime(0) NOT NULL AUTO_INCREMENT COMMENT '表格id'， 
--  PRIMARY KEY (`id`) USING BTREE
--) ENGINE = InnoDB AUTO_INCREMENT = 107 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '客户涉及能力' ROW_FORMAT = Dynamic;
-- ----------------------------

-- ----------------------------
-- 客户经理（CM）评价表
-- customer managers - CM
-- ----------------------------
DROP TABLE IF EXISTS `CM_grading`;
CREATE TABLE `CM_grading`  (
	`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '表格id',
	`time` datetime(0) NULL DEFAULT NULL COMMENT '表格填写时间',
	`CM_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '客户经理名称',
	`unit` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '所属单位',
	`credibility` smallint(6) NULL DEFAULT 0 COMMENT '信誉口碑:0~10分',
	`customer_relat` smallint(6) NULL DEFAULT 0 COMMENT '客情关系:0~5分',
	`project_support` smallint(6) NULL DEFAULT 0 COMMENT '方案支撑:0~10分',
	`personnel_quality` smallint(6) NULL DEFAULT 0 COMMENT '人员素质:0~5分',
	`comment` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
	`total` decimal(10, 2) NULL DEFAULT 0.00 COMMENT '总分',
	PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 107 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '客户经理评价表' ROW_FORMAT = Dynamic;


-- ----------------------------
-- 交付经理（DM）评分表 rating form
-- Delivery managers - DM
-- ----------------------------
DROP TABLE IF EXISTS `DM_grading`;
CREATE TABLE `DM_grading`  (
	`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '表格id',
	`time` datetime(0) NULL DEFAULT NULL COMMENT '表格填写时间',
	`DM_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '交付经理名称',
	`unit` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '所属单位',
	`constructability` smallint(6) NULL DEFAULT 0 COMMENT '施工能力:0~15分',
	`technique` smallint(6) NULL DEFAULT 0 COMMENT '技术能力:0~15分',
	`res_tl` smallint(6) NULL DEFAULT 0 COMMENT '响应及时性:0~15分',
	`compl_tl` smallint(6) NULL DEFAULT 0 COMMENT '项目竣工及时性:0~10分',
	`deliver_quality` smallint(6) NULL DEFAULT 0 COMMENT '交付质量:0~10分',
	`customer_satisfaction` smallint(6) NULL DEFAULT 0 COMMENT '客户满意度:0~10分',
	`comment` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
	`total` decimal(10, 2) NULL DEFAULT 0.00 COMMENT '总分',
	PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 107 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '交付经理评价表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- 单位列表
-- ----------------------------
DROP TABLE IF EXISTS `departments`;
CREATE TABLE `departments`  (
	`id` int NOT NULL COMMENT '部门id',
	`layer` int NOT NULL COMMENT '部门所属层级',
	`p_id` int not null comment '父节点id',
	`name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '部门名称',
	PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 107 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '单位列表' ROW_FORMAT = Dynamic;
