package com.example.demo.controller;

import com.example.demo.service.BookService;

import java.util.List;

import com.example.demo.domain.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
@RequestMapping("/books")
public class BookController {

  @Autowired
  private BookService bookService;
  
  @GetMapping
  public String index(Model model) {

     //Taskのリストを取得する
     List<Book> book = bookService.findAll();
     
    model.addAttribute("book", book);
    return "books/index";
  }



  @GetMapping("new")
  public String newBook(@ModelAttribute("book") Book book, Model model) {
      return "books/new";
  }

	

}