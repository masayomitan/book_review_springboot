package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Book;
import com.example.demo.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        return "books/index";
    }



    @GetMapping("new")
    public String newBooks(Model model) {
        return "books/new";
    }



    /**
     * 一件本データを取得し、フォーム内に表示
     * @param id
     * @param model
     * @return
     */
    //メソッドの引数に@PathVariableを設定するとURL上の値を取得することができる
    @GetMapping("/{id}")
    public String show(@PathVariable int id, Model model) { 

      //bookを取得(Optionalでラップ)
      Optional<Book> bookOpt = bookService.getBook(id);

        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        model.addAttribute("bookId", id);
        model.addAttribute("title", "更新用フォーム");

      return "book/index";
    }



    /**
     * タスクidを取得し、一件のデータ更新
     * @param result
     * @param id
     * @param model
     * @param redirectAttributes
     * @return
     */
    //メソッドの引数に@ModelAttributeをつけると送信されたリクエストのbodyの情報を取得できる
    @PostMapping
    public String update(@ModelAttribute Book book,
                         Model model,
                         BindingResult result,
                         @RequestParam("bookId") int Id,
                         RedirectAttributes redirectAttributes){

        bookService.update(book);
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        model.addAttribute("title", "タスク一覧");
        return "book/index";
      }


      
    /**
     * タスクidを取得し、一件のデータ削除
     * @param id
     * @param model
     * @return
     */
    @PostMapping("/delete")
    public String delete(
      @RequestParam("bookId") int id,
      Model model) {
      
        //本を一件削除しリダイレクト
        bookService.deleteById(id);
        return "redirect:/book";
    }

    

 

}