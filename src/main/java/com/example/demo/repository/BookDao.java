package com.example.demo.repository;


import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Book;


//interfaceは初めに処理内容を具体的に書かず、後からメソッドの実装をして使用するために使う
//後からメソッドの実装をするため、処理を変えたい場合に有効

public interface BookDao {

  List<Book> findAll();
	
	Optional<Book> findById(int id);

	void insert(Book book);

	void save(Book book);
	
	int update(Book book);
	
	int deleteById(int id);


  
}