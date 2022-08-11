
create TABLE if not exists food (
  food_id Integer NOT NULL,
  food_name varchar(64),
  inventory Integer ,
  picture varchar(512) DEFAULT NULL,
  price numeric(5,2),
  PRIMARY KEY (food_id)
) ;


insert into food(food_id,food_name,inventory,picture,price) values(1,'暑期快乐套餐',125,'/food/1.jpg',39.90);
insert into food(food_id,food_name,inventory,picture,price) values(2,'品牌专供饮品爆米花套餐',985,'/food/2.jpg',29.90);
insert into food(food_id,food_name,inventory,picture,price) values(3,'爆米花+可乐+薯片',996,'/food/3.jpg',19.90);
insert into food(food_id,food_name,inventory,picture,price) values(4,'爆米花满足大套餐',211,'/food/4.jpg',9.90);