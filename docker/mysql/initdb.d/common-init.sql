drop table if exists person;
create table person(
  id bigint unsigned auto_increment,
  name varchar(100) not null,
  primary key(id)
) engine=innodb charset=utf8mb4;
