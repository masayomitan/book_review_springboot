package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Book;



public interface BookRepository  {

  List<Book> findAll();

	Optional<Book> findOne(int id);
	
	void save(Book book);
	
	int update(Book book);
	
	int delete(int id);
  
}
