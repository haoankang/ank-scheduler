/*
Navicat MySQL Data Transfer

Source Server         : 10.100.1.211
Source Server Version : 50723
Source Host           : 10.100.1.211:3306
Source Database       : scheduler_bak

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2019-08-01 17:35:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ml_qrtz_blob_triggers
-- ----------------------------
DROP TABLE IF EXISTS `ml_qrtz_blob_triggers`;
CREATE TABLE `ml_qrtz_blob_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `BLOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `ml_qrtz_blob_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `ml_qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ml_qrtz_blob_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for ml_qrtz_calendars
-- ----------------------------
DROP TABLE IF EXISTS `ml_qrtz_calendars`;
CREATE TABLE `ml_qrtz_calendars` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `CALENDAR_NAME` varchar(200) NOT NULL,
  `CALENDAR` blob NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`CALENDAR_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ml_qrtz_calendars
-- ----------------------------

-- ----------------------------
-- Table structure for ml_qrtz_cron_triggers
-- ----------------------------
DROP TABLE IF EXISTS `ml_qrtz_cron_triggers`;
CREATE TABLE `ml_qrtz_cron_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `CRON_EXPRESSION` varchar(200) NOT NULL,
  `TIME_ZONE_ID` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `ml_qrtz_cron_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `ml_qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ml_qrtz_cron_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for ml_qrtz_fired_triggers
-- ----------------------------
DROP TABLE IF EXISTS `ml_qrtz_fired_triggers`;
CREATE TABLE `ml_qrtz_fired_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `ENTRY_ID` varchar(95) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `INSTANCE_NAME` varchar(200) NOT NULL,
  `FIRED_TIME` bigint(13) NOT NULL,
  `SCHED_TIME` bigint(13) NOT NULL,
  `PRIORITY` int(11) NOT NULL,
  `STATE` varchar(16) NOT NULL,
  `JOB_NAME` varchar(200) DEFAULT NULL,
  `JOB_GROUP` varchar(200) DEFAULT NULL,
  `IS_NONCONCURRENT` varchar(1) DEFAULT NULL,
  `REQUESTS_RECOVERY` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`ENTRY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ml_qrtz_fired_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for ml_qrtz_job_details
-- ----------------------------
DROP TABLE IF EXISTS `ml_qrtz_job_details`;
CREATE TABLE `ml_qrtz_job_details` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `JOB_NAME` varchar(200) NOT NULL,
  `JOB_GROUP` varchar(200) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `JOB_CLASS_NAME` varchar(250) NOT NULL,
  `IS_DURABLE` varchar(1) NOT NULL,
  `IS_NONCONCURRENT` varchar(1) NOT NULL,
  `IS_UPDATE_DATA` varchar(1) NOT NULL,
  `REQUESTS_RECOVERY` varchar(1) NOT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ml_qrtz_job_details
-- ----------------------------

-- ----------------------------
-- Table structure for ml_qrtz_locks
-- ----------------------------
DROP TABLE IF EXISTS `ml_qrtz_locks`;
CREATE TABLE `ml_qrtz_locks` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `LOCK_NAME` varchar(40) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`LOCK_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for ml_qrtz_paused_trigger_grps
-- ----------------------------
DROP TABLE IF EXISTS `ml_qrtz_paused_trigger_grps`;
CREATE TABLE `ml_qrtz_paused_trigger_grps` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ml_qrtz_paused_trigger_grps
-- ----------------------------

-- ----------------------------
-- Table structure for ml_qrtz_scheduler_state
-- ----------------------------
DROP TABLE IF EXISTS `ml_qrtz_scheduler_state`;
CREATE TABLE `ml_qrtz_scheduler_state` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `INSTANCE_NAME` varchar(200) NOT NULL,
  `LAST_CHECKIN_TIME` bigint(13) NOT NULL,
  `CHECKIN_INTERVAL` bigint(13) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`INSTANCE_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for ml_qrtz_simple_triggers
-- ----------------------------
DROP TABLE IF EXISTS `ml_qrtz_simple_triggers`;
CREATE TABLE `ml_qrtz_simple_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `REPEAT_COUNT` bigint(7) NOT NULL,
  `REPEAT_INTERVAL` bigint(12) NOT NULL,
  `TIMES_TRIGGERED` bigint(10) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `ml_qrtz_simple_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `ml_qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ml_qrtz_simple_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for ml_qrtz_simprop_triggers
-- ----------------------------
DROP TABLE IF EXISTS `ml_qrtz_simprop_triggers`;
CREATE TABLE `ml_qrtz_simprop_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `STR_PROP_1` varchar(512) DEFAULT NULL,
  `STR_PROP_2` varchar(512) DEFAULT NULL,
  `STR_PROP_3` varchar(512) DEFAULT NULL,
  `INT_PROP_1` int(11) DEFAULT NULL,
  `INT_PROP_2` int(11) DEFAULT NULL,
  `LONG_PROP_1` bigint(20) DEFAULT NULL,
  `LONG_PROP_2` bigint(20) DEFAULT NULL,
  `DEC_PROP_1` decimal(13,4) DEFAULT NULL,
  `DEC_PROP_2` decimal(13,4) DEFAULT NULL,
  `BOOL_PROP_1` varchar(1) DEFAULT NULL,
  `BOOL_PROP_2` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `ml_qrtz_simprop_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `ml_qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ml_qrtz_simprop_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for ml_qrtz_triggers
-- ----------------------------
DROP TABLE IF EXISTS `ml_qrtz_triggers`;
CREATE TABLE `ml_qrtz_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `JOB_NAME` varchar(200) NOT NULL,
  `JOB_GROUP` varchar(200) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `NEXT_FIRE_TIME` bigint(13) DEFAULT NULL,
  `PREV_FIRE_TIME` bigint(13) DEFAULT NULL,
  `PRIORITY` int(11) DEFAULT NULL,
  `TRIGGER_STATE` varchar(16) NOT NULL,
  `TRIGGER_TYPE` varchar(8) NOT NULL,
  `START_TIME` bigint(13) NOT NULL,
  `END_TIME` bigint(13) DEFAULT NULL,
  `CALENDAR_NAME` varchar(200) DEFAULT NULL,
  `MISFIRE_INSTR` smallint(2) DEFAULT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `SCHED_NAME` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`) USING BTREE,
  CONSTRAINT `ml_qrtz_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) REFERENCES `ml_qrtz_job_details` (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ml_qrtz_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for ml_scheduler_group
-- ----------------------------
DROP TABLE IF EXISTS `ml_scheduler_group`;
CREATE TABLE `ml_scheduler_group` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `APP_NAME` varchar(64) NOT NULL COMMENT '执行器AppName',
  `TITLE` varchar(64) NOT NULL COMMENT '执行器名称',
  `ADDRESS_TYPE` int(4) NOT NULL DEFAULT '0' COMMENT '执行器地址类型：0=自动注册、1=手动录入',
  `ADDRESS_LIST` varchar(512) DEFAULT NULL COMMENT '注册执行器地址列表，多地址逗号分隔',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of ml_scheduler_group
-- ----------------------------

-- ----------------------------
-- Table structure for ml_scheduler_group_detail
-- ----------------------------
DROP TABLE IF EXISTS `ml_scheduler_group_detail`;
CREATE TABLE `ml_scheduler_group_detail` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `APP_NAME` varchar(255) NOT NULL,
  `ADDRESS` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=149 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of ml_scheduler_group_detail
-- ----------------------------

-- ----------------------------
-- Table structure for ml_scheduler_job
-- ----------------------------
DROP TABLE IF EXISTS `ml_scheduler_job`;
CREATE TABLE `ml_scheduler_job` (
  `JOB_ID` int(11) NOT NULL AUTO_INCREMENT,
  `JOB_NAME` varchar(255) CHARACTER SET utf8mb4 NOT NULL,
  `VERSION` int(5) NOT NULL,
  `CRON_EXPRESSION` varchar(50) DEFAULT NULL,
  `CRON_JSON` varchar(255) DEFAULT NULL,
  `DEPENDFORMER` tinyint(1) DEFAULT '0' COMMENT '是否依赖上一周期:0-false,1-true',
  `TIMEOUT` double(10,5) DEFAULT '0.00000',
  `RUNIMMEDIATELY` tinyint(1) DEFAULT '0' COMMENT '是否立即运行:0-false,1-true',
  `JOBDETAIL_INFO` blob COMMENT '作业的任务列表信息，用于方便展示',
  `CONDITION_INFO` blob,
  `STATE` int(1) NOT NULL DEFAULT '0' COMMENT '0-下线1-上线；页面均展示',
  `PID` int(11) DEFAULT NULL COMMENT '原型id，最初版本id',
  `DELETE_FLAG` int(1) NOT NULL DEFAULT '0' COMMENT '任务状态：0-未删除，1-以删除',
  `CREATE_TIME` datetime NOT NULL,
  `CREATE_OPER` varchar(20) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  `UPDATE_OPER` varchar(20) DEFAULT NULL,
  `COMMENT` blob COMMENT '备注',
  `UPDATE_CONTENT` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`JOB_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=90 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ml_scheduler_job
-- ----------------------------

-- ----------------------------
-- Table structure for ml_scheduler_job_log
-- ----------------------------
DROP TABLE IF EXISTS `ml_scheduler_job_log`;
CREATE TABLE `ml_scheduler_job_log` (
  `JOB_LOG_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID AUTO_INCREMENT',
  `JOB_ID` int(11) NOT NULL,
  `JOB_PID` int(11) NOT NULL COMMENT '版本跟踪id',
  `JOB_TRIGGER_TIME` datetime DEFAULT NULL COMMENT '调度-时间',
  `JOB_HANDLE_STATE` int(2) NOT NULL COMMENT '执行结果-状态：0-运行中，1-成功，2-失败, 3-待运行',
  `JOB_HANDLE_MSG` varchar(2048) DEFAULT NULL COMMENT '执行结果-日志',
  `JOB_HANDLE_TIME` datetime DEFAULT NULL COMMENT '执行-时间',
  `JOB_HANDLE_FINISH_TIME` datetime DEFAULT NULL COMMENT '执行完成时间',
  PRIMARY KEY (`JOB_LOG_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1413 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of ml_scheduler_job_log
-- ----------------------------

-- ----------------------------
-- Table structure for ml_scheduler_statistics
-- ----------------------------
DROP TABLE IF EXISTS `ml_scheduler_statistics`;
CREATE TABLE `ml_scheduler_statistics` (
  `STATISTICS_ID` int(11) NOT NULL AUTO_INCREMENT,
  `SCHEDULER` varchar(2048) NOT NULL COMMENT '调度器IP:PORT',
  `JOB_CALL_COUNT` int(11) NOT NULL COMMENT 'JOB调度次数',
  `TASK_CALL_COUNT` int(11) NOT NULL COMMENT 'task调度次数',
  `JOB_EXCEPTION_COUNT` int(11) NOT NULL COMMENT 'JOB异常数量',
  `JOB_FINISHED_COUNT` int(11) NOT NULL COMMENT 'JOB已完成数量',
  `TASK_EXCEPTION_COUNT` int(11) NOT NULL COMMENT 'task异常数量',
  `TASK_FINISHED_COUNT` int(11) NOT NULL COMMENT 'task已完成数量',
  `LAST_TIME` datetime NOT NULL COMMENT '上次统计时间',
  `CREATE_TIME` datetime NOT NULL,
  PRIMARY KEY (`STATISTICS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of ml_scheduler_statistics
-- ----------------------------

-- ----------------------------
-- Table structure for ml_scheduler_task
-- ----------------------------
DROP TABLE IF EXISTS `ml_scheduler_task`;
CREATE TABLE `ml_scheduler_task` (
  `TASK_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `TASK_NAME` varchar(50) NOT NULL COMMENT '任务名称',
  `APP_NAME` varchar(50) NOT NULL COMMENT '执行器appname',
  `TASK_DESC` varchar(255) DEFAULT NULL COMMENT '任务描述',
  `DELETE_FLAG` int(1) NOT NULL DEFAULT '0' COMMENT '状态：0——可用，1——不可用',
  `TASK_SOURCE` int(1) NOT NULL DEFAULT '0' COMMENT '任务来源：0——自动注册，1——手动注册',
  `CREATE_TIME` datetime NOT NULL,
  `UPDATE_TIME` datetime NOT NULL,
  PRIMARY KEY (`TASK_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of ml_scheduler_task
-- ----------------------------

-- ----------------------------
-- Table structure for ml_scheduler_task_instance
-- ----------------------------
DROP TABLE IF EXISTS `ml_scheduler_task_instance`;
CREATE TABLE `ml_scheduler_task_instance` (
  `TASK_INSTANCE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `JOB_ID` int(11) NOT NULL,
  `TASK_ID` int(11) NOT NULL,
  `PRE_TASK_INSTANCE_ID` varchar(50) DEFAULT NULL COMMENT '前置任务',
  `INPUT_TYPE` varchar(255) NOT NULL DEFAULT 'from_ui' COMMENT 'task入参来源：{from_ui,from_task}',
  `INPUT_VALUE` blob COMMENT 'task入参参数值',
  `ROUTE_STATEGY` int(2) NOT NULL DEFAULT '0' COMMENT '路由策略:0——第一个，1——随机，2——最后一个',
  `FAILOVER` int(2) NOT NULL DEFAULT '0' COMMENT '失败处理策略：0——忽略继续执行，1——失败重试，2——作业结束',
  `FAILOVER_VALUE` varchar(255) DEFAULT NULL COMMENT '失败处理策略附属参数',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `CREATE_TIME` datetime NOT NULL COMMENT '创建时间',
  `READ_TIMEOUT` double(10,5) DEFAULT '0.00000' COMMENT '接口数据返回超时时间，单位小时',
  PRIMARY KEY (`TASK_INSTANCE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=111 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of ml_scheduler_task_instance
-- ----------------------------

-- ----------------------------
-- Table structure for ml_scheduler_task_instance_log
-- ----------------------------
DROP TABLE IF EXISTS `ml_scheduler_task_instance_log`;
CREATE TABLE `ml_scheduler_task_instance_log` (
  `TASK_INSTANCE_LOG_ID` int(11) NOT NULL AUTO_INCREMENT,
  `JOB_LOG_ID` int(11) NOT NULL,
  `TASK_INSTANCE_ID` int(11) NOT NULL,
  `DEPEND_ID` int(11) NOT NULL COMMENT '依赖id，以此作为执行顺序',
  `TASK_MSG` varchar(2048) DEFAULT NULL COMMENT '状态描述信息,如：异常信息，SUCCESS等',
  `TASK_STATE` int(2) NOT NULL COMMENT '状态值：0-运行中，1-成功，2-失败, 3-待运行',
  `TASK_HANDLE_TIME` datetime DEFAULT NULL COMMENT '开始执行时间',
  `TASK_FINISH_TIME` datetime DEFAULT NULL COMMENT '结束时间',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `ADDRESS` varchar(30) DEFAULT NULL COMMENT '非分布任务停止使用url',
  PRIMARY KEY (`TASK_INSTANCE_LOG_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1415 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of ml_scheduler_task_instance_log
-- ----------------------------
