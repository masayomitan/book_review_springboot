package com.example.demo.repository;


import java.sql.Date;


import java.util.List;
import java.util.Optional;

import com.example.demo.domain.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;



@Repository
public class BookRepositoryImpl implements BookRepository{
  

  @Autowired
  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public BookRepositoryImpl(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }


  @Override
  public List<Book> findAll() {

    String sql = "SELECT book.id, title, author, publisher, buy_Date, release_Date, over_View FROM Book";

    return jdbcTemplate.query(sql,new BeanPropertyRowMapper<Book>(Book.class));
    }


    @Autowired
    private NamedParameterJdbcTemplate template;


    @Override
    public Optional<Book> findOne(int id) {

      String sql = "SELECT book.id, title, author, publisher, buy_Date, release_Date, over_View FROM Book"
      + "WHERE id = :id";

      List<Book> result = template.query(sql, new MapSqlParameterSource().addValue("Id", id),
      (rs, i) -> {
        Book book = new Book();
        book.setId(rs.getInt("id"));
        book.setTitle(rs.getString("title"));
        book.setAuthor(rs.getString("author"));
        book.setPublisher(rs.getString("publisher"));
        book.setBuyDate((Date)rs.getDate("buy_Date"));
        book.setReleaseDate((Date)rs.getDate("release_Date"));
        book.setOverView((String)rs.getString("over_View"));
        return book;
        });
    return result.isEmpty() ? Optional.empty() : Optional.of(result.get(0));
    }



      @Override
      public void save(Book book) {
        jdbcTemplate.update("INSERT INTO book(title, author, publisher, buy_Date, release_Date, over_View) VALUES(?, ?, ?, ?, ?, ?)",
        book.getTitle(), book.getAuthor(), book.getPublisher(), book.getBuyDate(), book.getReleaseDate(), book.getOverView() );
      }
      
      @Override
      public int update(Book book) {
        return 	jdbcTemplate.update("UPDATE book SET id = ?, title = ?, author = ?, publisher = ?, buy_Date = ?, release_Date = ?, over_View = ?, WHERE id = ?",
        book.getId(), book.getTitle(), book.getAuthor(), book.getPublisher(), book.getBuyDate(), book.getReleaseDate(), book.getOverView() );
    }

      @Override
      public int delete(int id) {
        return jdbcTemplate.update("DELETE FROM book WHERE id = ?", id);
      }

    }