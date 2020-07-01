package com.example.demo.entity;



import org.springframework.web.multipart.MultipartFile;


public class User  {


  private int id;
  private String name;
  private String pass;
  private String introduce;
  private MultipartFile userImage;

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

    public String getIntroduce() {
      return introduce;
    }
  
    public void setIntroduce(String introduce) {
      this.introduce = introduce;
    }

    public MultipartFile getUserImage() {
      return userImage;
    }
  
    public void setUserImage(MultipartFile userImage) {
      this.userImage = userImage;
    }

}