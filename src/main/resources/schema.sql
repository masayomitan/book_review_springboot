CREATE TABLE book (
  id int(11) NOT NULL AUTO_INCREMENT,
  title varchar(50) DEFAULT NULL,
  author varchar(20) DEFAULT NULL,
  publisher varchar(20) DEFAULT NULL,
  buy_Date date,
  release_Date date,
  over_View varchar(50) DEFAULT NULL,
  PRIMARY KEY (id)
) ;