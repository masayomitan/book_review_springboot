package com.example.demo.service;


import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class BookServiceImpl implements BookService{
  
  
  private final BookRepository repo;

  @Autowired
	public BookServiceImpl(BookRepository repo) {
		this.repo = repo;
	}

	@Override
	public List<Book> findAll() {
		return repo.findAll();
	}
  
	@Override
	public  Optional<Book> findOne(int id) {
		return repo.findOne(id);
	}

	@Override
	public void insert(Book book) {
		repo.insert(book);
	}

	@Override
	public void save(Book book) {
		repo.save(book);
	}

  @Override
	public void update(Book book) {
		//Bookを更新 idが無ければ例外発生
		if (repo.update(book) == 0) {
			throw new BookNotFoundException("error");
		}
	}

	@Override
	public void delete(int id) {
		//Bookを更新 idがなければ例外発生
		if (repo.delete(id) == 0) {
			throw new BookNotFoundException("error");
		}else{
			repo.delete(id);
		}
  }

}
