create table if not exists todo(
  id   varchar(5)  not null primary key,
  text varchar(255) not null,
  done varchar(10)  default 'false'
);