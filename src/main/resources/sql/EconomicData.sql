DROP DATABASE IF EXISTS Economic;
CREATE DATABASE Economic;
use Economic;
CREATE table t_user(
`userid` BIGINT(20) primary key auto_increment,
`username` VARCHAR(50) NOT NULL unique,
`password` VARCHAR(50) NOT NULL,
`email` VARCHAR(50) NOT NULL,
`avatar` VARCHAR(255) DEFAULT ""
);

INSERT INTO  t_user(`username`,`password`, `email`, `avatar`) VALUES('admin1', 'admin', 'admin1@qq.com', 'http://xxxxxxxx.xxxxxxx');
INSERT INTO  t_user(`username`,`password`, `email`, `avatar`) VALUES('admin2','admin', 'admin2@qq.com', 'http://xxxxxxxx.xxxxxxx');
INSERT INTO  t_user(`username`,`password`, `email`, `avatar`) VALUES('用户3','admin', 'admin3@qq.com', 'http://xxxxxxxx.xxxxxxx');
SELECT * FROM  t_user;

CREATE table t_blog(
`blogid` BIGINT(20) primary key auto_increment,
`title` VARCHAR(50) NOT NULL unique,
`summary` TEXT  NOT NULL,
`content`  TEXT  NOT NULL,
`userid`  BIGINT(20)  NOT NULL,
`create_date` DATETIME NOT NULL ,
`comment_num`  BIGINT(20) default 0,
FOREIGN KEY(userid) REFERENCES t_user(userid)
);

INSERT INTO  t_blog(`title`,`summary`, `content`, `userid`, `create_date`, `comment_num`) VALUES('测试标题1','测试摘要1', '测试内容1', '1', '2021-11-20', '0');
INSERT INTO  t_blog(`title`,`summary`, `content`, `userid`, `create_date`, `comment_num`) VALUES('测试标题2','测试摘要2', '测试内容2', '1', '2021-11-20', '0');
INSERT INTO  t_blog(`title`,`summary`, `content`, `userid`, `create_date`, `comment_num`) VALUES('测试标题3','测试摘要3', '测试内容3', '1', '2021-11-20', '0');
SELECT * FROM  t_blog;

CREATE table t_comment(
`commentid`  BIGINT(20) primary key auto_increment,
`blogid` BIGINT(20)  NOT NULL,
`content`  TEXT  NOT NULL,
`userid`  BIGINT(20)  NOT NULL,
`state` int(2)  default 0,
`create_time` DATETIME NOT NULL,
FOREIGN KEY(userid) REFERENCES  t_user(userid),
FOREIGN KEY(blogid) REFERENCES  t_blog(blogid)
)ENGINE=InnoDB DEFAULT CHARSET=GBK;

INSERT INTO t_comment(`blogid`,`content`,`userid`, `state`, `create_time`) VALUES('1','Orz', '1', '0', '2021-11-20');
INSERT INTO t_comment(`blogid`,`content`,`userid`, `state`, `create_time`) VALUES('2','666', '1', '0', '2021-11-20');
INSERT INTO t_comment(`blogid`,`content`,`userid`, `state`, `create_time`) VALUES('1','大佬tql', '2', '0', '2021-11-20');
SELECT * FROM t_comment;

CREATE table  t_ticket(
`ticketid`  BIGINT(20) primary key auto_increment,
`username`  VARCHAR(50)  NOT NULL,
`expire_time` DATETIME NOT NULL,
`state` int(2)  default 0,
`ticket` VARCHAR(255) NOT NULL
);

INSERT INTO t_ticket(`username`,`expire_time`,`state`, `ticket`) VALUES('admin1','9999-12-31', '0', 'ulddssfji45456i30929ik900');
INSERT INTO t_ticket(`username`,`expire_time`,`state`, `ticket`) VALUES('admin2','9999-12-31', '0', '7890sfjui9456ikl929ik789k');
INSERT INTO t_ticket(`username`,`expire_time`,`state`, `ticket`) VALUES('用户3','9999-12-31', '0', '9008bui56gl6ikp0j9ik789ll');
SELECT * FROM t_ticket;

