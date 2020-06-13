package com.example.demo.entity;

import java.sql.Date;
import java.time.LocalDateTime;

public class books {
  
  private int id;
  private String title;
  private String author;
  private String publisher;
  private Date   buyDate;
  private Date   releaseDate;
  private String overview;

  private LocalDateTime deadline;

  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }
  public void setAuthor(String author) {
    this.author = author;
  }

  public String getPublisher() {
    return publisher;
  }
  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }

  public Date getBuyDate() {
    return buyDate;
  }
  public void setBuyDate(Date buyDate) {
    this.buyDate = buyDate;
  }
  
}