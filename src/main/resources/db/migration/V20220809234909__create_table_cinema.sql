create table cinema
(
    cinema_id   integer not null
        constraint cinema_pkey
            primary key,
    cinema_name varchar(255),
    location    varchar(255)
);