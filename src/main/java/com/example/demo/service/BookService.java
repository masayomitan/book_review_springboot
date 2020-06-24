package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.domain.Book;



public interface BookService {


  List<Book> findAll();

	Optional<Book> findOne(int id);
	
	void save(Book book);
	
	void update(Book book);
	
	void delete(int id);

}
