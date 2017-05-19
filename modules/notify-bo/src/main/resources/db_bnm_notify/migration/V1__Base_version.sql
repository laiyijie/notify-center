SET FOREIGN_KEY_CHECKS = 0;

CREATE TABLE `notify_hook` (
  `hook_name` varchar(45) NOT NULL,
  `description` varchar(45) DEFAULT NULL,
  `parameters` varchar(4096) DEFAULT NULL,
  PRIMARY KEY (`hook_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `notify_send_pattern` (
  `hook_name` varchar(45) NOT NULL,
  `type_name` varchar(45) NOT NULL,
  `pattern` varchar(1024) NOT NULL,
  `state` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`hook_name`,`type_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `notify_type` (
  `type_name` varchar(45) CHARACTER SET utf8 NOT NULL,
  `description` varchar(450) CHARACTER SET utf8 DEFAULT NULL,
  `patternConstraint` varchar(450) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`type_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

insert into `notify_type`(`type_name`,`description`,`patternConstraint`) values
('app','app推送消息',''),
('text','短信发送消息',''),
('wechat','微信模板消息','');

SET FOREIGN_KEY_CHECKS = 1;

