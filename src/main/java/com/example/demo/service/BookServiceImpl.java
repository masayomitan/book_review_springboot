package com.example.demo.service;

import java.util.Optional;
import java.util.List;


import com.example.demo.repository.BookRepository;
import com.example.demo.domain.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class BookServiceImpl implements BookService{
  
  
  private final BookRepository Repo;

  @Autowired
	public BookServiceImpl(BookRepository Repo) {
		this.Repo = Repo;
	}

	@Override
	public List<Book> findAll() {
		return Repo.findAll();
	}
  
	@Override
	public Optional<Book> findOne(int id) {
		return Repo.findOne(id);
	}

	@Override
	public void save(Book book) {
		Repo.save(book);
	}

  @Override
	public void update(Book book) {
		//Taskを更新 idが無ければ例外発生
		if (Repo.update(book) == 0) {
			throw new BookNotFoundException("error");
		}
	}

	@Override
	public void delete(int id) {
		//Taskを更新 idがなければ例外発生
		if (Repo.delete(id) == 0) {
			throw new BookNotFoundException("error");
		}
  }

}
