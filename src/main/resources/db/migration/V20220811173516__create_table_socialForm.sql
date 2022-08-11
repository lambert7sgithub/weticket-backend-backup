create table if not exists social_form
(
    id   VARCHAR(50)
        primary key,
    name VARCHAR(60),
    gender VARCHAR(10),
    phone VARCHAR(20),
    films VARCHAR(200),
    cinemas VARCHAR(200),
    user_id BIGINT DEFAULT NULL
);