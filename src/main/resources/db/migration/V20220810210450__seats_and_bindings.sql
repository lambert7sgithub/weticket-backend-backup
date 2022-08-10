create table if not exists t_seat
(
    id     uuid not null
        primary key,
    status integer,
    x      integer,
    y      integer
);

create table if not exists t_screening_seats
(
    screening_id integer not null
        references screening,
    seat_id      uuid    not null
        unique
        references t_seat,
    primary key (screening_id, seat_id)
);

create table if not exists t_user_seat
(
    seat_id uuid
        references t_seat,
    user_id bigint not null
        primary key
        references t_user
);

