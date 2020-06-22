CREATE TABLE book (
  id int(5) NOT NULL AUTO_INCREMENT,
  title varchar(50) ,
  author varchar(20) ,
  publisher varchar(20),
  buy_Date date,
  release_Date date,
  over_View varcher(100),
  PRIMARY KEY (id)
) ;