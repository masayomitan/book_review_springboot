package com.example.demo.controller;

import java.util.List;

import com.example.demo.entity.Book;
import com.example.demo.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
public class BookController {
  
  private final BookService bookService;

  @Autowired
  public BookController(BookService bookService){
    this.bookService = bookService;
  }

  /**
     * 本の一覧を表示します
     * @param bookForm
     * @param model
     * @return resources/templates下のHTMLファイル名
     */

    @GetMapping
    public String index(Model model){

    //Taskのリストを取得する
    List<Book> books = bookService.findAll();

      model.addAttribute("books", books);
      model.addAttribute("title", "タイトル");

        return "book/index";
    }


    @GetMapping("new")
    public String newBooks(Model model) {
        return "books/new";
    }


    
 

}