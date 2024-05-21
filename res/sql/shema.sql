DROP TABLE IF EXISTS `user`;
create table user
(
    id           bigint primary key auto_increment comment '主键id',
    username     varchar(256) null comment '用户昵称',
    userAccount  varchar(256) null comment '用户账号',
    avatarUrl    varchar(1024) null comment '头像url',
    gender       tinyint null comment '性别 0男 1女',
    userPassword varchar(512) not null comment '密码',
    phone        varchar(128) null comment '电话',
    email        varchar(512) null comment '邮箱',
    userStatus   int default 0 not null comment '状态 0-正常',
    createTime   datetime default current_timestamp null comment '创建时间',
    updateTime   datetime default current_timestamp null on update current_timestamp comment '更新时间',
    isDelete     tinyint default 0 not null comment '是否删除'
)
    comment '用户';
