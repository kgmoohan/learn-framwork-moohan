create table student
(
	sid         bigint primary key auto_increment comment '主键',
	name        varchar(20)        not null comment '学生姓名',
	sex         tinyint            not null comment '性别',
	email       varchar(30) unique not null comment '邮箱',
	create_time timestamp          not null comment '创建时间',
	update_time timestamp          not null comment '最近更新时间',
	status      tinyint unsigned default 0 comment '状态位',
	del_flag    bit              default 0 comment '删除标识 0-可用， 1-已删除'
) comment '学生表';

