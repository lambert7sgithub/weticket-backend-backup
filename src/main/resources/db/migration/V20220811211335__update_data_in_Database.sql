

insert into cinema(cinema_id,cinema_name,"location") values(1,'珠海影城','珠海');
insert into cinema(cinema_id,cinema_name,"location") values(2,'香洲影城','香洲');
insert into cinema(cinema_id,cinema_name,"location") values(3,'唐家影城','唐家');
update cinema set cinema_name = '幸福蓝海国际影城（珠海金湾华发商都店）' where cinema_id=1;
update cinema set "location" = '金湾区广东省珠海金湾区三灶镇金河东路720号金湾华发商都中心A馆A3001' where cinema_id=1;
update cinema set cinema_name = '珠海洛富特影城中影星天地影城（平沙钰海广场店）' where cinema_id=2;
update cinema set "location" = '香洲区梅界路237号奥园广场第四层401' where cinema_id=2;
update cinema set cinema_name = '海印电影城（珠海海印又一城店）' where cinema_id=3;
update cinema set "location" = '香洲区海印又一城商业广场B馆4楼' where cinema_id=3;
insert into cinema(cinema_id,cinema_name,"location") values(4,'幸福蓝海国际影城（扬名广场店）','香洲区扬名商业广场大家乐楼上');
