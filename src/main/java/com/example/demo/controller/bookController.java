package com.example.demo.controller;

import java.util.List;

import com.example.demo.entity.Book;
import com.example.demo.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/book")
public class BookController  {
     
  @Autowired
  private final BookService bookService;

  @Autowired
  public BookController(BookService bookService){
    this.bookService = bookService;
  }

  
  @GetMapping
	public String index(Model model) {
		model.addAttribute("books", bookService.findAll());
		return "index";
	}



    @GetMapping("new")
    public String newBooks(@ModelAttribute("book") Model model) {
        return "books/new";
    }


    //メソッドの引数に@PathVariableを設定するとURL上の値を取得することができる
    @GetMapping("{id}")
    public String show(@PathVariable int id, Model model) {
      model.addAttribute("book", bookService.getBook(id));
      return "show";
    }


    //メソッドの引数に@ModelAttributeをつけると送信されたリクエストのbodyの情報を取得できる
    @GetMapping("{id}/edit")
	  public String edit(@PathVariable int id, @ModelAttribute("book") Book book, Model model) {
		  model.addAttribute("book", bookService.getBook(id));
		  return "edit";
	  }

    @PostMapping
	  public String create(@ModelAttribute("item") @Validated Book book, BindingResult result, Model model) {
      if (result.hasErrors()) {
        return "new";
      } else {
        bookService.save(book);
        return "redirect:/book";
      }
    }

      
    @PostMapping("/delete")
    public String delete(
      @RequestParam("bookId") int id,
      Model model) {
      
        //本を一件削除しリダイレクト
        bookService.deleteById(id);
        return "redirect:/book";
    }

    
}