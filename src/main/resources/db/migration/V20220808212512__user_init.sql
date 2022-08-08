create table if not exists t_roles
(
    id   bigserial
        primary key,
    name varchar(60)
);

create table if not exists t_user
(
    id       bigserial
        primary key,
    email    varchar(255),
    name     varchar(255),
    password varchar(255),
    username varchar(255)
);

create table if not exists t_user_roles
(
    user_id bigint not null
        constraint fkpqntgokae5e703qb206xvfdk3
            references t_user,
    role_id bigint not null
        constraint fks6chhvbxjrqhhlb3grun2691k
            references t_roles,
    primary key (user_id, role_id)
);

insert into t_roles
values (1, 'ROLE_NORMAL');