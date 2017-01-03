create table m_user(
	uid int auto_increment not null comment '用户ID，自增', 
	ucount varchar(250) not null comment '用户帐号', 
	upassword varchar(250) not null comment '用户密码', 
	primary key(uid) comment '主键', 
	unique(ucount) comment '唯一约束')CHARSET=utf8;

create table m_film(
	fid int auto_increment not null comment '电影ID',
	fname varchar(250) not null comment '电影名名称',
	fdirector varchar(250) comment '导演',
	factor varchar(250) comment '主演',
	fremark varchar(1000) comment '简介',
	fcount int not null comment '剩余票数',
	primary key(fid))CHARSET=utf8;

create table m_purchase(
	pid int auto_increment not null comment '订单ID',
	ucount varchar(250) not null comment '用户名',
	fid int not null comment '电影ID',
	primary key(pid))CHARSET=utf8;

insert into m_user(ucount, upassword) values('test@163.com', '1111');
insert into m_film(fname, fdirector, factor, fremark, fcount)
	value('疯狂动物城', '里奇·摩尔', '金妮弗·古德温', '一个现代化的动物都市，每种动物在这里都有自己的居所...', 300);
