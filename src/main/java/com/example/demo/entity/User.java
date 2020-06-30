package com.example.demo.entity;

public class User {

  private int id;
  private String name;
  private String pass;
  private String email;
  private String introduce;

    public int getId() {
      return id;
    }

    public void setId(int id) {
      this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

      public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIntroduce() {
      return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

}