package com.example.demo.entity;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class Book {


  private int id;
  private String title;
  private String author;
  private String publisher;
  private Date   buyDate;
  private Date   releaseDate;
  private String genre;
  private String overView;
  private MultipartFile bookImage;

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

  public Date getReleaseDate() {
    return releaseDate;
  }
  public void setReleaseDate(Date releaseDate) {
    this.releaseDate = releaseDate;
  }

  public String getGenre() {
    return genre;
  }
  public void setGenre(String genre) {
    this.genre = genre;
  }

  public String getOverView() {
    return overView;
  }
  public void setOverView(String overView) {
    this.overView = overView;
  }

  public MultipartFile getBookImage() {
    return bookImage;
  }

  public void setBookImage(MultipartFile bookImage) {
    this.bookImage = bookImage;
  }


}
