package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


//Serviceの実装。業務ロジックを実行するためのメソッドを実装し、アプリケーション層に提供する。
//業務ロジック内で必要となる業務データは、Repositoryを介して、Entityオブジェクトとして取得する。
@Service
public class BookServiceImpl implements BookService {


  private final BookDao dao;

  @Autowired
  public BookServiceImpl(BookDao dao){
    this.dao = dao;
  }

  @Override
  public List<Book> findAll() {
		return dao.findAll();
	}
  
  

}
