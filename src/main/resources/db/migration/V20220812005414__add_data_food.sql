insert into food(food_id, food_name, inventory, picture, price)
values (5, '面筋哥牌烤面筋', 999, '/food/5.jpg', 2.90);
insert into food(food_id, food_name, inventory, picture, price)
values (6, '蜜汁烤翅', 965, '/food/6.jpg', 12.90);

update food
set price = 38
where food_id = 1;
update food
set food_name = '绝绝子水果茶'
where food_id = 2;
update food
set food_name = '跺jiojio爆米花'
where food_id = 3;
update food
set food_name = '单身爆米花'
where food_id = 4;
