alter table movie
	add length integer default 0;

alter table movie rename column movietype to movie_type;


update movie set length = 123 where movie_id=1;
update movie set length = 124 where movie_id=2;
update movie set length = 125 where movie_id=3;
update movie set length = 126 where movie_id=4;
update movie set length = 128 where movie_id=5;