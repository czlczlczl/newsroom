/*
Navicat MySQL Data Transfer

Source Server         : bendi
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : newsroom

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-04-27 23:54:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `announcements`
-- ----------------------------
DROP TABLE IF EXISTS `announcements`;
CREATE TABLE `announcements` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL COMMENT '公告标题',
  `content` text NOT NULL COMMENT '公告内容',
  `upload` text COMMENT '公告附件',
  `date_pub` datetime NOT NULL COMMENT '发布时间',
  `pic` text COMMENT '上传的图片名，|当间隔符',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='公告';

-- ----------------------------
-- Records of announcements
-- ----------------------------
INSERT INTO `announcements` VALUES ('1', '公告一', '公告一内容', '', '2018-04-01 21:07:54', null);
INSERT INTO `announcements` VALUES ('2', '公告二', '公告二内容', '', '2018-04-02 21:08:59', null);
INSERT INTO `announcements` VALUES ('3', '公告三', '公告三内容', '', '2018-04-02 21:10:54', null);

-- ----------------------------
-- Table structure for `articles`
-- ----------------------------
DROP TABLE IF EXISTS `articles`;
CREATE TABLE `articles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL COMMENT '稿件标题',
  `format` varchar(255) NOT NULL COMMENT '稿件格式，以分号串的格式存储',
  `academicsec` int(11) NOT NULL COMMENT '学术领域编号',
  `column` int(11) NOT NULL COMMENT '栏目',
  `keyword1_cn` varchar(255) NOT NULL,
  `keyword2_cn` varchar(255) DEFAULT NULL,
  `keyword3_cn` varchar(255) DEFAULT NULL,
  `keyword4_cn` varchar(255) DEFAULT NULL,
  `keyword1_en` varchar(255) DEFAULT NULL,
  `keyword2_en` varchar(255) DEFAULT NULL,
  `keyword3_en` varchar(255) DEFAULT NULL,
  `keyword4_en` varchar(255) DEFAULT NULL,
  `summary_cn` varchar(255) NOT NULL,
  `summary_en` varchar(255) DEFAULT NULL,
  `writer_id` int(11) NOT NULL COMMENT '投稿人id',
  `writers_info` text NOT NULL COMMENT '作者信息的格式化串',
  `writer_prefer` varchar(255) DEFAULT NULL COMMENT '作者倾向审稿人，以分号分割',
  `writer_avoid` varchar(255) DEFAULT NULL COMMENT '作者回避，以分号分割',
  `date_sub` datetime NOT NULL COMMENT '稿件创建时间',
  `date_pub` datetime DEFAULT NULL COMMENT '发布时间',
  PRIMARY KEY (`id`),
  KEY `FK_articles_authors` (`writer_id`),
  KEY `FK_articles_academicsec` (`academicsec`),
  KEY `FK_articles_column` (`column`),
  CONSTRAINT `FK_articles_academicsec` FOREIGN KEY (`academicsec`) REFERENCES `type_academicsec` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_articles_authors` FOREIGN KEY (`writer_id`) REFERENCES `authors` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_articles_column` FOREIGN KEY (`column`) REFERENCES `type_column` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='稿件信息';

-- ----------------------------
-- Records of articles
-- ----------------------------
INSERT INTO `articles` VALUES ('1', '测试', '.docx;.rar', '1', '1', '测试', null, null, null, 'test', null, null, null, '测试', 'test', '1', '', null, null, '2018-05-03 10:30:08', '1970-01-01 08:00:00');
INSERT INTO `articles` VALUES ('2', '测试2', '.docx;.rar', '1', '1', '测试2', null, null, null, 'test2', null, null, null, '测试2', 'test2', '1', '', null, null, '2018-05-27 18:09:07', null);

-- ----------------------------
-- Table structure for `authors`
-- ----------------------------
DROP TABLE IF EXISTS `authors`;
CREATE TABLE `authors` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL COMMENT '邮箱',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `name` varchar(255) NOT NULL COMMENT '姓名',
  `name_pinyin` varchar(255) NOT NULL COMMENT '姓名的全拼',
  `gender` int(11) NOT NULL COMMENT '性别',
  `address` text NOT NULL COMMENT '通信地址',
  `postcode` varchar(255) NOT NULL COMMENT '邮编',
  `workspace_cn` text NOT NULL COMMENT '单位中文名',
  `workspace_en` text COMMENT '单位英文名',
  `major` int(11) NOT NULL COMMENT '专业编号',
  `education` int(11) NOT NULL COMMENT '学历编号',
  `title` varchar(255) DEFAULT NULL COMMENT '职称',
  `officetel` varchar(255) DEFAULT NULL COMMENT '办公室电话',
  `phonenum` varchar(255) NOT NULL COMMENT '手机',
  `location` int(255) NOT NULL COMMENT '国家/地区编号',
  `researchdir` varchar(255) NOT NULL COMMENT '研究方向',
  `academicsec1` int(11) NOT NULL COMMENT '学术领域编号',
  `academicsec2` int(11) DEFAULT NULL COMMENT '学术领域编号',
  `academicsec3` int(11) DEFAULT NULL COMMENT '学术领域编号',
  `introduction` text COMMENT '个人介绍',
  `safeque1` text NOT NULL COMMENT '密保问题1',
  `safeque2` text NOT NULL COMMENT '密保问题2',
  `safeque3` text NOT NULL COMMENT '密保问题3',
  `alive` int(11) NOT NULL COMMENT '有效状态',
  PRIMARY KEY (`id`),
  KEY `FK_authors_type_major` (`major`),
  KEY `FK_authors_type_education` (`education`),
  KEY `FK_authors_type_location` (`location`),
  KEY `FK_authors_type_academicsec1` (`academicsec1`),
  KEY `FK_authors_type_academicsec2` (`academicsec2`),
  KEY `FK_authors_type_academicsec3` (`academicsec3`),
  CONSTRAINT `FK_authors_type_academicsec1` FOREIGN KEY (`academicsec1`) REFERENCES `type_academicsec` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_authors_type_academicsec2` FOREIGN KEY (`academicsec2`) REFERENCES `type_academicsec` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_authors_type_academicsec3` FOREIGN KEY (`academicsec3`) REFERENCES `type_academicsec` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_authors_type_education` FOREIGN KEY (`education`) REFERENCES `type_education` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_authors_type_location` FOREIGN KEY (`location`) REFERENCES `type_location` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_authors_type_major` FOREIGN KEY (`major`) REFERENCES `type_major` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='作者信息';

-- ----------------------------
-- Records of authors
-- ----------------------------
INSERT INTO `authors` VALUES ('1', '651383842@qq.com', '649f733c3f0c8fbc3e986d47aeeb8351ebc1275f9c1481c0179ae97de9105d7e', '作者1', 'zuozhe1', '1', '四川省成都市', '610000', '电子科技大学', 'UESTC', '1', '1', '高级医师', '6666666', '13666666666', '1', '临床医学', '1', null, null, '就是六', '1:四川成都', '5:电子科技大学', '6:父母', '1');
INSERT INTO `authors` VALUES ('2', '13402883297@163.com', '300dcb1038f40301aacc96bcc7913a7940efbd0307794450b3164035bb976522', '李西炜', 'lixiwei', '1', '123', '123', '123', '123', '2', '2', '123', '123', '123', '1', '123', '1', '2', '3', '123', '1;1', '2;2', '3;3', '1');
INSERT INTO `authors` VALUES ('3', 'test1@test.com', '8e65d32a4b6ad4763f6f9d4bd5c70916d221cf4267280f0bd944504d26466e2e', 'test1', 'test1', '1', 'test1', 'test1', 'test1', 'test1', '1', '2', 'test1', 'test123', '123', '1', 'test1', '4', '5', '3', 'test1', '1;1', '2;2', '3;3', '1');
INSERT INTO `authors` VALUES ('4', '994698269@qq.com', '486ada6c3fc5b27f7996693f196a867659115bcebab864626acdb45ac9d73362', '唐港迪', 'tanggangdi', '2', '新都', '510000', '西南石油大学', 'swpu', '2', '2', '学生', '83031236', '18328068525', '1', '医学前沿', '1', null, null, '学生', '1;四川', '2;唐自成', '3;李小玲', '0');
INSERT INTO `authors` VALUES ('5', 'zuozhe@qq.com', 'b519b9dc6696029df597c3111010d3ac420ae1a58077988f387cc768d7741eef', '李四', 'lisi', '1', '四川', '512698', 'swpu', '', '1', '2', '学生', '633333', '15726957742', '1', '医学', '2', null, null, '学生', '1;四川', '2;李三', '3;小李', '1');
INSERT INTO `authors` VALUES ('6', '123456789@qq.com', 'd30c069f83be70d8f2f0b817bb09298de6d026010bf646f0764e17c5dcfbad73', '张三', 'zhangsan', '1', 'swpu', '521436', '计科院', '', '2', '2', '学生', '83032569', '12345678955', '1', '基础医学', '1', null, null, '学生', '1;四川', '2;张四', '3;小李', '1');

-- ----------------------------
-- Table structure for `bank_safeque`
-- ----------------------------
DROP TABLE IF EXISTS `bank_safeque`;
CREATE TABLE `bank_safeque` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `safeque` text NOT NULL COMMENT '密保问题题目',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bank_safeque
-- ----------------------------
INSERT INTO `bank_safeque` VALUES ('1', '我的家乡是哪里？');
INSERT INTO `bank_safeque` VALUES ('2', '我的父亲叫什么？');
INSERT INTO `bank_safeque` VALUES ('3', '我的母亲叫什么？');
INSERT INTO `bank_safeque` VALUES ('4', '我最难忘的一天是什么？');
INSERT INTO `bank_safeque` VALUES ('5', '我的母校是什么？');
INSERT INTO `bank_safeque` VALUES ('6', '我的最爱的人是谁？');

-- ----------------------------
-- Table structure for `certificate`
-- ----------------------------
DROP TABLE IF EXISTS `certificate`;
CREATE TABLE `certificate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL COMMENT '证书名称',
  `content` text COMMENT '证书说明',
  `pic` text COMMENT '上传的图片名，|当间隔符',
  `date_pub` datetime NOT NULL COMMENT '证书发布时间',
  `weight` int(11) DEFAULT NULL COMMENT '优先序号',
  `alive` int(1) DEFAULT NULL COMMENT '是否启用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of certificate
-- ----------------------------
INSERT INTO `certificate` VALUES ('2', '医学证书', ' 这是 这是 这是第一个 这是第一个医学 这是第一个医学证书', '123.jpc', '2019-04-19 16:21:51', '1', '0');
INSERT INTO `certificate` VALUES ('3', '医书', ' 这是 这是 这是第一个 这是第一个医学 这是第一个医学证书', '123.jpc', '2019-04-19 16:21:59', '1', '1');
INSERT INTO `certificate` VALUES ('4', '医书', ' 这是第一个医学 这是第一个医学证书', '123.jpc', '2019-04-19 16:22:03', '1', '1');
INSERT INTO `certificate` VALUES ('5', '医书', ' 这是第一个医学 这是第一个医学证书', '123.jpc', '2019-04-19 16:22:05', '1', '1');
INSERT INTO `certificate` VALUES ('6', '医书', ' 这是第一个医学 这是第一个医学证书', '123.jpc', '2019-04-19 16:22:06', '1', '1');
INSERT INTO `certificate` VALUES ('7', '医书', ' 这是第一个医学 这是第一个医学证书', '123.jpc', '2019-04-19 16:22:07', '1', '1');
INSERT INTO `certificate` VALUES ('8', '医书', ' 这是第一个医学 这是第一个医学证书', '123.jpc', '2019-04-19 16:22:07', '1', '1');

-- ----------------------------
-- Table structure for `editors`
-- ----------------------------
DROP TABLE IF EXISTS `editors`;
CREATE TABLE `editors` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL COMMENT '工号',
  `password` varchar(255) NOT NULL DEFAULT '12345678' COMMENT '密码',
  `name` varchar(255) NOT NULL COMMENT '编辑姓名',
  `gender` int(11) NOT NULL COMMENT '编辑性别',
  `role` int(11) NOT NULL COMMENT '编辑等级标记，包含两种状态：\r\n（1）主编：0\r\n（2）编辑：1\r\n',
  `safeque1` text NOT NULL COMMENT '密保问题',
  `safeque2` text NOT NULL COMMENT '密保问题2',
  `safeque3` text NOT NULL COMMENT '密保问题3',
  `alive` int(11) NOT NULL DEFAULT '1' COMMENT '有效状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='编辑信息';

-- ----------------------------
-- Records of editors
-- ----------------------------
INSERT INTO `editors` VALUES ('1', 'test@test.com', 'e7b4bc122969abd71d661312c1acda7a11f20d9d982a8380a8e9da5db99c5be9', '主编2', '1', '0', '', '', '', '1');
INSERT INTO `editors` VALUES ('3', '651383842@qq.com', '649f733c3f0c8fbc3e986d47aeeb8351ebc1275f9c1481c0179ae97de9105d7e', '编辑3', '1', '1', '', '', '', '1');
INSERT INTO `editors` VALUES ('4', 'test4@test.com', '5014aeec1020124fbf915ebde9b017029978513e801a90462f06b67d2bf67fc1', '编辑4', '1', '1', '1;1', '2;2', '3;3', '1');
INSERT INTO `editors` VALUES ('5', 'test5@test.com', 'cd0c7485bc91734f11d6f509f00e6a3cdf29f10147bf8306d7d9301f5b3dbc87', '编辑5', '1', '1', '1;1', '2;2', '3;3', '1');
INSERT INTO `editors` VALUES ('6', 'test1@test.com', '8e65d32a4b6ad4763f6f9d4bd5c70916d221cf4267280f0bd944504d26466e2e', '编辑1', '1', '1', '1;眉山', '2;张三', '3;小李', '1');
INSERT INTO `editors` VALUES ('7', 'test6@test.com', 'ca0cb25f995e5b473ea589fad8a9ddfd4227927efb18776f5a9dad07cf9d84dc', '编辑6', '1', '1', '1;1', '2;2', '3;3', '1');
INSERT INTO `editors` VALUES ('8', 'test7@test.com', 'bb958e1581c8bcd607d22cc861522a66a7f11f0f5c80720c56c3d8067c69ea3c', '编辑7', '1', '0', '1;1', '2;2', '3;3', '1');

-- ----------------------------
-- Table structure for `friendlink`
-- ----------------------------
DROP TABLE IF EXISTS `friendlink`;
CREATE TABLE `friendlink` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `linkname` varchar(255) NOT NULL COMMENT '友情链接名称',
  `linkurl` varchar(255) NOT NULL COMMENT '友情链接网址',
  `weight` int(11) NOT NULL COMMENT '友情链接权重',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='友情链接';

-- ----------------------------
-- Records of friendlink
-- ----------------------------
INSERT INTO `friendlink` VALUES ('1', '百度', 'www.baidu.com', '0');
INSERT INTO `friendlink` VALUES ('2', '网易', 'www.wangyi.com', '0');
INSERT INTO `friendlink` VALUES ('3', '京东', 'www.jd.com', '2');
INSERT INTO `friendlink` VALUES ('5', '百度', 'www.baidu.com', '7');

-- ----------------------------
-- Table structure for `infocenter`
-- ----------------------------
DROP TABLE IF EXISTS `infocenter`;
CREATE TABLE `infocenter` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '资料中心的一条资料名字',
  `content` text NOT NULL COMMENT '资料对应的文件名',
  `date_pub` datetime NOT NULL,
  `priority` int(11) NOT NULL DEFAULT '1' COMMENT '优先级 1最高',
  `alive` int(11) NOT NULL DEFAULT '1' COMMENT '0是被删除，1是未被删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of infocenter
-- ----------------------------
INSERT INTO `infocenter` VALUES ('1', '投审流程', 'aaa.txt', '2019-04-12 23:05:24', '1', '1');
INSERT INTO `infocenter` VALUES ('2', '投审注意事项', 'bbb.txt', '2019-03-07 23:05:32', '1', '1');

-- ----------------------------
-- Table structure for `invoices`
-- ----------------------------
DROP TABLE IF EXISTS `invoices`;
CREATE TABLE `invoices` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_article` int(11) NOT NULL COMMENT '稿件id',
  `flag` int(11) DEFAULT NULL COMMENT '是否需要发票标记',
  `format` varchar(255) NOT NULL COMMENT '票据格式',
  `receipt_title` varchar(255) DEFAULT NULL COMMENT '发票抬头',
  `receipt_num` varchar(255) DEFAULT NULL COMMENT '发票税号',
  `address` text COMMENT '邮寄地址',
  `receiver` varchar(255) DEFAULT NULL COMMENT '收件人',
  `type` int(11) NOT NULL COMMENT '费用类型',
  `expense` int(255) NOT NULL COMMENT '应缴金额',
  `date` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `FK_invoices_articles` (`id_article`),
  CONSTRAINT `FK_invoices_articles` FOREIGN KEY (`id_article`) REFERENCES `articles` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of invoices
-- ----------------------------
INSERT INTO `invoices` VALUES ('1', '1', '0', '', null, null, null, null, '1', '66', '2018-06-01 17:33:56');
INSERT INTO `invoices` VALUES ('2', '1', '0', '', null, null, null, null, '2', '132', '2018-06-01 17:34:42');

-- ----------------------------
-- Table structure for `main`
-- ----------------------------
DROP TABLE IF EXISTS `main`;
CREATE TABLE `main` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL COMMENT '主页上方横栏中的具体分区名称（如编委会）',
  `content` text NOT NULL COMMENT '具体页面的内容',
  `priority` int(11) NOT NULL DEFAULT '1',
  `alive` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of main
-- ----------------------------
INSERT INTO `main` VALUES ('1', '编委会', '编委会内容', '1', '1');
INSERT INTO `main` VALUES ('2', '投稿须知', '投稿须知内容', '1', '1');
INSERT INTO `main` VALUES ('3', '联系方式', '联系方式内容', '1', '1');

-- ----------------------------
-- Table structure for `newsroominfo`
-- ----------------------------
DROP TABLE IF EXISTS `newsroominfo`;
CREATE TABLE `newsroominfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `year` int(11) NOT NULL COMMENT '期刊年份',
  `standard` int(11) NOT NULL COMMENT '期刊制式，包含3个状态：\r\n（1）季刊：4\r\n（2）双月刊：6\r\n（3）月刊：12',
  `admin` varchar(255) NOT NULL COMMENT '管理员用户名',
  `password` varchar(255) NOT NULL COMMENT '管理员密码',
  `reviewfee` int(11) NOT NULL DEFAULT '60' COMMENT ' 审稿费',
  `pagecharges` int(11) NOT NULL DEFAULT '100' COMMENT '版面费',
  `content` text NOT NULL,
  `articlenum` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of newsroominfo
-- ----------------------------
INSERT INTO `newsroominfo` VALUES ('1', '2018', '12', 'admin', '12345678', '66', '233', '{\"ddl\":[1525855239000,1526112701000,1526030890000,1526030892000,1526030894000,1526031629000,1526030897000,1526030898000,1526635700000,1527240502000,1526117303000,1526745600000],\"num\":[16,15,15,15,15,15,15,15,15,15,15,15]}', '15');
INSERT INTO `newsroominfo` VALUES ('4', '2019', '12', 'admin', '12345678', '66', '233', '{\"ddl\":[1525855239000,1526112701000,1526030890000,1526030892000,1526030894000,1526031629000,1526030897000,1526030898000,1526635700000,1527240502000,1526117303000,1526722104000],\"num\":[16,15,15,15,15,15,15,15,15,15,15,15]}', '15');

-- ----------------------------
-- Table structure for `professors`
-- ----------------------------
DROP TABLE IF EXISTS `professors`;
CREATE TABLE `professors` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL COMMENT '工号',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `name` varchar(255) NOT NULL COMMENT '审稿人姓名',
  `gender` int(11) NOT NULL COMMENT '审稿人性别',
  `address` varchar(255) DEFAULT NULL,
  `bank` varchar(255) DEFAULT NULL,
  `card` varchar(255) DEFAULT NULL COMMENT '银行卡号',
  `academicsec1` int(11) NOT NULL COMMENT '审稿人学术领域编号',
  `academicsec2` int(11) DEFAULT NULL,
  `academicsec3` int(11) DEFAULT NULL,
  `safeque1` text NOT NULL COMMENT '密保问题1',
  `safeque2` text NOT NULL COMMENT '密保问题2',
  `safeque3` text NOT NULL COMMENT '密保问题3',
  `alive` int(11) NOT NULL DEFAULT '1' COMMENT '有效状态',
  PRIMARY KEY (`id`),
  KEY `FK_professors_type_academicsec1` (`academicsec1`),
  KEY `FK_professors_type_academicsec2` (`academicsec2`),
  KEY `FK_professors_type_academicsec3` (`academicsec3`),
  CONSTRAINT `FK_professors_type_academicsec1` FOREIGN KEY (`academicsec1`) REFERENCES `type_academicsec` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_professors_type_academicsec2` FOREIGN KEY (`academicsec2`) REFERENCES `type_academicsec` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_professors_type_academicsec3` FOREIGN KEY (`academicsec3`) REFERENCES `type_academicsec` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='审稿人信息';

-- ----------------------------
-- Records of professors
-- ----------------------------
INSERT INTO `professors` VALUES ('4', '651383842@qq.com', '649f733c3f0c8fbc3e986d47aeeb8351ebc1275f9c1481c0179ae97de9105d7e', 'qq', '2', '111', '11111', '3333333333', '1', '2', '3', '1;1', '2;2', '3;3', '1');
INSERT INTO `professors` VALUES ('5', 'test5@test.com', 'cd0c7485bc91734f11d6f509f00e6a3cdf29f10147bf8306d7d9301f5b3dbc87', '王五', '1', null, null, '', '2', '3', '4', '1;1', '2;2', '3;3', '1');
INSERT INTO `professors` VALUES ('6', 'test6@test.com', '2328455d36c106566539a4719af6438b76325ad7cdbf5543b33d49f4ce07c441', '马六', '1', null, null, '', '3', '4', '5', '1;1', '2;2', '3;3', '1');
INSERT INTO `professors` VALUES ('7', 'test7@test.com', '1d94f42e4da23f02f07a37bb705cb0a763d620b136d9a528a555c8d8a9b728eb', '审稿人7', '1', null, null, '', '2', '1', '4', '1;1', '2;2', '3;3', '1');
INSERT INTO `professors` VALUES ('8', 'test8@test.com', '16f8f414fbd8855852f9a2b55436ba41d5f804ab3c9e6f3bcffef2ae919301d6', '审稿人8', '1', null, null, '', '2', '3', '4', '1;1', '2;2', '3;3', '1');
INSERT INTO `professors` VALUES ('9', 'shengaoren@qq.com', 'e167e3131b3d361339a27eb51c5d567cca2fc52dae10385db47bec6e80aec6bb', '审稿人测试', '1', null, null, null, '1', null, null, '1;四川', '3;小王', '2;小李', '1');

-- ----------------------------
-- Table structure for `tasks`
-- ----------------------------
DROP TABLE IF EXISTS `tasks`;
CREATE TABLE `tasks` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_article` int(11) NOT NULL COMMENT '稿件id',
  `id_role` int(11) NOT NULL COMMENT '稿件处理人id',
  `content` text COMMENT '审核结果详细内容',
  `stat` int(11) NOT NULL COMMENT '稿件状态，包含7个状态：\r\n（1）：未分配：0\r\n（2）：审阅中：1\r\n（3）：未通过：2\r\n（4）：待修改：3\r\n（5）：通过：4\r\n（6）：格式确认：5\r\n（7）：缴费：6\r\n（8）：重审：7',
  `role` int(11) NOT NULL COMMENT '角色表名编号，包含4个值：\r\n（1）作者：1\r\n（2）主编：2\r\n（3）编辑：3\r\n（4）审稿人：4',
  `flag` tinyint(4) NOT NULL DEFAULT '0' COMMENT '任务状态，包含2种：\r\n（1）未完成：0\r\n（2）已完成：1',
  `date` datetime NOT NULL COMMENT '该记录产生的时间',
  PRIMARY KEY (`id`),
  KEY `FK_tasks_articles` (`id_article`),
  KEY `FK_tasks_type_role` (`role`),
  CONSTRAINT `FK_tasks_articles` FOREIGN KEY (`id_article`) REFERENCES `articles` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_tasks_type_role` FOREIGN KEY (`role`) REFERENCES `type_role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tasks
-- ----------------------------
INSERT INTO `tasks` VALUES ('1', '1', '3', null, '0', '3', '1', '2019-04-26 21:30:43');
INSERT INTO `tasks` VALUES ('2', '1', '3', null, '4', '3', '1', '2019-04-26 21:31:56');
INSERT INTO `tasks` VALUES ('3', '1', '4', '1', '6', '4', '1', '2019-04-26 21:32:46');
INSERT INTO `tasks` VALUES ('4', '1', '7', '2', '2', '4', '1', '2019-04-26 21:33:06');
INSERT INTO `tasks` VALUES ('5', '1', '3', '3', '4', '3', '1', '2019-04-26 21:34:18');
INSERT INTO `tasks` VALUES ('6', '1', '3', '3', '3', '3', '1', '2019-04-26 21:35:48');
INSERT INTO `tasks` VALUES ('7', '1', '3', '3', '3', '1', '1', '2019-04-26 21:37:16');
INSERT INTO `tasks` VALUES ('8', '1', '3', null, '7', '3', '1', '2019-04-26 21:38:37');
INSERT INTO `tasks` VALUES ('9', '1', '4', '11', '7', '4', '1', '2019-04-26 21:39:57');
INSERT INTO `tasks` VALUES ('10', '1', '7', '22', '7', '4', '1', '2019-04-26 21:40:12');
INSERT INTO `tasks` VALUES ('11', '1', '3', '33', '5', '3', '1', '2019-04-26 21:40:38');
INSERT INTO `tasks` VALUES ('12', '1', '3', '33', '5', '1', '1', '2019-04-26 21:41:26');
INSERT INTO `tasks` VALUES ('13', '1', '3', '33', '4', '3', '1', '2019-04-26 21:42:46');
INSERT INTO `tasks` VALUES ('14', '1', '3', '33', '6', '3', '1', '2019-04-26 21:43:13');

-- ----------------------------
-- Table structure for `test`
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test
-- ----------------------------

-- ----------------------------
-- Table structure for `type_academicsec`
-- ----------------------------
DROP TABLE IF EXISTS `type_academicsec`;
CREATE TABLE `type_academicsec` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `academicsec` varchar(255) NOT NULL COMMENT '学术领域',
  `id_editor` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of type_academicsec
-- ----------------------------
INSERT INTO `type_academicsec` VALUES ('1', '基础医学', '3');
INSERT INTO `type_academicsec` VALUES ('2', '临床医学', '3');
INSERT INTO `type_academicsec` VALUES ('3', '内科医学', '3');
INSERT INTO `type_academicsec` VALUES ('4', '基础中医', '3');
INSERT INTO `type_academicsec` VALUES ('5', '中医针灸', '1');
INSERT INTO `type_academicsec` VALUES ('6', '外科医学', '1');
INSERT INTO `type_academicsec` VALUES ('7', '神经医学', '1');
INSERT INTO `type_academicsec` VALUES ('8', '预防医学', '1');
INSERT INTO `type_academicsec` VALUES ('9', '皮肤医学', '1');
INSERT INTO `type_academicsec` VALUES ('10', '检验医学', '4');
INSERT INTO `type_academicsec` VALUES ('11', '保健医学', '4');
INSERT INTO `type_academicsec` VALUES ('12', '康复医学', '4');
INSERT INTO `type_academicsec` VALUES ('13', '护理学', '4');

-- ----------------------------
-- Table structure for `type_column`
-- ----------------------------
DROP TABLE IF EXISTS `type_column`;
CREATE TABLE `type_column` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `column` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='期刊栏目';

-- ----------------------------
-- Records of type_column
-- ----------------------------
INSERT INTO `type_column` VALUES ('1', '综述');
INSERT INTO `type_column` VALUES ('2', '中医');
INSERT INTO `type_column` VALUES ('3', '国内西医');
INSERT INTO `type_column` VALUES ('4', '国外西医');
INSERT INTO `type_column` VALUES ('5', '医学前沿');
INSERT INTO `type_column` VALUES ('6', '生物医学');
INSERT INTO `type_column` VALUES ('7', '现代医药卫生');
INSERT INTO `type_column` VALUES ('8', '护理实践与研究');
INSERT INTO `type_column` VALUES ('9', '民族民间医药');

-- ----------------------------
-- Table structure for `type_education`
-- ----------------------------
DROP TABLE IF EXISTS `type_education`;
CREATE TABLE `type_education` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `education` varchar(255) NOT NULL COMMENT '学历',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of type_education
-- ----------------------------
INSERT INTO `type_education` VALUES ('1', '高中生');
INSERT INTO `type_education` VALUES ('2', '本科生');
INSERT INTO `type_education` VALUES ('3', '研究生');
INSERT INTO `type_education` VALUES ('4', '讲师');
INSERT INTO `type_education` VALUES ('5', '副教授');
INSERT INTO `type_education` VALUES ('6', '教授');
INSERT INTO `type_education` VALUES ('7', '其他');

-- ----------------------------
-- Table structure for `type_location`
-- ----------------------------
DROP TABLE IF EXISTS `type_location`;
CREATE TABLE `type_location` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `location` varchar(255) NOT NULL COMMENT '国家/地区',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of type_location
-- ----------------------------
INSERT INTO `type_location` VALUES ('1', '中华人民共和国');
INSERT INTO `type_location` VALUES ('2', '其他');

-- ----------------------------
-- Table structure for `type_major`
-- ----------------------------
DROP TABLE IF EXISTS `type_major`;
CREATE TABLE `type_major` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `major` varchar(255) NOT NULL COMMENT '专业',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of type_major
-- ----------------------------
INSERT INTO `type_major` VALUES ('1', '医学');
INSERT INTO `type_major` VALUES ('2', '其他');

-- ----------------------------
-- Table structure for `type_role`
-- ----------------------------
DROP TABLE IF EXISTS `type_role`;
CREATE TABLE `type_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roletable` varchar(255) DEFAULT NULL COMMENT '角色表名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of type_role
-- ----------------------------
INSERT INTO `type_role` VALUES ('1', 'authors');
INSERT INTO `type_role` VALUES ('2', 'editors');
INSERT INTO `type_role` VALUES ('3', 'editors');
INSERT INTO `type_role` VALUES ('4', 'professors');

-- ----------------------------
-- Procedure structure for `articles insert`
-- ----------------------------
DROP PROCEDURE IF EXISTS `articles insert`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `articles insert`()
BEGIN
DECLARE i int;
set i=1;
WHILE i<20000 do
INSERT INTO `newsroom`.`articles` (`title`, `format`, `academicsec`, `keyword1_cn`, `keyword2_cn`, `keyword3_cn`, `keyword4_cn`, `keyword1_en`, `keyword2_en`, `keyword3_en`, `keyword4_en`, `summary_cn`, `summary_en`, `writer_id`, `writers_info`, `date_pub`) 
VALUES (CONCAT("title",i), 'doc;', CONCAT("",(i%3)+1), CONCAT("keyword_cn",i), '三大', 'e', 'a',CONCAT("keyword_en",i), 's', 'c', 's', CONCAT("summary_cn",i), NULL, '2', '{\"a\":\"111\"}','2018-03-13 00:00:00');
SET i=i+1; 
END 
WHILE;

END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for `professor insert`
-- ----------------------------
DROP PROCEDURE IF EXISTS `professor insert`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `professor insert`()
BEGIN
DECLARE i int;
set i=1;
WHILE i<50000 do
INSERT INTO `newsroom`.`professors` (`username`, `password`, `name`, `gender`, `academicsec`, `safeque1`, `safeque2`, `safeque3`) VALUES (CONCAT('201522',i), CONCAT('czlpwd',i), CONCAT('czl',i), '1', '3', '1,a1', '2,a2', '3,a3');

SET i=i+1; 
END 
WHILE;

END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for `upateprofessor`
-- ----------------------------
DROP PROCEDURE IF EXISTS `upateprofessor`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `upateprofessor`()
BEGIN
DECLARE i int;
set i=1;
WHILE i<50008 do
UPDATE `newsroom`.`professors` SET alive=1;

SET i=i+1; 
END 
WHILE;

END
;;
DELIMITER ;
