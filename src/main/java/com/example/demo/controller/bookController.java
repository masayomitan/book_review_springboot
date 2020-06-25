package com.example.demo.controller;

import com.example.demo.service.BookService;

import java.util.List;

import com.example.demo.domain.Book;

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




@Controller
@RequestMapping("/books")
public class BookController {


  private final BookService bookService;

  @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
  
  @GetMapping
  public String index(Model model) {
     //Taskのリストを取得する
    List<Book> book = bookService.findAll();
    model.addAttribute("book", book);
    return "books/index";
  }

  @GetMapping("new")
  public String newBook(Model model) {
      return "books/new";
  }

  @PostMapping
	public String create(@ModelAttribute("book") @Validated Book book, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "books/new";
		} else {
			bookService.save(book);
			return "redirect:/books";
		}
  }


  @GetMapping("{id}")
	public String show(@PathVariable int id, Model model) {
    //Optional<Book> book = bookService.findOne(id);
    //model.addAttribute("book", book);とやってもうまくいかない
    //Optionalに含まれるオブジェクトをアンラップする必要がある。
    //参考url https://ja.coder.work/so/java/2151854
    bookService.findOne(id).ifPresent(o -> model.addAttribute("book", o));
		return "books/show";
	}
  
  
	@GetMapping("{id}/edit")
	public String edit(@PathVariable("id") int id, @ModelAttribute("book") Book book, Model model) {
   //上のshowメソッドと同じ
		bookService.findOne(id).ifPresent(o -> model.addAttribute("book", o));
		return "books/edit";
	}
  
  @PostMapping("{id}")
  public String update(@PathVariable int id, @ModelAttribute("book") @Validated Book book, BindingResult result, Model model){
    if (result.hasErrors()) {
			model.addAttribute("book", book);
			return "edit";
		} else {
			book.setId(id);
			bookService.update(book);
			return "redirect:/books";
		}
	}


}