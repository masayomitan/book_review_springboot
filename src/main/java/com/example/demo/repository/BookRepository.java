package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import com.example.demo.domain.Book;



//interfaceは初めに処理内容を具体的に書かず、後からメソッドの実装をして使用するために使う
//後からメソッドの実装をするため、処理を変えたい場合に有効



public interface BookRepository  {

  List<Book> findAll();

	Optional<Book> findOne(int id);
	
	void save(Book book);
	
	int update(Book book);
	
	int delete(int id);
  
}
