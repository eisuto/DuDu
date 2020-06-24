/*
Navicat MySQL Data Transfer

Source Server         : LinkOne
Source Server Version : 80017
Source Host           : localhost:3306
Source Database       : dudu

Target Server Type    : MYSQL
Target Server Version : 80017
File Encoding         : 65001

Date: 2020-06-24 17:58:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `comments`
-- ----------------------------
DROP TABLE IF EXISTS `comments`;
CREATE TABLE `comments` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `deleted_at` datetime DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `text` varchar(256) DEFAULT NULL,
  `video_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_comments_deleted_at` (`deleted_at`),
  KEY `idx_comments_user_id` (`user_id`),
  KEY `idx_comments_video_id` (`video_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of comments
-- ----------------------------
INSERT INTO `comments` VALUES ('23', '2020-04-18 20:52:38', '2020-04-18 20:52:38', null, '6', '奇哥', '2');
INSERT INTO `comments` VALUES ('24', '2020-04-18 20:53:20', '2020-04-18 20:53:20', null, '6', '奇哥', '2');
INSERT INTO `comments` VALUES ('25', '2020-04-18 20:56:16', '2020-04-18 20:56:16', null, '6', '奇哥帅气', '2');
INSERT INTO `comments` VALUES ('26', '2020-04-18 20:57:13', '2020-04-18 20:57:13', null, '6', '评论功能测试', '1');
INSERT INTO `comments` VALUES ('27', '2020-04-20 20:38:15', '2020-04-20 20:38:15', null, '1', '太帅了奇哥', '2');
INSERT INTO `comments` VALUES ('28', '2020-04-20 20:41:04', '2020-04-20 20:41:04', null, '17', '太狠了，一口闷', '2');

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `deleted_at` datetime DEFAULT NULL,
  `nick_name` longtext,
  `email` longtext,
  `pass_word` varchar(32) DEFAULT NULL,
  `avatar` varchar(32) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `role` int(11) DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `idx_users_deleted_at` (`deleted_at`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', '2020-04-05 11:35:37', '2020-04-05 11:35:37', null, 'admin', 'waabdxiaoyi@gmail.com', '233333', '/static/img/tx/de.png', '', '0');
INSERT INTO `users` VALUES ('6', '2020-04-06 21:04:11', '2020-04-10 21:19:16', null, 'eisuto', '381149832@qq.com', '233333', '/static/img/tx/eisuto.jpg', '', '1');
INSERT INTO `users` VALUES ('7', '2020-04-06 21:08:41', '2020-04-06 21:08:41', null, '123', '312@q.com', '123456', '/static/img/tx/de.png', '', '1');
INSERT INTO `users` VALUES ('8', '2020-04-06 21:08:51', '2020-04-06 21:08:51', null, '123', '312@q.com', '123456', '/static/img/tx/de.png', '', '1');
INSERT INTO `users` VALUES ('9', '2020-04-06 21:09:07', '2020-04-06 21:09:07', null, '31231', 'ewqe@qq.com', '32323333', '/static/img/tx/de.png', '', '1');
INSERT INTO `users` VALUES ('10', '2020-04-06 21:10:44', '2020-04-06 21:10:44', null, '312321', '1@qq.om', '122233333', '/static/img/tx/de.png', '', '1');
INSERT INTO `users` VALUES ('11', '2020-04-06 21:11:59', '2020-04-06 21:11:59', null, '3123123', '32@qq.coom', '33333333333', '/static/img/tx/de.png', '', '1');
INSERT INTO `users` VALUES ('12', '2020-04-06 21:12:21', '2020-04-06 21:12:21', null, '23131', '222@qq.com', '321321313', '/static/img/tx/de.png', '', '1');
INSERT INTO `users` VALUES ('13', '2020-04-06 21:12:48', '2020-04-06 21:12:48', null, '32131', '312321@qq.com', '23131333', '/static/img/tx/de.png', '', '1');
INSERT INTO `users` VALUES ('14', '2020-04-06 21:13:13', '2020-04-06 21:13:13', null, '32131', '312321@qq.com', '321312313213', '/static/img/tx/de.png', '', '1');
INSERT INTO `users` VALUES ('15', '2020-04-06 21:13:41', '2020-04-06 21:13:41', null, '32131', '312321@qq.com', '2313131313', '/static/img/tx/de.png', '', '1');
INSERT INTO `users` VALUES ('16', '2020-04-08 19:10:54', '2020-04-08 19:10:54', null, '321', '31232131@qq.com', '321312', '/static/img/tx/de.png', '', '1');
INSERT INTO `users` VALUES ('17', '2020-04-18 20:22:44', '2020-04-18 20:22:44', null, 'waabd', '312@qq.com', '233333', '/static/img/tx/de.png', '', '1');

-- ----------------------------
-- Table structure for `videos`
-- ----------------------------
DROP TABLE IF EXISTS `videos`;
CREATE TABLE `videos` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `deleted_at` datetime DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `title` varchar(64) DEFAULT NULL,
  `like` int(11) DEFAULT '0',
  `un_like` int(11) DEFAULT '0',
  `introduc` varchar(200) DEFAULT NULL,
  `fc_url` varchar(64) DEFAULT NULL,
  `play` int(11) DEFAULT NULL,
  `area` varchar(64) DEFAULT NULL,
  `duration` int(11) DEFAULT NULL,
  `comm` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_videos_user_id` (`user_id`),
  KEY `idx_videos_deleted_at` (`deleted_at`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of videos
-- ----------------------------
INSERT INTO `videos` VALUES ('1', '2020-04-10 21:19:16', '2020-04-20 21:38:14', null, '6', '【东方】幻灯花 - 魂音泉', '0', '0', '一曲幻灯花不仅粉碎了原曲，也几乎粉碎了听众的心，尽管男性的声音在东方歌姬中比例不大，然而这首绝对为精品预定，略带沧桑的男声不会让你一耳朵惊艳，然而听过，才会明白这是首多么耐听的歌', './static/img/fm/1.png', '203', null, '368', '1');
INSERT INTO `videos` VALUES ('2', '2020-04-11 10:19:10', '2020-04-20 21:38:18', null, '6', '佳奇喝酒', '1000', '100', null, './static/img/fm/2.png', '43', null, '44', '5');
