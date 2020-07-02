package com.example.demo.controller;

import java.util.List;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;




 
@Controller
@RequestMapping("/users")
public class UserController {
    
  
  @Autowired
  private UserService userService;

  
  @GetMapping
  public String index(Model model) { // ②
      List<User> users = userService.findAll();
      model.addAttribute("users", users); // ③
      return "players/index"; // ④
  }


  @GetMapping("new")
  public String newUser(@ModelAttribute("user") User user, Model model) {
		return "users/register";
	}


  @PostMapping
    public String create(@ModelAttribute("user") @Validated User user, BindingResult result, Model model) {
      if (result.hasErrors()) {
        return "users/resister";
      } else {
        userService.save(user);
        return "books/index";
      }
    }

  }