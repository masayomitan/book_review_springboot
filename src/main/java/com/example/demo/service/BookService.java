package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.example.demo.domain.Book;
import com.example.demo.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {


  @Autowired
  private BookRepository bookRepository;

	
	@Transactional
	public List<Book> findAll() {
		return bookRepository.findAll();
	}
  
	@Transactional
	public Optional<Book> findOne(int id) {
		return bookRepository.findOne(id);
	}

	@Transactional
	public void save(Book book) {
		bookRepository.save(book);
	}

  @Transactional
	public void update(Book book) {
		//Taskを更新 idが無ければ例外発生
		if (bookRepository.update(book) == 0) {
			throw new BookNotFoundException("error");
		}
	}

	@Transactional
	public void deleteById(int id) {
		//Taskを更新 idがなければ例外発生
		if (bookRepository.delete(id) == 0) {
			throw new BookNotFoundException("error");
		}
  }

}
