drop table if exists user;
create table user(
id int(10)not null auto_increment comment'ID',
user_name varchar(20) not null unique comment'用户名',
password varchar(20) not null comment'密码',
create_time datetime not null default current_timestamp comment'创建时间',
primary key(id));
insert into user(user_name,password) values('user1','12345678'),
('user2','12345678'),
('trump','12345678'),
('obama','12345678');

