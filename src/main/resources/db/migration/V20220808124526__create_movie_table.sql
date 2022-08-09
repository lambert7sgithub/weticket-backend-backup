DROP TABLE IF EXISTS movie;
CREATE TABLE movie (
  movie_id Integer NOT NULL,
  movie_name varchar(64) NOT NULL,
  actor varchar(512)  NULL,
  directed_by varchar(64) NULL,
  info varchar(1280)  NULL DEFAULT NULL,
  language varchar(20)  NULL,
  picture varchar(512) NULL DEFAULT NULL,
  show_time date NULL DEFAULT NULL,
  money numeric(5,2) NULL,
  movietype varchar(128) NULL,
  is_show boolean NULL DEFAULT false,
  score  numeric(5,2) NULL DEFAULT NULL,
  create_time date  NULL ,
  update_time date  NULL ,
  PRIMARY KEY (movie_id)
) ;




