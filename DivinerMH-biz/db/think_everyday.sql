/*
 Navicat Premium Data Transfer

 Source Server         : 139.196.143.72_3306 - ECS
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : 139.196.143.72:3306
 Source Schema         : think_everyday

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 11/01/2022 17:19:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_article
-- ----------------------------
DROP TABLE IF EXISTS `tb_article`;
CREATE TABLE `tb_article`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `title` varchar(400) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题',
  `author` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '作者',
  `des` mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '文章描述',
  `content` mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '内容',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '0' COMMENT '状态：0-启用 1-禁用',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '逻辑删除：0-正常 1-删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '文章表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_article
-- ----------------------------
INSERT INTO `tb_article` VALUES (1, 'How to write an article?', 'tycoding', '<h1 id=\"h1-how-to-write-an-article-\" style=\"font-family: Roboto, sans-serif;\">How to write an article?</h1><h2 id=\"h2-markdown-rules\" style=\"font-family: Roboto, sans-serif;\"><a name=\"Markdown rules\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>Markdown rules</h2><p><span style=\"font-weight: bolder;\">For example</span></p><p><a href=\"https://tycoding.cn/\">https://tycoding.cn</a></p>', '<h1 id=\"h1-how-to-write-an-article-\"><a name=\"How to write an article?\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>How to write an article?</h1><h2 id=\"h2-markdown-rules\"><a name=\"Markdown rules\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>Markdown rules</h2><p><strong>For example</strong></p>\n<p><a href=\"https://tycoding.cn\">https://tycoding.cn</a></p>\n<pre><code class=\"lang-java\">public static void main(String[] args) {\n        System.out.println(\"Hello World\");\n}\n</code></pre>\n<p><img src=\"http://img.api.tycoding.cn/1568958650973.jpeg\" alt=\"\">\n<table>\n<thead>\n<tr>\n<th>Name</th>\n<th>Link</th>\n</tr>\n</thead>\n<tbody>\n<tr>\n<td>Github</td>\n<td><a href=\"https://github.com/TyCoding\">https://github.com/TyCoding</a></td>\n</tr>\n<tr>\n<td>Blog</td>\n<td><a href=\"https://tycoding.cn\">https://tycoding.cn</a></td>\n</tr>\n</tbody>\n</table>\n<ul>\n<li>list one</li><li>list two</li><li>list there</li></ul>\n<h1 id=\"h1-contact\"><a name=\"Contact\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>Contact</h1><ul>\n<li><a href=\"http://www.tycoding.cn\">Blog@TyCoding’s blog</a></li><li><a href=\"https://github.com/TyCoding\">GitHub@TyCoding</a></li><li><a href=\"https://www.zhihu.com/people/tomo-83-82/activities\">ZhiHu@TyCoding</a></li><li>QQ Group: 671017003</li></ul>\n', '0', '2019-09-22 14:57:51', NULL, '0');
INSERT INTO `tb_article` VALUES (2, 'How to write an article? --2', 'tycoding', '<h1 id=\"h1-how-to-write-an-article-\" style=\"font-family: Roboto, sans-serif;\">How to write an article?</h1><h2 id=\"h2-markdown-rules\" style=\"font-family: Roboto, sans-serif;\"><a name=\"Markdown rules\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>Markdown rules</h2><h1><p style=\"color: rgb(96, 98, 102); font-size: 14px;\"><span style=\"font-weight: bolder;\">For example</span></p><p style=\"color: rgb(96, 98, 102); font-size: 14px;\"><a href=\"https://tycoding.cn/\">https://tycoding.cn</a></p></h1>', '<h1 id=\"h1-how-to-write-an-article-\"><a name=\"How to write an article?\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>How to write an article?</h1><h2 id=\"h2-markdown-rules\"><a name=\"Markdown rules\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>Markdown rules</h2><p><strong>For example</strong></p>\n<p><a href=\"https://tycoding.cn\">https://tycoding.cn</a></p>\n<pre><code class=\"lang-java\">public static void main(String[] args) {\n        System.out.println(\"Hello World\");\n}\n</code></pre>\n<p><img src=\"http://img.api.tycoding.cn/1568958650973.jpeg\" alt=\"\">\n<table>\n<thead>\n<tr>\n<th>Name</th>\n<th>Link</th>\n</tr>\n</thead>\n<tbody>\n<tr>\n<td>Github</td>\n<td><a href=\"https://github.com/TyCoding\">https://github.com/TyCoding</a></td>\n</tr>\n<tr>\n<td>Blog</td>\n<td><a href=\"https://tycoding.cn\">https://tycoding.cn</a></td>\n</tr>\n</tbody>\n</table>\n<ul>\n<li>list one</li><li>list two</li><li>list there</li></ul>\n<h1 id=\"h1-contact\"><a name=\"Contact\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>Contact</h1><ul>\n<li><a href=\"http://www.tycoding.cn\">Blog@TyCoding’s blog</a></li><li><a href=\"https://github.com/TyCoding\">GitHub@TyCoding</a></li><li><a href=\"https://www.zhihu.com/people/tomo-83-82/activities\">ZhiHu@TyCoding</a></li><li>QQ Group: 671017003</li></ul>\n', '0', '2019-09-22 14:58:31', NULL, '0');
INSERT INTO `tb_article` VALUES (3, 'How to write an article? --3', 'tycoding', '<h1 id=\"h1-how-to-write-an-article-\" style=\"font-family: Roboto, sans-serif;\">How to write an article?</h1><h2 id=\"h2-markdown-rules\" style=\"font-family: Roboto, sans-serif;\"><a name=\"Markdown rules\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>Markdown rules</h2><p><span style=\"font-weight: bolder;\">For example</span></p><p><a href=\"https://tycoding.cn/\">https://tycoding.cn</a></p>', '<h1 id=\"h1-how-to-write-an-article-\"><a name=\"How to write an article?\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>How to write an article?</h1><h2 id=\"h2-markdown-rules\"><a name=\"Markdown rules\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>Markdown rules</h2><p><strong>For example</strong></p>\n<p><a href=\"https://tycoding.cn\">https://tycoding.cn</a></p>\n<pre><code class=\"lang-java\">public static void main(String[] args) {\n        System.out.println(\"Hello World\");\n}\n</code></pre>\n<p><img src=\"http://img.api.tycoding.cn/1568958650973.jpeg\" alt=\"\">\n<table>\n<thead>\n<tr>\n<th>Name</th>\n<th>Link</th>\n</tr>\n</thead>\n<tbody>\n<tr>\n<td>Github</td>\n<td><a href=\"https://github.com/TyCoding\">https://github.com/TyCoding</a></td>\n</tr>\n<tr>\n<td>Blog</td>\n<td><a href=\"https://tycoding.cn\">https://tycoding.cn</a></td>\n</tr>\n</tbody>\n</table>\n<ul>\n<li>list one</li><li>list two</li><li>list there</li></ul>\n<h1 id=\"h1-contact\"><a name=\"Contact\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>Contact</h1><ul>\n<li><a href=\"http://www.tycoding.cn\">Blog@TyCoding’s blog</a></li><li><a href=\"https://github.com/TyCoding\">GitHub@TyCoding</a></li><li><a href=\"https://www.zhihu.com/people/tomo-83-82/activities\">ZhiHu@TyCoding</a></li><li>QQ Group: 671017003</li></ul>\n', '0', '2019-09-22 14:58:54', NULL, '0');

-- ----------------------------
-- Table structure for tb_article_category
-- ----------------------------
DROP TABLE IF EXISTS `tb_article_category`;
CREATE TABLE `tb_article_category`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `article_id` bigint NOT NULL COMMENT '文章ID',
  `category_id` bigint NOT NULL COMMENT '分类ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '文章&&分类关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_article_category
-- ----------------------------
INSERT INTO `tb_article_category` VALUES (1, 1, 1);
INSERT INTO `tb_article_category` VALUES (2, 2, 1);
INSERT INTO `tb_article_category` VALUES (3, 3, 1);
INSERT INTO `tb_article_category` VALUES (4, 2, 1);
INSERT INTO `tb_article_category` VALUES (5, 1, 4);

-- ----------------------------
-- Table structure for tb_article_tag
-- ----------------------------
DROP TABLE IF EXISTS `tb_article_tag`;
CREATE TABLE `tb_article_tag`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `article_id` bigint NOT NULL COMMENT '文章ID',
  `tag_id` bigint NOT NULL COMMENT '标签ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '文章&&标签关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_article_tag
-- ----------------------------
INSERT INTO `tb_article_tag` VALUES (1, 1, 4);
INSERT INTO `tb_article_tag` VALUES (2, 2, 4);
INSERT INTO `tb_article_tag` VALUES (3, 3, 1);
INSERT INTO `tb_article_tag` VALUES (4, 3, 4);
INSERT INTO `tb_article_tag` VALUES (5, 2, 1);

-- ----------------------------
-- Table structure for tb_category
-- ----------------------------
DROP TABLE IF EXISTS `tb_category`;
CREATE TABLE `tb_category`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类名称',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '0' COMMENT '状态：0-启用 1-禁用',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '逻辑删除：0-正常 1-删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '分类表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_category
-- ----------------------------
INSERT INTO `tb_category` VALUES (1, '测试', '0', '2022-01-07 02:32:06', NULL, '0');
INSERT INTO `tb_category` VALUES (2, '随笔', '0', '2022-01-07 02:32:06', NULL, '0');
INSERT INTO `tb_category` VALUES (3, '心情', '0', '2022-01-07 02:32:06', NULL, '0');
INSERT INTO `tb_category` VALUES (4, 'springboot', '0', '2022-01-07 02:32:06', NULL, '0');

-- ----------------------------
-- Table structure for tb_comment
-- ----------------------------
DROP TABLE IF EXISTS `tb_comment`;
CREATE TABLE `tb_comment`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `article_id` bigint NULL DEFAULT NULL COMMENT '文章ID',
  `nickname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '给谁留言',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '留言内容',
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `ip` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'IP地址',
  `device` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备',
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '0' COMMENT '状态：0-启用 1-禁用',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '逻辑删除：0-正常 1-删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '评论表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_comment
-- ----------------------------
INSERT INTO `tb_comment` VALUES (1, 13, 'tycoding', '测试留言', 'tytumo@163.com', '172.0.0.1', 'Mac OS', '北京市-海淀区', '0', '2020-06-27 16:25:42', NULL, '0');
INSERT INTO `tb_comment` VALUES (2, 13, 'test1', '测试留言', 'test@163.com', '172.0.0.1', 'Mac OS', '北京市-海淀区', '0', '2020-06-27 16:56:19', NULL, '0');
INSERT INTO `tb_comment` VALUES (4, 13, '1', 'sd', '2', '127.0.0.1', 'Chrome 8,Mac OS X', '内网IP|0|0|内网IP|内网IP', '0', '2020-06-28 18:35:23', NULL, '0');
INSERT INTO `tb_comment` VALUES (5, 13, '1', '1', '1', '127.0.0.1', 'Chrome 8,Mac OS X', '内网IP|0|0|内网IP|内网IP', '0', '2020-06-28 18:58:29', NULL, '0');

-- ----------------------------
-- Table structure for tb_link
-- ----------------------------
DROP TABLE IF EXISTS `tb_link`;
CREATE TABLE `tb_link`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '连接名称',
  `url` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '连接URL',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '0' COMMENT '状态：0-启用 1-禁用',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '逻辑删除：0-正常 1-删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '友链表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_link
-- ----------------------------
INSERT INTO `tb_link` VALUES (1, 'Blog', 'http://tycoding.cn', '0', '2022-01-07 02:33:46', NULL, '0');
INSERT INTO `tb_link` VALUES (2, 'Github', 'https://github.com/tycoding', '0', '2022-01-07 02:33:46', NULL, '0');
INSERT INTO `tb_link` VALUES (3, 'YanFei Blog', 'http://blog.ivan.group', '0', '2022-01-07 02:33:46', NULL, '0');

-- ----------------------------
-- Table structure for tb_log
-- ----------------------------
DROP TABLE IF EXISTS `tb_log`;
CREATE TABLE `tb_log`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作用户',
  `operation` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作描述',
  `time` bigint NULL DEFAULT NULL COMMENT '耗时(毫秒)',
  `method` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作方法',
  `params` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作参数',
  `ip` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'IP地址',
  `location` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作地点',
  `create_time` datetime NULL DEFAULT NULL COMMENT '操作时间',
  `update_time` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '逻辑删除：0-正常 1-删除',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '0' COMMENT '状态：0-启用 1-禁用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_log
-- ----------------------------
INSERT INTO `tb_log` VALUES (87, 'tycoding', '新增文章', 1, 'cn.tycoding.biz.controller.ArticleController.add()', ' sysArticle\"SysArticle(id=14, title=1, author=tycoding, des=1, content=1, create...', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2020-06-28 23:07:41', NULL, '0', '0');
INSERT INTO `tb_log` VALUES (88, 'tycoding', '更新文章', 1, 'cn.tycoding.biz.controller.ArticleController.update()', ' sysArticle\"SysArticle(id=14, title=123, author=tycoding, des=1, content=1, crea...', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2020-06-28 23:07:55', NULL, '0', '0');
INSERT INTO `tb_log` VALUES (94, 'tycoding', '新增友链', 0, 'cn.menghuan.blog.controller.LinkController.save()', NULL, '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2022-01-07 10:25:58', NULL, '0', '0');

-- ----------------------------
-- Table structure for tb_login_log
-- ----------------------------
DROP TABLE IF EXISTS `tb_login_log`;
CREATE TABLE `tb_login_log`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `ip` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'IP地址',
  `location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录地点',
  `create_time` datetime NULL DEFAULT NULL COMMENT '登录时间',
  `device` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录设备',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 113 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '登录日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_login_log
-- ----------------------------
INSERT INTO `tb_login_log` VALUES (1, 'tycoding', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2020-06-28 21:13:18', 'Chrome 8 -- Mac OS X');
INSERT INTO `tb_login_log` VALUES (2, 'tycoding', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2020-06-28 21:17:13', 'Chrome 8 -- Mac OS X');
INSERT INTO `tb_login_log` VALUES (110, 'tycoding', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2022-01-07 10:24:28', 'Chrome 8 -- Windows 10');
INSERT INTO `tb_login_log` VALUES (111, 'tycoding', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2022-01-07 12:07:39', 'Unknown -- Unknown');
INSERT INTO `tb_login_log` VALUES (112, 'tycoding', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2022-01-07 14:20:48', 'Unknown -- Unknown');
INSERT INTO `tb_login_log` VALUES (113, 'tycoding', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2022-01-07 14:22:53', 'Unknown -- Unknown');

-- ----------------------------
-- Table structure for tb_review_today
-- ----------------------------
DROP TABLE IF EXISTS `tb_review_today`;
CREATE TABLE `tb_review_today`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` int NULL DEFAULT NULL COMMENT '用户id',
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '名称',
  `type` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类型：0-',
  `wake_up_time` datetime NULL DEFAULT NULL COMMENT '起床时间（点）',
  `sack_time` datetime NULL DEFAULT NULL COMMENT '睡觉时间（点）',
  `learning_time` varchar(0) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '学习时长（段）（成长）',
  `playing_time` varchar(0) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '娱乐时长（段）',
  `sport_time` varchar(0) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '运动时长（段）（健康）',
  `is_have_breakfast` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '吃早餐：0-是 1-否（健康）',
  `is_listen_news` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '听新闻：0-是 1-否（成长）',
  `description` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '0' COMMENT '状态：0-积极 1-奋斗 2-咸鱼 3-划水 4-开心 5-郁闷 6-忧伤 9-消极',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '逻辑删除：0-正常 1-删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '每天内省' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_review_today
-- ----------------------------
INSERT INTO `tb_review_today` VALUES (1, 1, '1', 'a', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'a', '0', '2022-01-05 03:35:34', '2022-01-05 03:44:50', '0');

-- ----------------------------
-- Table structure for tb_tag
-- ----------------------------
DROP TABLE IF EXISTS `tb_tag`;
CREATE TABLE `tb_tag`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标签名称',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '0' COMMENT '状态：0-启用 1-禁用',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '逻辑删除：0-正常 1-删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '标签表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_tag
-- ----------------------------
INSERT INTO `tb_tag` VALUES (1, '随笔', '0', '2022-01-07 02:34:48', NULL, '0');
INSERT INTO `tb_tag` VALUES (4, '测试', '0', '2022-01-07 02:34:48', NULL, '0');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `username` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称 ( 中文名 )',
  `avatar` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `occupation` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '职业',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `des` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '介绍',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '0' COMMENT '状态：0-启用 1-禁用',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '逻辑删除：0-正常 1-删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (1, 'tycoding', 'c82a27d50dd5f3a536c85211cc7f2346', NULL, '/img/avatar/20180414165815.jpg', NULL, 'tytumo@163.com', '兴趣使然的Coder', '0', '2020-06-27 16:55:05', NULL, '0');
INSERT INTO `tb_user` VALUES (2, 'test', 'd256d670b614b1f54cecfb3874c025f1', NULL, '/img/avatar/20180414165815.jpg', NULL, NULL, NULL, '0', '2020-06-26 16:55:08', NULL, '0');
INSERT INTO `tb_user` VALUES (3, 'test2', 'd256d670b614b1f54cecfb3874c025f1', NULL, '/img/avatar/20180414165815.jpg', NULL, '12tycoding@11.com', NULL, '0', '2020-06-27 16:55:13', NULL, '0');
INSERT INTO `tb_user` VALUES (4, '123', 'd256d670b614b1f54cecfb3874c025f1', NULL, '/img/avatar/20180414165815.jpg', NULL, '123@11.com', NULL, '0', '2020-06-27 16:55:13', NULL, '0');

SET FOREIGN_KEY_CHECKS = 1;
