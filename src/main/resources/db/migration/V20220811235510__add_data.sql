update cinema
set cinema_name = '幸福蓝海国际影城（珠海金湾华发商都店）'
where cinema_id = 1;
update cinema
set "location" = '金湾区广东省珠海金湾区三灶镇金河东路720号金湾华发商都中心A馆A3001'
where cinema_id = 1;
update cinema
set cinema_name = '珠海洛富特影城中影星天地影城（平沙钰海广场店）'
where cinema_id = 2;
update cinema
set "location" = '香洲区梅界路237号奥园广场第四层401'
where cinema_id = 2;
update cinema
set cinema_name = '海印电影城（珠海海印又一城店）'
where cinema_id = 3;
update cinema
set "location" = '香洲区海印又一城商业广场B馆4楼'
where cinema_id = 3;
insert into cinema(cinema_id, cinema_name, "location")
values (4, '幸福蓝海国际影城（扬名广场店）', '香洲区扬名商业广场大家乐楼上');
insert into screening(screening_id, cinema_id, movie_id, seat_num, start_date, surplus_seats)
values (5, 3, 1, 144, '2022-08-12 11:23:54', 144);
insert into screening(screening_id, cinema_id, movie_id, seat_num, start_date, surplus_seats)
values (6, 3, 2, 144, '2022-08-12 14:43:14', 144);
insert into screening(screening_id, cinema_id, movie_id, seat_num, start_date, surplus_seats)
values (7, 3, 3, 144, '2022-08-12 17:55:54', 144);
insert into screening(screening_id, cinema_id, movie_id, seat_num, start_date, surplus_seats)
values (8, 2, 4, 144, '2022-08-12 20:20:10', 144);
insert into screening(screening_id, cinema_id, movie_id, seat_num, start_date, surplus_seats)
values (9, 2, 5, 144, '2022-08-12 22:53:54', 144);
insert into screening(screening_id, cinema_id, movie_id, seat_num, start_date, surplus_seats)
values (10, 2, 1, 144, '2022-08-13 00:23:54', 144);
insert into screening(screening_id, cinema_id, movie_id, seat_num, start_date, surplus_seats)
values (11, 1, 2, 144, '2022-08-13 03:46:54', 144);
insert into screening(screening_id, cinema_id, movie_id, seat_num, start_date, surplus_seats)
values (12, 1, 3, 144, '2022-08-13 06:23:14', 144);

insert into screening(screening_id, cinema_id, movie_id, seat_num, start_date, surplus_seats)
values (13, 1, 4, 144, '2022-08-13 15:59:54', 144);
insert into screening(screening_id, cinema_id, movie_id, seat_num, start_date, surplus_seats)
values (14, 4, 5, 144, '2022-08-14 00:23:54', 144);
insert into screening(screening_id, cinema_id, movie_id, seat_num, start_date, surplus_seats)
values (15, 4, 1, 144, '2022-08-14 09:44:54', 144);
insert into screening(screening_id, cinema_id, movie_id, seat_num, start_date, surplus_seats)
values (16, 4, 2, 144, '2022-08-14 12:23:54', 144);
insert into screening(screening_id, cinema_id, movie_id, seat_num, start_date, surplus_seats)
values (17, 2, 3, 144, '2022-08-14 16:53:54', 144);
insert into screening(screening_id, cinema_id, movie_id, seat_num, start_date, surplus_seats)
values (18, 2, 4, 144, '2022-08-14 23:11:54', 144);