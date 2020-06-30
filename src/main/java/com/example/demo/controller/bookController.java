package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.service.BookService;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


// @ResponseBody means the returned String is the response, not a view name
// @RequestParam means it is a parameter from the GET or POST request



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
    List<Book> book = bookService.findAll();
    model.addAttribute("book", book);
    return "books/index";
  }

  private Map<String,String> getGenre(){
    Map<String, String> selectMap = new LinkedHashMap<String, String>();
    selectMap.put("1", "小説");
    selectMap.put("2", "経営・戦略");
    selectMap.put("3", "政治・経済");
    selectMap.put("4", "IT");
    selectMap.put("5", "自己啓発");
    selectMap.put("6", "タレント本");
    selectMap.put("7", "その他");
    return selectMap;
  } 

  @GetMapping("new")
  public String newBook(@RequestParam("bookImage") MultipartFile bookImage, Model model) {
    model.addAttribute("selectBooks",getGenre());
    bookImage.getOriginalFilename();
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


    //Optional<Book> book = bookService.findOne(id);
    //model.addAttribute("book", book);
    //とやってもうまくいかない
    //Optionalに含まれるオブジェクトをアンラップする必要がある。
    //参考url https://ja.coder.work/so/java/2151854
  @GetMapping("{id}")
	public String show(@PathVariable int id, Model model) {
    bookService.findOne(id).ifPresent(o -> model.addAttribute("book", o));
		return "books/show";
	}
  
  
	@GetMapping("{id}/edit")
	public String edit(@PathVariable int id, @ModelAttribute("book") Book book, Model model) {
    model.addAttribute("selectBooks",getGenre());
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
  
  @DeleteMapping("{id}")
	public String delete(@PathVariable("id") int id) {
    Book book = bookService.findOne(id).get();
    if(book == null){
      return "";
    }
		bookService.delete(id);
		return "redirect:/books"; 
  }

}