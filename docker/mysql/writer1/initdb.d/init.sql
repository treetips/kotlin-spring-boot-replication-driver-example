drop table if exists host;
create table host(
  name varchar(10) not null primary key
) engine=Innodb charset=utf8mb4;

insert into host values('writer1');
