ALTER TABLE t_user_seat
    DROP CONSTRAINT t_user_seat_pkey;
ALTER TABLE t_user_seat
    ADD CONSTRAINT t_user_seat_pkey PRIMARY KEY (seat_id);