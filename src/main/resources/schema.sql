CREATE TABLE book (
  id int(11) NOT NULL AUTO_INCREMENT,
  title varchar(50) DEFAULT NULL,
  author varchar(20) DEFAULT NULL,
  publisher varchar(20) DEFAULT NULL,
  buy_date date,
  release_date date,
  genre varchar(20) DEFAULT NULL,
  over_view varchar(50) DEFAULT NULL,
  img_file BLOB DEFAULT NULL,
  PRIMARY KEY (id)
) ;