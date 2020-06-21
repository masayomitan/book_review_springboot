package com.example.demo.repository;


import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.demo.domain.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;



@Repository
public class BookRepositoryImpl implements BookRepository{
  

  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public BookRepositoryImpl(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }


  @Override
  public List<Book> findAll() {

    String sql = "SELECT book.id, title, author, publisher, buy_Date, release_Date, over_View, deadline FROM Book";

    List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql);

    List<Book> list = new ArrayList<Book>();

    for(Map<String, Object> result : resultList) {
      Book book = new Book();
			book.setId((int)result.get("id"));
			book.setTitle((String)result.get("title"));
			book.setAuthor((String)result.get("author"));
			book.setPublisher((String)result.get("publisher"));
      book.setBuyDate((Date)result.get("buy_Date"));
      book.setReleaseDate((Date)result.get("release_Date"));
      book.setOverView((String)result.get("over_View"));
      book.setDeadline(((Timestamp) result.get("deadline")).toLocalDateTime());
        }
      return list;
    }



    @Override
    public Optional<Book> findOne(int id){

      String sql = "SELECT book.id, title, author, publisher, buyDate, releaseDate, overView FROM Book"
      + "WHERE book.id = ?";

      Map<String, Object> result = jdbcTemplate.queryForMap(sql, id);

      Book book = new Book();
          book.setId((int)result.get("id"));
          book.setTitle((String)result.get("title"));
          book.setAuthor((String)result.get("author"));
          book.setPublisher((String)result.get("publisher"));
          book.setBuyDate((Date)result.get("buyDate"));
          book.setReleaseDate((Date)result.get("releaseDate"));
          book.setOverView((String)result.get("overView"));
          book.setDeadline(((Timestamp) result.get("deadline")).toLocalDateTime());

        //taskをOptionalでラップする
        Optional<Book> taskOpt = Optional.ofNullable(book);
        return taskOpt;
    }


      @Override
      public void save(Book book) {
        jdbcTemplate.update("INSERT INTO book(id, title, author, publisher, buyDate, releaseDate, overView, deadline) VALUES(?, ?, ?, ?, ?, ?, ?, ?)",
            book.getId(), book.getTitle(), book.getAuthor(), book.getPublisher(), book.getBuyDate(), book.getReleaseDate(), book.getOverView(), book.getDeadline() );
      }
      
      @Override
      public int update(Book book) {
        return 	jdbcTemplate.update("UPDATE book SET id = ?, title = ?, author = ?, publisher = ?, buyDate = ?, releaseDate = ?, overView = ?, deadline = ? WHERE id = ?",
        book.getId(), book.getTitle(), book.getAuthor(), book.getPublisher(), book.getBuyDate(), book.getReleaseDate(), book.getOverView(), book.getDeadline() );
    }

      @Override
      public int delete(int id) {
        return jdbcTemplate.update("DELETE FROM book WHERE id = ?", id);
      }

    }