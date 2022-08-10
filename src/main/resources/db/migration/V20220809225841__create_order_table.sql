create table if not exists orderform (
  order_id varchar(32) NOT NULL,
  movie_id Integer NOT NULL,
  cinema_id Integer NOT NULL,
  screening_id Integer NOT NULL,
  user_id bigserial  NOT NULL,
  votes Integer NULL,
  is_used boolean NULL,
  create_time date  NULL,
  update_time date  NULL,
  PRIMARY KEY (order_id)
) ;