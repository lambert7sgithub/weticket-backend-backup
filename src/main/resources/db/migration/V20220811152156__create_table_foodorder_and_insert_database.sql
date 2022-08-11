create TABLE if not exists food_order (
  food_order_id varchar(32) NOT NULL,
  food_name varchar(64),
  user_id bigserial  NOT NULL,
  count Integer,
  is_used boolean,
  price numeric(5,2),
  total_price numeric(5,2),
  create_time timestamp null,
  PRIMARY KEY (food_order_id)
);
insert into food_order(food_order_id,food_name,user_id,count,is_used,price,total_price,create_time)
values('sads3ad13asd1as','暑期快乐套餐',1,1,false,39.90,39.90,'2022-08-11 03:49:11');
insert into food_order(food_order_id,food_name,user_id,count,is_used,price,total_price,create_time)
values('s675784587asd1as','暑期快乐套餐',1,1,false,39.90,39.90,'2022-08-12 03:49:11');
insert into food_order(food_order_id,food_name,user_id,count,is_used,price,total_price,create_time)
values('s67sadasdas4587asd1as','暑期快乐套餐',1,1,false,39.90,39.90,'2022-08-10 09:45:11');