package com.example.demo.controller;

import com.example.demo.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
public class BookController {
  
  @Autowired
  private BookService bookService;

  
  public String index(Model model) {
    model.addAttribute("books", bookService.findAll());
    return "books/index";
  }

}