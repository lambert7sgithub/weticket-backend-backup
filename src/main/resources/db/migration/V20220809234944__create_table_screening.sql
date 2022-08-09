create table screening
(
    screening_id  integer not null
        constraint screening_pkey
            primary key
        constraint fk752is8e9p6485f9apj2hrq5pb
            references cinema,
    seat_num      integer not null,
    start_date    timestamp,
    surplus_seats integer not null,
    cinema_id     integer
        constraint fklf8ol40h1l4kfd6qyjkgf5xy0
            references cinema,
    movie_id      integer
        constraint fkfp7sh76xc9m508stllspchnp9
            references movie
);