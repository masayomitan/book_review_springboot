CREATE TABLE user (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(50) NOT NULL,
  pass varchar(60) NOT NULL,
  introduce varchar(255) DEFAULT NULL,
  book_image BLOB DEFAULT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE book (
  id int(11) NOT NULL AUTO_INCREMENT,
  title varchar(50) DEFAULT NULL,
  author varchar(20) DEFAULT NULL,
  publisher varchar(20) DEFAULT NULL,
  buy_date date,
  release_date date,
  genre varchar(20) DEFAULT NULL,
  over_view varchar(50) DEFAULT NULL,
  book_image BLOB DEFAULT NULL,
  PRIMARY KEY (id)
) ;
