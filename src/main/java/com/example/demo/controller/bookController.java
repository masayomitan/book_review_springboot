package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Book;
import com.example.demo.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/books")
public class BookController {
     
  @Autowired
  private final BookService bookService;

  @Autowired
  public BookController(BookService bookService){
    this.bookService = bookService;
  }

  
  @GetMapping
	public String index(Model model) {
    List<Book> books = bookService.findAll();
		model.addAttribute("books", books);
		return "books/index";
	}


    @GetMapping("new")
    public String newBooks(@ModelAttribute("book") Model model) {
        return "books/new";
    }

    @PostMapping
	  public String create(@ModelAttribute("book") @Validated Book book, BindingResult result, Model model) {
      if (result.hasErrors()) {
        return "new";
      } else {
        bookService.save(book);
        return "redirect:/book";
      }
    }

    //メソッドの引数に@PathVariableを設定するとURL上の値を取得することができる
    @GetMapping("{id}")
    public String show(@PathVariable int id, Model model) {
      Optional<Book> book = bookService.getBook(id);
      model.addAttribute("book", book);
      return "show";
    }

    
    //メソッドの引数に@ModelAttributeをつけると送信されたリクエストのbodyの情報を取得できる
    @GetMapping("{id}/edit")
	  public String edit(@PathVariable int id, @ModelAttribute("book") Book book, Model model) {
		  Optional<Book> editBook = bookService.getBook(id);
      model.addAttribute("book", editBook);
		  return "edit";
	  }

    
      
    @PostMapping("{id}")
	public String update(@PathVariable int id, @ModelAttribute("book") @Validated Book book, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("book", book);
			return "edit";
		} else {
			book.setId(id);
			bookService.update(book);
			return "redirect:/books";
		}
	}
	
	@DeleteMapping("{id}")
	public String delete(@PathVariable int id) {
		bookService.deleteById(id);
		return "redirect:/books"; 
	}
}
