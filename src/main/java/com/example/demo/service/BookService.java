package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Book;

public interface BookService {

  List<Book> findAll();

  Optional<Book> getBook(int id);

	void insert(Book book);
	
  void update(Book book);
	
	void deleteById(int id);


  
}